package unidimensionales.Ejercicio12;

public class Ejercicio12 {
    private static void rellenaArrayAleatoriamente(int[] valores, int min, int max){
        for(int i=0;i<valores.length;i++)
            valores[i]=(int)(Math.random()*(max-min-1) + min);
        
    }
    private static void pintarArray(int[] valores){
        for(int i=0;i<valores.length;i++)
            System.out.printf("%d ",valores[i]);
        System.out.println();
    }

    private static void desplazaArray(int[] numeros, int posIni, int posFin){
        int valorPosIni = numeros[posIni];
        int ultimoValor = numeros[numeros.length-1];
        for(int i=(numeros.length-1);i>0;i--){
            if(i<=posIni || i>posFin)
                numeros[i]=numeros[i-1];
        }
        numeros[0]=ultimoValor;
        numeros[posFin]=valorPosIni;
    }
    public static void main(String[] args) {
        try {
            final int CANTIDAD_NUMEROS = 10;
            System.out.print("Introduzca la posición inicial (0 - 9): ");
            int posInicial = Integer.parseInt(System.console().readLine());
            System.out.print("Introduzca la posición final (0 - 9): ");
            int posFinal = Integer.parseInt(System.console().readLine());
            int[] numeros = new int[CANTIDAD_NUMEROS];
            if(
                posInicial>=0 && 
                posFinal >=0 && 
                posInicial<CANTIDAD_NUMEROS && 
                posFinal<CANTIDAD_NUMEROS && 
                posInicial < posFinal){
                    rellenaArrayAleatoriamente(numeros, 0, 100);
                    System.out.println("Array Original");
                    pintarArray(numeros);
                    desplazaArray(numeros, posInicial, posFinal);
                    System.out.println("Array resultante");
                    pintarArray(numeros);

            }
            else{
                System.out.println("Tiene que introducir un valor entre 0 y 9 y el valor inicial debe ser menor que el valor final");
            }
            

        } catch (Exception e) {
            System.out.println("Ocurrió un error");
        }
    }
    
}
