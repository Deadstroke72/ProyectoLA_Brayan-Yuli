/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.itz.ProyectoLA.control;

import edu.itz.proyectoLA.vistas.Ventana;
import java.util.ArrayList;

/**
 *
 * @author josem
 * @author yulie
 */
public class Sintaxis {

    private ArrayList<String> tokensLexicos;
    private int currentTokenIndex = 0;
    private String currentTokenValue;
    private int currentTokenType;
    private Ventana vent;  // Referencia a la ventana

    public Sintaxis(Ventana ventana) {
        this.vent = ventana;
    }

    public Sintaxis(ArrayList<String> tokensLexicos, Ventana vent) {
        this.tokensLexicos = tokensLexicos;
        this.vent = vent;
        if (!tokensLexicos.isEmpty()) {
            procesarTokenActual();
        }
    }

    private void procesarTokenActual() {
        if (currentTokenIndex < tokensLexicos.size()) {
            String tokenCompleto = tokensLexicos.get(currentTokenIndex);
            String[] partes = tokenCompleto.split(" -> ");

            currentTokenValue = partes[0];
            try {
                currentTokenType = Integer.parseInt(partes[1]);
            } catch (NumberFormatException e) {
                currentTokenType = -1; // Token desconocido
            }
        } else {
            currentTokenValue = "";
            currentTokenType = -1; // Fin de tokens
        }
    }

    private boolean avanzarToken() {
        currentTokenIndex++;
        if (currentTokenIndex < tokensLexicos.size()) {
            procesarTokenActual();
            return true;
        } else {
            currentTokenValue = "";
            currentTokenType = -1;
            System.out.println("Advertencia: Fin de tokens alcanzado");
            vent.getTxtMensajes().append("Advertencia: Fin de tokens alcanzado\n");
            return false;
        }
    }

    public void Programa() {
        Bloque();
        int tokenType = currentTokenType;
        if (tokenType != 2) {
            System.out.println("error: Token inesperado en Programa (.): " + currentTokenValue + "\n");
            vent.getTxtMensajes().append("error: Token inesperado en Programa (.): " + currentTokenValue + "\n");
            return;
        }
        System.out.println(".");
        vent.getTxtMensajes().append(".\n");
    }
    
    private void Bloque() {
        A2();
        B2();
        C1();
        Proposicion();
    }
    
    private void A1() {
        int tokenType = currentTokenType;
        if (tokenType != 6) {
            System.out.println("error: Token inesperado en A1 (id): " + currentTokenValue + "\n");
            vent.getTxtMensajes().append("error: Token inesperado en A1 (id): " + currentTokenValue + "\n");
            return;
        }
        System.out.println("id");
        vent.getTxtMensajes().append("id \n");
        avanzarToken();
        
        if (currentTokenType != 10) {
            System.out.println("error: Token inesperado en A1 (=): " + currentTokenValue + "\n");
            vent.getTxtMensajes().append("error: Token inesperado en A1 (=): " + currentTokenValue + "\n");
            return;
        }
        System.out.println("=");
        vent.getTxtMensajes().append("= \n");
        avanzarToken();

        if (currentTokenType != 36) {
            System.out.println("error: Token inesperado en A1 (num): " + currentTokenValue + "\n");
            vent.getTxtMensajes().append("error: Token inesperado en A1 (num): " + currentTokenValue + "\n");
            return;
        }
        System.out.println("num");
        vent.getTxtMensajes().append("num \n");
        avanzarToken();
        
        PA1NULL();
    }

    private void PA1NULL() {
        int tokenType = currentTokenType;
        if (tokenType != 8) {
            return;
        }
        System.out.println(",");
        vent.getTxtMensajes().append(", \n");
        avanzarToken();
        
        A1();
    }

    private void A2() {
        int tokenType = currentTokenType;
        if (tokenType != 4) {
            return;
        }
        System.out.println("Const");
        vent.getTxtMensajes().append("Const \n");
        avanzarToken();
        
        A1();

        if (currentTokenType != 12) {
            System.out.println("error: Token inesperado en A2 (;): " + currentTokenValue + "\n");
            vent.getTxtMensajes().append("error: Token inesperado en A2 (;): " + currentTokenValue + "\n");
            return;
        }
        System.out.println(";");
        vent.getTxtMensajes().append("; \n");
        avanzarToken();
    }
    
