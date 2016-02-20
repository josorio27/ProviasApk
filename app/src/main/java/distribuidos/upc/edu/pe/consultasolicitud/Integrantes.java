package distribuidos.upc.edu.pe.consultasolicitud;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Integrantes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integrantes);

        setupActionBar();

        ListView lvIntegrantes = (ListView) findViewById(R.id.lvIntegrantes);

        String[] items = { "Omar Diaz Esquivel", "José Martín González Gallardo", "Johnny Tsuhako Chinen", "José Osorio Serrano", "Patricia Denisse Pazo Pineda","Miguel Viru Clavijo" };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);

        lvIntegrantes.setAdapter(adapter);

    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
