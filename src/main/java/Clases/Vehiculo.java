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
public class Vehiculo {
    private String placa;
    
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
    
    public String getPlaca(){
        return this.placa;
    }
    public void setPlaca(String placa){
        this.placa=placa;
    }
}