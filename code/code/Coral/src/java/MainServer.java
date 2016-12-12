


import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;


public class MainServer extends javax.swing.JFrame {

   static Vector col = new Vector();
    static Vector data = new Vector();
   static  Vector v = new Vector();
    InputStream inStream;
    DataInputStream inDataStream;
    OutputStream outStream;
    DataOutputStream outDataStream;
    String message = "", m2 = "";
    int bytesRead;
    private static Socket sock, sock1;
    private static String filname;
    public static int c = 0, s = 0;
    public static DefaultListModel model = new DefaultListModel();
    public static DefaultListModel model1 = new DefaultListModel();
    public static String dir = "", filn = "";
    public static Date end, start;
    public static int current = 0, fz;
    public static String ipaddr, csport;

    
    public MainServer() {
         BufferedReader br = null;
        try {
            initComponents();
            File f=new File("device.txt");
            if(f.exists())
            {
            col.addElement("Ip Address");
            col.addElement("port");
            col.addElement("Status");
           
            br = new BufferedReader(new FileReader(new File("device.txt")));
            String line="";
            while((line=br.readLine())!=null)
            {
              
                String s[]=line.split(",");
               
            } 
              br.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(MainServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void serverAct() {
        try {

            InputStream inStream;
            DataInputStream inDataStream;
            String message = "";
            ServerSocket serverSocket = null;
            serverSocket = new ServerSocket(5000);
            System.out.println("server started...");
           
            while (true) {

                Socket clientSocket = null;
                clientSocket = serverSocket.accept();
                System.out.println("Connection accepted...");
             
                inStream = clientSocket.getInputStream();
                inDataStream = new DataInputStream(inStream);
                message = inDataStream.readUTF();
                System.out.println("Client sent: " + message);
                System.out.println("mesge count " + c);
                String GRip = clientSocket.getRemoteSocketAddress().toString();
                s++;
                FileWriter fstream = new FileWriter("device.txt", true);
                BufferedWriter out1 = new BufferedWriter(fstream);
                 FileWriter fstream1 = new FileWriter("Log.txt", true);
                BufferedWriter out2 = new BufferedWriter(fstream1);
                String s1[] = message.split(":");
               if(s1[3].equalsIgnoreCase("0")){
                   System.out.println("==>"+s1[0]);
                out1.write(s1[0] + "," + s1[1] + "\n");
                
                  out1.close(); 
                  Random r=new Random();
                  int val= Integer.parseInt(s1[1]);
                  int k=r.nextInt(5000);
                   
               }
               
                   out2.write(s1[0] + "," + s1[1] + ","+s1[2]+"\n");  
               
               
              
                  out2.close();
                
            }

        } catch (Exception ex) {
            Logger.getLogger(MainServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Coral");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("                                                 Main Server");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Refersh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed


        try {
          ;
            try {
                
                data.removeAllElements();
                BufferedReader br = new BufferedReader(new FileReader(new File("Log.txt")));
                String line="";
                while((line=br.readLine())!=null)
                {
                    System.out.println(""+line);
                    Vector v = new Vector();
                    String s[]=line.split(",");
                    v.addElement(s[0]);
                    v.addElement(s[1]);
                    v.addElement(s[2]);
                    
                    data.add(v);
                }

                DefaultTableModel model = new DefaultTableModel(data, col);
                jTable1.setModel(model);
               
            } catch (Exception ex) {
                Logger.getLogger(MainServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        BufferedReader    br1 = new BufferedReader(new FileReader(new File("device.txt")));
            String line="";
            while((line=br1.readLine())!=null)
            {
              
                String s[]=line.split(",");
              
            } 
           br1.close();        } catch (Exception ex) {
            Logger.getLogger(MainServer.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public static void main(String args[]) {
       
        new MainServer().setVisible(true);
        serverAct();

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
