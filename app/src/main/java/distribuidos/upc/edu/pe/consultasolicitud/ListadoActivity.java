package distribuidos.upc.edu.pe.consultasolicitud;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ListadoActivity extends AppCompatActivity {

    ListView lvSolicitudes;
    public static String sharedData="sharedData";
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        lvSolicitudes =(ListView) findViewById(R.id.lvSolicitudes);preferences = getSharedPreferences(sharedData,0);
        String strReturnEndpoint = preferences.getString("endpoint","no se puedo obtener el endpoint");
        String strReturnDNI = preferences.getString("dni","no se puedo obtener el dni");


        //RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("http://192.168.1.202:8080/WSREST/rest").build();
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(strReturnEndpoint).build();

        ClienteService service = restAdapter.create(ClienteService.class);

        String dni=strReturnDNI;

        service.getSolicitud(dni, new Callback<List<Solicitud>>() {
            @Override
            public void success(List<Solicitud> solicitudes, Response response) {
                AdaptadorSolicitudes adapter = new AdaptadorSolicitudes(ListadoActivity.this, solicitudes);
                lvSolicitudes.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Toast.makeText(ListadoActivity.this, "Error en la conexión del servicio", Toast.LENGTH_LONG).show();

            }
        });

        /*LstFragment lstFragment = (LstFragment) getSupportFragmentManager().findFragmentByTag("listfragment");

        if (lstFragment==null){
            lstFragment = new LstFragment();

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(android.R.id.content,lstFragment,"listfragment");
            transaction.addToBackStack(null);
            transaction.commit();

        }*/

        setupActionBar();

    }

    /**
     * Set up the {@link android.app.ActionBar}, if the API is available.
     */
    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private class AdaptadorSolicitudes extends ArrayAdapter<Solicitud> {

        private List<Solicitud> listaSolicitudes;

        public AdaptadorSolicitudes(Context context, List<Solicitud> solicitudes){

            super(context, R.layout.listitem_solicitudes, solicitudes);
            listaSolicitudes = solicitudes;
        }

        public View getView(int position, View contentView, ViewGroup parent){
            LayoutInflater inflater = LayoutInflater.from(getContext());

            View item = inflater.inflate(R.layout.listitem_solicitudes, null);

            String estado="";
            switch (listaSolicitudes.get(position).getEstado()){
                case "1":
                    estado="Pendiente";
                    break;
                case "2":
                    estado="Aprobado";
                    break;
                case "3":
                    estado="Rechazado";
                    break;
                case "4":
                    estado="Cancelado";
                    break;
                case "5":
                    estado="Reenviado";
                    break;
            }

            TextView txtIdSolicitud = (TextView) item.findViewById(R.id.txtIdSolicitud);
            txtIdSolicitud.setText("Nro solicitud: " + listaSolicitudes.get(position).getNroSolicitud());

            TextView txtPlaca = (TextView) item.findViewById(R.id.txtPlaca);
            txtPlaca.setText("Placa: " + listaSolicitudes.get(position).getMatricula().toUpperCase());

            TextView txtEstado = (TextView) item.findViewById(R.id.txtEstado);
            txtEstado.setText(estado);

            return item;

        }


    }

}