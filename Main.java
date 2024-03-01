package Ej1;

import java.util.*;

public class Main {
    private static Scanner scanner=new Scanner(System.in);



    public static void imprimirMenu() {
        System.out.println("0 - Salir de la lista de reproducción");
        System.out.println("1 - Reproducir siguiente canción en la lista");
        System.out.println("2 - Reproducir la canción previa de la lista");
        System.out.println("3 - Repetir la canción actual");
        System.out.println("4 - Imprimir la lista de canciones en la playlist");
        System.out.println("5 - Volver a imprimir el menú");
        System.out.println("6 - Eliminar canción actual de la playlist");
    }

    public static void printPlayList(LinkedList<Cancion>PlayList){
        ListIterator<Cancion> iterator =PlayList.listIterator();
        System.out.println("Lista de reproducción: ");
        int cont=1;
        while (iterator.hasNext()){
            System.out.println(cont+"- "+iterator.next().toString());
            cont++;
        }
    }

    public static void main(String[] args) {


        ArrayList<Album> albums= new ArrayList<>();

        Album albumFeid=new Album("Ferxxo","Feid");
        albumFeid.addSong("Porfa",3.5);
        albumFeid.addSong("Classy 101",2.47);
        albumFeid.addSong("Hola", 3.2);
        albumFeid.addSong("Ferxxo",3.3);

        Album albumAnuel=new Album("RHLM", "Anuel");
        albumAnuel.addSong("Dime tu", 2.57);
        albumAnuel.addSong("Bandida", 3.12);
        albumAnuel.addSong("Brindemos", 3.45);
        albumAnuel.addSong("Culpables", 3.27);

        albums.add(albumFeid);
        albums.add(albumAnuel);

        LinkedList<Cancion> PlayList=new LinkedList<Cancion>();
        albumFeid.addToPlayList("Porfa", PlayList);
        albumFeid.addToPlayList(2, PlayList);
        albumFeid.addToPlayList(4, PlayList);
        albumAnuel.addToPlayList("Dime tu", PlayList);
        albumAnuel.addToPlayList(2, PlayList);
        albumAnuel.addToPlayList(4, PlayList);

        ListIterator<Cancion> listIterator=PlayList.listIterator(); //Utilizamos el list iterator para ir hacia adelante y hacia atrás

        boolean haciaAdelante=true;
        boolean continuar = true;
        int opcion = 0;
        imprimirMenu();

        try {

            while(continuar) {
                System.out.println("Elige una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 0:
                        continuar = false;
                        break;

                    case 1:
                        if (!haciaAdelante){
                            if (listIterator.hasNext())   //Comprueba que hay una siguiente canción a la que estamos reproduciendo
                                listIterator.next();
                            haciaAdelante=true;
                        }
                        if (listIterator.hasNext()){
                            System.out.println("Reproduciendo: "+listIterator.next().getTitulo()); //nos muestra la siguiente canción
                        }else {
                            System.out.println("Es la última canción de la playlist, estás en el final de la PlayList.");
                            haciaAdelante=true;
                        }
                        break;
                    case 2:
                        if (haciaAdelante){    //Nos muestra que hay una canción antes que la que se está reproduciendo
                            if (listIterator.hasPrevious())
                                listIterator.previous();
                            haciaAdelante=false;
                        }
                        if (listIterator.hasPrevious()){
                            System.out.println("Reproduciendo: "+listIterator.previous().getTitulo()); //nos muestra la canción anterior
                        }else {
                            System.out.println("No hay canciones anteriores a la que se está reproduciendo, estás en el inicio de la PlayList");
                            haciaAdelante=false;
                        }
                        break;

                    case 3:
                        if (haciaAdelante && listIterator.hasPrevious()){
                            System.out.println("Reproduciendo: "+listIterator.previous().getTitulo());
                            haciaAdelante=false;
                        }else if (!haciaAdelante && listIterator.hasNext()){
                            System.out.println("Reproduciendo: "+listIterator.next().getTitulo());
                            haciaAdelante=true;
                        }else {
                            System.out.println("La canción no se puede repetir");
                        }
                        break;

                    case 4:
                        printPlayList(PlayList);
                        break;

                    case 5:
                        imprimirMenu();
                        break;
                    case 6:
                        if (haciaAdelante && listIterator.hasPrevious()){
                            System.out.println("Se ha eliminado la canción "+listIterator.previous().getTitulo());
                            listIterator.remove();
                            if (listIterator.hasNext()){
                                listIterator.next();
                                System.out.println("Se está reproduciendo: "+listIterator.previous().getTitulo());
                            }
                            haciaAdelante=false;
                        } else if(!haciaAdelante && listIterator.hasNext()){
                            System.out.println("Se ha eliminado la canción "+listIterator.next().getTitulo());
                            listIterator.remove();
                            if (listIterator.hasPrevious()){
                                listIterator.previous();
                                System.out.println("Se está reproduciendo: "+listIterator.next().getTitulo());
                            }
                        }
                        break;
                    default:
                        System.out.println("Opción no válida");
                        continuar=true;
                        break;

                }
            }
            scanner.close();
        }
        catch (InputMismatchException e){
            System.out.println("Carácter no válido");
            scanner.nextLine();
            continuar=true;

        }
    }
}

