package br.ufsc.usecase.adapters;

import br.ufsc.configurator.api.adapter.RadioAdapter;
import br.ufsc.usecase.components.ReportRadio;

public class ReportRadioAdapter implements RadioAdapter<ReportRadio> {

	private ReportRadio component;

	public ReportRadioAdapter(ReportRadio component) {
		this.component = component;
	}

	@Override
	public void setValue(Object value) {
		this.component.setValue(value);
	}

	@Override
	public Object getValue() {
		return null;
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
	public ReportRadio getComponent() {
		return this.component;
	}

	@Override
	public String getCaption() {
		// TODO Auto-generated method stub
		return null;
	}

}
