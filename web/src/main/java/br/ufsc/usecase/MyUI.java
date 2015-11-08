package br.ufsc.usecase;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.StreamResource;
import com.vaadin.server.StreamResource.StreamSource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import br.ufsc.usecase.user.UserConfiguratorView;
import br.ufsc.usecase.utils.JasperReportHelper;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;

@Theme("mytheme")
@Widgetset("br.ufsc.usecase.MyAppWidgetset")
public class MyUI extends UI {

	private static final long serialVersionUID = 1L;

	UserConfiguratorView userView;

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);

		userView = new UserConfiguratorView();
		layout.addComponent(
				(Component) userView.generateView(VaadinConfiguration.getInstance(), "1000px").getComponent());

		Button printButton = new Button("Imprimir");
		printButton.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				onPrintClick();
			}
		});

		layout.addComponent(printButton);
		setContent(layout);
	}

	public void onPrintClick() {
		JasperReportBuilder report = DynamicReports.report();
		report.addDetail((ComponentBuilder) this.userView.generateView(ReportConfiguration.getInstance(), "570px")
				.getComponent());
		this.buildImprimirWindow(JasperReportHelper.buildReport(report));
	}

	public void buildImprimirWindow(final byte[] source) {
		final int TYPE_BROWSER = 2;
		Embedded pdf = new Embedded();

		StreamSource streamSource = new StreamResource.StreamSource() {
			private static final long serialVersionUID = 6688389823215904327L;

			@Override
			public InputStream getStream() {
				return source == null ? null : new ByteArrayInputStream(source);
			}
		};
		StreamResource resource = new StreamResource(streamSource, "impressao" + ".pdf");
		pdf.setSource(resource);
		pdf.setType(TYPE_BROWSER);
		pdf.setWidth("780px");
		pdf.setHeight("600px");

		Window window = new Window();
		window.setModal(true);
		window.setContent(pdf);
		window.setWidth(785, Unit.PIXELS);
		window.setHeight(657, Unit.PIXELS);
		window.center();
		UI.getCurrent().addWindow(window);
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {

		private static final long serialVersionUID = 1L;
	}
}
