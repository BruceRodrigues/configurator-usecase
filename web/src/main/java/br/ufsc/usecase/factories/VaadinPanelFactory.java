package br.ufsc.usecase.factories;

import br.ufsc.configurator.api.adapter.PanelAdapter;
import br.ufsc.configurator.api.adapter.SubComponentAdapter;
import br.ufsc.configurator.api.field.ConfigSubComponent;
import br.ufsc.configurator.api.field.factory.PanelFactory;
import br.ufsc.usecase.adapters.VaadinPanelAdapter;
import br.ufsc.usecase.components.HorizontalRowsPanel;

public class VaadinPanelFactory<FORM_FIELD> extends VaadinSubcomponentFactory<FORM_FIELD>
		implements PanelFactory<FORM_FIELD> {

	@SuppressWarnings("unchecked")
	@Override
	public SubComponentAdapter<FORM_FIELD> createPanel(ConfigSubComponent configSubComponent) {
		return (PanelAdapter<FORM_FIELD>) new VaadinPanelAdapter(
				new HorizontalRowsPanel(configSubComponent.getOptions().caption));
	}

}
