package Assignment5;

import java.util.*;
import java.net.*;
import java.io.*;

public class EchoClient {
    public static void main(String[] args) {
        try {
            //init socket for clilent
            DatagramSocket cl = new DatagramSocket();
            InetAddress addsv = InetAddress.getByName("localhost");   
            while(true) {                        
                //Sendingg messsages to server
                BufferedReader clientReader = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("User: ");
                String st = clientReader.readLine();
                byte buff[] = st.getBytes();
                DatagramPacket p = new DatagramPacket(buff, buff.length,addsv,3222);
                cl.send(p);
                
                if (st.equalsIgnoreCase("bye")) {
                    break;
                }//Receiving messages from server

                byte buff2[] = new byte[1024];
                DatagramPacket l = new DatagramPacket(buff2, buff2.length);
                cl.receive(l);
                //displayyyingg results 
                String data = new String(l.getData()).trim();
                System.out.println("Server: " + data);
                if(data.equalsIgnoreCase("bye")) {
                    break;
                }
            }
            cl.close(); 
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}