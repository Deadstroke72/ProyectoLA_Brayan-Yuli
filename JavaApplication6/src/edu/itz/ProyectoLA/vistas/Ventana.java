/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.itz.proyectoLA.vistas;

import edu.itz.proyectoLA.control.Control;
import javax.swing.JTextArea;

/**
 *
 * @author josem
 */
public class Ventana extends javax.swing.JFrame {

    Control control;

    /**
     * Creates new form ventana
     */
    public Ventana() {
        initComponents();
        control = new Control(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtCodigo = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMensajes = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnubArchivo = new javax.swing.JMenu();
        mnuAbrir = new javax.swing.JMenuItem();
        mnuLimpiar = new javax.swing.JMenuItem();
        mnuSalir = new javax.swing.JMenuItem();
        mnubCompilar = new javax.swing.JMenu();
        mnuLexico = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtCodigo.setColumns(20);
        txtCodigo.setRows(5);
        jScrollPane1.setViewportView(txtCodigo);

        txtMensajes.setColumns(20);
        txtMensajes.setRows(5);
        jScrollPane2.setViewportView(txtMensajes);

        mnubArchivo.setText("Archivo");

        mnuAbrir.setText("Abrir");
        mnuAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAbrirActionPerformed(evt);
            }
        });
        mnubArchivo.add(mnuAbrir);

        mnuLimpiar.setText("Limpiar");
        mnuLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLimpiarActionPerformed(evt);
            }
        });
        mnubArchivo.add(mnuLimpiar);

        mnuSalir.setText("Salir");
        mnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirActionPerformed(evt);
            }
        });
        mnubArchivo.add(mnuSalir);

        jMenuBar1.add(mnubArchivo);

        mnubCompilar.setText("Compilar");

        mnuLexico.setText("Léxico");
        mnuLexico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLexicoActionPerformed(evt);
            }
        });
        mnubCompilar.add(mnuLexico);

        jMenuBar1.add(mnubCompilar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAbrirActionPerformed
        control.abrirArchivo();
    }//GEN-LAST:event_mnuAbrirActionPerformed

    private void mnuLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLimpiarActionPerformed
        control.limpiar();
    }//GEN-LAST:event_mnuLimpiarActionPerformed

    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
       dispose();
    }//GEN-LAST:event_mnuSalirActionPerformed

    private void mnuLexicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLexicoActionPerformed
        control.lexemas();
    }//GEN-LAST:event_mnuLexicoActionPerformed

    /**
     * @return
     */
    public JTextArea getTxtCodigo() {
        return txtCodigo;
    }

    public JTextArea getTxtMensajes() {
        return txtMensajes;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem mnuAbrir;
    private javax.swing.JMenuItem mnuLexico;
    private javax.swing.JMenuItem mnuLimpiar;
    private javax.swing.JMenuItem mnuSalir;
    private javax.swing.JMenu mnubArchivo;
    private javax.swing.JMenu mnubCompilar;
    private javax.swing.JTextArea txtCodigo;
    private javax.swing.JTextArea txtMensajes;
    // End of variables declaration//GEN-END:variables
}
