package bidimensionales.Ejercicio3;

public class Ejercicio3 {
    public static void main(String[] args) {
        // Crear array bidimensional 5x5
        int[][] numeros = new int[5][5];
        
        // Generar números aleatorios entre 100 y 999
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                numeros[i][j] = (int)(Math.random() * 900 + 100);
            }
        }

        // Mostrar array y calcular sumas de filas
        for (int i = 0; i < 5; i++) {
            int sumaFila = 0;
            
            // Mostrar números y calcular suma de la fila
            for (int j = 0; j < 5; j++) {
                System.out.printf("%4d ", numeros[i][j]);
                sumaFila += numeros[i][j];
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
            for (int i = 0; i < 5; i++) {
                sumaColumna += numeros[i][j];
            }
            
            // Mostrar suma de la columna
            System.out.printf("%4d ", sumaColumna);
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