package br.ufsc.usecase.user;

import br.ufsc.configurator.api.ConfigOptions.Alignment;
import br.ufsc.configurator.api.field.ConfigField.ConfigFieldType;
import br.ufsc.configurator.api.field.ConfigSubComponent;
import br.ufsc.configurator.impl.BaseConfigurableViewImpl;

public class UserConfiguratorView extends BaseConfigurableViewImpl<UserForm> {

	@Override
	public void configView() {
		this.config.addComponent(this.createInformacoesPessoais());
	}

	private ConfigSubComponent createInformacoesPessoais() {
		ConfigSubComponent config = new ConfigSubComponent(0, 0, UserIds.INFORMACOES_PESSOAIS, "Informações Pessoais",
				"100%", new InformacoesPessoaisView());
		config.setType(ConfigFieldType.PANEL);
		config.getOptions().aligment = Alignment.CENTER;
		return config;
	}

}
