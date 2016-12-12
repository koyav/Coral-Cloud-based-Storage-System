

import java.net.*;
import java.io.*;

public class FileClient {

    InputStream inStream;
    DataInputStream inDataStream;
    OutputStream outStream;
    DataOutputStream outDataStream;
    String message = "";
    int bytesRead;

    public void filestoer(File file, String IP, int port, String fn) throws IOException {
        try {
            Socket sock = new Socket(IP, port);
            System.out.println(fn+"==> "+file.getAbsolutePath());
           
            message = fn;
            outStream = sock.getOutputStream();
            outDataStream = new DataOutputStream(outStream);
            outDataStream.writeUTF(message);
                       
            File myFile = file;
            byte[] mybytearray = new byte[(int) myFile.length()];

            FileInputStream fis = new FileInputStream(myFile);
            BufferedInputStream bis = new BufferedInputStream(fis);
            bis.read(mybytearray, 0, mybytearray.length);

            OutputStream os = sock.getOutputStream();

            os.write(mybytearray, 0, mybytearray.length);

            os.flush();

            sock.close();

        } catch (Exception ex) {

        }

    }
    
    
    
     public void Commandsend( String IP, int port, String fn) throws IOException {
        try {
            Socket sock = new Socket(IP, port);
            System.out.println("Enter your message here: ");
            DataInputStream dis = new DataInputStream(System.in);
            message = fn;
            outStream = sock.getOutputStream();
            outDataStream = new DataOutputStream(outStream);
            outDataStream.writeUTF(message);
                       

            sock.close();

        } catch (Exception ex) {

        }

    }
}
