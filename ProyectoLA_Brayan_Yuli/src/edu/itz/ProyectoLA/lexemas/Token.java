/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.itz.ProyectoLA.lexemas;

/**
 *
 * @author josem
 */
public enum Token {

    PUNTO(".", 2),
    COMA(",", 8),
    IGUAL("=", 10),
    PUNTO_Y_COMA(";", 12),
    IGUAL_IGUAL("==", 18),
    DIFERENTE("<>", 20),
    MENOR("<", 22),
    MAYOR(">", 24),
    MENOR_IGUAL("<=", 26),
    MAYOR_IGUAL(">=", 28),
    LLAVE_ABRE("{", 30),
    LLAVE_CIERRA("}", 32),
    DOS_PUNTOS(":", 46),
    FLECHA_DER("->", 50),
    FLECHA_IZQ("<-", 52),
    SUMA("+", 54),
    RESTA("-", 56),
    PAREN_ABRE("(", 58),
    PAREN_CIERRA(")", 60),
    MULTIPLICA("*", 62),
    DIVIDE("/", 64),
    
    Proced("proced", 16),
    
    Print("print", 34),
    
    Input("input", 38),
    
    Exec("exec", 40),
    
    If("if", 42),
    
    While("while", 44),
    
    For("for", 48),
    
    Const("const", 4),
    
    Var("var", 14);

    private final String elemento;
    private final int token;
    
    
    
    public String getElemento() {
        return elemento;
    }

    public int getToken() {
        return token;
    }

    Token(String elemento, int token) {
        this.elemento = elemento;
        this.token = token;
    }

    public static Token buscarPorSimbolo(String simbolo) {
        for (Token t : Token.values()) {
            if (t.elemento.equalsIgnoreCase(simbolo)) {
                return t;
            }
        }
        return null;
    }

}
