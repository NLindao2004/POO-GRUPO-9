/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * La clase Cliente hereda de la clase Usuario y representa a un cliente en el sistema.
 */
public class Cliente extends Usuario{
    
    
    
    
    Scanner sc= new Scanner(System.in);

     /**
     * Constructor de la clase Cliente.
     * 
     * @param cedula       La cédula del cliente.
     * @param nombre       El nombre del cliente.
     * @param edad         La edad del cliente.
     * @param correo       El correo electrónico del cliente.
     * @param usuario      El nombre de usuario del cliente.
     * @param contrasenia  La contraseña del cliente.
     * @param perfil       El perfil del cliente.
     */
    public Cliente(String cedula, String nombre, int edad,String correo, String usuario,String contrasenia, String perfil) {
        super(cedula,nombre,edad,correo,usuario,contrasenia,perfil);
    }
    /**
     * Constructor de la clase Cliente que recibe solo la cédula.
     * 
     * @param cedula La cédula del cliente.
     */
    public Cliente(String cedula){
        super(cedula);
    }
    
    /**
 * Este método permite al cliente consultar las multas asociadas a su vehículo.
 * El cliente puede buscar las multas por número de cédula o por placa del vehículo.
 * Se muestra el detalle de las multas encontradas y el total a pagar.
 * Además, se proporciona la información sobre cómo pagar las multas.
 * Si no se encuentran multas, se muestra un mensaje indicando que no hay multas pendientes.
 */
    @Override 
    public void consultarMulta(){
        String condicion =" ";
        while(condicion.equals(" ")){
            System.out.println("1. Buscar por cedula");
            System.out.println("2. Buscar por placa");
            System.out.print("Ingrese una opcion: ");
            int opcion= sc.nextInt();
            sc.nextLine();
            if (opcion==1){
                System.out.print("Ingrese el numero de cedula: ");
                String cedula = sc.nextLine();
                System.out.println("----------------------------------------------------------");
                System.out.println("                  DETALLE DE MULTAS");
                System.out.println("----------------------------------------------------------");
                try{ 
                    FileReader fileReader = new FileReader("C:\\Users\\PC.1\\Desktop\\PROYECTO 1P ENTREGABLE\\multas.txt");
                    BufferedReader bf = new BufferedReader(fileReader);
                    double total=0;
                    String bfRead;
                    while((bfRead = bf.readLine())!=null){
                        String[] datos = bfRead.split(",");
                        if (datos[0].equals(cedula)) {
                            System.out.print(bfRead);
                            double valor = Double.parseDouble(datos[3]);
                            total+=valor;
                            System.out.println();
                        }  
                    }
                    System.out.println();
                    System.out.println("TOTAL A PAGAR: "+total);
                    System.out.println();   
                    System.out.println("PARA PAGAR PUEDE ACERCARCE A LA AGENCIA MAS CERCANA");
                }
                catch (IOException e){
                    System.out.println("no se encontro archivo");
                }
            condicion+="FALSE";
            }else if (opcion==2) {
                System.out.print("Ingrese la placa: ");
                String placa = sc.nextLine();
                System.out.println("----------------------------------------------------------");
                System.out.println("                  DETALLE DE MULTAS");
                System.out.println("----------------------------------------------------------");
                try{ 
                FileReader fileReader = new FileReader("C:\\Users\\PC.1\\Desktop\\PROYECTO 1P ENTREGABLE\\multas.txt");
                BufferedReader bf = new BufferedReader(fileReader);
                double total=0;
                String bfRead;
                while((bfRead = bf.readLine())!=null){
                    String[] datos = bfRead.split(",");
                    if (datos[1].equals(placa)) {
                        System.out.print(bfRead);
                        double valor = Double.parseDouble(datos[3]);
                        total+=valor;
                        System.out.println();   
                    }  
                }
                System.out.println();
                System.out.println("TOTAL A PAGAR: "+total);
                System.out.println();
                System.out.println("PARA PAGAR PUEDE ACERCARCE A LA AGENCIA MAS CERCANA");
                }
                catch (IOException e){
                    System.out.println("no se encontro archivo");
                }
            condicion+="FALSE";    
            }else{
                System.out.println("Opción incorrecta");
            }
        }
    }
    
    
    /**
 * Este método permite al cliente agendar una cita para la revisión de su vehículo.
 * Se verifica si el vehículo tiene multas pendientes y muestra un mensaje en caso de tenerlas.
 * En caso contrario, se muestra una lista de horarios disponibles para la revisión y se permite al cliente elegir uno.
 * Luego de seleccionar el horario, se muestra un mensaje con los detalles de la cita y el valor a pagar por la revisión.
 * Se genera un número aleatorio para identificar la cita y se guarda en el archivo "revisión.txt" junto con la información de la cita.
 */
    public void agendarRevision(){
            double total = 0;
            System.out.print("Ingrese la placa: ");
            String placa = sc.nextLine();
            try{ 
            FileReader fileReader = new FileReader("C:\\Users\\PC.1\\Desktop\\PROYECTO 1P ENTREGABLE\\multas.txt");
            BufferedReader bf = new BufferedReader(fileReader);
            String bfRead;
            while((bfRead = bf.readLine())!=null){
                String[] datos = bfRead.split(",");
                    if (datos[1].equals(placa)) {
                        double valor = Double.parseDouble(datos[3]);
                        total+=valor;    
                    } 
                }
            }
            catch (IOException e){
                System.out.println("no se encontro archivo");
            }
            
            Vehiculo v = new Vehiculo();
            String ci = v.buscarAuto(placa);
            Usuario u = new Cliente(ci);
            Pago p = new Pago();
            
        if (total!=0) {
            System.out.println("NO PUEDE AGENDAR REVISIÓN TIENE MULTAS PENDIENTES ACERCARCE A LA AGENCIA MAS CERCANA ");
        }else if (total==0) {
            System.out.println("NO TIENE MULTAS");
            System.out.println();
            System.out.println("        HORARIOS DISPONIBLES");
            
            String[] Horarios = {"10-06-2023,09:00" , "10-06-2023,09:30" ,"10-06-2023,10:00" ,"10-06-2023,10:30" ,"10-06-2023,11:00", "......"}; 
            int contador=1;
            for (int i = 0; i < (Horarios.length); i++) {
                System.out.println(contador+"."+" "+Horarios[i]);
                contador+=1;
            }
            System.out.print("Elija un horario para la revisión: ");
            int numero = sc.nextInt();
            System.out.println();
            String [] fecha = Horarios[numero-1].split(",");
            System.out.println("************************************************************************************");
            System.out.println(u.getNombre()+", se ha agendado su cita para el "+fecha[0]+" a las "+fecha[1]);
            System.out.println("Valor a pagar: "+p.revisionPagoUser(ci));
            System.out.println();
            System.out.println("Puede pagar su cita hasta 24 horas antes de su cita.");
            System.out.println("De lo contrario se la cita se le cancelara.");
            System.out.println("************************************************************************************");
            
            
            FileWriter fichero = null;
            BufferedWriter bw = null;
            PrintWriter pw = null;
            int aleatorio = 0;
            aleatorio = (int) (Math.random()*1000);
            try {
                fichero = new FileWriter("C:\\Users\\PC.1\\Desktop\\PROYECTO 1P ENTREGABLE\\revisión.txt",true);
                bw = new BufferedWriter(fichero);
                bw.write(aleatorio+","+ci+","+placa+","+Horarios[numero-1]+"\n");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    // Nuevamente aprovechamos el finally para 
                    // asegurarnos que se cierra el fichero.
                    if (null != fichero) {
                        //fichero.close();
                        bw.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        
    }
    
    
}