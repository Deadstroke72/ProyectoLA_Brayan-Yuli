/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.itz.proyectoLA.control;

import edu.itz.ProyectoLA.lexemas.Token;
import edu.itz.proyectoLA.vistas.Ventana;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        int CONST = 4;
        int VAR = 14;
        int ID = 6;
        int NUM = 36;

        Pattern patron = Pattern.compile(
                "==|<=|>=|<>|->|<-|[{}();=:+\\-*/<>.,]"
                + // símbolos
                "|\\b(int|double|String|boolean|char|long|proced|print|input|exec|if|while|for)\\b"
                + // palabras clave
                "|\\d+(\\.\\d+)?"
                + // números
                "|\\b[a-zA-Z_][a-zA-Z0-9_]*\\b" // identificadores
        );

        Matcher match = patron.matcher(texto);

        while (match.find()) {
            String encontrado = match.group();
            Token token = Token.buscarPorSimbolo(encontrado);

            if (token == null) {
                if (encontrado.matches("\\d+(\\.\\d+)?")) {
                    vent.getTxtMensajes().append(encontrado + " -> " + NUM + "\n");
                /*} else if (encontrado.matches("")) {
                   // vent.getTxtMensajes().append(encontrado + " -> " + CONST + "\n");
                //}  else if (encontrado.matches("")) {
                     vent.getTxtMensajes().append(encontrado + " -> " + VAR + "\n");*/
                } else if (encontrado.matches("[a-zA-Z]+")) {
                    vent.getTxtMensajes().append(encontrado + " -> " + ID + "\n");
                }
            } else {
                vent.getTxtMensajes().append(encontrado + " -> " + token.getToken() + "\n");
            }
        }
    }
}
