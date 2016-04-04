package usecase.ufsc.br.usecaseandroid.adapters;

import android.widget.EditText;
import android.widget.TextClock;

import br.ufsc.configurator.api.adapter.TextFieldAdapter;

/**
 * Created by brucerodrigues on 1/23/16.
 */
public class AndroidTextFieldAdapter implements TextFieldAdapter<EditText> {

    private EditText component;

    public AndroidTextFieldAdapter(EditText component) {
        this.component = component;
    }

    @Override
    public void setValue(Object o) {
        this.component.setText((String)o);
    }

    @Override
    public Object getValue() {
        return this.component.getText();
    }

    @Override
    public void setWidth(String s) {
        if(s != null) {
            s = s.replace("px", "");
            this.component.setWidth(Integer.parseInt(s));
        }
    }

    @Override
    public void setEnabled(boolean b) {
    }

    @Override
    public void setVisible(boolean b) {
    }

    @Override
    public EditText getComponent() {
        return this.component;
    }

    @Override
    public String getCaption() {
        return null;
    }
}
