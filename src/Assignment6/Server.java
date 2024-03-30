package Assignment6;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    public static void main(String[] args) {
        try (DatagramSocket sv = new DatagramSocket(1222)) {
            while (true) {
                
                //Receive from client 
                byte buff1[] = new byte[1024];
                DatagramPacket q = new DatagramPacket(buff1, buff1.length);
                sv.receive(q);
                //placeholders to store int a and b
                ByteArrayInputStream receiveByteStream = new ByteArrayInputStream(buff1);
                DataInputStream receiveDataStream = new DataInputStream(receiveByteStream);
                int a = receiveDataStream.readInt();
                int b = receiveDataStream.readInt();
                
                //finding even numbers in range[a,b]
                List<Integer> evenNumbers = new ArrayList<>();
                for(int i =a; i<=b;i++)
                {
                    if(i % 2 == 0 )
                    {
                        evenNumbers.add(i);
                    }
                }
                
                //sending even numbers back to the client             
                ByteArrayOutputStream sendByteStream = new ByteArrayOutputStream();
                DataOutputStream sendDataStream = new DataOutputStream(sendByteStream);
                 for (int evenNumber : evenNumbers) {
                    sendDataStream.writeInt(evenNumber);
                } 
                byte[] sendData = sendByteStream.toByteArray();
                DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,q.getAddress(),q.getPort());
                sv.send(sendPacket);
                 
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
