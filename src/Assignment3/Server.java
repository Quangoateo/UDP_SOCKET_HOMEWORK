package Assignment3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args)
    {
         try{
           DatagramSocket sv = new DatagramSocket(1234);
           //receive x value from client 
           byte buff1[]= new byte[256];
           DatagramPacket q = new DatagramPacket(buff1,buff1.length);
           sv.receive(q); 
           String data_x = new String(q.getData()).trim();
           int x = Integer.parseInt(data_x);
           
           
           //receive y value from client
           byte buff2[] = new byte[256];
           DatagramPacket k = new DatagramPacket(buff2,buff2.length);
           sv.receive(k);
           String data_y = new String(k.getData()).trim();
           int y= Integer.parseInt(data_y);
           
           //Operation section
//           int multiplication= x*y ;
           int subtraction = x-y;
//           String result_multiplication = String.valueOf(multiplication);
           String result_subtraction = String.valueOf(subtraction);
           byte[] buff3 = result_subtraction.getBytes();
//           byte[] buff4 = .getBytes();
           
           //Sending the result back to the client
           InetAddress addcl = q.getAddress();  //q or k ,since it is the same client
           int portcl = q.getPort();            //q or k ,since it is the same client
           DatagramPacket j = new DatagramPacket(buff3,buff3.length,addcl,portcl);
//           DatagramPacket l= new DatagramPacket(buff4,buff4.length,addcl,portcl);
           sv.send(j);
//           sv.send(l);
           sv.close();
       }catch(IOException e)
       {
       }
    }
}
