package br.ufsc.usecase.user;

import br.ufsc.configurator.api.ConfigOptions;
import br.ufsc.configurator.api.field.ConfigField;
import br.ufsc.configurator.api.field.ConfigField.ConfigFieldType;
import br.ufsc.configurator.impl.SubComponentConfigurableViewImpl;

public class InformacoesPessoaisView
		extends SubComponentConfigurableViewImpl<InformacoesPessoaisForm, InformacoesPessoaisView> {

	private ConfigField createTextField(int line, String id, String caption) {
		ConfigOptions options = new ConfigOptions();
		options.caption = caption;
		return new ConfigField(line, -1, id, options, ConfigFieldType.TEXTFIELD);
	}

	@Override
	public void configView() {
		this.config.addComponent(this.createTextField(0, UserIds.FIRST_NAME, "Primeiro nome:"));
		this.config.addComponent(this.createTextField(1, UserIds.LAST_NAME, "Último nome:"));
		this.config.addComponent(this.createTextField(2, UserIds.CPF, "CPF:"));
	}

}
