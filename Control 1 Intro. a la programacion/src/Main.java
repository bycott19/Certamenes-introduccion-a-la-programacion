import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);

        //Variables
        double tarifa_total = 0, tarifa_adul_may = 0, tarifa_por_adulto_mayor = 0, tarifa_normal = 0;
        double tarifa_SA = 15.00;
        double tarifa_SB = 18.00;
        double tarifa_SC = 20.00;
        double Desc_SA = 0.3;
        double Desc_SB = 0.4;
        double Desc_SC = 0.5;

        int cant_grupo = 0;
        int cant_grupo_normal = 0;
        int cant_adult_mayor = 0;
        String sector, adult_mayor_true, incluir_alim;
        boolean sectorNotFound = false;


        System.out.println("------------------------------------------------------");
        System.out.println("BIENVENIDO AL SERVICIO DE TURISMO DE CAMINANTES");
        System.out.println("------------------------------------------------------");
        System.out.println();

        System.out.print("Ingrese la cantidad de personas del grupo: ");
        cant_grupo = SC.nextInt();

        while(cant_grupo > 10 || cant_grupo < 1) {
            System.out.println("La cantidad ingresada no es valida");
            System.out.print("Ingrese la cantidad de personas del grupo: ");
            cant_grupo = SC.nextInt();
        }

        System.out.println("¿Hay adultos mayores en el grupo?: ");
        System.out.println("s/n");
        adult_mayor_true = SC.next();

        while (!adult_mayor_true.equals("s") && !adult_mayor_true.equals("n")){
            System.out.println("Opción no valida");
            System.out.println("¿Hay adultos mayores en el grupo?: ");
            System.out.println("s/n");
            adult_mayor_true = SC.next();
        }

        if(adult_mayor_true.equalsIgnoreCase("s")){
            System.out.print("Ingrese la cantidad de adultos mayores del grupo: ");
            cant_adult_mayor = SC.nextInt();
            cant_grupo_normal = cant_grupo - cant_adult_mayor;
        }else{
            cant_grupo_normal = cant_grupo;
        }

        System.out.println("¿Desea incluir alimentación?");
        System.out.println("s/n");
        incluir_alim = SC.next();

        System.out.println("Ingrese el sector en el que quiere hacer la excursión: ");
        System.out.println("SECTORES:");
        System.out.println("A");
        System.out.println("B");
        System.out.println("C");
        System.out.print("Sector: ");
        sector = SC.next();

        switch(sector.toUpperCase()){
            case "A":
                System.out.println("Ha escogido el sector A");
                if(cant_grupo == 10 && cant_adult_mayor == 0){
                    if(incluir_alim.equalsIgnoreCase("s")){
                        tarifa_SA = tarifa_SA * 2;
                    }
                    tarifa_total = cant_grupo * tarifa_SA;
                    tarifa_total = tarifa_total * 0.9;

                }else{
                    if(incluir_alim.equalsIgnoreCase("s")){
                        tarifa_SA = tarifa_SA * 2;
                    }
                    //Calcular tarifa normal para los que no son adultos mayores
                    tarifa_normal = cant_grupo_normal * tarifa_SA;

                    //Calcular tarifa con descuento para adultos mayores
                    tarifa_por_adulto_mayor = tarifa_SA - (Desc_SA * tarifa_SA) ;
                    tarifa_adul_may = tarifa_por_adulto_mayor * cant_adult_mayor;

                    tarifa_total = tarifa_normal + tarifa_adul_may;
                }
                break;

            case "B":
                System.out.println("Ha escogido el sector B");
                if(cant_grupo == 10 && cant_adult_mayor == 0){
                    if(incluir_alim.equalsIgnoreCase("s")){
                        tarifa_SB = tarifa_SB * 2;
                    }
                    tarifa_total = cant_grupo * tarifa_SB;
                    tarifa_total = tarifa_total * 0.9;

                }else{
                    if(incluir_alim.equalsIgnoreCase("s")){
                        tarifa_SB = tarifa_SB * 2;
                    }
                    //Calcular tarifa normal para los que no son adultos mayores
                    tarifa_normal = cant_grupo_normal * tarifa_SB;

                    //Calcular tarifa con descuento para adultos mayores
                    tarifa_por_adulto_mayor = tarifa_SB - (Desc_SB * tarifa_SB) ;
                    tarifa_adul_may = tarifa_por_adulto_mayor * cant_adult_mayor;

                    tarifa_total = tarifa_normal + tarifa_adul_may;
                }
                break;

            case "C":
                System.out.println("Ha escogido el sector C");
                if(cant_grupo == 10 && cant_adult_mayor == 0){
                    if(incluir_alim.equalsIgnoreCase("s")){
                        tarifa_SC = tarifa_SC * 2;
                    }
                    tarifa_total = cant_grupo * tarifa_SC;
                    tarifa_total = tarifa_total * 0.9;

                }else{
                    if(incluir_alim.equalsIgnoreCase("s")){
                        tarifa_SC = tarifa_SC * 2;
                    }
                    //Calcular tarifa normal para los que no son adultos mayores
                    tarifa_normal = cant_grupo_normal * tarifa_SC;

                    //Calcular tarifa con descuento para adultos mayores
                    tarifa_por_adulto_mayor = tarifa_SC - (Desc_SC * tarifa_SC) ;
                    tarifa_adul_may = tarifa_por_adulto_mayor * cant_adult_mayor;

                    tarifa_total = tarifa_normal + tarifa_adul_may;
                }
                break;

            default:
                sectorNotFound = true;
        }

        if (sectorNotFound == false) {
            System.out.println("El total final que debera pagar es de $" + tarifa_total);
        }else{
            System.out.println("No se ha encontrado el sector");
        }
        System.out.println("----------------------------------------------------------------");
        System.out.println("Gracias por utilizar el programa. Adios");
        System.out.println("----------------------------------------------------------------");
    }
}