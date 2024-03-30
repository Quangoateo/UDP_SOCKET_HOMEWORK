
package Assignment4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args)
    {
        final int server_port =7;
        try{
            while(true)
            {
                DatagramSocket sv = new DatagramSocket(server_port);
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

                DatagramPacket k = new DatagramPacket(buff2,buff2.length,addcl,portcl);
                //sending back to the client
                sv.send(k);
                sv.close();
            }
        }
        catch(IOException e)
        {            
        }
    }
}
