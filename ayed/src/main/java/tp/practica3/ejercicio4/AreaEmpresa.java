package tp.practica3.ejercicio4;

public class AreaEmpresa {
    private String nombre;
    private int retardoMensaje;

    public AreaEmpresa(String nombre, int retardoMensaje) {
        this.nombre = nombre;
        this.retardoMensaje = retardoMensaje;
    }

    public AreaEmpresa() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRetardoMensaje() {
        return retardoMensaje;
    }

    public void setRetardoMensaje(int retardoMensaje) {
        this.retardoMensaje = retardoMensaje;
    }
}
