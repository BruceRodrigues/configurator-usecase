package usecase.ufsc.br.usecaseandroid.configuration;

import android.content.Context;

import br.ufsc.configurator.api.field.ConfigField;
import br.ufsc.configurator.api.field.ViewConfiguration;
import br.ufsc.configurator.api.field.factory.BaseFactory;
import br.ufsc.configurator.api.field.factory.LayoutFactory;
import usecase.ufsc.br.usecaseandroid.factories.AndroidLayoutFactory;
import usecase.ufsc.br.usecaseandroid.factories.AndroidPanelFactory;
import usecase.ufsc.br.usecaseandroid.factories.AndroidRadioFactory;
import usecase.ufsc.br.usecaseandroid.factories.AndroidSubComponentFactory;
import usecase.ufsc.br.usecaseandroid.factories.AndroidTextFieldFactory;

/**
 * Created by brucerodrigues on 1/24/16.
 */
public class AndroidConfiguration implements ViewConfiguration {

    public Context getCurrentContext() {
        return currentContext;
    }

    public void setCurrentContext(Context currentContext) {
        this.currentContext = currentContext;
    }

    private Context currentContext;

    private static AndroidTextFieldFactory textFieldFactory = new AndroidTextFieldFactory();

    private static AndroidRadioFactory radioFactory = new AndroidRadioFactory();

    private static AndroidLayoutFactory layoutFactory = new AndroidLayoutFactory();

    private static AndroidSubComponentFactory subComponentFactory = new AndroidSubComponentFactory();

    private static AndroidPanelFactory panelFactory = new AndroidPanelFactory();

    private static AndroidConfiguration instance;

    public static AndroidConfiguration getInstance() {
        if(instance == null) {
            instance = new AndroidConfiguration();
        }
        return instance;
    }


    @Override
    public BaseFactory getFactory(ConfigField.ConfigFieldType configFieldType) {
        switch (configFieldType) {
            case TEXTFIELD:
                return textFieldFactory;
            case TABLE:
                break;
            case COLUMN:
                break;
            case SUBCOMPONENT:
                return subComponentFactory;
            case TITLE:
                break;
            case COMBOBOX:
                break;
            case LABEL:
                break;
            case EMBEDDED:
                break;
            case RADIO:
                return radioFactory;
            case CHECKBOX:
                break;
            case PANEL:
                return panelFactory;
            case BUTTON:
                break;
        }
        return null;
    }

    @Override
    public LayoutFactory<?> getLayoutFactory() {
        return layoutFactory;
    }

    @Override
    public BaseFactory getCustomFactory(Object o) {
        return null;
    }

    @Override
    public void addCustomFactory(Object o, BaseFactory baseFactory) {

    }
}
