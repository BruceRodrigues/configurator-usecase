package usecase.ufsc.br.usecaseandroid.adapters;

import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import br.ufsc.configurator.api.ConfigOptions;
import br.ufsc.configurator.api.adapter.ComponentAdapter;
import br.ufsc.configurator.api.adapter.LayoutAdapter;

/**
 * Created by brucerodrigues on 1/23/16.
 */
public class AndroidLayoutAdapter implements LayoutAdapter<LinearLayout> {

    private LinearLayout component;

    private LinearLayout currentRow;

    private List<ComponentAdapter<?>> components = new ArrayList<>();


    public AndroidLayoutAdapter(LinearLayout layout) {
        this.component = layout;
        this.component.setOrientation(LinearLayout.VERTICAL);
        this.newRow();
    }

    @Override
    public void addComponent(ComponentAdapter<?> componentAdapter, ConfigOptions.Alignment alignment) {
        this.currentRow.addView((View) componentAdapter.getComponent());
        this.components.add(componentAdapter);
    }

    @Override
    public void newRow() {
        this.currentRow = new LinearLayout(this.component.getContext());
        this.component.addView(this.currentRow);
    }

    @Override
    public void setRowWidth(String s) {
        s = s.replace("px", "");
        this.currentRow.setMinimumWidth(Integer.parseInt(s));
    }

    @Override
    public List<ComponentAdapter<?>> getComponents() {
        return this.components;
    }

    @Override
    public void setWidth(String s) {
        s = s.replace("px", "");
//        if(s.contains("."))
//            s = s.split(".")[0];
//        this.component.setMinimumWidth(Integer.parseInt(s));
    }

    @Override
    public void setEnabled(boolean b) {
        this.component.setEnabled(b);
    }

    @Override
    public void setVisible(boolean b) {
        this.component.setVisibility(b ? View.VISIBLE : View.INVISIBLE);
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
