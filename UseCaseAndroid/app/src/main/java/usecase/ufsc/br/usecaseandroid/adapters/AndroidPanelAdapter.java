package usecase.ufsc.br.usecaseandroid.adapters;

import android.widget.LinearLayout;

import java.util.List;

import br.ufsc.configurator.api.ConfigOptions;
import br.ufsc.configurator.api.adapter.ComponentAdapter;
import br.ufsc.configurator.api.adapter.PanelAdapter;

/**
 * Created by brucerodrigues on 2/9/16.
 */
public class AndroidPanelAdapter implements PanelAdapter<LinearLayout> {

    @Override
    public Object getFormField() {
        return null;
    }

    @Override
    public void addComponent(ComponentAdapter<?> componentAdapter, ConfigOptions.Alignment alignment) {

    }

    @Override
    public void newRow() {

    }

    @Override
    public void setRowWidth(String s) {

    }

    @Override
    public List<ComponentAdapter<?>> getComponents() {
        return null;
    }

    @Override
    public void setWidth(String s) {

    }

    @Override
    public void setEnabled(boolean b) {

    }

    @Override
    public void setVisible(boolean b) {

    }

    @Override
    public LinearLayout getComponent() {
        return null;
    }

    @Override
    public String getCaption() {
        return null;
    }
}
