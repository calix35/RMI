package client;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

import java.util.Scanner;

import common.Calculadora;

public class Client{

    public static void main(String[] args) {
    
        try {
            //Localizar el rmiregistry
            //OJO: El rmiregistry solo se ejecuta en el servidor
            //Como el cliente y el servidor estan en la misma computadora, se le puede poner localhost
            Registry registry = LocateRegistry.getRegistry("localhost");

            //Obtengo el objeto remoto
            Calculadora calculadora = (Calculadora)registry.lookup("Calculadora");

            Scanner sc = new Scanner(System.in);
            int opcion;
            float a,b, resp;
            do{
                System.out.println("1) Suma");
                System.out.println("2) Resta");
                System.out.println("3) Multiplicacion");
                System.out.println("4) Division");
                System.out.println("5) Salir");
                System.out.print("Opcion: ");
                opcion = sc.nextInt();
                switch(opcion) {
                    case 1: 
                        System.out.print("a = ");
                        a = sc.nextFloat();
                        System.out.print("b = ");
                        b = sc.nextFloat();
                        resp = calculadora.suma(a, b);
                        System.out.println(resp);
                        break;
                    case 2: 
                        System.out.print("a = ");
                        a = sc.nextFloat();
                        System.out.print("b = ");
                        b = sc.nextFloat();
                        resp = calculadora.resta(a, b);
                        System.out.println(resp);
                        break;
                    case 3: 
                        System.out.print("a = ");
                        a = sc.nextFloat();
                        System.out.print("b = ");
                        b = sc.nextFloat();
                        resp = calculadora.multiplicacion(a, b);
                        System.out.println(resp);
                        break;
                    case 4: 
                        System.out.print("a = ");
                        a = sc.nextFloat();
                        System.out.print("b = ");
                        b = sc.nextFloat();
                        resp = calculadora.division(a, b);
                        System.out.println(resp);
                        break;
                    case 5: 
                        break;
                    default: 
                        System.out.println("Operacion no permitida!");
                }
            }while(opcion!=5);
            
            
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

}