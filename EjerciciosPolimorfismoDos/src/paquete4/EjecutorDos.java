/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete4;

import java.util.ArrayList;
import paquete2.Arriendo;
import paquete3.ArriendoLocalComercial;
import paquete3.ArriendoLocalComida;
import paquete3.ArriendoLocalSesiones;
import java.util.Scanner;

/**
 *
 * @author InnoVausuario
 */
public class EjecutorDos {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Arriendo> listaArriendos = new ArrayList<>();

        System.out.print("Ingrese el nombre del centro comercial: ");
        String nombreCentroComer = entrada.nextLine();

        System.out.println("Cuantos locales de arriendo de comida desea ingresar?");
        int arrComida = entrada.nextInt();
        System.out.println("Cuantos locales de arriendo comercial desea ingresar?");
        int arrComercial = entrada.nextInt();
        System.out.println("Cuantos locales de arriendo de sesiones desea ingresar?");
        int arrSesiones = entrada.nextInt();
        entrada.nextLine();

        System.out.println("------------------------------------------");
        for (int i = 0; i < arrComida; i++) {
            System.out.println("\tArriendo Local de Comida (" + (i+1) + ")" );
            System.out.print("Ingrese el nombre del propietario: ");
            String nombreComida = entrada.nextLine();
            System.out.print("Ingrese la cuota base: ");
            double cuotaBase = entrada.nextDouble();
            System.out.println("\n");
            System.out.print("Ingrese el valor del agua: ");
            double valorAgua = entrada.nextDouble();
            System.out.print("Ingrese el valor de la luz: ");
            double valorLuz = entrada.nextDouble();
            System.out.print("Ingres el iva: ");
            double iva = entrada.nextDouble();
            System.out.println("");
            entrada.nextLine();

            ArriendoLocalComida arriendoComida = new ArriendoLocalComida(
                    nombreComida, cuotaBase);
            arriendoComida.establecerIva(iva);
            arriendoComida.establecerValorAgua(valorAgua);
            arriendoComida.establecerValorLuz(valorLuz);
            listaArriendos.add(arriendoComida);
        }

        System.out.println("------------------------------------------");
        for (int i = 0; i < arrComercial; i++) {
            System.out.println("\tArriendo Local Comercial (" + (i+1) + ")" );
            System.out.print("Ingrese el nombre del propietario: ");
            String nombreComercial = entrada.nextLine();
            System.out.print("Ingrese el valor de la cuota base: ");
            double cuotaBaseComer = entrada.nextDouble();
            System.out.println("\n");
            System.out.print("Ingrese el valor adicional fijo: ");
            double valorAdicFijo = entrada.nextDouble();
            System.out.println("");
            entrada.nextLine();

            ArriendoLocalComercial arriendoComercial = new ArriendoLocalComercial(
                    nombreComercial, cuotaBaseComer);
            arriendoComercial.establecerValorAdicionalFijo(valorAdicFijo);
            listaArriendos.add(arriendoComercial);
        }

        System.out.println("------------------------------------------");
        for (int i = 0; i < arrSesiones; i++) {
            System.out.println("\tArriendo Local de Sesiones (" + (i+1) + ")" );
            System.out.print("Ingrese el nombre del propietario: ");
            String nombreSesiones = entrada.nextLine();
            System.out.print("Ingrese el valor de la cuota base: ");
            double cuotaBaseSes = entrada.nextDouble();
            System.out.println("\n");
            System.out.println("Ingrese el valor de las sillas: ");
            double valorSillas = entrada.nextDouble();
            System.out.print("Ingrese el valor de amplificacion: ");
            double valorAmplificacion = entrada.nextDouble();
            System.out.println("");
            entrada.nextLine();
            
            ArriendoLocalSesiones arriendoSesiones = new ArriendoLocalSesiones(
                    nombreSesiones, cuotaBaseSes);
            arriendoSesiones.establecerValorSillas(valorSillas);
            arriendoSesiones.establecerValorAmplificacion(valorAmplificacion);
            listaArriendos.add(arriendoSesiones);
        }

        for (int i = 0; i < listaArriendos.size(); i++) {
            listaArriendos.get(i).establecerArriendoMensual();
        }

        CentroComercial centro = new CentroComercial(nombreCentroComer,
                listaArriendos);
        centro.establecerTotalArriendosBaseMensual();
        centro.establecerTotalArriendosFinalMensual();
        System.out.println(centro);
    }
}
    