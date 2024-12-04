package unidimensionales.Ejercicio6;

public class Ejercicio6 {
    private static void rellenaArrayAleatoriamente(int[] valores, int min, int max){
        for(int i=0;i<valores.length;i++)
            valores[i]=(int)(Math.random()*(max-min-1) + min);
        
    }

    private static void pintaArrayHorizontal(int[] valores){
        for(int i = 0; i<valores.length;i++)
            System.out.printf("| %2d ",i);
        System.out.println("|");
        for(int i = 1;i<=valores.length;i++)
            System.out.print("-----");
        System.out.println("");
        for(int i = 0; i<valores.length;i++)
            System.out.printf("|%3d ",valores[i]);
        System.out.println("|");
    }

    private static int[] rota(int[] valores){
        int ultimo = valores[valores.length-1];
        for(int i=(valores.length-1);i>0;i--)
            valores[i]=valores[i-1];
        valores[0] = ultimo;
        return valores;
    }

    public static void main(String[] args) {
        final int VALORES = 15;
        int[] numeros = new int[VALORES];
        rellenaArrayAleatoriamente(numeros, 0, 999);
        System.out.println("Array Original");
        pintaArrayHorizontal(numeros);
        System.out.println("Array rotado a la derecha una posición:");
        pintaArrayHorizontal(rota(numeros));
        
    }
    
}
