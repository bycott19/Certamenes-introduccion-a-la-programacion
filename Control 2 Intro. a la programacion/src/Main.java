import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String formato = "%-6s %-15s %-10s\n";

        System.out.println("------------------------------------------------------");
        System.out.println("BIENVENIDO AL SISTEMA DE VOTACIÓN DEL TRICEL DE ICINF");
        System.out.println("------------------------------------------------------");

        String continuar_votacion;
        String lista_votada;

        int edad;
        int cont_hasta_19 = 0, cont_20_22 = 0, cont_sobre_23 = 0;
        int cont_votos_A = 0, cont_votos_B = 0, cont_votos_C = 0;
        int total_votos = 0;
        double porcentaje_votos_A = 0.0, porcentaje_votos_B = 0.0, porcentaje_votos_C = 0.0;

        do{
            System.out.println("IMPORTANTE: Solo pueden votar personas mayores de 15 años");
            System.out.print("Ingrese su edad: ");
            edad = sc.nextInt();
            while(edad < 15 || edad > 99){
                System.out.println("La edad ingresada no esta en el rango valido (15 - 99)");
                System.out.print("Ingrese su edad: ");
                edad = sc.nextInt();
            }
            System.out.println();
            System.out.println("Listas de los postulantes:");
            System.out.println("Lista A");
            System.out.println("Lista B");
            System.out.println("Lista C");
            System.out.println("Ingrese la letra de la lista por la que desea votar: ");
            System.out.print("Lista: ");

            lista_votada = sc.next();

            switch(lista_votada.toUpperCase()){
                case "A":
                    if(edad <= 19){
                        cont_hasta_19++;
                    }else
                    if(edad >= 20 && edad <= 22){
                        cont_20_22++;
                    }else{
                        cont_sobre_23++;
                    }
                    cont_votos_A++;
                    break;

                case "B":
                    if(edad <= 19){
                        cont_hasta_19++;
                    }else
                    if(edad >= 20 && edad <= 22){
                        cont_20_22++;
                    }else{
                        cont_sobre_23++;
                    }
                    cont_votos_B++;
                    break;

                case "C":
                    if(edad <= 19){
                        cont_hasta_19++;
                    }else
                    if(edad >= 20 && edad <= 22){
                        cont_20_22++;
                    }else{
                        cont_sobre_23++;
                    }
                    cont_votos_C++;
                    break;

                default:
                    System.out.println("La lista no existe");
            }
            total_votos++;
            System.out.println("¿Desea continuaar con la votación?");
            System.out.println("s/n");
            continuar_votacion = sc.next();

            while(!continuar_votacion.equalsIgnoreCase("s") && !continuar_votacion.equalsIgnoreCase("n")){
                System.out.print("Ingrese una opción valida si desea continuar (s/n): ");
                continuar_votacion = sc.next();
                System.out.println();
            }

        }while(continuar_votacion.equalsIgnoreCase("s"));

        porcentaje_votos_A = (cont_votos_A * 100.0) / total_votos;
        porcentaje_votos_B = (cont_votos_B * 100.0) / total_votos;
        porcentaje_votos_C = (cont_votos_C * 100.0) / total_votos;

        System.out.println("----------------------------------------------------------");
        System.out.println("REPORTE DE VOTOS");
        System.out.println("----------------------------------------------------------");
        System.out.printf(formato,"Lista", "Total de votos", "% de votos");
        System.out.println("-----------------------------------");

        formato = "%-6s %-15d %-10f %-1s \n";
        System.out.printf(formato, "A", cont_votos_A, porcentaje_votos_A ,"%");
        System.out.printf(formato, "B", cont_votos_B, porcentaje_votos_B, "%");
        System.out.printf(formato, "C", cont_votos_C, porcentaje_votos_C, "%");
        System.out.println("-----------------------------------");

        formato = "%-15s %-20s \n";
        System.out.printf(formato,"Grupo etario", "Cantidad de votantes");
        System.out.println("-------------------------------------------");

        formato = "%-15s %-20d \n";
        System.out.printf(formato, "Hasta 19", cont_hasta_19);
        System.out.printf(formato, "Entre 20 y 22", cont_20_22);
        System.out.printf(formato, "23 y más", cont_sobre_23);

        System.out.println("-----------------------------------------------");
        if(cont_votos_A > cont_votos_B && cont_votos_A > cont_votos_C){
            System.out.println("La lista A es la ganadora ");
        }else
        if(cont_votos_B > cont_votos_A && cont_votos_B > cont_votos_C){
            System.out.println("La lista B es la ganadora ");
        }else {
            System.out.println("La lista C es la ganadora ");
        }
        System.out.println("------------------------------------------------");

    }
}