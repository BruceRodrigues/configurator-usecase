package br.ufsc.usecase.factories;

import com.vaadin.ui.OptionGroup;

import br.ufsc.configurator.api.adapter.ComponentAdapter;
import br.ufsc.configurator.api.field.ConfigRadio;
import br.ufsc.configurator.api.field.factory.RadioFactory;
import br.ufsc.usecase.adapters.VaadinRadioAdapter;

public class VaadinRadioFactory implements RadioFactory<OptionGroup> {

	@Override
	public ComponentAdapter<OptionGroup> createComponent(ConfigRadio config) {
		OptionGroup component = new OptionGroup(config.getOptions().caption);
		component.addItems(config.getValues());
		return new VaadinRadioAdapter(component);
	}

}
