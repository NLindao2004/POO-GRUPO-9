/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Esta clase representa la plataforma del sistema.
 * Permite validar el usuario e interactuar con el sistema dependiendo del tipo de usuario.
 */
public class Plataforma {

    Scanner sc = new Scanner(System.in);
    /**
     * Muestra el encabezado del sistema.
     */
    public void encabezado(){
        System.out.println("***********************************************");
        System.out.println("         BIENVENIDO AL SISTEMA                 ");
        System.out.println("***********************************************");

    }
    
    /**
     * Valida el usuario e inicia sesión en el sistema.
     * Permite a los operadores y clientes interactuar con el sistema según su rol.
     */
    public void validarUsuario(){
        String tipo="";
        boolean condicion=true;
        
        while(condicion){ 
            this.encabezado();
            System.out.print("Ingrese un usuario:");
            String user = sc.nextLine();
            System.out.print("Ingrese su contraseña:");
            String contrasenia = sc.nextLine();
            System.out.println();
            
            try{ 
            FileReader fileReader = new FileReader("C:\\Users\\PC.1\\Desktop\\PROYECTO 1P ENTREGABLE\\usuarios.txt");
            BufferedReader bf = new BufferedReader(fileReader);
            String bfRead;
            while((bfRead = bf.readLine())!=null){
                String[] datos = bfRead.split(",");
                if (datos[4].equals(user) && datos[5].equals(contrasenia) && datos[6].equals("O")) {
                    tipo="O"; 
                    boolean c=true;
                    while(c){
                        Operador Op= new Operador(datos[0],datos[1], Integer.parseInt(datos[2]),datos[3],datos[4],datos[5],datos[6]);
                        System.out.println("1. Registrar Pagos");
                        System.out.println("2. Consultar multas clientes");
                        System.out.println("3. Consultar usuarios");
                        System.out.println("4. Salir");
                        
                        System.out.print("Ingrese una opcion: ");
                        String opcion = sc.nextLine();

                            if (opcion.equals("1")) {
                                System.out.print("Ingrese la cedula: ");
                                String cedula= sc.nextLine();
                                Op.registrarPago(cedula);    
                            }
                            else if(opcion.equals("2")){                            
                                Op.consultarMulta();   
                            }
                            else if(opcion.equals("3")){
                                Op.consultarUser();                                
                            }
                            else if(opcion.equals("4")){
                                break;
                            }
                        } 
                    condicion=false;
                    }
                    else if(datos[4].equals(user) && datos[5].equals(contrasenia) && (datos[6].equals("S") || datos[6].equals("E")) ){ //VALIDACIÓN DE CLIENTE
                        Cliente cliE= new Cliente(datos[0],datos[1],Integer.parseInt(datos[2]),datos[3],datos[4],datos[5],datos[6]);
                        System.out.println("1. Consultar Multas");
                        System.out.println("2. Agendar Revision Tecnica");
                        System.out.println("3. Salir");
                        tipo=datos[6];
                        
                        boolean c=true;
                        while(c){
                            System.out.print("Ingrese una opcion: ");
                            String opcion = sc.nextLine();
                                if(opcion.equals("1")) {
                                    cliE.consultarMulta();                                  
                                }
                                else if(opcion.equals("2")){
                                    cliE.agendarRevision(); 
                                }
                                else if(opcion.equals("3")){
                                    break;
                                }else{
                                    System.out.println("Opción incorrecta");
                                }
                            }
                        condicion=false;
                    }// if de CLIENTE
                }// while buffer
            }//fin de lectura
            catch (IOException e){
            System.out.println("no se encontro archivo");
            }
        }
    }
}//end class