    private void B1() {
        int tokenType = currentTokenType;
        if (tokenType != 6) {
            System.out.println("error: Token inesperado en B1 (id): " + currentTokenValue + "\n");
            vent.getTxtMensajes().append("error: Token inesperado en B1 (id): " + currentTokenValue + "\n");
            return;
        }
        System.out.println("id");
        vent.getTxtMensajes().append("id \n");
        avanzarToken();
        
        PB1NULL();
    }

    private void PB1NULL() {
        int tokenType = currentTokenType;
        if (tokenType != 8) {
            return;
        }
        System.out.println(",");
        vent.getTxtMensajes().append(", \n");
        avanzarToken();
        
        B1();
    }

    private void B2() {
        int tokenType = currentTokenType;
        if (tokenType != 14) {
            return;
        }
        System.out.println("var");
        vent.getTxtMensajes().append("var \n");
        avanzarToken();
        
        B1();
        
        if (currentTokenType != 12) {
            System.out.println("error: Token inesperado en B2 (;): " + currentTokenValue + "\n");
            vent.getTxtMensajes().append("error: Token inesperado en B2 (;): " + currentTokenValue + "\n");
            return;
        }
        System.out.println(";");
        vent.getTxtMensajes().append("; \n");
        avanzarToken();
    }
    
    private void C1() {
        int tokenType = currentTokenType;
        if (tokenType != 16){
            return;
        }
        System.out.println("Proced");
        vent.getTxtMensajes().append("Proced \n");
        avanzarToken();

        if (currentTokenType != 6) {
            System.out.println("error: Token inesperado en C1 (id): " + currentTokenValue + "\n");
            vent.getTxtMensajes().append("error: Token inesperado en C1 (id): " + currentTokenValue + "\n");
            return;
        }
        System.out.println("id");
        vent.getTxtMensajes().append("id \n");
        avanzarToken();

        if (currentTokenType != 12) {
            System.out.println("error: Token inesperado en C1 (;): " + currentTokenValue + "\n");
            vent.getTxtMensajes().append("error: Token inesperado en C1 (;): " + currentTokenValue + "\n");
            return;
        }
        System.out.println(";");
        vent.getTxtMensajes().append("; \n");
        avanzarToken();
        
        Bloque();

        if (currentTokenType != 12) {
            System.out.println("error: Token inesperado en C1 (;): " + currentTokenValue + "\n");
            vent.getTxtMensajes().append("error: Token inesperado en C1 (;): " + currentTokenValue + "\n");
            return;
        }
        System.out.println(";");
        vent.getTxtMensajes().append("; \n");
        avanzarToken();
        
        C1();
    }
    
    private void Condicion() {
        Expresion();
        D1();
        Expresion();
    }
    
    private void D1() {
        int tokenType = currentTokenType;
        switch (tokenType) {
            case 18 -> {
                System.out.println("==");
                vent.getTxtMensajes().append("== \n");
                avanzarToken();
            }
            case 20 -> {
                System.out.println("<>");
                vent.getTxtMensajes().append("<> \n");
                avanzarToken();
            }
            case 22 -> {
                System.out.println("<");
                vent.getTxtMensajes().append("< \n");
                avanzarToken();
            }
            case 24 -> {
                System.out.println(">");
                vent.getTxtMensajes().append("> \n");
                avanzarToken();
            }
            case 26 -> {
                System.out.println("<=");
                vent.getTxtMensajes().append("<= \n");
                avanzarToken();
            }
            case 28 -> {
                System.out.println(">=");
                vent.getTxtMensajes().append(">= \n");
                avanzarToken();
            }
            default -> {
                System.out.println("error: Token inesperado en D1(==,<>,<,>,<=,>=): " + currentTokenValue + "\n");
                vent.getTxtMensajes().append("error: Token inesperado en D1(==,<>,<,>,<=,>=): " + currentTokenValue + "\n");
                return;
            }
        }   
    }
    
