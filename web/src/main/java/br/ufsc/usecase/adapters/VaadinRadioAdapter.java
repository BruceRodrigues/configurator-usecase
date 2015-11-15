package br.ufsc.usecase.adapters;

import com.vaadin.ui.OptionGroup;

import br.ufsc.configurator.api.adapter.RadioAdapter;

public class VaadinRadioAdapter implements RadioAdapter<OptionGroup> {

	private OptionGroup component;

	public VaadinRadioAdapter(OptionGroup component) {
		this.component = component;
	}

	@Override
	public void setValue(Object value) {
		this.component.setValue(value);
	}

	@Override
	public Object getValue() {
		return this.component.getValue();
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
	public OptionGroup getComponent() {
		return this.component;
	}

	@Override
	public String getCaption() {
		return this.component.getCaption();
	}

}
