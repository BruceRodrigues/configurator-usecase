package br.ufsc.usecase.factories;

import br.ufsc.configurator.api.adapter.ComponentAdapter;
import br.ufsc.configurator.api.adapter.SubComponentAdapter;
import br.ufsc.configurator.api.field.ConfigSubComponent;
import br.ufsc.configurator.api.field.factory.SubComponentFactory;
import br.ufsc.usecase.adapters.VaadinSubcomponentAdapter;
import br.ufsc.usecase.components.HorizontalRowsLayout;

public class VaadinSubcomponentFactory<FORM_FIELD> implements SubComponentFactory<FORM_FIELD> {

	@SuppressWarnings({ "unchecked" })
	@Override
	public ComponentAdapter<FORM_FIELD> createComponent(ConfigSubComponent config) {
		return (SubComponentAdapter<FORM_FIELD>) new VaadinSubcomponentAdapter(
				new HorizontalRowsLayout(config.getOptions().caption));
	}

}
