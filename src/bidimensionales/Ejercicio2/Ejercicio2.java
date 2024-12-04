package bidimensionales.Ejercicio2;

public class Ejercicio2 {
    private static void rellenaMatrizAleatoriamente(int[][] matriz){
        for(int i=0;i<matriz.length;i++){
            for(int j = 0; j<matriz[0].length; j++){
                matriz[i][j]=(int)(Math.random()*100);
            }
        }
    }
    private static void imprimirTabla(int[][] matriz){
        
        for(int i=0;i<matriz.length;i++){
            int sumafila = 0;
            for(int j = 0; j<matriz[0].length; j++){
                System.out.printf("\t%d",matriz[i][j]);
                sumafila+=matriz[i][j];
                if(i>0){
                    matriz[0][j]+=matriz[i][j];
                }
            }
            System.out.printf("   |\t%d%n", sumafila);
        }
        int sumatotal = 0; 
        for(int i=0; i<matriz[0].length;i++){
            System.out.printf("\t%d",matriz[0][i]);
            sumatotal+=matriz[0][i];

        }
        System.out.printf("\t|\t%d%n", sumatotal);
    }
    public static void main(String[] args) {
        int[][] matriz = new int[4][5];
        rellenaMatrizAleatoriamente(matriz);
        imprimirTabla(matriz);
    }
    
}
