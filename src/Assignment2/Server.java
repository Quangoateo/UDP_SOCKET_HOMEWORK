package Assignment2;

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
           DatagramPacket x_value = new DatagramPacket(buff1,buff1.length);
           sv.receive(x_value); 
           String data_x = new String(x_value.getData()).trim();
           int x = Integer.parseInt(data_x);
                     
           //receive y value from client
           byte buff2[] = new byte[256];
           DatagramPacket y_value = new DatagramPacket(buff2,buff2.length);
           sv.receive(y_value);
           String data_y = new String(y_value.getData()).trim();
           int y = Integer.parseInt(data_y);
           
           //Receive z value from client
           byte buff3[] = new byte[256];
           DatagramPacket z_value = new DatagramPacket(buff3,buff3.length);
           sv.receive(z_value);
           String data_z = new String(z_value.getData()).trim();
           int z= Integer.parseInt(data_z);
           
           //Caculating LCM OF (x,y,z )values
           Finding_LCM caculator = new Finding_LCM();
           int lcm_result = caculator.lcm(x, y, z);
           String resultString = String.valueOf(lcm_result);
           byte[] buff_Result = resultString.getBytes();          
           //Sending the result back to the client
           InetAddress addcl = z_value.getAddress();  
           int portcl = z_value.getPort();
           
           DatagramPacket result_data = new DatagramPacket(buff_Result,buff_Result.length,addcl,portcl);
           sv.send(result_data);
           sv.close();
       }
        catch(IOException e)
       {
       }
    }

}
