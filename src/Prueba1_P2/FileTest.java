/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba1_P2;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Laura Sabillon
 */
public class FileTest {

    public static void main(String[] args) {
        MyFile file = new MyFile();
        String path = "";
        Scanner scan = new Scanner(System.in).useDelimiter("\n");

        while (true) {
            System.out.println("\n1.- Set Archivo/Folder    ");
            System.out.println("2.- Ver informacion         ");
            System.out.println("3.- Crear un Archivo        ");
            System.out.println("4.- Crear un Folder         ");
            System.out.println("5.- Borrar                  ");
            System.out.println("6.- DIR                     ");
            System.out.println("7.- Tree                    ");
            System.out.println("8.- REESCRIBIR E ANADIR     ");
            System.out.println("10.- LEER INFO              ");
            System.out.println("11.- Salir                  ");
            System.out.println("Escoja una opcion.          ");
            try {
                int ventana = scan.nextInt();

                if (ventana == 1) {
                    System.out.println("\n  -     SET ARCHIVO/ FOLDER     -");
                    String direc = scan.next();
                    file.setFile(direc);
                    path = direc;
                }

                if (ventana == 2) {
                    System.out.println("\n -      VER INFORMACION         -");
                    file.info();
                }
                if (ventana == 3) {
                    System.out.println("\n -      CREAR ARCHIVO           -");
                    if (file.crearFile()) {
                        System.out.println("Archivo creado!");
                    } else {
                        System.out.println("Archivo no creado!");
                    }

                }
                if (ventana == 4) {
                    System.out.println("\n -      CREAR FOLDER            -");
                    if (file.crearFolder()) {
                        System.out.println("Folder creado!");
                    } else {
                        System.out.println("Folder no creado!");
                    }
                }
                if (ventana == 5) {
                    System.out.println("\n-          BORRAR                  -");
                    if (file.borrar(path)) {
                        System.out.println("Se borro!");
                    } else {
                        System.out.println("No se borro!");
                    }
                }
                if (ventana == 6) {
                    System.out.println("\n-       DIR         -");
                    file.dir();
                }
                if (ventana == 7) {
                    System.out.println("\n-       TREE         -");
                    System.out.println("");
                    file.tree();
                }
                if (ventana == 8) {
                    System.out.println("-       INFORMACION         -");
                    System.out.println("1.- Reescribir informacion  ");
                    System.out.println("2.- Anadir informacion      ");
                    System.out.println("Escoja una opcion.");
                    int opcion = scan.nextInt();

                    if (opcion == 1) {
                        System.out.println("-       REESCRIBIR INFORMACION          -");
                        String escribir = scan.next();
                        file.reescribir(escribir);
                    }
                    if (opcion == 2) {
                        System.out.println("-       ANADIR INFORMACION             -");
                        String añadir = scan.next();
                        file.añadirInfo(añadir);

                    }
                }

                if (ventana == 10) {
                    System.out.println("\n-            LEER INFO             -");
                    System.out.println("1.- Leer con FileReader");
                    System.out.println("2.- Leer con BufferedReader");
                    System.out.println("Escojer una opcion.");
                    int opcion = scan.nextInt();

                    if (opcion == 1) {
                        System.out.println("-     INFORMACION (FILEREADER)      -");
                        System.out.println("");
                        file.InfoFile();
                        System.out.println("");
                    }
                    if (opcion == 2) {
                        System.out.println("-     INFORMACION (BUFFREADER)      -");
                        System.out.println("");
                        file.InfoBuffer();
                    }
                }

                if (ventana == 11) {
                    System.exit(0);
                }

            } catch (InputMismatchException e) {
                System.out.println("Ingrese una opcion valida!");
                scan.next();
            } catch (NullPointerException e) {
                System.out.println("Favor seleccionar opcion 1!");
            } catch (IOException e) {
                System.out.println("ERROR" + e.getMessage());
            }
        }
    }
}
