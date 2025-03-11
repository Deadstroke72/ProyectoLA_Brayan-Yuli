/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.itz.proyectoLA.control;

import edu.itz.proyectoLA.vistas.Ventana;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author yulie
 */
public class Control {

    Ventana vent;

    public Control(Ventana vent) {
        this.vent = vent;
    }

    public void abrirArchivo() {
        limpiar();
        String path = null;
        JFileChooser jfc = new JFileChooser();
        int returnVal = jfc.showOpenDialog(vent);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            path = jfc.getSelectedFile().getAbsolutePath();
            JOptionPane.showMessageDialog(vent, "Archivo seleccionado:\n" + path);
        }
        if (path == null) {
            JOptionPane.showMessageDialog(vent,
                    "No seleccionaste el archivo o diste cancelar");
            return;
        }
        leerArchivo(path);
    }

    public void limpiar() {
        vent.getTxtCodigo().setText("");
        vent.getTxtMensajes().setText("");
    }

    public void leerArchivo(String archivo) {
        String texto = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                texto += linea;
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        vent.getTxtCodigo().append(texto + "\n");
    }
}
