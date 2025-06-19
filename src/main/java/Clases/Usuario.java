/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**

Clase abstracta Usuario que representa a un usuario genérico del sistema.

Contiene propiedades y métodos comunes a todos los usuarios.
*/
public abstract class Usuario {
    protected String cedula;
    protected String nombre;
    protected int edad;
    protected String correo;
    protected String usuario;
    protected String contrasenia;
    protected String perfil;

/**

Constructor que recibe todos los datos del usuario.
@param cedula Cédula del usuario.
@param nombre Nombre del usuario.
@param edad Edad del usuario.
@param correo Correo electrónico del usuario.
@param usuario Nombre de usuario del usuario.
@param contrasenia Contraseña del usuario.
@param perfil Perfil del usuario.
*/
    
    public Usuario(String cedula, String nombre, int edad,String correo, String usuario,String contrasenia, String perfil){
        this.cedula=cedula;
        this.nombre=nombre;
        this.edad=edad;
        this.correo=correo;
        this.usuario=usuario;
        this.contrasenia=contrasenia;
        this.perfil=perfil;
    }
/**

Constructor que busca y carga los datos del usuario desde un archivo basado en su cédula.
@param cedula Cédula del usuario.
*/
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

/**

Método abstracto que debe ser implementado por las clases hijas para consultar las multas del usuario.
*/
    public abstract void consultarMulta();
    
/** 
Obtiene el nombre del usuario.
@return Nombre del usuario.
*/
    public String getNombre(){
        return this.nombre;
    }
    
/**

Obtiene la edad del usuario.
@return Edad del usuario.
*/
    public int getEdad(){
        return this.edad;
    }

/**

Obtiene el perfil del usuario.
@return Perfil del usuario.
*/
    public String getPerfil(){
        return this.perfil;
    }
    
/**

Obtiene el correo electrónico del usuario.
@return Correo electrónico del usuario.
*/
    public String getCorreo(){
        return this.correo;
    }
    
/**

Obtiene la cédula del usuario.
@return Cédula del usuario.
*/
   
    public String getCedula(){
        return this.cedula;
    }
 
/**

Establece el nombre del usuario.
@param nombre Nombre del usuario.
*/
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
/**

Establece la edad del usuario.
@param edad Edad del usuario.
*/
    public void setEdad(int edad){
        this.edad=edad;
    }
    
/**

Establece el perfil del usuario.
@param perfil Perfil del usuario.
*/
    public void setPerfil(String perfil){
        this.perfil=perfil;
    }
/**

Establece el correo electrónico del usuario.
@param correo Correo electrónico del usuario.
*/
    public void setCorreo(String correo){
        this.correo=correo;
    }
    
/**

Establece la cédula del usuario.
@param cedula Cédula del usuario.
*/
    public void setCedula(String cedula){
        this.cedula=cedula;
    }

/**

Sobrescribe el método toString para retornar una representación en forma de cadena del usuario.
@return Cadena que representa al usuario.
*/
    @Override
    public String toString(){
        return "Nombre: "+this.nombre+" Cedula: "+this.cedula+" Edad: "+this.edad+" Perfil: "+this.perfil+" Correo: "+this.correo;
    }
}