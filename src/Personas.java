import java.util.Random;

public class Personas {

    private String nombre;
    private String apellido;
    private String barrio;
    private String dni;
    private String ocupacion;
    private Integer edad;

    private Integer temperatura;
    private Integer kitsn;


    public Personas() {
    }

    public Personas(String nombre, String apellido, String barrio, String dni, String ocupacion, Integer edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.barrio = barrio;
        this.dni = dni;
        this.ocupacion = ocupacion;
        this.edad = edad;
        this.kitsn = null;
        this.temperatura=generartemperatura();
    }
    public Personas(String nombre, String apellido, String barrio, String dni, String ocupacion, Integer edad,Integer kitsn) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.barrio = barrio;
        this.dni = dni;
        this.ocupacion = ocupacion;
        this.edad = edad;
        this.kitsn = kitsn;
        this.temperatura=generartemperatura();

    }

    public Integer getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Integer temperatura) {
        this.temperatura = temperatura;
    }

    public Integer getKitsn() {
        return kitsn;
    }

    public void setKitsn(Integer kitsn) {
        this.kitsn = kitsn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Personas{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", barrio='" + barrio + '\'' +
                ", dni='" + dni + '\'' +
                ", ocupacion='" + ocupacion + '\'' +
                ", edad=" + edad +
                ", kitsn=" + kitsn +
                '}';
    }

    public int generartemperatura() {
        Random random = new Random();
        int x = random.nextInt(36,39)  ;
        return x;
    }
}
