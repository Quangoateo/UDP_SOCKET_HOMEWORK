package Assignment4;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args)
    {
       final int server_port = 7;
       final String server_host = "192.168.152.1";
        try{
            DatagramSocket cl = new DatagramSocket();
            System.out.println("ENTER STRING FROM KEYBOARD");
            Scanner keyboard= new Scanner(System.in);
            String str = keyboard.nextLine();
            //sending string to server
            byte buff[] = str.getBytes();
            InetAddress addsv = InetAddress.getByName("localhost");
            DatagramPacket p = new DatagramPacket(buff,buff.length,addsv,1234);
            cl.send(p);
            //receiving data from server
            byte buff2[] = new byte[256];
            DatagramPacket l = new DatagramPacket(buff2,buff2.length);
            cl.receive(l);
            String data = new String(l.getData()).trim();
            System.out.println("String return from server: "+data);
            cl.close();
        }
        catch(IOException e)
        {
            
        }
    }
            
}
