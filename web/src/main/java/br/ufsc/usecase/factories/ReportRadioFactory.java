package br.ufsc.usecase.factories;

import br.ufsc.configurator.api.adapter.ComponentAdapter;
import br.ufsc.configurator.api.field.ConfigRadio;
import br.ufsc.configurator.api.field.factory.RadioFactory;
import br.ufsc.usecase.adapters.ReportRadioAdapter;
import br.ufsc.usecase.components.ReportRadio;

public class ReportRadioFactory implements RadioFactory<ReportRadio> {

	@Override
	public ComponentAdapter<ReportRadio> createComponent(ConfigRadio config) {
		ReportRadio component = new ReportRadio(config.getOptions().caption);
		component.addItems(config.getValues());
		return new ReportRadioAdapter(component);
	}

}
