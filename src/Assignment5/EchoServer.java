package Assignment5;

import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) {
        try (DatagramSocket sv = new DatagramSocket(3222)) {
            while (true) {
                //Receive from client 
                byte buff1[] = new byte[1024];
                DatagramPacket q = new DatagramPacket(buff1, buff1.length);
                sv.receive(q);
                
                // Extract received data
                String data = new String(q.getData(), 0, q.getLength()); // Specify the length of the received data
                System.out.println("User: " + data);
                
                if (data.equalsIgnoreCase("bye")) {
                    System.out.println("Server: Chat ended. Exiting...");
                    break;
                }
                
                // Sending to client
                BufferedReader serverReader = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Server: ");
                String st = serverReader.readLine();
    
                byte buff2[] = st.getBytes();
                InetAddress addcl = q.getAddress();
                int portcl = q.getPort();
                DatagramPacket k = new DatagramPacket(buff2, buff2.length, addcl, portcl);
                sv.send(k);
    
                if (st.equalsIgnoreCase("bye")) {
                    System.out.println("Server: Chat ended. Exiting...");
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
