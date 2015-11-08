package br.ufsc.usecase.components;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

public class HorizontalRowsLayout extends VerticalLayout {

	private static final long serialVersionUID = 1L;

	protected HorizontalLayout currentRowLayout;

	private String rowWidth = null;

	public HorizontalRowsLayout() {
		super();
		this.init();
	}

	public HorizontalRowsLayout(String caption) {
		this();
		this.setCaption(caption);
	}

	protected void init() {
		this.newRow();
	}

	@Override
	public void addComponent(Component component) {
		this.currentRowLayout.addComponent(component);
	}

	protected void addComponentToRoot(Component component) {
		super.addComponent(component);
	}

	public HorizontalLayout newRow() {
		this.currentRowLayout = new HorizontalLayout();
		this.currentRowLayout.setWidth(this.rowWidth);
		super.addComponent(this.currentRowLayout);
		return this.currentRowLayout;
	}

	public HorizontalLayout getCurrentRow() {
		return this.currentRowLayout;
	}

	@Override
	public void setComponentAlignment(Component childComponent, Alignment alignment) {
		this.currentRowLayout.setComponentAlignment(childComponent, alignment);
	}

	@Override
	public void removeAllComponents() {
		super.removeAllComponents();
	}

	public void setRowWidth(String value) {
		this.currentRowLayout.setWidth(value);
		this.rowWidth = value;
	}

	public void setRowAlignment(Alignment middleCenter) {
		super.setComponentAlignment(this.currentRowLayout, middleCenter);
	}

}
