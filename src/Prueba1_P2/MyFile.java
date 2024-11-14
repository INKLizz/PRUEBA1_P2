/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba1_P2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Cristina Sabillon
 */
public class MyFile {

    private File mifile = null;

    void setFile(String direccion) {
        mifile = new File(direccion);
    }

    void info() {
        if (mifile.exists()) {
            System.out.println("\nNombre: " + mifile.getName()
                    + "\nPath: " + mifile.getPath()
                    + "\nAbsoluta: " + mifile.getAbsolutePath()
                    + "\nBytes: " + mifile.length()
                    + "\nModificado en : " + new Date(mifile.lastModified())
                    + "\nPadre: " + mifile.getAbsoluteFile().getParentFile().getName());
            if (mifile.isFile()) {
                System.out.println("Es una archivo!");
            } else if (mifile.isDirectory()) {
                System.out.println("Es un folder!");
            }
            System.out.println("-+-+-+-+-+-+-+-+-+--+-+-+-+-+-+-+-+-");
        } else {
            System.out.println("No existe!");
        }
    }

    boolean crearFile() throws IOException {
        return mifile.createNewFile();
    }

    boolean crearFolder() {
        return mifile.mkdirs();
    }

    boolean borrar(String folderPath) {
        File folder = new File(folderPath);

        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    borrar(file.getPath());
                }
            }
        }
        return folder.delete();
    }

    void dir() {
        if (mifile.isDirectory()) {
            System.out.println("Directorio de : " + mifile.getAbsolutePath());
            System.out.println("");
            //contadores
            int cArchi = 0, cdir = 0, tbytes = 0;
            for (File child : mifile.listFiles()) {
                if (!child.isHidden()) {
                    //ultima modificacion
                    Date ult = new Date(child.lastModified());
                    System.out.print(ult + "\t ");
                    //si es file o folder
                    if (child.isDirectory()) {
                        cdir++;
                        System.out.print("<DIR>\t\t");
                    } else {
                        //File
                        cArchi++;
                        tbytes += child.length();
                        System.out.print("    \t" + child.length() + "\t");
                    }
                    //mostrar los objetos
                    System.out.println(child.getName());
                }
            }
            System.out.println(cArchi + " archivos\t" + tbytes + " bytes");
            System.out.println(cdir + " dirs\t");
        }
    }

    private void tree(File dir, String tab) {
        if (dir.isDirectory()) {
            System.out.println(tab + dir.getName());
            for (File child : dir.listFiles()) {
                if (!child.isHidden()) {
                    tree(child, tab + "--");
                }
            }
        }
    }

    void tree() {
        tree(mifile, "-");
    }

    void reescribir(String info) throws IOException {
        FileWriter write = new FileWriter(mifile);
        for (int indice = 0; indice < info.length(); indice++) {
            write.write(info.charAt(indice));
        }
        System.out.println("Se pudo reescribir!");
        write.close();
    }

    void añadirInfo(String info) throws IOException {
        FileWriter write = new FileWriter(mifile, true);
        for (int indice = 0; indice < info.length(); indice++) {
            write.append(info.charAt(indice));
        }
        System.out.println("Se pudo añadir informacion!");
        write.close();
    }

    void InfoFile() throws IOException {
        FileReader read = new FileReader(mifile);
        
        for (int indice = read.read() ; indice != -1 ; indice = read.read()) {
            System.out.print((char)indice);
        }
        read.close();
    }

    void InfoBuffer() throws IOException{
        FileReader read = new FileReader(mifile);
        BufferedReader rea = new BufferedReader(read);
        String info = rea.readLine();
        System.out.println(info);
    }
}
