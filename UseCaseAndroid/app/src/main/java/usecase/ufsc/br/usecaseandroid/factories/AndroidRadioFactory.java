package usecase.ufsc.br.usecaseandroid.factories;

import android.graphics.Color;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import br.ufsc.configurator.api.adapter.ComponentAdapter;
import br.ufsc.configurator.api.field.ConfigRadio;
import br.ufsc.configurator.api.field.factory.RadioFactory;
import usecase.ufsc.br.usecaseandroid.adapters.AndroidRadioAdapter;
import usecase.ufsc.br.usecaseandroid.configuration.AndroidConfiguration;

/**
 * Created by brucerodrigues on 1/24/16.
 */
public class AndroidRadioFactory implements RadioFactory<RadioGroup> {

    @Override
    public ComponentAdapter<RadioGroup> createComponent(ConfigRadio configRadio) {
        RadioGroup group = new RadioGroup(AndroidConfiguration.getInstance().getCurrentContext());
        for(Object value : configRadio.getValues()) {
            RadioButton radio = new RadioButton(AndroidConfiguration.getInstance().getCurrentContext());
            radio.setText(value.toString());
            radio.setTextColor(Color.BLACK);

            group.addView(radio);
        }
        return new AndroidRadioAdapter(group);
    }
}
