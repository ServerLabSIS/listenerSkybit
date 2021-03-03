/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listenerskybit;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.net.InetAddress;

/**
 *
 * @author SISPC-0100
 */
public class ListenerSkybit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ServerSocket servidor;
        Socket sc;
        
        byte[] tramaIn = new byte[50];
        
        String salida = "2929210005AAB10C330D";
        
        // Ip Address
        InetAddress myIP;
        // Puerto del servidor
        final int PUERTO = 1002;
        
        try {
            // Socket del servidor
            servidor = new ServerSocket(PUERTO);
            myIP = InetAddress.getLocalHost();
            //myPort = InetAddress.getPort;
            System.out.println("Servidor iniciado en la IP: " + myIP);
            
            // Escuchar peticiones
            sc = servidor.accept();
            while(true){
                // Conexión del cliente
                
                System.out.println("Trama recibida: ");
                
                //BufferedReader entrada = new BufferedReader(new InputStreamReader(sc.getInputStream()));
                DataInputStream in = new DataInputStream(sc.getInputStream());
                
                in.read(tramaIn);
                String decod = toHexadecimal.bytesToHex(tramaIn);
                
                String subDecod = decod.substring(4, 6); 
                if( "B1".equals(subDecod)){
                    System.out.println(decod);
                    byte[] tramaOut = toByteArray.hexStringToByteArray(salida);
                    OutputStream out = sc.getOutputStream();
                    out.write(tramaOut);
                    out.flush();
                    System.out.println("Salida enviada: " + salida);
                } else {
                    System.out.println(decod);
                }
                
                
                
                
                
                //out.writeUTF("Mensaje enviado");
                
                // Cerramos socket
//                sc.close();
//                System.out.println("Cliente desconectado");
            }
        
        } catch(IOException ex){
            Logger.getLogger(ListenerSkybit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
