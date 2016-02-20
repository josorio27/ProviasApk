package distribuidos.upc.edu.pe.consultasolicitud;

/**
 * Created by Omar on 19/02/2016.
 */
public class Solicitud {

    private String nroSolicitud;
    private String dni;
    private String matricula;
    private String estado;
    private String fechaSolicitud;
    private String revisionTecnica;
    //private File revisionTecnica;
    private String revisionTecnicaFileName;
    private String revisionTecnicaContentType;
    private String fechaModificacion;
    //private Solicitante solicitante;
    //private Vehiculo vehiculo;


    public String getNroSolicitud() {
        return nroSolicitud;
    }

    public void setNroSolicitud(String nroSolicitud) {
        this.nroSolicitud = nroSolicitud;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getRevisionTecnica() {
        return revisionTecnica;
    }

    public void setRevisionTecnica(String revisionTecnica) {
        this.revisionTecnica = revisionTecnica;
    }

    public String getRevisionTecnicaFileName() {
        return revisionTecnicaFileName;
    }

    public void setRevisionTecnicaFileName(String revisionTecnicaFileName) {
        this.revisionTecnicaFileName = revisionTecnicaFileName;
    }

    public String getRevisionTecnicaContentType() {
        return revisionTecnicaContentType;
    }

    public void setRevisionTecnicaContentType(String revisionTecnicaContentType) {
        this.revisionTecnicaContentType = revisionTecnicaContentType;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @Override
    public String toString() {
        return "Solicitud{" +
                "nroSolicitud='" + nroSolicitud + '\'' +
                ", dni='" + dni + '\'' +
                ", matricula='" + matricula + '\'' +
                ", estado='" + estado + '\'' +
                ", fechaSolicitud='" + fechaSolicitud + '\'' +
                ", revisionTecnica='" + revisionTecnica + '\'' +
                ", revisionTecnicaFileName='" + revisionTecnicaFileName + '\'' +
                ", revisionTecnicaContentType='" + revisionTecnicaContentType + '\'' +
                ", fechaModificacion='" + fechaModificacion + '\'' +
                '}';
    }
}
