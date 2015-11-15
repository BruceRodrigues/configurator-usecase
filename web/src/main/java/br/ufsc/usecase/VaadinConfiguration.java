package br.ufsc.usecase;

import br.ufsc.configurator.api.field.ConfigField.ConfigFieldType;
import br.ufsc.configurator.api.field.ViewConfiguration;
import br.ufsc.configurator.api.field.factory.BaseFactory;
import br.ufsc.configurator.api.field.factory.LayoutFactory;
import br.ufsc.usecase.factories.VaadinLayoutFactory;
import br.ufsc.usecase.factories.VaadinPanelFactory;
import br.ufsc.usecase.factories.VaadinTextFieldFactory;

public class VaadinConfiguration implements ViewConfiguration {

	private static VaadinTextFieldFactory textFieldFactory = new VaadinTextFieldFactory();

	private static VaadinLayoutFactory layoutFactory = new VaadinLayoutFactory();

	private static VaadinPanelFactory<?> panelFactory = new VaadinPanelFactory<>();

	private static VaadinConfiguration instance;

	private VaadinConfiguration() {
	}

	public static VaadinConfiguration getInstance() {
		if (instance == null) {
			instance = new VaadinConfiguration();
		}
		return instance;
	}

	@Override
	public LayoutFactory<?> getLayoutFactory() {
		return VaadinConfiguration.layoutFactory;
	}

	@Override
	public BaseFactory getFactory(ConfigFieldType type) {
		switch (type) {
		case TEXTFIELD:
			return textFieldFactory;
		case PANEL:
			return panelFactory;
		default:
			return null;
		}
	}

	@Override
	public BaseFactory getCustomFactory(Object factoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCustomFactory(Object factoryId, BaseFactory factory) {
		// TODO Auto-generated method stub

	}

}