    private void Proposicion() {
        int tokenType = currentTokenType;
        switch (tokenType) {
            case 30 -> {
                E2();
            }
            case 6 -> {
                F1();
            }
            case 34 -> {
                G2();
            }
            case 38 -> {
                H1();
            }
            case 40 -> {
                I1();
            }
            case 42 -> {
                J1();
            }
            case 44 -> {
                K1();
            }
            case 48 -> {
                L2();
            }
            default -> {
                System.out.println("error: Token inesperado en Proposicion ({,id,print,input,exec,if,while,for): " + currentTokenValue + "\n");
                vent.getTxtMensajes().append("error: Token inesperado en Proposicion ({,id,print,input,exec,if,while,for): " + currentTokenValue + "\n");
                return;
            }
        }
    }
    
    private void E1() {
        Proposicion();
        PE1NULL();
    }

    private void PE1NULL() {
        int tokenType = currentTokenType;
        if (tokenType != 12) {
            return;
        }
        System.out.println(";");
        vent.getTxtMensajes().append("; \n");
        avanzarToken();
        
        E1();
    }

    private void E2() {
        int tokenType = currentTokenType;
        if (tokenType != 30) {
            System.out.println("error: Token inesperado en E2({): " + currentTokenValue + "\n");
            vent.getTxtMensajes().append("error: Token inesperado en E2({): " + currentTokenValue + "\n");
            return;
        }
        System.out.println("{");
        vent.getTxtMensajes().append("{ \n");
        avanzarToken();
        
        E1();
        
        if (currentTokenType != 32) {
            System.out.println("error: Token inesperado en E2(}): " + currentTokenValue + "\n");
            vent.getTxtMensajes().append("error: Token inesperado en E2(}): " + currentTokenValue + "\n");
            return;
        }
        System.out.println("}");
        vent.getTxtMensajes().append("} \n");
        avanzarToken();
    }
    
    private void F1() {
        int tokenType = currentTokenType;
        if (tokenType != 6) {
            System.out.println("error: Token inesperado en F1(id): " + currentTokenValue + "\n");
            vent.getTxtMensajes().append("error: Token inesperado en F1(id): " + currentTokenValue + "\n");
            return;
        }
        System.out.println("id");
        vent.getTxtMensajes().append("id \n");
        avanzarToken();

        if (currentTokenType != 10) {
            System.out.println("error: Token inesperado en F1(=): " + currentTokenValue + "\n");
            vent.getTxtMensajes().append("error: Token inesperado en F1(=): " + currentTokenValue + "\n");
            return;
        }
        System.out.println("=");
        vent.getTxtMensajes().append("= \n");
        avanzarToken();
        
        Expresion();
    }
    
    private void G1() {
        int tokenType = currentTokenType;
        switch (tokenType) {
            case 6 -> {
                System.out.println("id \n");
                vent.getTxtMensajes().append("id \n");
                avanzarToken();
            }
            case 36 -> {
                System.out.println("num \n");
                vent.getTxtMensajes().append("num \n");
                avanzarToken();
            }
            default -> {
                System.out.println("error: Token inesperado en G1: " + currentTokenValue);
                vent.getTxtMensajes().append("error: Token inesperado en G1: " + currentTokenValue + "\n");
                return;
            }
        }
    }

    private void G2() {
        int tokenType = currentTokenType;
        if (tokenType != 34) {
            System.out.println("error: Token inesperado en G2 (print): " + currentTokenValue + "\n");
            vent.getTxtMensajes().append("error: Token inesperado en G2 (print): " + currentTokenValue + "\n");
            return;
        }
        System.out.println("print");
        vent.getTxtMensajes().append("print \n");
        avanzarToken();
        
        G1();
    }
    
