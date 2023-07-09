/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author PC.1
 */
public class Pago {
    Scanner sc = new Scanner(System.in);
    
    public String pagoMultas(String cedula){
        int total = 0;
        String formato= "";
        try{ 
            FileReader fileReader = new FileReader("C:\\Users\\PC.1\\Desktop\\PROYECTO 1P ENTREGABLE\\multas.txt");
            BufferedReader bf = new BufferedReader(fileReader);
            
            String bfRead;
            
            while((bfRead = bf.readLine())!=null){
                String[] datos = bfRead.split(",");
                if (datos[0].equals(cedula)) {
                    double valor= Double.parseDouble(datos[3]);
                    total+=valor;
                    
                }
            }//FIN WHILE 
        }
        catch (IOException e){
            System.out.println("no se encontro archivo");}
        
        if (total!=0) {
            System.out.println();
            System.out.println("Valor a pagar: "+total);
            formato+= total;
            System.out.println();
            System.out.println("¿Qué metodo de pago va a usar?");
            System.out.println("1. Efectivo");
            System.out.println("2. Tarjeta");  
            System.out.println();
            String condicion = " ";
            while(condicion.equals(" ")){
                System.out.print("Ingrese la opción: ");
                int opc = sc.nextInt();  
                sc.nextLine();
                if(opc==1) { // EFECTIVO
                    System.out.println("Valor a pagar: "+total);
                    formato+=",E";
                    System.out.println();
                    String c = " ";  
                    System.out.println("¿Desea proceder con el pago?");
                    System.out.println("1. Sí");
                    System.out.println("2. No");
                    System.out.println();
                    
                    while(c.equals(" ")){
                        System.out.print("Elija una opción: ");
                        String opc1=sc.nextLine();
                            if (opc1.equals("1")) {
                                formato+=","+total+",MULTA";
                                System.out.println("******************************");
                                System.out.println("Se ha realizado el pago");
                                System.out.println("******************************");
                                c+="FALSE";
                            }else if (opc1.equals("2")) {
                                System.out.println("Pago cancelado");
                                c+="FALSE";
                            }else{
                                System.out.println("Opción incorrecta");
                            }
                        condicion+="FALSO";}
                    }else if(opc==2) { //TARJETA
                        formato+=",T";
                        double pagoF= total+(total*0.10);
                        System.out.println("Valor a pagar: "+pagoF);
                        System.out.println();
                        System.out.println("¿Desea proceder con el pago?");
                        System.out.println("1. Sí");
                        System.out.println("2. No");
                        System.out.println();
                        String c1 = " ";
                        while(c1.equals(" ")){
                            System.out.print("Elija una opción: ");
                            String opc1=sc.nextLine();
                            if (opc1.equals("1")) {
                                formato+=","+pagoF+",MULTA";
                                System.out.println("******************************");
                                System.out.println("Se ha realizado el pago");
                                System.out.println("******************************");
                                c1+="FALSE";
                            }else if (opc1.equals("2")) {
                                System.out.println("Pago cancelado");
                                c1+="FALSE";
                            }else{
                                System.out.println("Opción incorrecta");
                            }
                        }
                    condicion+="FALSO";       
                }else{
                    System.out.println("Opción incorrecta");
                    }
           } 
        }else{
            System.out.println("No tienes deudas");
        }
        return cedula+","+formato; 
    }
    
