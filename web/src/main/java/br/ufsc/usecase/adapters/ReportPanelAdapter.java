package br.ufsc.usecase.adapters;

import java.util.ArrayList;
import java.util.List;

import br.ufsc.configurator.api.ConfigOptions.Alignment;
import br.ufsc.configurator.api.adapter.ComponentAdapter;
import br.ufsc.configurator.api.adapter.PanelAdapter;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;

public class ReportPanelAdapter implements PanelAdapter<HorizontalListBuilder> {

	private HorizontalListBuilder component;

	private List<ComponentAdapter<?>> components = new ArrayList<ComponentAdapter<?>>();

	public ReportPanelAdapter(HorizontalListBuilder component) {
		this.component = component;
		StyleBuilder style = DynamicReports.stl.style();
		style.setHorizontalTextAlignment(HorizontalTextAlignment.CENTER);
		this.component.setStyle(style);
	}

	@Override
	public Object getFormField() {
		return null;
	}

	@Override
	public void addComponent(ComponentAdapter<?> component, Alignment alignment) {
		this.component.add((ComponentBuilder) component.getComponent());
		this.components.add(component);
	}

	@Override
	public void newRow() {
		HorizontalListBuilder newRow = this.component.newRow();
		StyleBuilder style = DynamicReports.stl.style();
		style.setHorizontalTextAlignment(HorizontalTextAlignment.CENTER);
		newRow.setStyle(style);
	}

	@Override
	public List<ComponentAdapter<?>> getComponents() {
		return this.components;
	}

	@Override
	public void setWidth(String width) {
	}

	@Override
	public void setEnabled(boolean value) {
	}

	@Override
	public void setVisible(boolean value) {
	}

	@Override
	public HorizontalListBuilder getComponent() {
		return this.component;
	}

	@Override
	public String getCaption() {
		return null;
	}

	@Override
	public void setRowWidth(String value) {
	}

}
