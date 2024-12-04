package bidimensionales.Ejercicio8;

public class Ejercicio8 {
    // Códigos de color ANSI
    static final String MARRON = "\u001B[48;5;130m";  // Fondo marrón
    static final String NARANJA = "\u001B[48;5;215m";  // Fondo naranja
    static final String ALFIL = "♗";  // Símbolo del alfil
    static final String PUNTO = "•";   // Símbolo para movimientos posibles
    static final String RESET = "\u001B[0m";
    
    public static void main(String[] args) {
        // Crear tablero
        String[][] tablero = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = " ";
            }
        }
        
        // Pedir posición del alfil
        System.out.print("Introduzca la posición del alfil (por ejemplo d5): ");
        String posicion = System.console().readLine().toLowerCase();
        
        // Validar entrada
        if (posicion.length() != 2 || 
            posicion.charAt(0) < 'a' || posicion.charAt(0) > 'h' ||
            posicion.charAt(1) < '1' || posicion.charAt(1) > '8') {
            System.out.println("Posición no válida");
            return;
        }
        
        // Convertir posición a coordenadas del array
        int columna = posicion.charAt(0) - 'a';
        int fila = 8 - (posicion.charAt(1) - '0');
        
        // Colocar alfil
        tablero[fila][columna] = ALFIL;
        
        // Calcular y marcar movimientos posibles
        System.out.println("\nEl alfil puede moverse a las siguientes posiciones:");
        
        // Concatenar movimientos de las cuatro diagonales
        String movimientos = marcarDiagonal(tablero, fila, columna, -1, 1)   // Superior derecha
                         + marcarDiagonal(tablero, fila, columna, -1, -1)    // Superior izquierda
                         + marcarDiagonal(tablero, fila, columna, 1, 1)      // Inferior derecha
                         + marcarDiagonal(tablero, fila, columna, 1, -1);    // Inferior izquierda
        
        System.out.println(movimientos);
        
        // Mostrar tablero
        System.out.println("\n   a  b  c  d  e  f  g  h");
        
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i)+" ");
            for (int j = 0; j < 8; j++) {
                // Alternar colores del tablero empezando con naranja en a8
                String color = ((i + j) % 2 == 1) ? MARRON : NARANJA;
                System.out.print(color + " " + tablero[i][j] + " " + RESET);
            }
            System.out.println();
        }
    }
    
    private static String marcarDiagonal(String[][] tablero, int fila, int columna, 
                                       int incFila, int incColumna) {
        String movimientos = "";
        int f = fila + incFila;
        int c = columna + incColumna;
        
        while (f >= 0 && f < 8 && c >= 0 && c < 8) {
            tablero[f][c] = PUNTO;
            char letraColumna = (char)('a' + c);
            int numeroFila = 8 - f;
            movimientos += letraColumna + "" + numeroFila + " ";
            f += incFila;
            c += incColumna;
        }
        
        return movimientos;
    }
} 