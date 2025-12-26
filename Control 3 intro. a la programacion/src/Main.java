import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nroEmp = 0;
        String nomEmpleado;
        int codProyectro = 0, duracion = 0;
        int cont_proyectos = 0;
        int monto = 0, monto_acumulado = 0;
        double prom_monto, monto_bono = 0;

        int proy_mas_ext = 0;
        int monto_menor = 999999999;

        System.out.print("Ingrese el número de empleados: ");
        nroEmp = sc.nextInt();

        for (int i = 0; i < nroEmp; i++) {
            System.out.print("Ingrese el nombre del empleado: ");
            nomEmpleado = sc.next();
            System.out.print("Ingrese el codigo del proyecto: ");
            codProyectro = sc.nextInt();

            while(codProyectro != -1) {
                System.out.print("Ingrese la duración del proyecto: ");
                duracion = sc.nextInt();
                System.out.print("Ingrese la monto de la proyecto: ");
                monto = sc.nextInt();

                if(monto < monto_menor){
                    monto_menor = monto;
                }
                if(duracion > proy_mas_ext){
                    proy_mas_ext = duracion;
                }
                cont_proyectos++;
                monto_acumulado += monto;

                System.out.print("Ingrese el codigo del proyecto: ");
                codProyectro = sc.nextInt();
            }
            if(cont_proyectos < 3) {
                prom_monto = monto_acumulado / cont_proyectos;
                monto_bono = prom_monto * 0.05;
            }else{
                prom_monto = monto_acumulado / cont_proyectos;
                monto_bono = prom_monto * 0.07;
            }
            System.out.println("------------------------------------------------------");
            System.out.println("Nombre empleado: " + nomEmpleado);
            System.out.println("Nro. de proyectos: " + cont_proyectos);
            System.out.println("Monto del bono: " + monto_bono);
            System.out.println("------------------------------------------------------");

            cont_proyectos = 0;
            monto_acumulado = 0;
        }
        System.out.println();
        System.out.println("Reporte de Proyectos");
        System.out.println("====================");
        System.out.println("Duración proyecto mas extenso: " + proy_mas_ext);
        System.out.println("Monto proyecto con menor ingreso: " + monto_menor);
    }
}
