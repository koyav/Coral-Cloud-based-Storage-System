

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;
import java.security.spec.ECGenParameterSpec;


public class ECDSA {

    public static int s = 0;

    public static String  ECDSA(int Randomkey, String dat) {
           String res="";
        try {
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA", "BC");
            ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
            
            keyGen.initialize(ecSpec, new SecureRandom());

            KeyPair keyPair = keyGen.generateKeyPair();
            Signature signature = Signature.getInstance("ECDSA", "BC");
            PublicKey pub = keyPair.getPublic();
            System.out.println(pub.toString());
            PrivateKey prikey = keyPair.getPrivate();
            System.out.println(pub.toString());
            System.out.println(prikey.toString());

        
           
            String data[] = dat.split("#");

            res="\nName :" + data[0]+"\nEmail :" + data[2]+"\n dob :" + data[3]
                  +"\n KEY: "+data[1]+"\n"+pub.toString() + "\n"+prikey.toString() + "\n";
            signature.initSign(keyPair.getPrivate(), new SecureRandom());
            String rankey = String.valueOf(Randomkey);
            byte[] message = rankey.getBytes();
            String s = new String(message);
        
            signature.update(message);

            byte[] sigBytes = signature.sign();
            signature.initVerify(keyPair.getPublic());
            byte[] message1 = "1000".getBytes();
            String ss = new String(message1);
          
            signature.update(message1);
          
        } catch (Exception ex) {
          
        }
        return res;
    }

    
    
    
    
    public static boolean ECDSAVerify(int Randomkey,int tagkey) {
           boolean res=false;
        try {
            
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA", "BC");
            ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
            
            keyGen.initialize(ecSpec, new SecureRandom());
             
            KeyPair keyPair = keyGen.generateKeyPair();
            Signature signature = Signature.getInstance("ECDSA", "BC");
            PublicKey pub = keyPair.getPublic();
            System.out.println(pub.toString());
            PrivateKey prikey = keyPair.getPrivate();
            System.out.println(pub.toString());
            System.out.println(prikey.toString());

               
            signature.initSign(keyPair.getPrivate(), new SecureRandom());
            String rankey = String.valueOf(Randomkey);
            byte[] message = rankey.getBytes();
            String s = new String(message);
         
            signature.update(message);

            byte[] sigBytes = signature.sign();
            signature.initVerify(keyPair.getPublic());
             String tkey = String.valueOf(tagkey);
            byte[] message1 = tkey.getBytes();
            String ss = new String(message1);
         
            signature.update(message1);
          
            res=signature.verify(sigBytes);
            System.out.println("res==="+res);
        } catch (Exception ex) {
           
        }
          System.out.println("res= test=="+res);
        return res;
    }
    
    
    
    
       public static boolean BLC(int Randomkey,int tagkey) {
           boolean res=false;
        try {
            System.out.println(" TPA Auditing\n");
             System.out.println(" ==============================================\n");
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA", "BC");
            ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
            
            keyGen.initialize(ecSpec, new SecureRandom());
             
            KeyPair keyPair = keyGen.generateKeyPair();
            Signature signature = Signature.getInstance("ECDSA", "BC");
            PublicKey pub = keyPair.getPublic();
            System.out.println(pub.toString());
            PrivateKey prikey = keyPair.getPrivate();
            System.out.println(pub.toString());
            System.out.println(prikey.toString());

               
            signature.initSign(keyPair.getPrivate(), new SecureRandom());
            String rankey = String.valueOf(Randomkey);
            byte[] message = rankey.getBytes();
            String s = new String(message);
         
            signature.update(message);

            byte[] sigBytes = signature.sign();
            signature.initVerify(keyPair.getPublic());
             String tkey = String.valueOf(tagkey);
            byte[] message1 = tkey.getBytes();
            String ss = new String(message1);
          
            signature.update(message1);
           
        } catch (Exception ex) {
          
        }
         
        return res;
    }
}
