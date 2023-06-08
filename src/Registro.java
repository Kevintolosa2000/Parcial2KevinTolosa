public class Registro
{
    private Integer temperatura;

    private String dni;

    public Registro(int temperatura, String dni) {
        this.temperatura = temperatura;
        this.dni = dni;
    }

    public Integer getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Integer temperatura) {
        this.temperatura = temperatura;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "temperatura=" + temperatura +
                ", dni='" + dni + '\'' +
                '}';
    }
}
