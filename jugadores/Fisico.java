package jugadores;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Fisico  extends Jugador{
	private String IP;
	public ArrayBlockingQueue<Integer> queue=new ArrayBlockingQueue<Integer>(999);
	static BufferedReader buffer1 = new BufferedReader(new InputStreamReader(System.in));
	int n;
	public Fisico(){
		IP=null;
		n=0;
	}
	
	
	public String getIP() {
		return IP;
	}


	public void setIP(String IP) {
		this.IP = IP;
	}


	public void conectar(){
		try{
             
            InetAddress direccionPropia = InetAddress.getLocalHost();
            setIP(direccionPropia.toString());
            System.out.println("Escriba el nombre del servidor con el que se va a conectar");
 
            String nombre = buffer1.readLine();
            final Socket cliente  = new Socket(nombre,8085);
            
            Thread reader = new Thread(){
                public void run(){
                	 FileOutputStream fos = null;
                     BufferedOutputStream out =null;
                     BufferedInputStream in = null;
                	
                    while(true){
                		
                    	
                        try{ 
                        	
                        	 // Se lee los datos que envía el cliente
                            DataInputStream dis = new DataInputStream( cliente.getInputStream() );
                     
                            // Se obtiene el nombre del archivo
                            String nombreArchivo = dis.readUTF().toString(); 
              
                            // Se obtiene el tamaño del archivo
                            int tam = dis.readInt(); 
              
                            System.out.println( "Recibiendo archivo "+nombreArchivo );
                     
                            //Se crea un flujo de salida el cual permite concer donde se guardará eñ archivo
                            fos = new FileOutputStream( "C://Users//Luis D Coto//Desktop//Cambios//n"+n+nombreArchivo );
                            out = new BufferedOutputStream( fos );
                            in = new BufferedInputStream( cliente.getInputStream() );
              
                            // Creamos el array de bytes para poder leer los datos que posee el archivo
                            byte[] buffer = new byte[ tam ];
              
                            // Obtenemos el archivo mediante la lectura de bytes enviados
                            for( int i = 0; i < buffer.length; i++ )
                            {
                               buffer[ i ] = ( byte )in.read( ); 
                            }
              
                            // Se escribe el archivo
                            out.write( buffer ); 
              
                            // Cierra los flujos
                            out.flush(); 
                            out.close();
                            n++;
                            
                            System.out.println( "Archivo Recibido "+nombreArchivo );
                        }
                        
                        
                        
                        
                        catch(Exception e){}
                        
                        
                        
                    }
                }
            };
            Thread writer = new Thread(){
                public void run(){   	
                	
                	BufferedInputStream bis=null;
                	DataOutputStream dos=null;
                	FileInputStream fis=null;
                	BufferedOutputStream bos=null;
                	while(true){
                	
	                	try
	                    {
	                		
	                	  Object mensaje = queue.take();
	                   
	                      // Creamos el archivo que vamos a enviar
	                	
	                	  String nombreArchivo = "C:/Users/Luis D Coto/Desktop/Cambios/plan.pdf";
	                      File archivo = new File( nombreArchivo );
	                   
	                      // Obtenemos el tamaño del archivo
	                      int tamañoArchivo = ( int )archivo.length();
	                   
	                      //Se implementa un flujo de salida, el cual permite la escritura de diferentes tipos de datos como: Strings, boolean, caracteres y enteros, etc.
	                      dos = new DataOutputStream(cliente.getOutputStream() );
	                   
	                      System.out.println( "Enviando Archivo: "+archivo.getName() );
	                   
	                      // Enviamos el nombre del archivo 
	                      dos.writeUTF( archivo.getName() );
	                   
	                      // Enviamos el tamaño del archivo
	                      dos.writeInt( tamañoArchivo );
	                   
	                      // Creamos flujo de entrada para realizar la lectura del archivo en bytes
	                      fis = new FileInputStream( nombreArchivo );
	                      bis = new BufferedInputStream( fis );
	                   
	                      // Creamos el flujo de salida para enviar los datos del archivo en bytes
	                      bos = new BufferedOutputStream( cliente.getOutputStream());
	                      
	                      // Se agrega un array de tipo byte con el tamaño del archivo 
	                      byte[] buffer = new byte[ tamañoArchivo ];
	                   
	                      // Se lee el archivo y se introduce en el array de bytes 
	                      bis.read( buffer ); 
	                   
	                      // Se envían los bytes pertenecientes al archivo
	                      
	                      for( int i = 0; i < buffer.length; i++ )
	                      {
	                          bos.write( buffer[ i ] ); 
	                         
	                      } 
	                   
	                      System.out.println( "Archivo Enviado: "+archivo.getName() );
	                      bos.flush();
	                     
	                    }
	                    catch( Exception e )
	                    {
	                    	
	                      System.out.println( e.toString() );
	                    }
                   
                   }
            	}
                	
                	
                	
                }; 
            
            
            
            
            
            
            
            
            
             
            
            Thread prueba = new Thread(){
                public void run(){
                	try {
                		Thread.sleep(10000);
						queue.put(1);
						
						
						Thread.sleep(10000);
						queue.put(2);
						
						Thread.sleep(10000);
						queue.put(3);
						
					} catch (InterruptedException e) {
						
					}
                	
                	                    	
                	}
                };
            reader.start();
            writer.start();
            prueba.start();
        }
        catch(Exception e){
            System.out.println("ERROR: " + e);
        }
		
	}
}
