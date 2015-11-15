package br.ufsc.usecase.components;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.VerticalAlignment;

public class ReportRadio extends HorizontalListBuilder {

	private static final long serialVersionUID = 1L;

	private static final int cellWidth = 18;
	private static final int cellHeight = 18;

	private Map<Object, TextFieldBuilder> values = new HashMap<>();

	public ReportRadio(String caption) {
		this.add(DynamicReports.cmp.text(caption));
		this.newRow();
	}

	public void addItems(Collection<Object> items) {
		for (Object item : items) {
			this.add(this.textCell("", 1, item), DynamicReports.cmp.text(item.toString()));
		}
	}

	public void setValue(Object value) {
		if (this.values.containsKey(value)) {
			this.values.get(value).setText("X");
		}
	}

	private HorizontalListBuilder textCell(String text, int size, Object item) {
		HorizontalListBuilder list = DynamicReports.cmp.horizontalList();
		String cellText = StringUtils.rightPad(text, size);
		cellText = StringUtils.left(cellText, size);

		StyleBuilder cellStyle = DynamicReports.stl.style().setBorder(DynamicReports.stl.pen1Point())
				.setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);

		for (char character : cellText.toCharArray()) {
			TextFieldBuilder<String> cell = DynamicReports.cmp.text(String.valueOf(character)).setStyle(cellStyle)
					.setFixedDimension(cellWidth, cellHeight);
			list.add(cell);
			this.values.put(item, cell);
		}
		return list;
	}

}
