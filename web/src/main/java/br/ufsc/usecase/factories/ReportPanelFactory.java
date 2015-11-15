package br.ufsc.usecase.factories;

import br.ufsc.configurator.api.adapter.SubComponentAdapter;
import br.ufsc.configurator.api.field.ConfigSubComponent;
import br.ufsc.configurator.api.field.factory.PanelFactory;
import br.ufsc.usecase.adapters.ReportPanelAdapter;
import br.ufsc.usecase.utils.BaseReportStyle;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.ComponentPositionType;

public class ReportPanelFactory<FORM_FIELD> extends ReportSubcomponentFactory<FORM_FIELD>
		implements PanelFactory<FORM_FIELD> {

	@SuppressWarnings({ "unchecked" })
	@Override
	public SubComponentAdapter<FORM_FIELD> createPanel(ConfigSubComponent config) {
		HorizontalListBuilder layout = DynamicReports.cmp.horizontalList();

		StyleBuilder style = DynamicReports.stl.style();
		style.setTopPadding(2);
		style.setBottomPadding(5);
		layout.setStyle(style);

		TextFieldBuilder<?> textValue = DynamicReports.cmp.text(config.getOptions().caption);
		textValue.setStyle(BaseReportStyle.titleStyle);
		textValue.setFixedHeight(18);
		textValue.setPositionType(ComponentPositionType.FLOAT);
		textValue.setStretchWithOverflow(true);
		layout.add(textValue).newRow().newRow();
		return (SubComponentAdapter<FORM_FIELD>) new ReportPanelAdapter(layout);
	}

}
