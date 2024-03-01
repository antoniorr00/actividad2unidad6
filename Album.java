package Ej1;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    String nombre;
    String artista;
    ArrayList<Cancion> canciones = new ArrayList<>();

    public Album(String nombre, String artista) {
        this.nombre = nombre;
        this.artista = artista;
    }

    private Cancion findSong(String titulo) {
        for (int i = 0; i < canciones.size(); i++) {
            if (canciones.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                return canciones.get(i); //devuelve el titulo de la cancion en esa posicion porque existe
            }
        }
        return null; // si no existe devuelve null
    }
    //TAMBIEN SE PODRÍA HACER ASI:
    //for (Cancion cancion : canciones) {
    //            if (cancion.getTitulo().equalsIgnoreCase(titulo)) {
    //                return cancion;
    //            }
    //        }
    //        return null;
    //    }


    public boolean addSong(String titulo, double duracion) {
        if (findSong(titulo) == null) { //si la cancion no existe
            canciones.add(new Cancion(titulo, duracion)); //añade la cancion
            return true;
        } else {
            return false; //si la cancion existe no te dejará añadirla
        }
    }

    public boolean addToPlayList(int numeroDePista, LinkedList<Cancion> List) {
        int index = numeroDePista-1; //Ponemos -1 para que la lista empiece en 0 en lugar de 1
        if (index >= 0 && index < canciones.size()){ //vemos si el indice se encuentra dentro del rango
            if (findSong(canciones.get(index).getTitulo()) != null) { //vemos si la canción existe comparando el indice y el titulo de la cancion
                List.add(canciones.get(index));
                return true; //se ha añadido la cancion
            }else{
                System.out.println("La canción no está dentro del album");
                return false; //no se añade la cancion
            }
        }else {
            System.out.println("El número no se encuentra dentro del rango");
            return false; //no se añade la cancion
            }
        }


        public boolean addToPlayList (String titulo, LinkedList < Cancion > List){
            Cancion tituloCancion = findSong(titulo);
            if (titulo!=null) { //si existe
                List.add(tituloCancion); //se añadirá a la PlayList la cancion
                return true;
            } else {
                System.out.println("La canción "+titulo+" no se encuentra dentro del álbum.");
                return false; //Si existe no dejará que se añada el titulo devolviendonos un false
            }
        }
    }





