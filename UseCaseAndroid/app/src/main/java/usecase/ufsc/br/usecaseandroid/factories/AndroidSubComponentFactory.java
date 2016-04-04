package usecase.ufsc.br.usecaseandroid.factories;

import android.widget.LinearLayout;

import br.ufsc.configurator.api.adapter.ComponentAdapter;
import br.ufsc.configurator.api.field.ConfigSubComponent;
import br.ufsc.configurator.api.field.factory.SubComponentFactory;
import usecase.ufsc.br.usecaseandroid.adapters.AndroidLayoutAdapter;
import usecase.ufsc.br.usecaseandroid.configuration.AndroidConfiguration;

/**
 * Created by brucerodrigues on 1/24/16.
 */
public class AndroidSubComponentFactory implements SubComponentFactory<LinearLayout> {

    @Override
    public ComponentAdapter<LinearLayout> createComponent(ConfigSubComponent configSubComponent) {
        return new AndroidLayoutAdapter(new LinearLayout(AndroidConfiguration.getInstance().getCurrentContext()));
    }
}
