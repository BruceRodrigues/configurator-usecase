package usecase.ufsc.br.usecaseandroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import br.ufsc.usecase.user.UserConfiguratorView;
import usecase.ufsc.br.usecaseandroid.configuration.AndroidConfiguration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        UserConfiguratorView userView = new UserConfiguratorView();
        AndroidConfiguration.getInstance().setCurrentContext(this.getApplicationContext());
        this.setContentView(R.layout.activity_main);
        RelativeLayout relative = (RelativeLayout) this.findViewById(R.id.content);
        relative.addView(userView.generateView(AndroidConfiguration.getInstance(), "100", View.class).getComponent());

        Toolbar t = (Toolbar) this.findViewById(R.id.toolbar);
        t.setTitle("Informações Pessoais");

//        userView.setFieldValue("first-name", "Bruce");
//        userView.setFieldValue("last-name", "Rodrigues");
//        userView.setFieldValue("cpf", "012.123.456-78");
//        userView.setFieldValue("sexo", "Masculino");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
