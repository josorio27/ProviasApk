package distribuidos.upc.edu.pe.consultasolicitud;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Omar on 18/02/2016.
 */
public class LstFragment extends ListFragment {

    TextView txtResultado;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_listado, container, false);

        String[] dataSource = {"Omar","Macbeth","Gabrielito","Yanina","Visita"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.row_listado,R.id.txtitem, dataSource);



        setListAdapter(adapter);

        setRetainInstance(true);

        return rootView;

    }

    public void onListItemClick(ListView l, View view, int position, long id){

        ViewGroup viewGroup = (ViewGroup) view;

        TextView txt = (TextView) viewGroup.findViewById(R.id.txtitem);

        Toast.makeText(getActivity(), txt.getText().toString(), Toast.LENGTH_LONG).show();
    }

    /*private class AdaptadorSolicitudes extends ArrayAdapter<Solicitud>{

        private List<Solicitud> listaSolicitudes;

        public AdaptadorSolicitudes(Context context, List<Solicitud> solicitudes){

            super(context, R.layout.);
        }


    }*/

}
