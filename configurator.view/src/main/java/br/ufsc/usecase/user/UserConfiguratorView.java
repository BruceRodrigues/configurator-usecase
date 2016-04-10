package br.ufsc.usecase.user;

import java.util.ArrayList;
import java.util.List;

import br.ufsc.configurator.api.ConfigOptions;
import br.ufsc.configurator.api.field.ConfigField;
import br.ufsc.configurator.api.field.ConfigField.ConfigFieldType;
import br.ufsc.configurator.api.field.ConfigRadio;
import br.ufsc.configurator.impl.BaseConfigurableViewImpl;

public class UserConfiguratorView extends BaseConfigurableViewImpl {

	private ConfigField createTextField(int line, String id, String caption) {
		ConfigOptions options = new ConfigOptions();
		options.caption = caption;
		return new ConfigField(line, -1, id, options, ConfigFieldType.TEXTFIELD);
	}

	@Override
	public void configView() {
		this.config.addComponent(this.createTextField(0, UserIds.FIRST_NAME, "Primeiro nome:"));
		this.config.addComponent(this.createTextField(1, UserIds.LAST_NAME, "Último nome:"));
		this.config.addComponent(this.createTextField(3, UserIds.CPF, "CPF:"));

		ConfigRadio configRadio = new ConfigRadio(4, 0, UserIds.SEXO, "Sexo:", "100%", true);
		List<Object> values = new ArrayList<Object>();
		values.add("Masculino");
		values.add("Feminino");
		configRadio.setValues(values);
		this.config.addComponent(configRadio);
	}

}
