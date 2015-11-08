package br.ufsc.usecase.utils;

import java.awt.Color;

import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.style.PenBuilder;
import net.sf.dynamicreports.report.builder.style.SimpleStyleBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.LineStyle;
import net.sf.dynamicreports.report.constant.VerticalAlignment;

public class BaseReportStyle {

	public static StyleBuilder labelStyle;

	public static StyleBuilder fieldStyle;

	public static StyleBuilder tableStyle;

	public static StyleBuilder titleStyle;

	public static StyleBuilder subtitleStyle;

	public static SimpleStyleBuilder evenRowStyle;

	public static SimpleStyleBuilder oddRowStyle;

	public static StyleBuilder tableHeaderStyle;

	static {

		labelStyle = createLabelStyle();
		fieldStyle = createFieldStyle();
		tableStyle = createTableStyle();
		titleStyle = createTitleStyle();
		subtitleStyle = createSubtitleStyle();
		evenRowStyle = createEvenRowStyle();
		oddRowStyle = createOddRowStyle();
		tableHeaderStyle = createTableHeaderStyle();
	}

	private static StyleBuilder createLabelStyle() {
		StyleBuilder style = DynamicReports.stl.style();
		style.setBackgroundColor(Color.WHITE);
		style.setLeftPadding(3);
		style.setFontSize(8);
		style.setBold(false);
		PenBuilder pen = DynamicReports.stl.pen();
		style.setBottomBorder(pen.setLineWidth(2F).setLineStyle(LineStyle.SOLID).setLineColor(Color.WHITE));
		style.setBorder(pen.setLineWidth(0F).setLineStyle(LineStyle.SOLID).setLineColor(Color.WHITE));
		style.setHorizontalAlignment(HorizontalAlignment.LEFT);
		return style;
	}

	private static StyleBuilder createFieldStyle() {
		StyleBuilder style = DynamicReports.stl.style();
		style.setLeftPadding(15);
		style.setRightPadding(5);
		style.setFontSize(9);
		style.setBold(false);
		PenBuilder pen = DynamicReports.stl.pen();
		style.setBorder(pen.setLineWidth(0.5F).setLineStyle(LineStyle.DOTTED).setLineColor(new Color(171, 171, 171)));
		style.setVerticalAlignment(VerticalAlignment.MIDDLE);
		return style;
	}

	private static StyleBuilder createTableStyle() {
		StyleBuilder style = DynamicReports.stl.style();
		return style;
	}

	private static StyleBuilder createTitleStyle() {
		StyleBuilder style = DynamicReports.stl.style();
		style.setBackgroundColor(new Color(61, 61, 61));
		style.setForegroundColor(Color.WHITE);
		style.setLeftPadding(10);
		style.setFontSize(10);
		style.setBold(true);
		style.setHorizontalAlignment(HorizontalAlignment.CENTER);
		return style;
	}

	private static StyleBuilder createSubtitleStyle() {
		StyleBuilder style = DynamicReports.stl.style();
		style.setBackgroundColor(new Color(156, 154, 154));
		style.setForegroundColor(Color.WHITE);
		style.setFontSize(10);
		style.setLeftPadding(10);
		style.setBold(true);
		style.setHorizontalAlignment(HorizontalAlignment.CENTER);
		return style;
	}

	private static SimpleStyleBuilder createEvenRowStyle() {
		SimpleStyleBuilder style = DynamicReports.stl.simpleStyle();
		style.setBackgroundColor(new Color(214, 214, 214));
		return style;
	}

	private static SimpleStyleBuilder createOddRowStyle() {
		SimpleStyleBuilder style = DynamicReports.stl.simpleStyle();
		style.setBackgroundColor(new Color(255, 255, 255));
		return style;
	}

	private static StyleBuilder createTableHeaderStyle() {
		StyleBuilder style = DynamicReports.stl.style();
		style.setBackgroundColor(new Color(156, 154, 154));
		style.setForegroundColor(Color.WHITE);
		style.setFontSize(9);
		style.setBold(true);
		return style;
	}

}
