/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author PC.1
 */
public class Cliente extends Usuario{
    Scanner sc= new Scanner(System.in);

    
    public Cliente(String cedula, String nombre, int edad,String correo, String usuario,String contrasenia, String perfil) {
        super(cedula,nombre,edad,correo,usuario,contrasenia,perfil);
    }
    public Cliente(String cedula){
        super(cedula);
    }
    
}