    public String pagoRevision(String cedula){
        String formato = "";
        try{ 
            FileReader fileReader = new FileReader("C:\\Users\\PC.1\\Desktop\\PROYECTO 1P ENTREGABLE\\usuarios.txt");
            BufferedReader bf = new BufferedReader(fileReader);
            
            String bfRead;
            
            while((bfRead = bf.readLine())!=null){
                String[] datos = bfRead.split(",");
                if (datos[0].equals(cedula)&& datos[6].equals("E")) {   
                    double valorP= 150-(150*0.20);
                    formato+=valorP;
                    System.out.println("Valor a pagar: "+valorP);
                    System.out.println();
                    System.out.println("¿Qué modo de pago va a usar?");
                    System.out.println("1. Efectivo");
                    System.out.println("2. Tarjeta de credito");
                    System.out.println();
                    String c = " ";
                    while(c.equals(" ")){
                        System.out.print("Elija una opción: ");
                        String opc=sc.nextLine();
                        if (opc.equals("1")) {
                            formato+=",E,"+valorP+",REVISION";
                            System.out.println("¿Desea proceder con el pago?");
                            System.out.println("Sí");
                            System.out.println("No");
                            System.out.println();
                            
                            String c1 = " ";
                            while(c1.equals(" ")){
                                System.out.print("Elija una opción: ");
                                String opc1=sc.nextLine();
                                if (opc1.equals("1")) {
                                    System.out.println("*************************************************************");
                                    System.out.println("Se ha realizado el pago. Ahora puede proceder con la revisión ");
                                    System.out.println("*************************************************************");
                                    c1+="FALSE";
                                }else if (opc1.equals("2")) {
                                    System.out.println("Pago cancelado");
                                    c1+="FALSE";
                                }else{
                                    System.out.println("Opción incorrecta");
                                }
                            }  
                            c+="FALSE";
                        }else if(opc.equals("2")){
                            double pagoT= valorP+(valorP*0.10);
                            formato+=",T,"+pagoT+",REVISION";
                            System.out.println("Valor a pagar: "+pagoT);
                            System.out.println("¿Desea proceder con el pago?");
                            System.out.println("1. Sí");
                            System.out.println("2. No");
                            System.out.println();
                            String c2 = " ";
                            while(c2.equals(" ")){ 
                                System.out.print("Elija una opción: ");
                                String opc1=sc.nextLine();
                                if(opc1.equals("1")) {
                                    System.out.println("*************************************************************");
                                    System.out.println("Se ha realizado el pago. Ahora puede proceder con la revisión ");
                                    System.out.println("*************************************************************");
                                    c2+="FALSE";
                                }else if (opc1.equals("2")) {
                                    System.out.println("Pago cancelado");
                                    c2+="FALSE";
                                }else{
                                   System.out.println("Opción incorrecta"); 
                                }
                            } 
                            c+="FALSE";
                        }else{
                            System.out.println("Opción incorrecta");
                        }
                    }//FIN WHILE 
                }else if(datos[0].equals(cedula)&& datos[6].equals("S")){ // PAGO REVISION ESTANDAR
                    int puntosPerdidos = 0;
                    try{ // BUSCAN LOS PUNTOS PERDIDOS
                    FileReader fileR = new FileReader("C:\\Users\\PC.1\\Desktop\\PROYECTO 1P ENTREGABLE\\multas.txt");
                    BufferedReader bf1 = new BufferedReader(fileR);

                    String bf1Read;

                    while((bf1Read = bf1.readLine())!=null){
                        String[] datos1 = bf1Read.split(",");
                        if (datos[0].equals(cedula)) {
                            double valor= Double.parseDouble(datos1[6]);
                            puntosPerdidos+=valor;                    
                            }  
                        }
                    }//FIN WHILE BUFFEREAD DE ESTANDAR
                    catch (IOException e){
                    System.out.println("no se encontro archivo");
                    }
                    int totalP = 150+(10*puntosPerdidos);
                    System.out.println("Valor a pagar: "+totalP);
                    System.out.println();
                    formato+=totalP;
                    String c4= " ";
                    System.out.println("¿Qué modo de pago va a usar?");
                    System.out.println("1. Efectivo");
                    System.out.println("2. Tarjeta de credito");
                    System.out.println();
                    while(c4.equals(" ")){
                        System.out.print("Elija una opción: ");
                        String opc=sc.nextLine();
                        if (opc.equals("1")) {
                            sc.nextLine();
                            formato+=",E,"+totalP+",REVISION";
                            System.out.println("Valor a pagar: "+totalP);
                            System.out.println();
                            System.out.println("¿Desea proceder con el pago?");
                            System.out.println("1. Sí");
                            System.out.println("2. No");
                            System.out.println();
                            String c5 = " ";
                            while(c5.equals(" ")){
                                System.out.print("Elija una opción: ");
                                String opc1=sc.nextLine();
                                if (opc1.equals("1")) {
                                    System.out.println("******************************");
                                    System.out.println("Se ha realizado el pago");
                                    System.out.println("******************************");
                                    c5+="FALSE";
                                }else if (opc1.equals("2")) {
                                    System.out.println("Pago cancelado");
                                    c5+="FALSE";
                                }else{
                                    System.out.println("Opción incorrecta");}
                            }
                            c4+="FALSE";
                        }else if (opc.equals("2")) {
                            double pagoT= totalP+(totalP*0.10);
                             formato+=",T,"+pagoT+",REVISION";
                            System.out.println("Valor a pagar: "+pagoT);
                            System.out.println("¿Desea proceder con el pago?");
                            System.out.println("1. Sí");
                            System.out.println("2. No");
                            System.out.println();
                            String c6 = " ";
                            while(c6.equals(" ")){
                                System.out.print("Elija una opción: ");
                                String opc1=sc.nextLine();
                                if (opc1.equals("1")) {
                                    System.out.println("*************************************************************");
                                    System.out.println("Se ha realizado el pago. Ahora puede proceder con la revisión ");
                                    System.out.println("*************************************************************");
                                    c6+= "FALSE";    
                                }else if (opc1.equals("2")) {
                                    System.out.println("Pago cancelado");
                                    c6+= "FALSE"; 
                                }
                            c4+="FALSE";
                            }
                        }else{
                            System.out.println("Opción incorrecta");
                        }
                    }//FIN WHILE C4
                }
            }//FIN WHILE DE LECTURA TXT
        }
        catch (IOException e){
            System.out.println("no se encontro archivo");}
        return cedula+","+formato;
    }
    
    public double revisionPagoUser(String cedula){
        try{ 
            FileReader fileReader = new FileReader("C:\\Users\\PC.1\\Desktop\\PROYECTO 1P ENTREGABLE\\usuarios.txt");
            BufferedReader bf = new BufferedReader(fileReader);
            
            String bfRead;
            
            while((bfRead = bf.readLine())!=null){
                String[] datos = bfRead.split(",");
                if (datos[0].equals(cedula)&& datos[6].equals("E")) {   
                    double valorP= 150-(150*0.20);
                    return valorP;
                }else if(datos[0].equals(cedula)&& datos[6].equals("S")){
                    int puntosPerdidos = 0;
                    try{ // BUSCA LOS PUNTOS PERDIDOS
                    FileReader fileR = new FileReader("C:\\Users\\PC.1\\Desktop\\PROYECTO 1P ENTREGABLE\\multas.txt");
                    BufferedReader bf1 = new BufferedReader(fileR);

                    String bf1Read;

                    while((bf1Read = bf1.readLine())!=null){
                        String[] datos1 = bf1Read.split(",");
                        if (datos[0].equals(cedula)) {
                            double valor= Double.parseDouble(datos1[6]);
                            puntosPerdidos+=valor;    
                            }  
                        }
                    int totalP = 150+(10*puntosPerdidos);
                    return totalP;
                    }
                    catch (IOException e){
                    System.out.println("no se encontro archivo");
                    }
                }
            }
        }catch (IOException e){
            System.out.println("no se encontro archivo");}
        return 0;
    }
}//FIN CLASE
