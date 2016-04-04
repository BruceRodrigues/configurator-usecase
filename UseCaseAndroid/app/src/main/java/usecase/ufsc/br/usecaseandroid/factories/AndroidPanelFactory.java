package usecase.ufsc.br.usecaseandroid.factories;

import android.widget.LinearLayout;

import br.ufsc.configurator.api.adapter.ComponentAdapter;
import br.ufsc.configurator.api.adapter.SubComponentAdapter;
import br.ufsc.configurator.api.field.ConfigSubComponent;
import br.ufsc.configurator.api.field.factory.PanelFactory;
import usecase.ufsc.br.usecaseandroid.adapters.AndroidSubComponentAdapter;
import usecase.ufsc.br.usecaseandroid.configuration.AndroidConfiguration;

/**
 * Created by brucerodrigues on 2/9/16.
 */
public class AndroidPanelFactory extends AndroidSubComponentFactory implements PanelFactory<LinearLayout> {

    @Override
    public SubComponentAdapter<LinearLayout> createPanel(ConfigSubComponent configSubComponent) {
        return new AndroidSubComponentAdapter(new LinearLayout(AndroidConfiguration.getInstance().getCurrentContext()));
    }
}
