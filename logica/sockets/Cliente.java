package sockets;

import java.io.*;
import java.net.*;
 
/**
 * Clase cliente
 *
 */
public class Cliente extends Thread{
	
	/**
	 *Constructor de la conexión
	 */
	public void conexion(){
		
	}
	
	/**
	 * Método inicializador
	 */
    public static void main(String args[]){
        try{
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             
            InetAddress my_address = InetAddress.getLocalHost();
            System.out.println("Enter the machine name of the server:");
 
            String address = br.readLine();
            final Socket client = new Socket(address,8085);
             
            Thread reader_thread = new Thread(){
                public void run(){
                    while(true){
                        try{
                            InputStream from_server = client.getInputStream();
                            DataInputStream in = new DataInputStream(from_server);
                            System.out.println("Servidor dice: " + in.readUTF());
                        }
                        catch(Exception e){}
                    }
                }
            };
             
            Thread writer_thread = new Thread(){
                public void run(){
                    while(true){
                        try{
                            final String message = br.readLine();
                            OutputStream to_send = client.getOutputStream();
                            DataOutputStream out = new DataOutputStream(to_send);
                            out.writeUTF(message);
                        }
                        catch(Exception e){}
                    }   
                }
            };
             
            reader_thread.start();
            writer_thread.start();
        }
        catch(Exception e){
            System.out.println("Houston.. we have a problem " + e);
        }
    }
}
