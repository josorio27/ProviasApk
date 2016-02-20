package distribuidos.upc.edu.pe.consultasolicitud;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Preferencias extends AppCompatActivity implements View.OnClickListener {

    EditText txtEndpoint;
    EditText txtDNI;
    public static String sharedData="sharedData";
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias);

        setupVariables();
        setupActionBar();

        preferences = getSharedPreferences(sharedData,0);
        String strReturnEndpoint = preferences.getString("endpoint","no se puedo obtener el endpoint");
        String strReturnDNI = preferences.getString("dni","no se puedo obtener el dni");
        txtEndpoint.setText(strReturnEndpoint);
        txtDNI.setText(strReturnDNI);

    }

    private void setupVariables(){

        Button btnGuardar = (Button) findViewById(R.id.btnGuardar);
        Button btnLimpiar = (Button) findViewById(R.id.btnLimpiar);

        txtEndpoint = (EditText) findViewById(R.id.txtEndPoint);
        txtDNI = (EditText) findViewById(R.id.txtDNI);

        btnGuardar.setOnClickListener(this);
        btnLimpiar.setOnClickListener(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnGuardar:
                String strEnpoint = txtEndpoint.getText().toString();
                String strDNI = txtDNI.getText().toString();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("endpoint", strEnpoint);
                editor.putString("dni",strDNI);
                editor.commit();
                break;
            case R.id.btnLimpiar:
                txtEndpoint.setText("");
                txtDNI.setText("");
                break;
        }
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
