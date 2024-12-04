package bidimensionales.Ejercicio0;

public class Ejercicio0 {
    private static void rellenaTablero(int[][] tablero){
        int valor = 0;
        for(int i =1;i<=8;i++){
            for(int j=1;j<=8;j++){
                tablero[i-1][j-1]=valor;
                valor = (++valor)%2;
            }
            valor = (++valor)%2;
        }
    }
    private static void pintarTablero(int[][] tablero){
        for(int i =1;i<=8;i++){
            for(int j=1;j<=8;j++){
                if(tablero[i-1][j-1]==0)
                    System.out.print("\033[47m"+"  "+"\033[0m");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] tablero = new int[8][8];
        rellenaTablero(tablero);
        pintarTablero(tablero);
    }
    
}
