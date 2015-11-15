package br.ufsc.usecase;

import br.ufsc.configurator.api.field.ConfigField.ConfigFieldType;
import br.ufsc.configurator.api.field.ViewConfiguration;
import br.ufsc.configurator.api.field.factory.BaseFactory;
import br.ufsc.configurator.api.field.factory.LayoutFactory;
import br.ufsc.usecase.factories.ReportLayoutFactory;
import br.ufsc.usecase.factories.ReportPanelFactory;
import br.ufsc.usecase.factories.ReportRadioFactory;
import br.ufsc.usecase.factories.ReportTextFieldFactory;

@SuppressWarnings("rawtypes")
public class ReportConfiguration implements ViewConfiguration {

	private static ReportLayoutFactory layoutFactory = new ReportLayoutFactory();

	private static ReportTextFieldFactory textFieldFactory = new ReportTextFieldFactory();

	private static ReportPanelFactory<?> panelFactory = new ReportPanelFactory<>();

	private static ReportRadioFactory radioFactory = new ReportRadioFactory();

	private static ReportConfiguration instance;

	private ReportConfiguration() {
	}

	public static ReportConfiguration getInstance() {
		if (instance == null) {
			instance = new ReportConfiguration();
		}
		return instance;
	}

	@Override
	public LayoutFactory<?> getLayoutFactory() {
		return ReportConfiguration.layoutFactory;
	}

	@Override
	public BaseFactory<?, ?> getFactory(ConfigFieldType type) {
		switch (type) {
		case TEXTFIELD:
		case LABEL:
		case TITLE:
			return textFieldFactory;
		case PANEL:
			return panelFactory;
		case RADIO:
			return radioFactory;
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