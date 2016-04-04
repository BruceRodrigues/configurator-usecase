package usecase.ufsc.br.usecaseandroid.factories;

import android.widget.LinearLayout;

import br.ufsc.configurator.api.adapter.ComponentAdapter;
import br.ufsc.configurator.api.field.ConfigField;
import br.ufsc.configurator.api.field.factory.LayoutFactory;
import usecase.ufsc.br.usecaseandroid.adapters.AndroidLayoutAdapter;
import usecase.ufsc.br.usecaseandroid.configuration.AndroidConfiguration;

/**
 * Created by brucerodrigues on 1/23/16.
 */
public class AndroidLayoutFactory implements LayoutFactory<LinearLayout> {


    @Override
    public ComponentAdapter<LinearLayout> createComponent(ConfigField configField) {
        return new AndroidLayoutAdapter(new LinearLayout(AndroidConfiguration.getInstance().getCurrentContext()));
    }
}
