package Assignment6;
import java.util.*;
import java.net.*;
import java.io.*;
public class Client {
    public static void main(String[] args) {
        try {
            //init socket for clilent
            DatagramSocket cl = new DatagramSocket();
            InetAddress addsv = InetAddress.getByName("localhost");   
            
                            
                //Sendingg a and b integers to server
                BufferedReader clientReader = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("User_ENTER FIRST INT NUMBER ");
                int a = Integer.parseInt(clientReader.readLine());
                System.out.println("User_ENTER SECOND INT NUMBER");
                int b= Integer.parseInt(clientReader.readLine());
                //sending both integers to server   
                ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
                DataOutputStream dataStream = new DataOutputStream(byteStream);
                dataStream.writeInt(a);
                dataStream.writeInt(b);
                
                byte[] sendData = byteStream.toByteArray();
                DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,addsv,1222);
                cl.send(sendPacket);
                
                
                //receive the even nums from server
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                cl.receive(receivePacket);
                
                ByteArrayInputStream receiveByteStream = new ByteArrayInputStream(receiveData);
                DataInputStream receiveDataStream = new DataInputStream(receiveByteStream);
                while (receiveDataStream.available() > 0 ) {                          
                    int evenNumber = receiveDataStream.readInt();
                    if(evenNumber != 0)
                    {
                         System.out.println("Received even number: " + evenNumber);
                    }                   
               }
                cl.close();                             
            
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}