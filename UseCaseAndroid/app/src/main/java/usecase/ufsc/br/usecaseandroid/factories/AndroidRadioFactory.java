package usecase.ufsc.br.usecaseandroid.factories;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.HashMap;
import java.util.Map;

import br.ufsc.configurator.api.adapter.ComponentAdapter;
import br.ufsc.configurator.api.field.ConfigRadio;
import br.ufsc.configurator.api.field.factory.RadioFactory;
import usecase.ufsc.br.usecaseandroid.adapters.AndroidRadioAdapter;
import usecase.ufsc.br.usecaseandroid.configuration.AndroidConfiguration;

/**
 * Created by brucerodrigues on 1/24/16.
 */
public class AndroidRadioFactory implements RadioFactory<RadioGroup> {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public ComponentAdapter<RadioGroup> createComponent(ConfigRadio configRadio) {
        int[][] states = new int[][] {
                new int[] { android.R.attr.state_enabled}, // enabled
                new int[] {-android.R.attr.state_enabled}, // disabled
                new int[] {-android.R.attr.state_checked}, // unchecked
                new int[] { android.R.attr.state_pressed}  // pressed
        };

        int[] colors = new int[] {
                Color.BLACK,
                Color.RED,
                Color.GREEN,
                Color.BLUE
        };

        ColorStateList myList = new ColorStateList(states, colors);


        RadioGroup group = new RadioGroup(AndroidConfiguration.getInstance().getCurrentContext());
        Map<String, RadioButton> buttons = new HashMap<String, RadioButton>();
        for(Object value : configRadio.getValues()) {
            RadioButton radio = new RadioButton(AndroidConfiguration.getInstance().getCurrentContext());
            radio.setText(value.toString());
            radio.setTextColor(Color.BLACK);
            buttons.put(value.toString(), radio);
            radio.setButtonTintList(myList);
            group.addView(radio);
        }
        return new AndroidRadioAdapter(group, buttons);
    }
}
