package br.ufsc.usecase.factories;

import com.vaadin.ui.TextField;

import br.ufsc.configurator.api.adapter.ComponentAdapter;
import br.ufsc.configurator.api.field.ConfigField;
import br.ufsc.configurator.api.field.factory.TextFieldFactory;
import br.ufsc.usecase.adapters.VaadinTextFieldAdapter;

public class VaadinTextFieldFactory implements TextFieldFactory<TextField, ConfigField> {

	@Override
	public ComponentAdapter<TextField> createComponent(ConfigField config) {
		TextField field = new TextField(config.getOptions().caption);
		field.setWidth(config.getOptions().width);
		return new VaadinTextFieldAdapter(field);
	}

}
