package usecase.ufsc.br.usecaseandroid.factories;

import android.graphics.Color;
import android.widget.EditText;

import br.ufsc.configurator.api.adapter.ComponentAdapter;
import br.ufsc.configurator.api.field.ConfigField;
import br.ufsc.configurator.api.field.factory.TextFieldFactory;
import usecase.ufsc.br.usecaseandroid.adapters.AndroidTextFieldAdapter;
import usecase.ufsc.br.usecaseandroid.configuration.AndroidConfiguration;

/**
 * Created by brucerodrigues on 1/24/16.
 */
public class AndroidTextFieldFactory implements TextFieldFactory<EditText, ConfigField> {

    @Override
    public ComponentAdapter<EditText> createComponent(ConfigField androidConfigField) {
        EditText textField = new EditText(AndroidConfiguration.getInstance().getCurrentContext());
        textField.setHint(androidConfigField.getOptions().caption);
        textField.setTextColor(Color.BLACK);
        textField.setHintTextColor(Color.BLACK);
        textField.setLinkTextColor(Color.BLACK);
        return new AndroidTextFieldAdapter(textField);
    }
}
