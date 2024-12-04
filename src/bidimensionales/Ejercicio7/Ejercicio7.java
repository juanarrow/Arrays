package bidimensionales.Ejercicio7;

public class Ejercicio7 {
    public static void main(String[] args) {
        // Crear el tablero
        String[][] tablero = new String[4][5];
        
        // Inicializar tablero vacío
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                tablero[i][j] = " ";
            }
        }
        
        // Colocar tesoro y mina aleatoriamente
        int tesoroX = 0;
        int tesoroY = 0;
        int minaX = 0, minaY = 0;
        
        do {
            tesoroX = (int)(Math.random() * 5);
            tesoroY = (int)(Math.random() * 4);
            minaX = (int)(Math.random() * 5);
            minaY = (int)(Math.random() * 4);
        } while (minaX == tesoroX && minaY == tesoroY); // Evitar que coincidan
        
        boolean juegoTerminado = false;
        
        while (!juegoTerminado) {
            // Mostrar tablero con las jugadas
            for (int i = 3; i >= 0; i--) {
                System.out.print(i + "| ");
                for (int j = 0; j < 5; j++) {
                    System.out.print(tablero[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("  ----------");
            System.out.println("   0 1 2 3 4");
            
            // Pedir coordenadas
            int x = -1;
            int y = -1;
            
            try {
                System.out.print("\nCoordenada x: ");
                String entradaX = System.console().readLine();
                if (entradaX == null || entradaX.trim().isEmpty()) {
                    System.out.println("Entrada no válida");
                    continue;
                }
                x = Integer.parseInt(entradaX.trim());
                
                System.out.print("Coordenada y: ");
                String entradaY = System.console().readLine();
                if (entradaY == null || entradaY.trim().isEmpty()) {
                    System.out.println("Entrada no válida");
                    continue;
                }
                y = Integer.parseInt(entradaY.trim());
                
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número válido");
                continue;
            }
            
            // Validar coordenadas
            if (x < 0 || x > 4 || y < 0 || y > 3) {
                System.out.println("Coordenadas fuera del tablero");
                continue;
            }
            
            // Comprobar si ha encontrado el tesoro
            if (x == tesoroX && y == tesoroY) {
                System.out.println("\n¡Enhorabuena! ¡Has encontrado el tesoro!");
                tablero[tesoroY][tesoroX] = "$";
                tablero[minaY][minaX] = "*";
                juegoTerminado = true;
            }
            // Comprobar si ha tocado la mina
            else if (x == minaX && y == minaY) {
                System.out.println("\nLo siento, la mina ha explotado.");
                tablero[tesoroY][tesoroX] = "$";
                tablero[minaY][minaX] = "*";
                juegoTerminado = true;
            }
            // Comprobar si hay una mina cerca
            else if (hayMinaCerca(x, y, minaX, minaY)) {
                System.out.println("\n¡Cuidado! ¡Hay una mina cerca!");
                tablero[y][x] = "X";
            }
            else {
                System.out.println("\nNo hay mina cerca.");
                tablero[y][x] = "X";
            }
        }
        
        System.out.println("\nTablero final:");
        for (int i = 3; i >= 0; i--) {
            System.out.print(i + "| ");
            for (int j = 0; j < 5; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("   ---------");
        System.out.println("   0 1 2 3 4");
    }
    
    // Método para comprobar si hay una mina a distancia 1
    private static boolean hayMinaCerca(int x, int y, int minaX, int minaY) {
        return Math.abs(x - minaX) <= 1 && Math.abs(y - minaY) <= 1 &&
               !(x == minaX && y == minaY);
    }
} 