


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Splitter {

    private int noOfParts;
    private File fileToSplit;
    private String opSys;
    private long partSize;
    boolean parts;

    public Splitter(File fileToSplit, int noOfParts, long partSize, boolean parts) {
        this.noOfParts = noOfParts;
        this.fileToSplit = fileToSplit;
        this.partSize = partSize;
        this.parts = parts;

    }

    public ArrayList split() {
        ArrayList spiltfileList = new ArrayList();

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("direc.table", true));
            BufferedWriter out = new BufferedWriter(new FileWriter("spilt.table", true));
            int k = Joiner.getKey();
            
                long fileSize = fileToSplit.length();
                String filePath = fileToSplit.getAbsolutePath();
                String directory;
                if (filePath.lastIndexOf("/") != -1) {
                    directory = filePath.substring(0, filePath.lastIndexOf("/"));
                    opSys = "/";
                } else {
                    directory = filePath.substring(0, filePath.lastIndexOf("\\"));
                    opSys = "\\";
                }
                String fileName = fileToSplit.getName();
                if (parts) {
                    partSize = fileSize / noOfParts;
                } else {
                    noOfParts = (int) (fileSize / partSize);
                    noOfParts++;
                }
                String fname = fileToSplit.getName();
                String orgname = fname;
                int lidx = fname.lastIndexOf(".");
                fname = fname.substring(0, lidx);
                File fdir = new File("spilted\\" + fname);
                if (fdir.exists()) {
                } else {
                    fdir.mkdir();
                }

                FileClient f = new FileClient();

                String sconfig = "";
                BufferedReader br=new BufferedReader(new FileReader("device.txt"));
                  while((sconfig=br.readLine())!=null)
                 {
                    String sl[]=sconfig.split(",");
                   int prt=Integer.parseInt(sl[1]);
                               

                bw.write(orgname+","+fname+","+k+","+sl[0]+","+sl[1]+"\n");
                 }
                File[] fileArr = new File[noOfParts];
                for (int i = 0; i < noOfParts; i++) {

                    fileArr[i] = new File("spilted" + opSys + fname + opSys + fileName + (i + 1) + ".split");
                    boolean success = fileArr[i].createNewFile();
                    String fn = fileName + (i + 1) + ".split";
                    long size = fileArr[i].length();
                    System.out.println("" + size);
                    
                    String credat = getCurmsgDate();
                    
                    out.write(fn + "," + k + "," + credat + "\n");
                }
                out.close();
                FileInputStream input = new FileInputStream(fileToSplit);
                BufferedInputStream iBuff = new BufferedInputStream(input);
                int i = 0;
                FileOutputStream output = new FileOutputStream(fileArr[i]);
                BufferedOutputStream oBuff = new BufferedOutputStream(output);
                int buffSize = 8 * 1024;
                byte[] buffer = new byte[buffSize];
                while (true) {
                    if (iBuff.available() < buffSize) {
                        byte[] newBuff = new byte[iBuff.available()];
                        iBuff.read(newBuff);
                        oBuff.write(newBuff);
                        oBuff.flush();
                        oBuff.close();
                        String credat = getCurmsgDate();
                        spiltfileList.add(fileArr[i].getName() + "," + k + "," + ((fileArr[i].length()) / 1024) + "," + credat);
                        JOptionPane.showMessageDialog(null, "Job Completed");
                        break;
                    }

                    int r = iBuff.read(buffer);
                    if (fileArr[i].length() >= partSize) {
                        oBuff.flush();
                        oBuff.close();
                       String credat = getCurmsgDate();
                        spiltfileList.add(fileArr[i].getName() + "," + k + "," + ((fileArr[i].length()) / 1024) + "," + credat);
                        i++;
                        output = new FileOutputStream(fileArr[i]);
                        oBuff = new BufferedOutputStream(output);
                    }
                    oBuff.write(buffer);
                }

           

            bw.close();
            
             Commanmsg cm=new Commanmsg();
             int c=0;
            for(int j=0;j<fileArr.length;j++)
            {
              
                 String finfo = fileArr[j].getName() + ":" + "1";
                  BufferedReader br1 = new BufferedReader(new FileReader(new File("device.txt")));
                     String line = "";
                                
                                while ((line = br1.readLine()) != null) {
                                    String s[] = line.split(",");
                                  int prt = Integer.parseInt(s[1]);
                                    f.filestoer(fileArr[j], s[0], prt,finfo );
                                  cm.msgtoserver(fileArr[j].getName(), s[0], s[1]);
                              
                                }
                                System.out.println(j+"==>"+fileArr[j].getAbsolutePath());
                                br1.close();
            }
            
            
       
        } catch (IOException ex) {
            System.out.println("==========>" + ex.getMessage());
        }

        return spiltfileList;
    }

    public static String getCurmsgDate() {
        String dat = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd HH:mm:ss a");
        String date = sdf.format(new Date());
        System.out.println(date);
        dat = date;
        return dat;
    }
}
