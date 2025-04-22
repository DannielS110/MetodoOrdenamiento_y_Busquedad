import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese cantidad de Personas del listado: ");
        int cantidadPersonas = scanner.nextInt();
        scanner.nextLine();
        
        Persona[] listaPersonas = new Persona[cantidadPersonas];
        
        for (int i = 0; i < cantidadPersonas; i++) {
            System.out.println("Ingrese Persona:");
            System.out.print(" Nombre: ");
            String nombre = scanner.nextLine();
            
            int edad;
            do {
                System.out.print(" Edad: ");
                edad = scanner.nextInt();
                scanner.nextLine();
                
                if (edad < 0) {
                    System.out.println("La edad no puede ser negativa. Intente nuevamente.");
                }
            } while (edad < 0);
            
            listaPersonas[i] = new Persona(nombre, edad);
        }
        
        System.out.println("Arreglo original:");
        BusquedadBinaria.mostrarArreglo(listaPersonas);
        
        System.out.println("Ordenando con método burbuja...");
        MetodoOrdenamientoBurbuja.ordenamientoBurbuja(listaPersonas);
        
        System.out.println("Arreglo ordenado por edad:");
        BusquedadBinaria.mostrarArreglo(listaPersonas);
        
        System.out.print("Ingrese la edad de la persona a buscar: ");
        int edadBuscada = scanner.nextInt();
        
        System.out.println("Realizando búsqueda binaria para edad: " + edadBuscada);
        int posicion = BusquedadBinaria.busquedaBinaria(listaPersonas, edadBuscada);
        
        if (posicion != -1) {
            System.out.println("RESULTADO: La persona con la edad " + edadBuscada + " es " + listaPersonas[posicion].getNombre());
        } else {
            System.out.println("RESULTADO: No se encontró ninguna persona con la edad " + edadBuscada);
        }
        
        scanner.close();
    }
}