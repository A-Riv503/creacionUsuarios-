/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio7;

/**
 *
 * @author ariel
 */
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class solo7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // logica de creacion de usuarios
    String correo, contraseña, password, user, num;
    int contador=0;
    String[] usuario =new String[3];
    Scanner lector= new Scanner(System.in);
    solo7 validarCorreo=new solo7();
    for(int i=0; i<3; i++){
      System.out.println("ingrese su usuario: ");
      user=lector.nextLine();
      System.out.println("ingrese su numero de telefono: ");
      num=lector.nextLine();
      int contadorV=0;
      do{
        System.out.println("ingrese su correo: ");
        correo=lector.nextLine();
        if(validarCorreo.validarEmail(correo)){
           if(contador==0){
             usuario[0]=correo;
             contador++;
             contadorV=0;
           }else if(contador==1){
            if(!validarCorreo.equalEmail(usuario[0], correo)){
              usuario[1]=correo;
              contador++;
              contadorV=0;
            }else{
             System.out.println("el correo ingresado ya esta en uso, intentelo nuevamente");
             contadorV++;
            }  
           }else if(contador==2){
             if(!validarCorreo.equalEmail(usuario[0],correo) && 
                !validarCorreo.equalEmail(usuario[1],correo)){
                contadorV=0; 
             }else{
              System.out.println("el correo ingresado ya esta en uso, intentelo nuevamente");
              contadorV++;  
             } 
            }
        }else{
          System.out.println("el correo ingresado no es un correo, intentelo nuevamente");
          contadorV++;
        }
          
      }while(contadorV!=0);
      int contadorC=0;
      do{
        System.out.println("ingrese su contraseña con mayusculas al inicio y al final");
        contraseña=lector.nextLine();
        password=contraseña.toUpperCase();
        if(contraseña.charAt(0)!= password.charAt(0)||
           contraseña.charAt(contraseña.length()-1)!= password.charAt(password.length()-1)){
           System.out.println("la contraseña ingresada no cumple "
                   + "los requisitos intentelo nuevamnete");
           contadorC++; 
        }else{
            contadorC=0;
        }
            
      }while(contadorC>0);
      
      System.out.println("usuario: "+user+" correo "+usuario[i]+
              " contraseña "+contraseña+" numero de telefono: "+num);
      
    }
        
 }
     public boolean validarEmail(String email){
        Pattern pattern=Pattern.compile("[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[gmail]+(\\.[gmail]+)*(\\.[com]{2,})$");
        Matcher mather=pattern.matcher(email);
        return mather.find();
          
    }
    public boolean equalEmail(String email1, String email2){
        
        boolean validar=email1.equals(email2);
        return validar;
    }
}