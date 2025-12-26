import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        Random rand = new Random();

    int [][] maquinas = new int [20][50];

    int [] precio_Productos = new int [50];
    int opcion = 0;
    int cod_producto, unidades;
    int estado;

    do{
        System.out.println("MENU DE OPCIONES");
        System.out.println("1. Ingresar un pedido");
        System.out.println("2. Generar reporte de maquinas");
        System.out.println("3. Salir");
        opcion = sc.nextInt();
        switch(opcion){
            case 1:
                System.out.print("Ingrese el codigo del pedido: ");
                cod_producto = sc.nextInt();
                System.out.println("Ingrese el n° de unidades a fabricar: ");
                unidades = sc.nextInt();

                for(int i = 0; i < maquinas.length; i++){

                    estado = maquinas[i][cod_producto];

                    if(estado == -1){
                        System.out.println("La máquina " + i + " no ha sido programada para producir el producto " + cod_producto);
                    }else
                        if(estado == 0){
                            System.out.println("Maquina disponible" + i);
                            maquinas[i][cod_producto] = unidades;
                            System.out.println("Pedido asignado a la máquina " + i);
                            break;
                        }else{
                            System.out.println("La máquina " + i + " no está disponible por el momento.");
                            System.out.println("Se encuentra fabricando " + estado + " unidades del producto " + cod_producto);
                        }
                }
                break;
            case 2:
                System.out.println("REPORTE DE MAQUINAS");
                System.out.println("===================");
                
                break;
            default:
        }
    }while(true);

    }
}