    private void H1() {
        int tokenType = currentTokenType;
        if (tokenType != 38) {
            System.out.println("error: Token inesperado en H1(input): " + currentTokenValue);
            vent.getTxtMensajes().append("error: Token inesperado en H1(input): " + currentTokenValue + "\n");
            return;
        }
        System.out.println("input");
        vent.getTxtMensajes().append("input \n");
        avanzarToken();

        if (currentTokenType != 6) {
            System.out.println("error: Token inesperado en H1 (id): " + currentTokenValue + "\n");
            vent.getTxtMensajes().append("error: Token inesperado en H1 (id): " + currentTokenValue + "\n");
            return;
        }
        System.out.println("id");
        vent.getTxtMensajes().append("id \n");
        avanzarToken();
    }
    
    private void I1() {
        int tokenType = currentTokenType;
        if (tokenType != 40) {
            System.out.println("error: Token inesperado en I1 (exec): " + currentTokenValue + "\n");
            vent.getTxtMensajes().append("error: Token inesperado en I1 (exec): " + currentTokenValue + "\n");
            return;
        }
        System.out.println("exec");
        vent.getTxtMensajes().append("exec \n");
        avanzarToken();

        if (currentTokenType != 6) {
            System.out.println("error: Token inesperado en I1 (id): " + currentTokenValue + "\n");
            vent.getTxtMensajes().append("error: Token inesperado en I1 (id): " + currentTokenValue + "\n");
            return;
        }
        System.out.println("id");
        vent.getTxtMensajes().append("id \n");
        avanzarToken();
    }
    
    private void J1() {
        int tokenType = currentTokenType;
        if (tokenType != 42) {
            System.out.println("error: Token inesperado en J1 (if): " + currentTokenValue + "\n");
            vent.getTxtMensajes().append("error: Token inesperado en J1 (if): " + currentTokenValue + "\n");
            return;
        }
        System.out.println("if");
        vent.getTxtMensajes().append("if \n");
        avanzarToken();
        
        Condicion();

        if (currentTokenType != 46) {
            System.out.println("error: Token inesperado en J1 (:): " + currentTokenValue + "\n");
            vent.getTxtMensajes().append("error: Token inesperado en J1 (:): " + currentTokenValue + "\n");
            return;
        }
        System.out.println(":");
        vent.getTxtMensajes().append(": \n");
        avanzarToken();
        
        Proposicion();
    }
    
    private void K1() {
        int tokenType = currentTokenType;
        if (tokenType != 44) {
            System.out.println("error: Token inesperado en K1 (while): " + currentTokenValue + "\n");
            vent.getTxtMensajes().append("error: Token inesperado en K1 (while): " + currentTokenValue + "\n");
            return;
        }
        System.out.println("while");
        vent.getTxtMensajes().append("while \n");
        avanzarToken();
        
        Condicion();

        if (currentTokenType != 46) {
            System.out.println("error: Token inesperado en K1 (:): " + currentTokenValue + "\n");
            vent.getTxtMensajes().append("error: Token inesperado en K1 (:): " + currentTokenValue + "\n");
            return;
        }
        System.out.println(":");
        vent.getTxtMensajes().append(": \n");
        avanzarToken();
        
        Proposicion();
    }

    private void L1() {
        int tokenType = currentTokenType;
        switch (tokenType) {
            case 50 -> {
                System.out.println("->");
                vent.getTxtMensajes().append("-> \n");
                avanzarToken();
            }
            case 52 -> {
                System.out.println("<-");
                vent.getTxtMensajes().append("<- \n");
                avanzarToken();
            }
            default -> {
                System.out.println("error: Token inesperado en L1 (->,<-): " + currentTokenValue + "\n");
                vent.getTxtMensajes().append("error: Token inesperado en L1(->,<-): " + currentTokenValue + "\n");
                return;
            }
        }
    }

