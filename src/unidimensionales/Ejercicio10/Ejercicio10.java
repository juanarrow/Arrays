package unidimensionales.Ejercicio10;

public class Ejercicio10 {
    private static void rellenaArrayAleatoriamente(int[] valores, int min, int max){
        for(int i=0;i<valores.length;i++)
            valores[i]=(int)(Math.random()*(max-min-1) + min);
        
    }

    private static void pintarArray(int[] valores){
        for(int i=0;i<valores.length;i++)
            System.out.printf("%d ",valores[i]);
        System.out.println();
    }

    private static int[] ordenaValores(int[] valores){
        int[] aux = new int[valores.length];
        int pares = 0;
        int impares = valores.length-1;
        for(int i=0; i<valores.length;i++){
            if(valores[i]%2==0)
                aux[pares++]=valores[i];
            if(valores[valores.length-i-1]%2!=0)
                aux[impares--]=valores[valores.length-i-1];
        }
        return aux;
    }
    private static int[] ordenaValores2(int[] valores){
        int[] aux = new int[valores.length];
        int posicion = 0;
        for(int i=0; i<valores.length;i++){
            if(valores[i]%2==0)
                aux[posicion++]=valores[i];
        }
        for(int i=0; i<valores.length;i++){
            if(valores[i]%2!=0)
                aux[posicion++]=valores[i];
        }
        return aux;
    }
    public static void main(String[] args) {
        final int VALORES = 20;
        int[] numeros = new int[VALORES];
        rellenaArrayAleatoriamente(numeros, 0, 100);
        System.out.println("Array original:");
        pintarArray(numeros);
        int[] ordenados = ordenaValores2(numeros);
        System.out.println("Array con los pares al principio:");
        pintarArray(ordenados);
    }
    
}
