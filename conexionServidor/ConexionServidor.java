package conexionServidor;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;



public class ConexionServidor extends Thread{
 
    
    private ServerSocket socket;
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static Socket servidor; 
    
    ConexionServidor(){
    	
    }
    ConexionServidor(int puerto) throws IOException{
    	socket = new ServerSocket(puerto);
        socket.setSoTimeout(100000000);
    }
    
 
    public void run(){
        try{
            InetAddress direccionPropia = InetAddress.getLocalHost();
            String nombreServidor = direccionPropia.getHostName();
            System.out.println("Nombre del Servidor:"+nombreServidor);
            servidor = socket.accept();
            System.out.println("Se conectó a:" + servidor.getRemoteSocketAddress());      
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void conectar(){
    	int puerto = 8085;
    	
        try{    	
        	
            Thread conexion = new ConexionServidor(puerto);
            conexion.start();
            try{
            	conexion.join();}
            catch(Exception e){
            	
            }
            Thread reader = new Thread(){
                public void run(){
                    while(true){
                        try{
                            DataInputStream in = new DataInputStream(servidor.getInputStream());
                            System.out.println("Cliente dice: " + in.readUTF());
                        }
                        catch(Exception e){
                        	
                        }
                    }
                }
            };
             
            Thread writer = new Thread(){
                public void run(){
                    while(true){
                        try{
                            String message = buffer.readLine();
                            DataOutputStream out = new DataOutputStream(servidor.getOutputStream());
                            out.writeUTF(message);
                        }
                        catch(Exception e){
                        	
                        }   
                    }
                }
            };
            reader.start();
            writer.start();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
     
    
}