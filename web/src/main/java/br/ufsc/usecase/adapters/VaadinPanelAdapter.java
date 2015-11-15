package br.ufsc.usecase.adapters;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Component;

import br.ufsc.configurator.api.ConfigOptions.Alignment;
import br.ufsc.configurator.api.adapter.ComponentAdapter;
import br.ufsc.configurator.api.adapter.PanelAdapter;
import br.ufsc.usecase.components.HorizontalRowsPanel;

public class VaadinPanelAdapter implements PanelAdapter<HorizontalRowsPanel> {

	private HorizontalRowsPanel component;

	private List<ComponentAdapter<?>> components = new ArrayList<ComponentAdapter<?>>();

	public VaadinPanelAdapter(HorizontalRowsPanel component) {
		this.component = component;
	}

	@Override
	public Object getFormField() {
		return null;
	}

	@Override
	public void addComponent(ComponentAdapter<?> component, Alignment alignment) {
		this.component.addComponent((Component) component.getComponent());
		this.components.add(component);
	}

	@Override
	public void newRow() {
		this.component.newRow();
	}

	@Override
	public void setRowWidth(String value) {
	}

	@Override
	public List<ComponentAdapter<?>> getComponents() {
		return this.components;
	}

	@Override
	public void setWidth(String width) {
		this.component.setWidth(width);
	}

	@Override
	public void setEnabled(boolean value) {
		this.component.setEnabled(value);
	}

	@Override
	public void setVisible(boolean value) {
		this.component.setVisible(value);
	}

	@Override
	public HorizontalRowsPanel getComponent() {
		return this.component;
	}

	@Override
	public String getCaption() {
		return this.component.getCaption();
	}

}
