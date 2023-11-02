import java.io.*;
import java.net.*;
 
class daemonpoc
{
    public static void main(String[] args)
    {
        String hostname = "xraydaemon.<namespace>.svc.cluster.local";
        int port = 2000;
 
        try{
 
            InetAddress address = InetAddress.getByName(hostname);
            DatagramSocket socket = new DatagramSocket();
 
            String segment="{\"format\":\"json\",\"version\":1}\n{\"id\":\"831c2b6eec626f11\",\"name\":\"Test\",\"trace_id\":\"1-651e7dbb-035261e91f79706eff6ab8d0\",\"start_time\":1696497089,\"end_time\":1696497090}";

            byte[] buffer=segment.getBytes();
            DatagramPacket request = new DatagramPacket(buffer, buffer.length, address, port);
            socket.send(request);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}