package br.ufsc.usecase.adapters;

import java.util.List;

import br.ufsc.configurator.api.ConfigOptions;
import br.ufsc.configurator.api.adapter.ComponentAdapter;
import br.ufsc.configurator.api.adapter.PanelAdapter;
import br.ufsc.configurator.api.adapter.SubComponentAdapter;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;

public class ReportSubcomponentAdapter
		implements SubComponentAdapter<HorizontalListBuilder>, PanelAdapter<HorizontalListBuilder> {

	private HorizontalListBuilder component;

	public ReportSubcomponentAdapter(HorizontalListBuilder component) {
		this.component = component;
	}

	@Override
	public void setWidth(String width) {
		if (width != null) {
			width = width.replace("px", "");
			Double value = Double.parseDouble(width);
			this.component.setWidth(value.intValue());
		}
	}

	@Override
	public HorizontalListBuilder getComponent() {
		return this.component;
	}

	@Override
	public Object getFormField() {
		return null;
	}

	@Override
	public void addComponent(ComponentAdapter<?> component, ConfigOptions.Alignment alignment) {
		this.component.add((ComponentBuilder) component.getComponent());
	}

	@Override
	public void newRow() {
		this.component.newRow();
	}

	@Override
	public List<ComponentAdapter<?>> getComponents() {
		return null;
	}

	@Override
	public String getCaption() {
		return null;
	}

	@Override
	public void setEnabled(boolean value) {
	}

	@Override
	public void setVisible(boolean value) {
	}

	@Override
	public void setRowWidth(String value) {
	}

}
