import java.util.*;

public class SSM extends LinkedList {

    private Queue<Personas> filaPersonas;
    private static int reactivos = 10;

    @Override
    public String toString() {
        return "SSM{" +
                "\nfilaPersonas=" + filaPersonas +
                +
                        '}';
    }

    public SSM() {
        filaPersonas = new LinkedList<>();
    }

    public SSM(Queue<Personas> filaPersonas) {
        this.filaPersonas = filaPersonas;
    }


    public Queue<Personas> getFilaPersonas() {
        return filaPersonas;
    }

    public void setFilaPersonas(Queue<Personas> filaPersonas) {
        this.filaPersonas = filaPersonas;
    }

    public static int getReactivos() {
        return reactivos;
    }

    public static void setReactivos(int reactivos) {
        SSM.reactivos = reactivos;
    }

    public int generarKitRandom() {
        Random random = new Random();
        int x = random.nextInt(100) + 1;
        return x;
    }

    public boolean comprobardni(Personas p) {
        boolean flag = true;

        for (Personas x : filaPersonas) {
            if (x.getDni() == p.getDni()) {
                flag = false;
            } else {
                flag = true;
            }
        }
        return flag;
    }

    public void agregarCliente(Personas persona) throws Reactivos {

        if (comprobardni(persona)) {
            if (persona.getKitsn() == null) {
                persona.setKitsn(generarKitRandom());
            }
            filaPersonas.add(persona);
            reactivos--;
        } else {
            System.out.println("Dni igual no se pudo agregar a: " + persona.getNombre());
        }
        if (reactivos <= 0) {
            throw new Reactivos("No hay reactivos.");
        }

    }

    public Hashtable<Integer, Registro> testear() {

        Random random = new Random();
        Hashtable<Integer, Registro> tablaDeDatos = new Hashtable<>();

        for (Personas p : filaPersonas) {
            tablaDeDatos.put(p.getKitsn(), new Registro(p.getTemperatura(), p.getDni()));
        }
        return tablaDeDatos;
    }


    public List<String> aislar(Hashtable<Integer, Registro> tabla) throws Positivo {
        Enumeration<Integer> keys = tabla.keys();

        List<String> pacientesAislados = new ArrayList<>();

        while (keys.hasMoreElements())
        {
            Integer key = keys.nextElement();
            Registro value = tabla.get(key);

            for (Personas p : filaPersonas)
            {
                if (value.getTemperatura() >= 38)

                {
                        pacientesAislados.add("Nro de test: " + p.getKitsn() + " Barrio: " + p.getBarrio());
                        throw new Positivo("Temperatura Alta");
                }
            }
        }
        return pacientesAislados;
    }

}
