package bidimensionales.Obstaculos;

public class Obstaculos {
    static final String AZUL_CIELO = "\u001B[48;5;117m";  // Fondo azul cielo
    static final String VERDE = "\u001B[48;5;40m";        // Fondo verde
    static final String RESET = "\u001B[0m";
    private static int[][] rellenaMatriz(int[][] matriz){
        for(int i=0;i<matriz.length; i++){
            for(int j=0;j<matriz[0].length;j++){
                matriz[i][j]=0;
            }
        }
        return matriz;
    }
    private static void pintaMatriz(int[][] matriz){
        // Limpiar pantalla
        System.out.print("\033[H\033[2J");
        System.out.flush();
        for(int i=0;i<matriz.length; i++){
            for(int j=0;j<matriz[0].length;j++)
                System.out.print(matriz[i][j]==0?AZUL_CIELO+"  "+RESET:VERDE+"  "+RESET);
            System.out.println();
        }
    }

    private static int[][] desplazaIzq(int[][] matriz, boolean obstaculo){
        int[] aux = new int[matriz.length];

        for(int j=0;j<matriz[0].length-1; j++){
            for(int i=0;i<matriz.length; i++){
                matriz[i][j]=matriz[i][j+1];
            }
        }
        int altura = (int)(Math.random()*matriz.length-3);
        int max = matriz.length-altura;
        int min = max - 4;
        int valor = obstaculo?1:0;
        for(int i=matriz.length-1; i>=0;i--){
            matriz[i][matriz[0].length-1] = (i>min && i<max)?0:valor; 
        }
        return matriz;
    }
    public static void main(String[] args) {
        int[][] matriz = new int[20][30];
        matriz = rellenaMatriz(matriz);
        boolean obstaculo = false;
        int pasos = 0;
        int pasoUltimoObstaculo = -1;
        while(true){
            pintaMatriz(matriz);
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
            }
            if(Math.abs(pasoUltimoObstaculo - pasos)>=5 && Math.random()>0.5){
                pasoUltimoObstaculo = pasos;
                obstaculo = true;
            }
            else
                obstaculo = false;
            matriz = desplazaIzq(matriz, obstaculo);
            pasos++;
        }
    }    
}
