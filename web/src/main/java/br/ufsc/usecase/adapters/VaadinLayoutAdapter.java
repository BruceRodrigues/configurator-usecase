package br.ufsc.usecase.adapters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vaadin.ui.Component;

import br.ufsc.configurator.api.ConfigOptions;
import br.ufsc.configurator.api.ConfigOptions.Alignment;
import br.ufsc.configurator.api.adapter.ComponentAdapter;
import br.ufsc.configurator.api.adapter.LayoutAdapter;
import br.ufsc.usecase.components.HorizontalRowsLayout;

public class VaadinLayoutAdapter implements LayoutAdapter<HorizontalRowsLayout> {

	public static Map<ConfigOptions.Alignment, com.vaadin.ui.Alignment> ALIGNMENTS = new HashMap<ConfigOptions.Alignment, com.vaadin.ui.Alignment>();

	private List<ComponentAdapter<?>> components = new ArrayList<ComponentAdapter<?>>();

	static {
		ALIGNMENTS.put(ConfigOptions.Alignment.LEFT, com.vaadin.ui.Alignment.MIDDLE_LEFT);
		ALIGNMENTS.put(ConfigOptions.Alignment.CENTER, com.vaadin.ui.Alignment.MIDDLE_CENTER);
		ALIGNMENTS.put(ConfigOptions.Alignment.RIGHT, com.vaadin.ui.Alignment.MIDDLE_RIGHT);
	}

	private HorizontalRowsLayout component;

	public VaadinLayoutAdapter(HorizontalRowsLayout component) {
		this.component = component;
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
	public HorizontalRowsLayout getComponent() {
		return this.component;
	}

	@Override
	public String getCaption() {
		return this.component.getCaption();
	}

	@Override
	public void addComponent(ComponentAdapter<?> component, Alignment alignment) {
		Component c = (Component) component.getComponent();
		this.component.addComponent(c);
		// this.component.setComponentAlignment(c, ALIGNMENTS.get(alignment));
		this.components.add(component);
	}

	@Override
	public void newRow() {
		this.component.newRow();
	}

	@Override
	public void setRowWidth(String value) {
		this.component.setRowWidth(value);
	}

	@Override
	public List<ComponentAdapter<?>> getComponents() {
		return this.components;
	}

}