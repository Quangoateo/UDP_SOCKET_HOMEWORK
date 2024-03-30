
package Assignment3;
//Performing Multiplication

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
        public static void main(String[]args)
        {  
               try{
        DatagramSocket cl = new DatagramSocket();
        InetAddress addsv = InetAddress.getByName("localhost");
        Scanner keyboard = new Scanner(System.in);    
        
        //INPUT INTEGER X
        System.out.println("Please input  integer(X):");
        int a= keyboard.nextInt();
        byte buff1[] = String.valueOf(a).getBytes();
        DatagramPacket x_value = new DatagramPacket(buff1,buff1.length,addsv,1234);
        cl.send(x_value);     
        
        //INPUT INTEGER Y
        System.out.println("Please input integer(Y):");
        int y = keyboard.nextInt();
        byte buff2[] = String.valueOf(y).getBytes();
        DatagramPacket y_value = new DatagramPacket(buff2,buff2.length,addsv,1234);
        cl.send(y_value);
                
        //Received server Result
        System.out.println("Subtraction result");
        byte buff3[] = new byte[256];
        DatagramPacket data_result = new DatagramPacket(buff3,buff3.length);
        cl.receive(data_result);
        String received_data = new String(data_result.getData(),0,data_result.getLength());
        System.out.println("Subtraction Result:"+received_data);
        cl.close();
        } 
        catch(IOException e){
                
        }
        }
}
