package br.ufsc.usecase.components;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;

public class HorizontalRowsPanel extends RowsPanel<HorizontalLayout> {

	private static final long serialVersionUID = 1L;

	public HorizontalRowsPanel() {
		super();
	}

	public HorizontalRowsPanel(String caption) {
		super(caption);
	}

	@Override
	protected void setupNewRow() {
		this.currentRowLayout.setWidth("100%");
	}

	@Override
	protected HorizontalLayout createLayout() {
		return new HorizontalLayout();
	}

	@Override
	public void setComponentAlignment(Component child, Alignment alignment) {
		this.contentLayout.setComponentAlignment(child, alignment);
	}

}
