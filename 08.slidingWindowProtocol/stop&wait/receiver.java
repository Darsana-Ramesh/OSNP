import java.io.*; 
import java.net.*; 
public class SWReceiver{ 
 ServerSocket receiver; 
 Socket connection=null; 
 ObjectOutputStream out; 
 ObjectInputStream in; 
 String packet,ack,data=""; 
 int i=0,sequence=0; 
 SWReceiver(){ } 
 public void run(){ 
  try{ 
   BufferedReader br=new BufferedReader(new 
InputStreamReader(System.in)); 
   receiver = new ServerSocket(2005,10); 
   System.out.println("waiting for connection..."); 
   connection=receiver.accept(); 
   sequence=0; 
   System.out.println("Connection established   :"); 
   out=new 
ObjectOutputStream(connection.getOutputStream()); 
   out.flush(); 
   in=new 
ObjectInputStream(connection.getInputStream()); 
   out.writeObject("connected    ."); 
 
   do{ 
    try{ 
     packet=(String)in.readObject(); 
    
 if(Integer.valueOf(packet.substring(0,1))==sequence){ 
      data+=packet.substring(1); 
      sequence=(sequence==0)?1:0; 
      System.out.println("\nreceiver   
>"+packet); 
     } 
     else{ 
      System.out.println("\nreceiver    >"+packet 
+"   duplicate data"); 
     } 
     if(i<3){ 
     
 out.writeObject(String.valueOf(sequence));i++; 
     } 
     else{ 
     
 out.writeObject(String.valueOf((sequence+1)%2)); 
      i=0; 
     } 
    } 
    catch(Exception e){ 
    } 
   }while(!packet.equals("end")); 
   System.out.println("Data received="+data); 
   out.writeObject("connection ended    ."); 
  } 
  catch(Exception e){ 
  } 
  finally{ 
   try{ 
    in.close(); 
    out.close(); 
    receiver.close(); 
   } 
   catch(Exception e){ 
   } 
  } 
 } 
 public static void main(String args[]){ 
  SWReceiver s=new SWReceiver(); 
  s.run(); 
 } 
} 
 
/*
 
//Sender Output 
 
java SWSender 
Waiting for Connection.... 
receiver     > connected    . 
Enter the data to send.... 
HELLO 
data sent>0H 
waiting for ack..... 
receiver   >   packet received 
data sent>1E 
waiting for ack..... 
receiver   >   packet received 
data sent>0L 
waiting for ack..... 
receiver   >   packet received 
data sent>1L 
waiting for ack..... 
Time out resending data.... 
data sent>1L 
waiting for ack..... 
receiver   >   packet received 
data sent>0O 
waiting for ack..... 
receiver   >   packet received 
All data sent. exiting. 
 
 
 
//Receiver Output 

java SWReceiver 
waiting for connection... 
Connection established   : 
receiver         
>0H 
receiver         
receiver         
receiver         
receiver         
receiver         
>1E 
>0L 
>1L 
>1L   
>0O 
Data received=HELLO
 duplicate data

*/