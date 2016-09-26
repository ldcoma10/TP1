package sockets;

import java.net.*;
import java.io.*;
 
public class Servidor extends Thread{
 
    
    private ServerSocket serverSocket;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Socket server; 
    public Servidor(int port) throws IOException{
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(100000000);
    }
 
    public void run(){
        try{
            InetAddress my_address = InetAddress.getLocalHost();
            String hostname = my_address.getHostName();
            System.out.println(hostname);
            server = serverSocket.accept();
            System.out.println("Connected to " + server.getRemoteSocketAddress());      
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
     
    public static void main(String [] args){
        int port = 8085;
        try{
 
            Thread connector = new Servidor(port);
            connector.start();
            try{connector.join();}catch(Exception e){}
            Thread reader_thread = new Thread(){
                public void run(){
                    while(true){
                        try{
                            DataInputStream in = new DataInputStream(server.getInputStream());
                            System.out.println("Cliente dice: " + in.readUTF());
                        }catch(Exception e){}
                    }
                }
            };
             
            Thread writer_thread = new Thread(){
                public void run(){
                    while(true){
                        try{
                            String message = br.readLine();
                            DataOutputStream out = new DataOutputStream(server.getOutputStream());
                            out.writeUTF(message);
                        }catch(Exception e){}   
                    }
                }
            };
            reader_thread.start();
            writer_thread.start();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}