    private void L2() {
        int tokenType = currentTokenType;
        if (tokenType != 48) {
            System.out.println("error: Token inesperado en L2 (for): " + currentTokenValue);
            vent.getTxtMensajes().append("error: Token inesperado en L2(for): " + currentTokenValue + "\n");
            return;
        }
        System.out.println("for");
        vent.getTxtMensajes().append("for \n");
        avanzarToken();

        if (currentTokenType != 6) {
            System.out.println("error: Token inesperado en L2 (id): " + currentTokenValue + "\n");
            vent.getTxtMensajes().append("error: Token inesperado en L2 (id): " + currentTokenValue + "\n");
            return;
        }
        System.out.println("id");
        vent.getTxtMensajes().append("id \n");
        avanzarToken();

        if (currentTokenType != 10) {
            System.out.println("error: Token inesperado en L2 (=): " + currentTokenValue + "\n");
            vent.getTxtMensajes().append("error: Token inesperado en L2 (=): " + currentTokenValue + "\n");
            return;
        }
        System.out.println("=");
        vent.getTxtMensajes().append("= \n");
        avanzarToken();
        
        Expresion();
        L1();
        Expresion();

        if (currentTokenType != 46) {
            System.out.println("error: Token inesperado en L2 (:): " + currentTokenValue + "\n");
            vent.getTxtMensajes().append("error: Token inesperado en L2 (:): " + currentTokenValue + "\n");
            return;
        }
        System.out.println(":");
        vent.getTxtMensajes().append(": \n");
        avanzarToken();
        
        Proposicion();
    }
    
    private void Expresion() {
        Termino();
        EM1NULL();
    }

    private void EM1NULL() {
        int tokenType = currentTokenType;
        if (tokenType != 54 && tokenType != 56) {
            return;
        }
        M1();
        Expresion();
    }
    
    private void M1() {
        int tokenType = currentTokenType;
        switch (tokenType) {
            case 54 -> {
                System.out.println("+");
                vent.getTxtMensajes().append("+ \n");
                avanzarToken();
            }
            case 56 -> {
                System.out.println("-");
                vent.getTxtMensajes().append("- \n");
                avanzarToken();
            }
            default -> {
                System.out.println("error: Token inesperado en M1(+,-): " + currentTokenValue+ "\n");
                vent.getTxtMensajes().append("error: Token inesperado en M1(+,-): " + currentTokenValue + "\n");
                return;
            }
        }

    }
    
    private void Termino() {
        Factor();
        TN1NULL();
    }

    private void TN1NULL() {
        int tokenType = currentTokenType;
        if (tokenType != 64 && tokenType != 62) {
            return;
        }
        N1();
        Termino();
    }
    
    private void N1() {
        int tokenType = currentTokenType;
        switch (tokenType) {
            case 64 -> {
                System.out.println("/");
                vent.getTxtMensajes().append("/ \n");
                avanzarToken();
            }
            case 62 -> {
                System.out.println("*");
                vent.getTxtMensajes().append("* \n");
                avanzarToken();
            }
            default -> {
                System.out.println("error: Token inesperado en N1(*,/): " + currentTokenValue + "\n");
                vent.getTxtMensajes().append("error: Token inesperado en N1(*,/): " + currentTokenValue + "\n");
                return;
            }
        }
    }
    
    private void Factor() {
        switch (currentTokenType) {
            case 58 -> O1();
            case 6 -> {
                System.out.println("id \n");
                vent.getTxtMensajes().append("id \n");
                avanzarToken();
            }
            case 36 -> {  
                System.out.println("num \n");
                vent.getTxtMensajes().append("num \n");
                avanzarToken();
            }
            default -> {
                System.out.println("error: Token inesperado en Factor((,id,num): " + currentTokenValue + "\n");
                vent.getTxtMensajes().append("error: Token inesperado en Factor((,id,num): " + currentTokenValue + "\n");
                return;
            }
        }
    }

    private void O1() {
        int tokenType = currentTokenType;
        if (tokenType != 58) {
            System.out.println("error: Token inesperado en O1((): " + currentTokenValue + "\n");
            vent.getTxtMensajes().append("error: Token inesperado en O1((): " + currentTokenValue + "\n");
            return;
        }
        System.out.println("(");
        vent.getTxtMensajes().append("( \n");
        avanzarToken();
        
        Expresion();
        
        if (currentTokenType != 60) {
            System.out.println("error: Token inesperado en O1 ()): " + currentTokenValue + "\n");
            vent.getTxtMensajes().append("error: Token inesperado en O1 ()): " + currentTokenValue + "\n");
            return;
        }
        System.out.println(")");
        vent.getTxtMensajes().append(") \n");
        avanzarToken();
    }
}