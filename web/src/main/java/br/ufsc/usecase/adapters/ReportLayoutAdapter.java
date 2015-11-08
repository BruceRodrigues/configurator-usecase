package br.ufsc.usecase.adapters;

import java.util.List;

import br.ufsc.configurator.api.ConfigOptions;
import br.ufsc.configurator.api.adapter.ComponentAdapter;
import br.ufsc.configurator.api.adapter.LayoutAdapter;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.ComponentPositionType;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;

public class ReportLayoutAdapter implements LayoutAdapter<HorizontalListBuilder> {

	private HorizontalListBuilder layout = DynamicReports.cmp.horizontalList();

	@Override
	public void setWidth(String width) {
		/**
		 * Safe conversion
		 */
		if (width != null && !width.isEmpty()) {
			if (width.contains("px")) {
				width = width.replace("px", "");
			}
			Double d = Double.parseDouble(width);
			// this.layout.setFixedWidth(d.intValue());
		}
	}

	@Override
	public HorizontalListBuilder getComponent() {
		return this.layout;
	}

	@Override
	public void addComponent(ComponentAdapter<?> component, ConfigOptions.Alignment alignment) {
		this.layout.add(0, (ComponentBuilder) component.getComponent()).setPositionType(ComponentPositionType.FLOAT);
		StyleBuilder style = DynamicReports.stl.style();
		style.setHorizontalTextAlignment(HorizontalTextAlignment.CENTER);
		this.layout.setStyle(style);
	}

	@Override
	public void newRow() {
		this.layout.newRow();
	}

	@Override
	public List<ComponentAdapter<?>> getComponents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCaption() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEnabled(boolean value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setVisible(boolean value) {
		this.layout.setWidth(0);
		this.layout.setHeight(0);
	}

	@Override
	public void setRowWidth(String value) {
		// TODO Auto-generated method stub

	}

}
