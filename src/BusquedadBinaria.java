import java.util.Arrays;
import java.util.Comparator;

public class BusquedadBinaria {
    
    public static int busquedaBinaria(Persona[] arreglo, int edadBuscada) {
        int inicio = 0;
        int fin = arreglo.length - 1;
        
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            int valorMedio = arreglo[medio].getEdad();
            
            imprimirSubarreglo(arreglo, inicio, fin);
            System.out.println("inferior=" + inicio + " superior=" + fin + " medio=" + medio + 
                    " valorMedio=" + valorMedio + 
                    (valorMedio == edadBuscada ? " --> ENCONTRADO" : 
                     valorMedio < edadBuscada ? " --> DERECHA" : " --> IZQUIERDA"));
            
            if (valorMedio == edadBuscada) {
                while (medio > 0 && arreglo[medio - 1].getEdad() == edadBuscada) {
                    medio--;
                }
                return medio;
            } else if (valorMedio < edadBuscada) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        
        return -1;
    }
    
    public static void mostrarArreglo(Persona[] personas) {
        if (personas.length == 0) return;
        
        System.out.print(personas[0].getEdad());
        for (int i = 1; i < personas.length; i++) {
            System.out.print(" | " + personas[i].getEdad());
        }
        System.out.println();
    }
    
    public static void imprimirSubarreglo(Persona[] personas, int inicio, int fin) {
        if (inicio <= fin) {
            System.out.print(personas[inicio].getEdad());
            for (int i = inicio + 1; i <= fin; i++) {
                System.out.print(" | " + personas[i].getEdad());
            }
            System.out.println();
        }
    }
    
    public static void ordenarPorEdad(Persona[] personas) {
        Arrays.sort(personas, Comparator.comparingInt(Persona::getEdad));
    }
}