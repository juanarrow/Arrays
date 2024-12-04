package unidimensionales.Ejercicio8;

public class Ejercicio8 {
    static String[] meses = 
        {"enero", 
        "febrero", 
        "marzo", 
        "abril", 
        "mayo", 
        "junio", 
        "julio", 
        "agosto", 
        "septiembre", 
        "octubre", 
        "noviembre", 
        "diciembre"};

    private static String obtenerTextoMes(int mes){
        return meses[mes];
    }

    private static int obtenerNumeroMes(String mes){
        return switch(mes){
            case "enero"->0;
            case "febrero"->1;
            case "marzo"->2;
            case "abril"->3;
            case "mayo"->4;
            case "junio"->5;
            case "julio"->6;
            case "agosto"->7;
            case "septiembre"->8;
            case "octubre"->9;
            case "noviembre"->10;
            case "diciembre"->11;
            default->-1;

        };
    }
    private static int obtenerTemperaturaAleatorio(String mes){
        return switch(mes){
            case "diciembre","enero","febrero"->(int)(Math.random()*19);
            case "marzo","abril","mayo"->(int)(Math.random()*(25-12+1)+12);
            case "junio","julio","agosto"->(int)(Math.random()*(38-23+1)+23);
            case "septiembre","octubre","noviembre"->(int)(Math.random()*(28-20+1)+20);
            default->0;
        };
    }
    private static int[] rellenaTemperaturas(int[] temperaturas){
        for(int i=0;i<temperaturas.length-1;i++){
            temperaturas[i]=obtenerTemperaturaAleatorio(obtenerTextoMes(i));
        }
        return temperaturas;
    }

    private static void pintaTablaTemperaturas(int[] temperaturas){
        for(int i=0;i<12;i++){
            System.out.printf("%11s\u2502", obtenerTextoMes(i));
            for(int j=1;j<=temperaturas[i];j++)
                System.out.print("\u25A0");
            System.out.printf("%dºC%n",temperaturas[i]);
        }
    }
    public static void main(String[] args) {
        int[] temperaturas=new int[12];
        pintaTablaTemperaturas(rellenaTemperaturas(temperaturas));
    }
    
}
