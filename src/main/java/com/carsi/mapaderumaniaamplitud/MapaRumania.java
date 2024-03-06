/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.carsi.mapaderumaniaamplitud;

import java.util.*;
/**
 *
 * @author oscar
 */
public class MapaRumania {
    private HashMap<String, HashMap<String, Integer>> mapa;

    //Se crea el mapa de Rumania con las ciudades y sus conexiones en el constructor
    public MapaRumania(){
        this.mapa = crearMapa();
    }

    //Se declaran las conexiones de las ciudades de Rumania además del valor que se consume al ir de una a otra
    private HashMap<String, HashMap<String, Integer>> crearMapa(){
        HashMap<String, HashMap<String, Integer>> mapaRumania = new HashMap<>();
        //Arad
        HashMap<String, Integer> coneccionesDeArad = new HashMap<>();
        coneccionesDeArad.put("Zerind", 75);
        coneccionesDeArad.put("Sibiu", 140);
        coneccionesDeArad.put("Timisoara", 118);
        mapaRumania.put("Arad", coneccionesDeArad);
        //Zerind
        HashMap<String, Integer> coneccionesDeZerind = new HashMap<>();
        coneccionesDeZerind.put("Arad", 75);
        coneccionesDeZerind.put("Oradea", 71);
        mapaRumania.put("Zerind", coneccionesDeZerind);
        //Oradea
        HashMap<String, Integer> coneccionesDeOradea = new HashMap<>();
        coneccionesDeOradea.put("Zerind", 71);
        coneccionesDeOradea.put("Sibiu", 151);
        mapaRumania.put("Oradea", coneccionesDeOradea);
        //Sibiu
        HashMap<String, Integer> coneccionesDeSibiu = new HashMap<>();
        coneccionesDeSibiu.put("Arad", 140);
        coneccionesDeSibiu.put("Oradea", 151);
        coneccionesDeSibiu.put("Fagaras", 99);
        coneccionesDeSibiu.put("Rimnicu Vilcea", 80);
        mapaRumania.put("Sibiu", coneccionesDeSibiu);
        //Timisoara
        HashMap<String, Integer> coneccionesDeTimisoara = new HashMap<>();
        coneccionesDeTimisoara.put("Arad", 118);
        coneccionesDeTimisoara.put("Lugoj", 111);
        mapaRumania.put("Timisoara", coneccionesDeTimisoara);
        //Lugoj
        HashMap<String, Integer> coneccionesDeLugoj = new HashMap<>();
        coneccionesDeLugoj.put("Timisoara", 111);
        coneccionesDeLugoj.put("Mehadia", 70);
        mapaRumania.put("Lugoj", coneccionesDeLugoj);
        //Mehadia
        HashMap<String, Integer> coneccionesDeMehadia = new HashMap<>();
        coneccionesDeMehadia.put("Lugoj", 70);
        coneccionesDeMehadia.put("Dobreta", 75);
        mapaRumania.put("Mehadia", coneccionesDeMehadia);
        //Dobreta
        HashMap<String, Integer> coneccionesDeDobreta = new HashMap<>();
        coneccionesDeDobreta.put("Mehadia", 75);
        coneccionesDeDobreta.put("Craiova", 120);   
        mapaRumania.put("Dobreta", coneccionesDeDobreta);
        //Craiova
        HashMap<String, Integer> coneccionesDeCraiova = new HashMap<>();
        coneccionesDeCraiova.put("Dobreta", 120);
        coneccionesDeCraiova.put("Rimnicu Vilcea", 146);
        coneccionesDeCraiova.put("Pitesti", 138);
        mapaRumania.put("Craiova", coneccionesDeCraiova);
        //Rimnicu Vilcea
        HashMap<String, Integer> coneccionesDeRimnicuVilcea = new HashMap<>();
        coneccionesDeRimnicuVilcea.put("Sibiu", 80);
        coneccionesDeRimnicuVilcea.put("Craiova", 146);
        coneccionesDeRimnicuVilcea.put("Pitesti", 97);
        mapaRumania.put("Rimnicu Vilcea", coneccionesDeRimnicuVilcea);
        //Fagaras
        HashMap<String, Integer> coneccionesDeFagaras = new HashMap<>();
        coneccionesDeFagaras.put("Sibiu", 99);
        coneccionesDeFagaras.put("Bucharest", 211);
        mapaRumania.put("Fagaras", coneccionesDeFagaras);
        //Pitesti
        HashMap<String, Integer> coneccionesDePitesti = new HashMap<>();
        coneccionesDePitesti.put("Rimnicu Vilcea", 97);
        coneccionesDePitesti.put("Craiova", 138);
        coneccionesDePitesti.put("Bucarest", 101);
        mapaRumania.put("Pitesti", coneccionesDePitesti);
        //Bucharest
        HashMap<String, Integer> coneccionesDeBucarest = new HashMap<>();
        coneccionesDeBucarest.put("Fagaras", 211);
        coneccionesDeBucarest.put("Pitesti", 101);
        coneccionesDeBucarest.put("Giurgiu", 90);
        coneccionesDeBucarest.put("Urziceni", 85);
        mapaRumania.put("Bucharest", coneccionesDeBucarest);
        //Giurgiu
        HashMap<String, Integer> coneccionesDeGiurgiu = new HashMap<>();
        coneccionesDeGiurgiu.put("Bucarest", 90);
        mapaRumania.put("Giurgiu", coneccionesDeGiurgiu);
        //Urziceni
        HashMap<String, Integer> coneccionesDeUrziceni = new HashMap<>();
        coneccionesDeUrziceni.put("Bucarest", 85);
        coneccionesDeUrziceni.put("Hirsova", 98);   
        coneccionesDeUrziceni.put("Vaslui", 142);
        mapaRumania.put("Urziceni", coneccionesDeUrziceni);
        //Hirsova
        HashMap<String, Integer> coneccionesDeHirsova = new HashMap<>();
        coneccionesDeHirsova.put("Urziceni", 98);   
        coneccionesDeHirsova.put("Efiore", 86);
        mapaRumania.put("Hirsova", coneccionesDeHirsova);
        //Eforie
        HashMap<String, Integer> coneccionesDeEfiore = new HashMap<>();
        coneccionesDeEfiore.put("Hirsova", 86);
        mapaRumania.put("Efiore", coneccionesDeEfiore);
        //Vaslui
        HashMap<String, Integer> coneccionesDeVaslui = new HashMap<>();
        coneccionesDeVaslui.put("Urziceni", 142);
        coneccionesDeVaslui.put("Iasi", 92);
        mapaRumania.put("Vaslui", coneccionesDeVaslui);
        //Iasi
        HashMap<String, Integer> coneccionesDeIasi = new HashMap<>();
        coneccionesDeIasi.put("Vaslui", 92);
        coneccionesDeIasi.put("Neamt", 87);
        mapaRumania.put("Iasi", coneccionesDeIasi);
        //Neamt
        HashMap<String, Integer> coneccionesDeNeamt = new HashMap<>();
        coneccionesDeNeamt.put("Iasi", 87);
        mapaRumania.put("Neamt", coneccionesDeNeamt);
        return mapaRumania;
    }

    //Método para acceder al mapa desde una instancia
    public HashMap<String, HashMap<String, Integer>> getMapa() {
        return mapa;
    }
}

