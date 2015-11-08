package br.ufsc.usecase.factories;

import br.ufsc.configurator.api.adapter.ComponentAdapter;
import br.ufsc.configurator.api.field.ConfigField;
import br.ufsc.configurator.api.field.factory.LayoutFactory;
import br.ufsc.usecase.adapters.VaadinLayoutAdapter;
import br.ufsc.usecase.components.HorizontalRowsLayout;

public class VaadinLayoutFactory implements LayoutFactory<HorizontalRowsLayout> {

	@Override
	public ComponentAdapter<HorizontalRowsLayout> createComponent(ConfigField config) {
		return new VaadinLayoutAdapter(new HorizontalRowsLayout());
	}

}
