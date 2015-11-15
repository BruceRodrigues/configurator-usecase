package br.ufsc.usecase.factories;

import br.ufsc.configurator.api.adapter.ComponentAdapter;
import br.ufsc.configurator.api.adapter.SubComponentAdapter;
import br.ufsc.configurator.api.field.ConfigSubComponent;
import br.ufsc.configurator.api.field.factory.PanelFactory;
import br.ufsc.configurator.api.field.factory.SubComponentFactory;
import br.ufsc.usecase.adapters.ReportSubcomponentAdapter;
import net.sf.dynamicreports.report.builder.DynamicReports;

public class ReportSubcomponentFactory<FORM_FIELD>
		implements SubComponentFactory<FORM_FIELD>, PanelFactory<FORM_FIELD> {

	@SuppressWarnings("unchecked")
	@Override
	public ComponentAdapter<FORM_FIELD> createComponent(ConfigSubComponent config) {
		return (SubComponentAdapter<FORM_FIELD>) new ReportSubcomponentAdapter(DynamicReports.cmp.horizontalList());
	}

	@SuppressWarnings("unchecked")
	@Override
	public SubComponentAdapter<FORM_FIELD> createPanel(ConfigSubComponent config) {
		return (SubComponentAdapter<FORM_FIELD>) new ReportSubcomponentAdapter(DynamicReports.cmp.horizontalList());
	}

}
