package bidimensionales.FlappyBird;

public class FlappyBird {
    // Códigos de color ANSI
    static final String AZUL_CIELO = "\u001B[48;5;117m";  // Fondo azul cielo
    static final String VERDE = "\u001B[48;5;40m";        // Fondo verde
    static final String AMARILLO = "\u001B[48;5;226m";    // Fondo amarillo para el pájaro
    static final String RESET = "\u001B[0m";
    
    static final int ALTO = 20;    // Alto del tablero
    static final int ANCHO = 30;   // Ancho del tablero
    static final int HUECO = 6;    // Tamaño del hueco en los obstáculos
    static final int GRAVEDAD = 1; // Velocidad de caída (positiva para bajar)
    
    public static void main(String[] args) {
        String[][] tablero = new String[ALTO][ANCHO];
        int[] alturaObstaculos = new int[ANCHO];
        int posicionPajaro = ALTO / 2;
        int velocidadVertical = 0;  // Nueva variable para la velocidad vertical
        
        // Inicializar alturas de obstáculos fuera del tablero
        for (int i = 0; i < ANCHO; i++) {
            alturaObstaculos[i] = -1;
        }
        
        while (true) {
            // Limpiar pantalla
            System.out.print("\033[H\033[2J");
            System.out.flush();
            
            // Inicializar tablero con fondo azul
            for (int i = 0; i < ALTO; i++) {
                for (int j = 0; j < ANCHO; j++) {
                    tablero[i][j] = AZUL_CIELO + "  " + RESET;
                }
            }
            
            // Generar nuevo obstáculo con probabilidad
            if (Math.random() < 0.1) {  // 10% de probabilidad
                int alturaObstaculo = (int)(Math.random() * (ALTO - HUECO - 2)) + 1;
                alturaObstaculos[ANCHO - 1] = alturaObstaculo;
            }
            
            // Mover obstáculos a la izquierda
            for (int i = 0; i < ANCHO - 1; i++) {
                alturaObstaculos[i] = alturaObstaculos[i + 1];
            }
            alturaObstaculos[ANCHO - 1] = -1;
            
            // Dibujar obstáculos
            for (int x = 0; x < ANCHO; x++) {
                if (alturaObstaculos[x] != -1) {
                    // Dibujar obstáculo inferior
                    for (int y = 0; y < alturaObstaculos[x]; y++) {
                        tablero[y][x] = VERDE + "  " + RESET;
                    }
                    // Dibujar obstáculo superior
                    for (int y = alturaObstaculos[x] + HUECO; y < ALTO; y++) {
                        tablero[y][x] = VERDE + "  " + RESET;
                    }
                }
            }
            
            // Dibujar pájaro
            tablero[posicionPajaro][5] = AMARILLO + "><" + RESET;
            
            // Mostrar tablero
            mostrarTablero(tablero);
            
            // Aplicar gravedad
            velocidadVertical += GRAVEDAD;
            posicionPajaro += velocidadVertical;
            
            // Mantener el pájaro dentro de los límites
            if (posicionPajaro >= ALTO) {
                posicionPajaro = ALTO - 1;
                velocidadVertical = 0;
            }
            if (posicionPajaro < 0) {
                posicionPajaro = 0;
                velocidadVertical = 0;
            }
            
            // Leer entrada del usuario (si hay)
            try {
                if (System.in.available() > 0) {
                    int tecla = System.in.read();
                    if (tecla == 10) {  // Intro para saltar
                        velocidadVertical = -3;  // Impulso hacia arriba (negativo para subir)
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            // Comprobar colisión
            if (hayColision(tablero, posicionPajaro, 5)) {
                System.out.println("\n¡Game Over!");
                break;
            }
            
            // Pequeña pausa
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    private static void mostrarTablero(String[][] tablero) {
        for (int i = 0; i < ALTO; i++) {
            for (int j = 0; j < ANCHO; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println();
        }
    }
    
    private static boolean hayColision(String[][] tablero, int posicionPajaro, int x) {
        return tablero[posicionPajaro][x].contains(VERDE);
    }
} 