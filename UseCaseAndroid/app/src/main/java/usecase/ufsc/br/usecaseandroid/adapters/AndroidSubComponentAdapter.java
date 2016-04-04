package usecase.ufsc.br.usecaseandroid.adapters;

import android.view.View;
import android.widget.LinearLayout;

import java.util.List;

import br.ufsc.configurator.api.ConfigOptions;
import br.ufsc.configurator.api.adapter.ComponentAdapter;
import br.ufsc.configurator.api.adapter.PanelAdapter;
import br.ufsc.configurator.api.adapter.SubComponentAdapter;

/**
 * Created by brucerodrigues on 1/23/16.
 */
public class AndroidSubComponentAdapter implements SubComponentAdapter<LinearLayout>, PanelAdapter<LinearLayout> {

    private LinearLayout component;

    private LinearLayout currentRow;

    public AndroidSubComponentAdapter(LinearLayout layout) {
        this.component = layout;
        this.component.setOrientation(LinearLayout.VERTICAL);
        this.newRow();
    }

    @Override
    public Object getFormField() {
        return null;
    }

    @Override
    public void addComponent(ComponentAdapter<?> componentAdapter, ConfigOptions.Alignment alignment) {
        this.component.addView((View) componentAdapter.getComponent());
    }

    @Override
    public void newRow() {
        this.currentRow = new LinearLayout(this.component.getContext());
        this.component.addView(this.currentRow);
    }

    @Override
    public void setRowWidth(String s) {
        if(s != null) {
            s = s.replace("px", "");
            this.currentRow.setMinimumWidth(Integer.parseInt(s));
        }
    }

    @Override
    public void setWidth(String s) {

    }

    @Override
    public List<ComponentAdapter<?>> getComponents() {
        return null;
    }

    @Override
    public void setEnabled(boolean b) {

    }

    @Override
    public void setVisible(boolean b) {

    }

    @Override
    public LinearLayout getComponent() {
        return this.component;
    }

    @Override
    public String getCaption() {
        return null;
    }
}
