import java.lang.System;  
import java.net.*; 
import java.io.*;  
import java.text.*; 
import java.util.Random;  
import java.util.*; 
public class SRCli{  
 static Socket connection; 
 public static void main(String a[]) throws SocketException{
  
  try{  
   int v[] = new int[10];  
   int n = 0; 
   Random rands = new Random();  
   int rand = 0; 
   InetAddress addr = 
InetAddress.getByName("Localhost");  
   System.out.println(addr); 
   connection = new Socket(addr, 8011); 
  
   DataOutputStream out = new 
DataOutputStream(connection.getOutputStream()); 
   DataInputStream in = new 
DataInputStream(connection.getInputStream()); 
   int p = in.read(); 
   System.out.println("No of frame is:" + p);  
   for (int i = 0; i < p; i++){  
    v[i] = in.read(); 
    System.out.println(v[i]); 
   } 
   rand = rands.nextInt(p); v[rand] = -1; 
   for (int i = 0; i < p; i++){  
    System.out.println("Received frame is:" + v[i]); 
   } 
   for (int i = 0; i<p; i++) if (v[i] == -1){  
    System.out.println("Request to retransmit from 
packet no"+ (i+1)+"again!!"); 
    n = i;  
    out.write(n); 
    out.flush(); 
   } 
   System.out.println(); v[n] = in.read(); 
   System.out.println("Received frame is:" + v[n]);  
   System.out.println("quiting"); 
  } 
  catch (Exception e){  
   System.out.println(e); 
  } 
 } 
} 
 
/*
Output 
 
Server 
java SRSer 
waiting for connection 
The number of packets sent is:8 
Data Sent: 30 
Data Sent: 40 
Data Sent: 50 
Data Sent: 60 
Data Sent: 70 
Data Sent: 80 
Data Sent: 90 
Data Sent: 100 
 
Client 
 
java SRCli 
Localhost/127.0.0.1 
No of frame is:8 
30 
40 
50 
60 
70 
80 
90 
100 
Received frame is:30 
Received frame is:40 
Received frame is:50 
Received frame is:60 
Received frame is:70 
Received frame is:-1 
Received frame is:90 
Received frame is:100 
Request to retransmit from packet no6again!! 
Received frame is:80 
quiting
*/