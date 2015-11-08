package br.ufsc.usecase.factories;

import br.ufsc.configurator.api.adapter.ComponentAdapter;
import br.ufsc.configurator.api.field.ConfigField;
import br.ufsc.configurator.api.field.factory.TextFieldFactory;
import br.ufsc.usecase.adapters.ReportTextFieldAdapter;
import br.ufsc.usecase.components.ReportTextField;
import br.ufsc.usecase.utils.BaseReportStyle;

public class ReportTextFieldFactory implements TextFieldFactory<ReportTextField, ConfigField> {

	@Override
	public ComponentAdapter<ReportTextField> createComponent(ConfigField config) {
		ReportTextField field = new ReportTextField();
		field.getLabel().setStyle(BaseReportStyle.labelStyle);
		field.getLabel().setFixedHeight(10);
		field.getLabel().setText(config.getOptions().caption);
		field.getTextValue().setFixedHeight(18);
		field.getTextValue().setStyle(BaseReportStyle.fieldStyle);

		return new ReportTextFieldAdapter(field);
	}

}
