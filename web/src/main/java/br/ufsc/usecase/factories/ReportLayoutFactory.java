package br.ufsc.usecase.factories;

import br.ufsc.configurator.api.adapter.ComponentAdapter;
import br.ufsc.configurator.api.field.ConfigField;
import br.ufsc.configurator.api.field.factory.LayoutFactory;
import br.ufsc.usecase.adapters.ReportLayoutAdapter;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;

public class ReportLayoutFactory implements LayoutFactory<HorizontalListBuilder> {

	@Override
	public ComponentAdapter<HorizontalListBuilder> createComponent(ConfigField config) {
		return new ReportLayoutAdapter();
	}

}
