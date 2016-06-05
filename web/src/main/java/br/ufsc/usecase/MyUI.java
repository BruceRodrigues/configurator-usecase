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
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import br.ufsc.usecase.user.UserConfiguratorView;
import br.ufsc.usecase.utils.JasperReportHelper;
import br.ufsc.usecase.utils.ReportPanel;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;

@Theme("mytheme")
@Widgetset("br.ufsc.usecase.MyAppWidgetset")
public class MyUI extends UI {

	private static final long serialVersionUID = 1L;

	UserConfiguratorView userView;

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);

		this.userView = new UserConfiguratorView();
		Component component = this.userView.generateView(VaadinConfiguration.getInstance(), "250px", Component.class)
				.getComponent();

		this.setValues();

		Panel panel = new Panel("Informações Pessoais");
		panel.setWidthUndefined();
		panel.setContent(component);

		layout.addComponent(panel);
		layout.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);

		Button saveButton = new Button("Salvar");
		saveButton.setWidth("250px");
		Button printButton = new Button("Imprimir");
		printButton.setWidth("250px");
		printButton.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MyUI.this.onPrintClick();
			}
		});

		layout.addComponent(saveButton);
		layout.setComponentAlignment(saveButton, Alignment.MIDDLE_CENTER);
		layout.addComponent(printButton);
		layout.setComponentAlignment(printButton, Alignment.MIDDLE_CENTER);
		this.setContent(layout);

	}

	public void onPrintClick() {
		JasperReportBuilder report = DynamicReports.report();

		HorizontalListBuilder panel = ReportPanel.createPanel("Informações Pessoais");
		panel.setWidth(250);
		panel.add(this.userView.generateView(ReportConfiguration.getInstance(), "500px", ComponentBuilder.class)
				.getComponent());

		this.setValues();

		report.addDetail(panel);
		this.buildImprimirWindow(JasperReportHelper.buildReport(report));
	}

	private void setValues() {
		// this.userView.setFieldValue(UserIds.FIRST_NAME, "Bruce");
		// this.userView.setFieldValue(UserIds.LAST_NAME, "Rodrigues");
		// this.userView.setFieldValue(UserIds.CPF, "012.123.456-78");
		// this.userView.setFieldValue(UserIds.SEXO, "Masculino");

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
