package bidimensionales.Ejercicio6;

public class Ejercicio6 {
    public static void main(String[] args) {
        // Crear array bidimensional 6x10
        int[][] numeros = new int[6][10];
        
        // Variables para guardar el máximo y mínimo y sus posiciones
        int maximo = Integer.MIN_VALUE;
        int minimo = Integer.MAX_VALUE;
        int maxFila = 0, maxColumna = 0;
        int minFila = 0, minColumna = 0;
        
        // Generar números aleatorios entre 0 y 1000 sin repetición
        boolean[] usados = new boolean[1001]; // Para controlar números usados
        
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 10; j++) {
                int numero;
                do {
                    numero = (int)(Math.random() * 1001); // 0 a 1000 inclusive
                } while (usados[numero]); // Repetir si el número ya está usado
                
                usados[numero] = true; // Marcar como usado
                numeros[i][j] = numero;
                
                // Actualizar máximo si corresponde
                if (numero > maximo) {
                    maximo = numero;
                    maxFila = i;
                    maxColumna = j;
                }
                
                // Actualizar mínimo si corresponde
                if (numero < minimo) {
                    minimo = numero;
                    minFila = i;
                    minColumna = j;
                }
            }
        }

        // Mostrar índices de columnas
        System.out.println("     0    1    2    3    4    5    6    7    8    9");
        
        // Mostrar línea superior
        System.out.println("  ┌──────────────────────────────────────────────────┐");
        
        // Mostrar array con índices de filas
        for (int i = 0; i < 6; i++) {
            System.out.printf("%d │", i);
            for (int j = 0; j < 10; j++) {
                System.out.printf(" %3d ", numeros[i][j]);
            }
            System.out.println("│");
        }
        
        // Mostrar línea inferior
        System.out.println("  └──────────────────────────────────────────────────┘");
        
        // Mostrar máximo y mínimo con sus posiciones
        System.out.printf("El máximo es %d y está en la fila %d, columna %d\n", 
                         maximo, maxFila, maxColumna);
        System.out.printf("El mínimo es %d y está en la fila %d, columna %d\n", 
                         minimo, minFila, minColumna);
    }
} 