
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;


public class Commanmsg {
     InputStream inStream;
    DataInputStream inDataStream;
    OutputStream outStream;
    DataOutputStream outDataStream;
    String message = "", m2 = "";
    int bytesRead;
    Socket sock,sock1;
    private static String filname,format,Grip,ippaddr;
    public static int c = 0,srcprt,ms=0;
    public static DefaultListModel model = new DefaultListModel();
     public static DefaultListModel model1 = new DefaultListModel();
 public static String dir="",filn="";
 public static Date end,start;
 public static int current = 0, fz;
 public static String ipaddr,csport;
 
 public  void msgtoserver(String mes,String ip,String port)
 {
      try {
            
            String mIP = "127.0.0.1";
             ippaddr = InetAddress.getLocalHost().getHostAddress().toString();
            
            sock1 = new Socket(mIP, 5000);
            
          
           
                            message = ip+":"+port+":"+mes+"->sent:1";
                            outStream = sock1.getOutputStream();
                            outDataStream = new DataOutputStream (outStream);
                            outDataStream.writeUTF(message);
                            ms=1;
        sock1.close();
        }  catch (Exception ex) {
            Logger.getLogger(Commanmsg.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
 
 public  void msgtoserverAuth(String mes,String ip,int port)
 {
      try {
            
            String mIP = "127.0.0.1";
             ippaddr = InetAddress.getLocalHost().getHostAddress().toString();
            
            sock1 = new Socket(mIP, 5000);
            
          
           
                            message = ip+":"+port+":"+mes+"->sent:1";
                            outStream = sock1.getOutputStream();
                            outDataStream = new DataOutputStream (outStream);
                            outDataStream.writeUTF(message);
                            ms=1;
        sock1.close();
        }  catch (Exception ex) {
            Logger.getLogger(Commanmsg.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
 
 public  void msgtoproxyserver(String mes,String ip,String port)
 {
      try {
            
            String mIP = "127.0.0.1";
             ippaddr = InetAddress.getLocalHost().getHostAddress().toString();
            
            sock1 = new Socket(mIP, 6000);
            
          
            DataInputStream dis = new DataInputStream(System.in);
                            message = ip+":"+port+":"+mes+"->sent:1";
                            outStream = sock1.getOutputStream();
                            outDataStream = new DataOutputStream (outStream);
                            outDataStream.writeUTF(message);
                            ms=1;
        sock1.close();
        }  catch (Exception ex) {
            Logger.getLogger(Commanmsg.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
 
  public  void msgtoproxyserverTPA(String data)
 {
      try {
            
             String mIP = "192.168.1.95";
             ippaddr = InetAddress.getLocalHost().getHostAddress().toString();
             
            sock1 = new Socket(mIP, 6000);             
                                  message = data;
                            outStream = sock1.getOutputStream();
                            outDataStream = new DataOutputStream (outStream);
                            outDataStream.writeUTF(message);                   
        sock1.close();
        }  catch (Exception ex) {
            Logger.getLogger(Commanmsg.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
}
