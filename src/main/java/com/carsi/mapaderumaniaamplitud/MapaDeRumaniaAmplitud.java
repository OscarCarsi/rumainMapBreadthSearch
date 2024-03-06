/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.carsi.mapaderumaniaamplitud;

import java.util.*;

/**
 *
 * @author oscar
 */
public class MapaDeRumaniaAmplitud {

    public static void main(String[] args) {
        //Se piden las entradas de la ciudad a la que se desea ir y a la que se desea llegar
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la ciudad de origen: ");
        String origen = scanner.nextLine();
        System.out.println("Ingrese la ciudad de destino: ");
        String destino = scanner.nextLine();
        buscarRuta(origen, destino);
        scanner.close(); 
    }

    public static void buscarRuta(String origen, String destino) {
        //Se crea un objeto de la clase donde se implemento el mapa
        MapaRumania mapa = new MapaRumania();
        //Se obtiene una instancia del mapa de Rumania
        HashMap<String, HashMap<String, Integer>> grafoMapa = mapa.getMapa();
        //Se declara la cola para guardar las ciudades que van a estar visitandose según el nodo actual
        Queue<String> cola = new LinkedList<>();
        //Se crea un mapa para guardar la ciudad padre de la ciudad actual, donde la llave es la ciudad actual y el valor es la ciudad padre, esto me servira para guardar el recorrido, también sirve para saber si ya se visito la ciudad y evitar bucles
        HashMap<String, String> ciudadPadre = new HashMap<>();
        //Se crea un mapa para guardar el costo de llegar a la ciudad actual, donde la llave es la ciudad actual y el valor es el costo de llegar a esa ciudad, esto me servira para guardar el costo del recorrido
        HashMap<String, Integer> costo = new HashMap<>();
        //Se agrega la ciudad de origen a la cola y a la lista de ciudades visitadas
        cola.add(origen);
        //Se le agrega al mapa de ciudad padre la ciudad de donde partimos y se le asigna un valor nulo, ya que es la primera ciudad
        ciudadPadre.put(origen, null);
        //Se le agrega al mapa de costo la ciudad de donde partimos y se le asigna un valor de 0, porque igualmente es la primera ciudad
        costo.put(origen, 0);
        //Mientras la cola no este vacía se va a seguir buscando la ciudad destino
        while (!cola.isEmpty()) {
            //Sacamos el primer elemento de la cola y se le asigna a un string que representa la ciudad en la que estamos actualmente
            String ciudadActual = cola.poll();
            //Se obtienen las ciudades conectadas a la ciudad actual
            HashMap<String, Integer> ciudadesConectadas = grafoMapa.get(ciudadActual);
            //Se pregunta si la ciudad en la que estamos es la ciudad a la que tenemos que llegar
            if (ciudadActual.equals(destino)) {
                //Se crea una lista para guardar el recorrido
                List<String> recorrido = new ArrayList<>();
                //Se recorre el mapa de ciudad padre para guardar el recorrido, empezando en la ciudad destino y mediante el map se va obteniendo la ciudad padre de la ciudad actual
                for (String ciudad = destino; ciudad != null; ciudad = ciudadPadre.get(ciudad)) {
                    recorrido.add(ciudad);
                }
                System.out.println("El recorrido es: ");
                //Se voltea la lista pore recorre la lista de recorrido para imprimir el recorrido
                Collections.reverse(recorrido);
                for (String ciudad : recorrido) {
                    System.out.print(ciudad + " -> ");
                }
                System.out.println("\n");
                //Se imprime el costo total del recorrido tomando lo sumado con la llave de la ciudad destino
                System.out.println("Costo total: " + costo.get(destino));
                return;
            }
            //Se recorren las ciudades con las que tiene conexión la ciudad actual y se le asigna a un string la ciudad conectada
            for (String ciudadConectada : ciudadesConectadas.keySet()) {
                //Se pregunta si la ciudad conectada no esta en el mapa de ciudad padre para evitar bucles
                if (!ciudadPadre.containsKey(ciudadConectada)) {
                    //Si no se encuentra en el mapa de ciudad padre se agrega a la cola para seguir buscando
                    cola.add(ciudadConectada);
                    //Al mapa de ciudad padre se le agrega como llame la ciudad conectada y como valor la ciudad actual, diciendo que la ciudad conectada es hija de la ciudad actual, esto para guardar el recorrido
                    ciudadPadre.put(ciudadConectada, ciudadActual);
                    //Al mapa de costo se le agrega como llave la ciudad conectada y como valor el costo de llegar a esa ciudad, que es lo que nos costo llegar a la ciudad actual e ir a la ciudad conectada
                    costo.put(ciudadConectada, costo.get(ciudadActual) + ciudadesConectadas.get(ciudadConectada));
                }
            }
        }
    }

}
