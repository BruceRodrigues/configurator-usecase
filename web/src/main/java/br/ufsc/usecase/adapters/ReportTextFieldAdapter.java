package br.ufsc.usecase.adapters;

import br.ufsc.configurator.api.adapter.TextFieldAdapter;
import br.ufsc.configurator.api.converter.CoreWidthConverter;
import br.ufsc.usecase.components.ReportTextField;

public class ReportTextFieldAdapter implements TextFieldAdapter<ReportTextField> {

	private ReportTextField component;

	public ReportTextFieldAdapter(ReportTextField component) {
		this.component = component;
	}

	@Override
	public void setValue(Object value) {
		this.component.setFieldValue(String.valueOf(value));
	}

	@Override
	public Object getValue() {
		return null;
	}

	@Override
	public void setWidth(String width) {
		this.component.setWidth(CoreWidthConverter.convertToInt(width));
	}

	@Override
	public void setEnabled(boolean value) {
	}

	@Override
	public void setVisible(boolean value) {
	}

	@Override
	public ReportTextField getComponent() {
		return this.component;
	}

	@Override
	public String getCaption() {
		return null;
	}

}
