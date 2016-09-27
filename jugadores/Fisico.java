package jugadores;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Fisico  extends Jugador{
	private String IP;
	
	public Fisico(){
		IP=null;		
	}
	
	
	public String getIP() {
		return IP;
	}


	public void setIP(String IP) {
		this.IP = IP;
	}


	public void conectar(){
		try{
            final BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
             
            InetAddress direccionPropia = InetAddress.getLocalHost();
            setIP(direccionPropia.toString());
            System.out.println("Escriba el nombre del servidor con el que se va a conectar");
 
            String nombre = buffer.readLine();
            final Socket cliente  = new Socket(nombre,8085);
             
            Thread reader = new Thread(){
                public void run(){
                    while(true){
                        try{
                            InputStream mensajeServidor = cliente.getInputStream();
                            DataInputStream in = new DataInputStream(mensajeServidor);
                            System.out.println("Servidor dice: " + in.readUTF());
                        }
                        catch(Exception e){}
                    }
                }
            };
             
            Thread writer = new Thread(){
                public void run(){
                    while(true){
                        try{
                            final String mensaje = buffer.readLine();
                            OutputStream mensajeCliente = cliente.getOutputStream();
                            DataOutputStream out = new DataOutputStream(mensajeCliente);
                            out.writeUTF(mensaje);
                        }
                        catch(Exception e){}
                    }   
                }
            };
             
            reader.start();
            writer.start();
        }
        catch(Exception e){
            System.out.println("ERROR: " + e);
        }
		
	}
}
