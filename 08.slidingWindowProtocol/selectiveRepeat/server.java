import java.io.DataInputStream;  
import java.io.DataOutputStream;  
import java.io.IOException;  
import java.net.ServerSocket;  
import java.net.Socket; 
import java.net.SocketException;  
public class SRSer{   
 static ServerSocket serversocket;  
 static DataInputStream dis; 
 static DataOutputStream dos; 
 public static void main(String[] args) throws 
SocketException{  
  try{  
   int a[] = { 30, 40, 50, 60, 70, 80, 90, 100 }; 
   serversocket = new ServerSocket(8011);  
   System.out.println("waiting for connection");  
   Socket client = serversocket.accept(); 
   dis = new DataInputStream(client.getInputStream());  
   dos = new DataOutputStream(client.getOutputStream()); 
   System.out.println("The number of packets sent is:"+ 
a.length);  
   int y = a.length; 
   dos.write(y); 
   dos.flush(); 
   for (int i = 0; i < a.length; i++){  
    dos.write(a[i]); 
    System.out.println("Data Sent: "+a[i]); 
    dos.flush(); 
   } 
   int k = dis.read();  
   dos.write(a[k]); 
   dos.flush(); 
  } 
  catch (IOException e){ 
   System.out.println(e); 
  } 
  finally{ 
   try{  
    dis.close(); 
    dos.close(); 
   } 
   catch (IOException e){  
    e.printStackTrace(); 
   } 
  } 
 } 
} 