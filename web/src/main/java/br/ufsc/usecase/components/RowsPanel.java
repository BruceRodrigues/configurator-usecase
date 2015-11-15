package br.ufsc.usecase.components;

import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public abstract class RowsPanel<LAYOUT_TYPE extends AbstractLayout> extends CustomComponent {

	private static final long serialVersionUID = 1L;

	protected Panel rootPanel;
	protected VerticalLayout rootLayout;
	protected VerticalLayout contentLayout;
	protected HorizontalLayout header;
	protected LAYOUT_TYPE currentRowLayout;

	private Alignment alignment = Alignment.MIDDLE_LEFT;

	public RowsPanel() {
		super();
		this.init(null);
	}

	public RowsPanel(String caption) {
		super();
		this.init(caption);
	}

	private void init(String caption) {
		this.header = new HorizontalLayout();
		this.contentLayout = new VerticalLayout();
		this.contentLayout.setWidth("100%");
		this.rootPanel = new Panel(caption);
		this.rootLayout = new VerticalLayout();
		this.rootLayout.setWidth("100%");
		this.rootPanel.setContent(this.rootLayout);
		this.rootLayout.addComponent(this.header);
		this.header.setVisible(false);
		this.rootLayout.addComponent(this.contentLayout);
		this.newRow();
		this.setCompositionRoot(this.rootPanel);
	}

	public void addComponentOnVertical(Component component) {
		this.contentLayout.addComponent(component);
	}

	public void addComponent(Component component) {
		this.currentRowLayout.addComponent(component);
	}

	public abstract void setComponentAlignment(Component child, Alignment alignment);

	public AbstractLayout newRow() {
		this.currentRowLayout = this.createLayout();
		this.contentLayout.addComponent(this.currentRowLayout);
		this.setupNewRow();
		this.setComponentAlignment(this.currentRowLayout, this.alignment);
		return this.currentRowLayout;
	}

	protected abstract void setupNewRow();

	public AbstractLayout getCurrentRow() {
		return this.currentRowLayout;
	}

	public void removeAllComponents() {
		this.contentLayout.removeAllComponents();
	}

	public void setPanelStyle(String panelStyle) {
		this.rootPanel.setStyleName(panelStyle);
	}

	public VerticalLayout getRootLayout() {
		return this.rootLayout;
	}

	public VerticalLayout getContentLayout() {
		return this.contentLayout;
	}

	public HorizontalLayout getHeader() {
		this.header.setVisible(true);
		return this.header;
	}

	@Override
	public void setWidth(String width) {
		super.setWidth(width);
		this.contentLayout.setWidth(width);
	}

	public void setRowAlignment(Alignment alignment) {
		this.alignment = alignment;
	}

	public Alignment getRowAlignment() {
		return this.alignment;
	}

	protected abstract LAYOUT_TYPE createLayout();

}
