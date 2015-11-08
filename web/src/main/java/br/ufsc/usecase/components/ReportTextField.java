package br.ufsc.usecase.components;

import lombok.Getter;
import lombok.Setter;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;

@Getter
@Setter
public class ReportTextField extends HorizontalListBuilder {

	private static final long serialVersionUID = 1L;

	private TextFieldBuilder<?> label = DynamicReports.cmp.text("");

	private TextFieldBuilder<?> textValue = DynamicReports.cmp.text("");

	public ReportTextField() {
		this.add(this.label).newRow().add(this.textValue);
	}

	public void setFieldValue(String value) {
		this.textValue.setText(value);
	}

}