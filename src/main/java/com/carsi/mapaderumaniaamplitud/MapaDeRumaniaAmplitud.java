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
    }

    public static void buscarRuta(String origen, String destino) {
        //Se crea un objeto de la clase donde se implemento el mapa
        MapaRumania mapa = new MapaRumania();
        //Se obtiene una instancia del mapa de Rumania
        HashMap<String, HashMap<String, Integer>> grafoMapa = mapa.getMapa();
        //Se declara la cola para guardar las ciudades que van a estar visitandose según el nodo actual
        Queue<String> cola = new LinkedList<>();
        //Se hace una lista para guardar las ciudades que ya se visitaron
        List<String> ciudadesVisitadas = new ArrayList<>();
        //Se agrega la ciudad de origen a la cola y a la lista de ciudades visitadas
        cola.add(origen);
        //Se agrega la ciudad de origen a la lista de ciudades visitadas, para evitar entrar de nuevo a la ciudad y se cicle el algortimo
        ciudadesVisitadas.add(origen);
        //Mientras la cola no este vacía se va a seguir buscando la ciudad destino
        while (!cola.isEmpty()) {
            //Sacamos el primer elemento de la cola y se le asigna a un string que representa la ciudad en la que estamos actualmente
            String ciudadActual = cola.poll();
            //Se obtienen las ciudades conectadas a la ciudad actual
            HashMap<String, Integer> ciudadesConectadas = grafoMapa.get(ciudadActual);
            //Se pregunta si la ciudad en la que estamos es la ciudad a la que tenemos que llegar
            if (ciudadActual.equals(destino)) {
                System.out.println("Se llego a la ciudad destino: " + ciudadActual);
                return;
            }
            //Se recorren las ciudades con las que tiene conexión la ciudad actual y se le asigna a un string la ciudad conectada
            for (String ciudadConectada : ciudadesConectadas.keySet()) {
                //Se pregunta si la ciudad conectada no ha sido visitada para evitar el bucle infinito
                if (!ciudadesVisitadas.contains(ciudadConectada)) {
                    //Si no se encuentra la ciudad conectada en la lista de ciudades visitadas se agrega a la cola y a la lista de ciudades visitadas
                    cola.add(ciudadConectada);
                    ciudadesVisitadas.add(ciudadConectada);
                }
            }
        }
    }

}
