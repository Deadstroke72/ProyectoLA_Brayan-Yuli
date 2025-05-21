/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.itz.proyectoLA.control;
import edu.itz.ProyectoLA.lexemas.Token;
import edu.itz.proyectoLA.vistas.Ventana;
import java.io.*;
import java.util.regex.*;
import javax.swing.*;

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
                texto += linea + "\n";
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        vent.getTxtCodigo().append(texto + "\n");

    }

    public void lexemas() {
        String texto = vent.getTxtCodigo().getText();  // texto del usuario
        vent.getTxtMensajes().setText("");  // limpiamos salida

        int ID = 6;
        int NUM = 36;

        Pattern patron = Pattern.compile(
                "==|<=|>=|<>|->|<-|[{}();=:+\\-*/<>.,]"
                + "|\\b(int|double|String|boolean|char|long|proced|print|input|exec|if|while|for)\\b" // palabras clave
                + "|[1-9][0-9]\\d*|0" // números
                + "|\\b[a-zA-Z_][a-zA-Z0-9_]*\\b"
                + "|(?<==)\\s*([a-zA-Z_][a-zA-Z0-9_]*)\\b"
        );

        Matcher match = patron.matcher(texto);

        while (match.find()) {
            String encontrado = match.group();
            Token token = Token.buscarPorSimbolo(encontrado);

            if (token == null) {
                if (encontrado.matches("[1-9][0-9]\\d*|0")) {
                    vent.getTxtMensajes().append(encontrado + " -> " + NUM + "\n");
                } else if (encontrado.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
                    vent.getTxtMensajes().append(encontrado + " -> " + ID + "\n");
                }
            } else {
                vent.getTxtMensajes().append(encontrado + " -> " + token.getToken() + "\n");
            }
        }
    }
}
