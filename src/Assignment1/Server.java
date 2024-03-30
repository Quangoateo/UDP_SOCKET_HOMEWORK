
package Assignment1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args)
    {
           try{
            DatagramSocket sv = new DatagramSocket(1234);
            byte buff1[] = new byte[256];
            DatagramPacket q = new DatagramPacket(buff1, buff1.length);
            sv.receive(q);
            
            
            //converting string to lowerCase;
            String data= new String(q.getData()).trim();
            String kq = data.toLowerCase();
            byte buff2[] = new byte[256];
            buff2 = kq.getBytes();
            
            InetAddress addcl =q.getAddress();
            int portcl = q.getPort();
            
            DatagramPacket k=new DatagramPacket(buff2,buff2.length,addcl,portcl);
            
            sv.send(k);
            sv.close();
  
        }
        catch(IOException e)
        {   
//            System.out.println("Connection error");
        }
    }
}
