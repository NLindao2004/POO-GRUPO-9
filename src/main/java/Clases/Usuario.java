/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



/**
 *
 * @author PC.1
 */
public abstract class Usuario {
    protected String cedula;
    protected String nombre;
    protected int edad;
    protected String correo;
    protected String usuario;
    protected String contrasenia;
    protected String perfil;
    
    
    public Usuario(String cedula, String nombre, int edad,String correo, String usuario,String contrasenia, String perfil){
        this.cedula=cedula;
        this.nombre=nombre;
        this.edad=edad;
        this.correo=correo;
        this.usuario=usuario;
        this.contrasenia=contrasenia;
        this.perfil=perfil;
    }
    
    public Usuario(String cedula){
        try{
            FileReader f = new FileReader("C:\\Users\\PC.1\\Desktop\\PROYECTO 1P ENTREGABLE\\usuarios.txt");
            BufferedReader bf1 = new BufferedReader(f);
            String bf1Read;
            while((bf1Read = bf1.readLine())!=null){
                String[] datos = bf1Read.split(",");
                if(datos[0].equals(cedula)){
                this.nombre=datos[1];
                this.edad=Integer.parseInt(datos[2]);
                this.correo=datos[3];
                this.usuario=datos[4];
                this.contrasenia=datos[5];
                this.perfil=datos[6];
                }
            }
        }catch(IOException e){
            }
    }
    
    public abstract void consultarMulta();
    
    
    public String getNombre(){
        return this.nombre;
    }
    public int getEdad(){
        return this.edad;
    }
    public String getPerfil(){
        return this.perfil;
    }
    public String getCorreo(){
        return this.correo;
    }
   
    public String getCedula(){
        return this.cedula;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setEdad(int edad){
        this.edad=edad;
    }
    public void setPerfil(String perfil){
        this.perfil=perfil;
    }
    public void setCorreo(String correo){
        this.correo=correo;
    }
    public void setCedula(String cedula){
        this.cedula=cedula;
    }
    
}