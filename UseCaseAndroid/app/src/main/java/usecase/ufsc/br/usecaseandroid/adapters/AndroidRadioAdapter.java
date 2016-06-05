package usecase.ufsc.br.usecaseandroid.adapters;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.HashMap;
import java.util.Map;

import br.ufsc.configurator.api.adapter.RadioAdapter;

/**
 * Created by brucerodrigues on 1/23/16.
 */
public class AndroidRadioAdapter implements RadioAdapter<RadioGroup> {

    private RadioGroup component;

    private Map<String, RadioButton> buttons = new HashMap<String, RadioButton>();

    public AndroidRadioAdapter(RadioGroup button, Map<String, RadioButton> buttons) {
        this.component = button;
        this.buttons = buttons;
    }

    @Override
    public void setValue(Object o) {

        this.buttons.get(o.toString()).setChecked(true);
    }

    @Override
    public Object getValue() {
        return this.component.isActivated();
    }

    @Override
    public void setWidth(String s) {
        if(s != null) {
            s = s.replace("px","");
//            if(s.contains("."))
//                s = s.split(".")[0];
//            this.component.setMinimumWidth(Integer.parseInt(s));
        }
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
    public RadioGroup getComponent() {
        return this.component;
    }

    @Override
    public String getCaption() {
//        return this.component.getText().toString();
        return "";
    }
}
