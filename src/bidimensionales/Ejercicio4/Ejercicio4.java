package bidimensionales.Ejercicio4;

public class Ejercicio4 {
    public static void main(String[] args) {
        // Crear array bidimensional 4x5
        int[][] numeros = new int[4][5];
        
        // Generar números aleatorios entre 100 y 999
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                numeros[i][j] = (int)(Math.random() * 900 + 100);
            }
        }

        // Mostrar array y calcular sumas de filas
        for (int i = 0; i < 4; i++) {
            int sumaFila = 0;
            
            // Mostrar números y calcular suma de la fila
            for (int j = 0; j < 5; j++) {
                System.out.printf("%4d ", numeros[i][j]);
                sumaFila += numeros[i][j];
            }
            
            // Pequeña pausa antes de mostrar la suma
            try {
                Thread.sleep(500); // Pausa de medio segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            // Mostrar suma de la fila
            System.out.printf("| %5d", sumaFila);
            System.out.println();
        }

        // Mostrar línea separadora
        System.out.println("-------------------------------------------");

        // Calcular y mostrar sumas de columnas
        for (int j = 0; j < 5; j++) {
            int sumaColumna = 0;
            
            // Calcular suma de la columna
            for (int i = 0; i < 4; i++) {
                sumaColumna += numeros[i][j];
            }
            
            // Pequeña pausa antes de mostrar la suma de columna
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            // Mostrar suma de la columna
            System.out.printf("%4d ", sumaColumna);
        }
        
        // Pequeña pausa antes de mostrar la suma total
        try {
            Thread.sleep(1000); // Pausa de un segundo para la suma total
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.printf("| %5d", calcularSumaTotal(numeros));
    }

    // Método para calcular la suma total de todos los números
    private static int calcularSumaTotal(int[][] array) {
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                total += array[i][j];
            }
        }
        return total;
    }
} 