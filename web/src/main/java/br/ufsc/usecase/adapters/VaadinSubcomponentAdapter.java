package br.ufsc.usecase.adapters;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Component;

import br.ufsc.configurator.api.ConfigOptions;
import br.ufsc.configurator.api.adapter.ComponentAdapter;
import br.ufsc.configurator.api.adapter.SubComponentAdapter;
import br.ufsc.usecase.components.HorizontalRowsLayout;

public class VaadinSubcomponentAdapter implements SubComponentAdapter<HorizontalRowsLayout> {

	private HorizontalRowsLayout component;

	private List<ComponentAdapter<?>> components = new ArrayList<ComponentAdapter<?>>();

	public VaadinSubcomponentAdapter(HorizontalRowsLayout component) {
		this.component = component;
	}

	@Override
	public void setWidth(String width) {
		this.component.setWidth(width);
	}

	@Override
	public HorizontalRowsLayout getComponent() {
		return this.component;
	}

	@Override
	public Object getFormField() {
		return null;
	}

	@Override
	public void addComponent(ComponentAdapter<?> component, ConfigOptions.Alignment alignment) {
		this.component.addComponent((Component) component.getComponent());
		this.components.add(component);
	}

	@Override
	public void newRow() {
		this.component.newRow();
	}

	@Override
	public List<ComponentAdapter<?>> getComponents() {
		return this.components;
	}

	@Override
	public String getCaption() {
		return this.component.getCaption();
	}

	@Override
	public void setEnabled(boolean value) {
		this.component.setEnabled(value);
	}

	@Override
	public void setRowWidth(String value) {
	}

	@Override
	public void setVisible(boolean value) {
		this.component.setVisible(value);
	}

}
