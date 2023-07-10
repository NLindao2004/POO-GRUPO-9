/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



/**
 * Esta clase representa un objeto Operador, que hereda de la clase Usuario.
 * Un Operador es un tipo de usuario que puede realizar acciones como registrar pagos, consultar multas y consultar usuarios.
 */
public class Operador extends Usuario {
    
    
    private int sueldo;
    
    Scanner sc = new Scanner(System.in);

    /**
     * Constructor de la clase Operador.
     * 
     * @param cedula La cédula del operador.
     * @param nombre El nombre del operador.
     * @param edad La edad del operador.
     * @param correo El correo electrónico del operador.
     * @param usuario El nombre de usuario del operador.
     * @param contrasenia La contraseña del operador.
     * @param perfil El perfil del operador.
     */
    public Operador(String cedula, String nombre, int edad,String correo, String usuario,String contrasenia, String perfil){
        super(cedula,nombre,edad,correo,usuario,contrasenia,perfil);
    }
    
     /**
     * Constructor alternativo de la clase Operador.
     * Permite buscar y cargar los datos de un operador a partir de su cédula.
     * 
     * @param cedula La cédula del operador.
     */
    public Operador(String cedula){
        super(cedula);
    }
    
     /**
     * Método que registra el pago de multas o revisiones de un usuario.
     * Permite elegir entre pagar multas o revisiones y registra el pago en el archivo "registroPagos.txt".
     * 
     * @param cedula La cédula del usuario.
     */
    
    public void registrarPago(String cedula){
        
        Pago p = new Pago();
        
        String condicion=" ";
        
        while(condicion.equals(" ")){
            System.out.println("¿Qué deseas pagar?");
            System.out.println("1. Multas");
            System.out.println("2. Revisión ");
            System.out.println("3. Salir");
            System.out.print("Elija una opción: ");
            int op = sc.nextInt();
            if (op==1) {
               String formato = p.pagoMultas(cedula);
               FileWriter fichero = null;
               BufferedWriter bw = null;
               PrintWriter pw = null;

               try {
                   int aleatorio = 0;
                   aleatorio = (int) (Math.random()*1000);
                   fichero = new FileWriter("C:\\Users\\PC.1\\Desktop\\PROYECTO 1P ENTREGABLE\\registroPagos.txt",true);
                   bw = new BufferedWriter(fichero);
                   bw.write(aleatorio+","+formato+"\n");
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
            condicion+="FALSE";    
            }else if(op==2){
                String formato1 = p.pagoRevision(cedula);
                FileWriter fichero = null;
                BufferedWriter bw = null;
                PrintWriter pw = null;

                try {
                    int aleatorio = 0;
                    aleatorio = (int) (Math.random()*1000);
                    fichero = new FileWriter("C:\\Users\\PC.1\\Desktop\\PROYECTO 1P ENTREGABLE\\registroPagos.txt",true);
                    bw = new BufferedWriter(fichero);
                    bw.write(aleatorio+","+formato1+"\n");
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
            condicion+="FALSE";    
            }else{
                System.out.println("Opción incorrecta");
            }
        }
    }

    
    
    
    
    @Override
    public void consultarMulta(){
        Scanner sc = new Scanner(System.in);
        String condicion = " ";
        while(condicion.equals(" ")){ 
            System.out.print("Ingrese número del mes: ");
            int mes = sc.nextInt(); 
            try{ 
                FileReader fileReader = new FileReader("C:\\Users\\PC.1\\Desktop\\PROYECTO 1P ENTREGABLE\\multas.txt");
                BufferedReader bf = new BufferedReader(fileReader);
                String temp="";
                String bfRead;
                while((bfRead = bf.readLine())!=null){
                    String[] datos = bfRead.split(",");
                    String[] fecha = datos[4].split("-");
                    int m = Integer.parseInt(fecha[1]);
                    if (mes==m) {
                        System.out.println("----------------------------------------------------------");
                        System.out.println("                    CONSULTAR MULTAS");
                        System.out.println("----------------------------------------------------------");
                        System.out.println(bfRead);
                        condicion+="FALSE";
                    }
                } System.out.println("No se encontraron multas en el mes ingresado");
            }
            catch (IOException e){
                System.out.println("no se encontro archivo");
            }
       }
    }
   
     /**
     * Método que permite consultar y mostrar los usuarios registrados en el sistema.
     * Muestra el nombre, perfil y sueldo de los operadores, y el nombre y tipo de los clientes (estrella o estándar).
     */
    
    public void consultarUser(){
        System.out.println("----------------------------------------------------------");
        System.out.println("                    CONSULTAR USUARIOS");
        System.out.println("----------------------------------------------------------");
        try{ 
            FileReader fileReader = new FileReader("C:\\Users\\PC.1\\Desktop\\PROYECTO 1P ENTREGABLE\\usuarios.txt");
            BufferedReader bf = new BufferedReader(fileReader);
          
            String bfRead;
            
            
            while((bfRead = bf.readLine())!=null){
                String[] datos = bfRead.split(",");
                if (datos[6].equals("O")) {
                    String sueldo= buscarSueldo(datos[0]);
                    System.out.println(datos[1]+" | OPERADOR | "+sueldo);
                }else if (datos[6].equals("E")) {
                    
                    System.out.println(datos[1]+" | CLIENTE ESTRELLA | "+datos[0]);
                }else if (datos[6].equals("S")) {
                    
                    System.out.println(datos[1]+" | CLIENTE ESTANDAR | "+datos[0]);
                }
            }
            
        }
        catch (IOException e){
            System.out.println("no se encontro archivo");
        }
        
    }
    
    
/**
 * Método que busca el sueldo de un operador a partir de su cédula en el archivo "operadores.txt".
 * 
 * @param cedula La cédula del operador.
 * @return El sueldo del operador encontrado.
 */
    public String buscarSueldo(String cedula){
        String sueldo = " ";
        try{
        FileReader operadores= new FileReader("C:\\Users\\PC.1\\Desktop\\PROYECTO 1P ENTREGABLE\\operadores.txt");
        BufferedReader bf1 = new BufferedReader(operadores);
        String bf1Read;
        while((bf1Read = bf1.readLine())!=null){
            String[] datos = bf1Read.split(",");
            if (cedula.equals(datos[0])) {
                sueldo=datos[1];
            }
        }
        
        }
        catch (IOException e){
            System.out.println("no se encontro archivo");
        }
     return sueldo;   
    }
/**
 * Método getter que obtiene el sueldo del operador.
 * 
 * @return El sueldo del operador.
 */
    public int getSuelgo(){
        return this.sueldo;
    }
    
/**
 * Método setter que establece el sueldo del operador.
 * 
 * @param sueldo El sueldo del operador a establecer.
 */
    public void setSueldo(int sueldo){
        this.sueldo=sueldo;
    }
    
    
}