package br.ufsc.usecase.adapters;

import com.vaadin.ui.TextField;

import br.ufsc.configurator.api.adapter.TextFieldAdapter;

public class VaadinTextFieldAdapter implements TextFieldAdapter<TextField> {

	private TextField component;

	public VaadinTextFieldAdapter(TextField component) {
		this.component = component;
	}

	@Override
	public void setValue(Object value) {
		this.component.setValue(String.valueOf(value));
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
	public TextField getComponent() {
		return this.component;
	}

	@Override
	public String getCaption() {
		return this.component.getCaption();
	}

}
