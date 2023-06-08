import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


/** kit nulo */Personas persona1 = new Personas("Kevin", "tolosa", "tejedor", "243423432", "trabajador", 12);
/** dni repetido */Personas persona2 = new Personas("juan", "pepe", "estrada", "243423432", "trabajador", 12);
/** kit a mano */Personas persona3 = new Personas("lucas", "sommaruga", "tejedor", "134223545", "trabajador", 12, 777);


        SSM fila = new SSM();
        try {
            fila.agregarCliente(persona1);
            fila.agregarCliente(persona2);
            fila.agregarCliente(persona3);
            System.out.println(fila.toString());

            Hashtable<Integer, Registro> tabla = fila.testear();

            System.out.println(tabla);
            try {
                List<String> listaAislados = fila.aislar(tabla);

                Gson gson = new GsonBuilder().setPrettyPrinting().create();

                try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("NoAislado.json")))
                {
                    gson.toJson(tabla, Hashtable.class, bufferedWriter);
                } catch (IOException e)
                {
                    try {
                        BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter("Aislado.json"));
                        gson.toJson(listaAislados, List.class, bufferedWriter2);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    System.out.println("Error en el archivo JSON");
                }

            } catch (Positivo e) {

                System.out.printf("Persona con mas de 38 AISLARLA YA");

            }
        } catch (Reactivos e) {
            System.out.println("No hay reactivos agregar mas? si, no ");
            Scanner scanner = new Scanner(System.in);
            if (scanner.next().equals("si")) {
                SSM.setReactivos(10);
            }

        }
    }
}