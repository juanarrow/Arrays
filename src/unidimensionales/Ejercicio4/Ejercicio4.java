package unidimensionales.Ejercicio4;

public class Ejercicio4 {
    private static void rellenaArrayAleatoriamente(int[] valores, int min, int max){
        for(int i=0;i<valores.length;i++)
            valores[i]=(int)(Math.random()*(max-min-1) + min);
        
    }

    private static void pintarTabla(int[] n, int[] n2, int[] n3){
        System.out.printf("  n  |   n2  |    n3   %n");
        System.out.printf("-----------------------%n");
        for(int i = 0; i < n.length; i++)
            System.out.printf(" %3d | %5d | %7d %n", n[i], n2[i], n3[i]);
        
    }

    public static void main(String[] args) {
        final int VALORES = 20;
        int[] numero = new int[VALORES];
        int[] cuadrado = new int[VALORES];
        int[] cubo = new int[VALORES];
        rellenaArrayAleatoriamente(numero, 0, 100);
        for(int i=0;i<VALORES;i++){
            cuadrado[i] = numero[i]*numero[i];
            cubo[i] = cuadrado[i]*numero[i];
        }
        pintarTabla(numero, cuadrado, cubo);
        
    }
    
}
