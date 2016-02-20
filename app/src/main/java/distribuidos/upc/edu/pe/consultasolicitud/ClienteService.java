package distribuidos.upc.edu.pe.consultasolicitud;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;


/**
 * Created by Omar on 19/02/2016.
 */
public interface ClienteService{

    @GET("/solicitud/{dni}")
    void getSolicitud(@Path("dni") String dni,Callback<List<Solicitud>> callback );

}
