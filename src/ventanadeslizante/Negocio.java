/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanadeslizante;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author KRLOS
 */
public class Negocio {
    
     
      
    public Negocio(){
    }
    
    /*
    METODO QUE ARMA LA TRAMA A ENVIAR SEGUN LOS BITS 
    DIGITADOS DEL CLIENTE
    */
    public  String GetTramas ( ){
        String cad ="";
        int Ttrama=8;
        for(int i =0; i<Ttrama ; i++){
        cad+=String.valueOf((int)(Math.random()*9)+1);
        }
        return cad ;
    }
    
   
    
    public void Emisor (String SERVER, String TRAMA, int PORT){
    boolean exit=false;//bandera para controlar ciclo del programa
        Socket socket;//Socket para la comunicacion cliente servidor        
        try {            
            System.out.println("Cliente> Inicio");  
            while( !exit ){//ciclo repetitivo                                
                socket = new Socket(SERVER, PORT);//abre socket                
                //Para leer lo que envie el servidor      
                BufferedReader input = new BufferedReader( new InputStreamReader(socket.getInputStream()));                
                //para imprimir datos del servidor
                PrintStream output = new PrintStream(socket.getOutputStream());                
                      
                //manda peticion al servidor
                output.println(TRAMA); 
                //captura respuesta e imprime
                String st = input.readLine();
                if( st != null ) System.out.println("Servidor> " + st );    
                
                    exit=true;                  
                    System.out.println("Cliente> Fin de programa");    
                
                socket.close();
            }//end while                                    
       } catch (IOException ex) {        
         System.err.println("Cliente> " + ex.getMessage());   
       }
    }
    
    
    
    
}
