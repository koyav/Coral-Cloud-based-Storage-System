


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Activity_Methods {
           InputStream inStream;
    DataInputStream inDataStream;
    OutputStream outStream;
    DataOutputStream outDataStream;
    String message = "", m2 = "";
    int bytesRead;
 
    private static String filname,format,Grip,ippaddr;
    public static int c = 0,srcprt,ms=0;
  public static String dir="",filn="";
 public static Date end,start;
 public static int current = 0, fz;
 public static String ipaddr,csport;
    
     public static String getPhysicalAddress()
    {
        InetAddress ip;
        String phyaddr="";
	try {
			
		ip = InetAddress.getLocalHost();
		System.out.println("Current IP address : " + ip.getHostAddress());
		
		NetworkInterface network = NetworkInterface.getByInetAddress(ip);
			
		byte[] mac = network.getHardwareAddress();
			
		System.out.print("Current MAC address : ");
			
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
		}
		System.out.println(sb.toString());
			phyaddr=sb.toString();
	} catch (UnknownHostException e) {
		
		e.printStackTrace();
		
	} catch (SocketException e){
			
		e.printStackTrace();
			
	}
	    return phyaddr;
    }
     
     
     
   public static void addUserInCloud(String data)  
   {
       try{
       BufferedWriter bw=new BufferedWriter(new FileWriter("user.db",true));
         bw.write(data);
         bw.close();
               }catch(Exception ex){}    
   }
   
   public static String getT(String mac)
   {
       String Tagkey="";
       try{
       BufferedReader br=new BufferedReader(new FileReader("user.db"));
       String line="";
       while((line=br.readLine())!=null)
       {
           String s=line;
           String ss[]=s.split("#");
           String vk=ss[0];
           if(vk.equalsIgnoreCase(mac))
           {
               Tagkey=ss[1];
           }
       }
       }catch(Exception ex){}
       
       return  Tagkey;
   }
   
   
   
   public static void addStorageServer(String data)  
   {
       try{
       BufferedWriter bw=new BufferedWriter(new FileWriter("SServer.db",true));
         bw.write(data+"\n");
         bw.close();
         addStorageSserverdetails(data+": Activated",data);
               }catch(Exception ex){}    
   }
   
   
   
      public static void addStorageSserverdetails(String data,String fname)  
   {
       try{
          
       BufferedWriter bw=new BufferedWriter(new FileWriter("Storageserver/"+fname+".db",true));
         bw.write(data+"\n");
         bw.close();
               }catch(Exception ex){
                   System.out.println(""+ex.getLocalizedMessage());
               }    
   }
  public void clientResponse(String ip,String result)
  {
        try {        
     
           
          
          Socket   sock1 = new Socket(ip, 6000);             
                                  message = result;
                            outStream = sock1.getOutputStream();
                            outDataStream = new DataOutputStream (outStream);
                            outDataStream.writeUTF(message);                       
        
        }  catch (Exception ex) {
           
        }  
  }
}
