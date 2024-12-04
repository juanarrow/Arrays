package unidimensionales.Ejercicio3;

public class Ejercicio3 {
    public static void main(String[] args) {
        final int NUMEROS = 3;
        System.out.printf("Por favor, introduzca %d números enteros.", NUMEROS);
        System.out.print("Pulse la tecla INTRO después de introducir cada número.");
        int[] valores = new int[NUMEROS];
        for(int i=0;i<NUMEROS;i++)
            valores[i] = Integer.parseInt(System.console().readLine());
        System.out.println("Los números introducidos, al revés, son los siguientes:");
        for(int i=0; i<NUMEROS;i++){
            if(i!=(NUMEROS-1))
                System.out.print(valores[NUMEROS-i-1]+", ");
            else
                System.out.print(valores[NUMEROS-i-1]);

        }
            

    }
}
