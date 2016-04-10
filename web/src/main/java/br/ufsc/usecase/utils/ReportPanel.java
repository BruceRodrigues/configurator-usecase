package br.ufsc.usecase.utils;

import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.ComponentPositionType;

public class ReportPanel {

	public static HorizontalListBuilder createPanel(String caption) {
		HorizontalListBuilder layout = DynamicReports.cmp.horizontalList();

		StyleBuilder style = DynamicReports.stl.style();
		style.setTopPadding(2);
		style.setBottomPadding(5);
		layout.setStyle(style);

		TextFieldBuilder<?> textValue = DynamicReports.cmp.text(caption);
		textValue.setStyle(BaseReportStyle.titleStyle);
		textValue.setFixedHeight(18);
		textValue.setPositionType(ComponentPositionType.FLOAT);
		textValue.setStretchWithOverflow(true);
		layout.add(textValue).newRow().newRow();

		return layout;
	}

}
