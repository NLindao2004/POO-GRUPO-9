/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**

Clase Vehiculo que representa un vehículo en el sistema.
*/
public class Vehiculo {
    private String placa;

/**

Busca un auto en un archivo basado en su placa.
@param placa Placa del vehículo a buscar.
@return Modelo del vehículo encontrado.
*/
    public String buscarAuto(String placa){
        try{ 
            FileReader file1 = new FileReader("C:\\Users\\PC.1\\Desktop\\PROYECTO 1P ENTREGABLE\\vehiculos.txt");
            BufferedReader bf1 = new BufferedReader(file1);
            String bf2Read;
            while((bf2Read = bf1.readLine())!=null){
                String[] datos1 = bf2Read.split(",");
                    if (datos1[1].equals(placa)) {
                        return datos1[0];
                                         
                    }  
                }
            }
            catch (IOException e){
                System.out.println("no se encontro archivo");
            }
        return null;
    }

/**

Obtiene la placa del vehículo.
@return Placa del vehículo.
*/
    public String getPlaca(){
        return this.placa;
    }
/**

Establece la placa del vehículo.
@param placa Placa del vehículo.
*/
    public void setPlaca(String placa){
        this.placa=placa;
    }
/**

Sobrescribe el método toString para retornar una representación en forma de cadena de la placa del vehículo.
@return Cadena que representa la placa del vehículo.
*/
    @Override
    public String toString(){
        return this.placa;
    }
}