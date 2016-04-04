package usecase.ufsc.br.usecaseandroid.adapters;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import br.ufsc.configurator.api.adapter.RadioAdapter;

/**
 * Created by brucerodrigues on 1/23/16.
 */
public class AndroidRadioAdapter implements RadioAdapter<RadioGroup> {

    private RadioGroup component;

    public AndroidRadioAdapter(RadioGroup button) {
        this.component = button;
    }

    @Override
    public void setValue(Object o) {
        this.component.setActivated((Boolean) o);
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
