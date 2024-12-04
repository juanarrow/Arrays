package unidimensionales.Ejercicio14;

public class Ejercicio14 {
    private static String[] colores = {"verde", "rojo", "azul", "amarillo", "naranja", "rosa", "negro", "blanco", "morado"};

    private static boolean esColor(String color){
        boolean encontrado = false;
        int i = 0;
        while(!encontrado && i < colores.length)
            encontrado = color.equals(colores[i++]);
        
        return encontrado;
    }
    private static void pintarArray(String[] valores){
        for(int i=0;i<valores.length;i++)
            System.out.printf("%s ",valores[i]);
        System.out.println();
    }

    private static String[] ordenaPalabras(String[] valores){
        String[] aux = new String[valores.length];
        int colores = 0;
        int palabras = valores.length-1;
        for(int i=0; i<valores.length;i++){
            if(esColor(valores[i]))
                aux[colores++]=valores[i];
            else
                aux[palabras--]=valores[i];

        }
        return aux;
    }
    
    public static void main(String[] args) {
        final int NUM_PALABRAS = 8;
        String[] palabras = new String[NUM_PALABRAS];
        System.out.println("Introduzca 8 palabras (vaya pulsando [INTRO] entre una y otra.");
        for(int i=1;i<=NUM_PALABRAS;i++)
            palabras[i-1]=System.console().readLine();
        
        System.out.println("Array original:");
        pintarArray(palabras);
        String[] ordenados = ordenaPalabras(palabras);
        System.out.println("Array con los pares al principio:");
        pintarArray(ordenados);
    }
    
}
