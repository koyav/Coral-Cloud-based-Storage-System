


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


public class ProxyServer extends javax.swing.JFrame {

    static Random r = new Random();
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

   
    public ProxyServer() {
        initComponents();
        
         File f=new File("device.txt");
          if(f.isFile())
           {
         String Tagkey="";
       try{
          
         
       BufferedReader br=new BufferedReader(new FileReader("device.txt"));
       String line="";
       while((line=br.readLine())!=null)
       {
        jTextArea2.append(line+"\n");
        
       }
       }catch(Exception ex){}
       }
       
    }

    
    public static void serverAct() {
        try {

          
            InputStream inStream;
            DataInputStream inDataStream;

            String message = "";

            ServerSocket serverSocket = null;
            serverSocket = new ServerSocket(6000);
            System.out.println("server started...");

            while (true) {
                Socket clientSocket = null;
                clientSocket = serverSocket.accept();
                System.out.println("Connection accepted...");
                jTextArea1.append("Connection accepted.\n");
               
                inStream = clientSocket.getInputStream();
                inDataStream = new DataInputStream(inStream);
                message = inDataStream.readUTF();
                System.out.println("Client sent: " + message);
                System.out.println("mesge count " + c);
                String GRip = clientSocket.getRemoteSocketAddress().toString();

                FileWriter fstream = new FileWriter("user.db", true);
                BufferedWriter out1 = new BufferedWriter(fstream);
                String s1[] = message.split(":");
                String chk = s1[0];
                int key = r.nextInt(100000);
                if (chk.equalsIgnoreCase("reg")) {
                    String dat = s1[1] + "#" + key;
                    String em[]= s1[1].split("#");
                    
                    out1.write(dat + "\n");
                    out1.close();
                    String res = ECDSA.ECDSA(key, dat);
                    System.out.println("" + res);
                  
                } else {
                 
                    String mac = s1[1];
                    String ackey = s1[2];
                    String vkey = Activity_Methods.getT(mac);
                  
                    System.out.println("keyyy===>" + vkey);
                    
                    int rk = Integer.parseInt(ackey);
                    int tak = Integer.parseInt(vkey);
                    boolean res = ECDSA.ECDSAVerify(rk, tak);
                    System.out.println("res===>"+res);
                  
                    if(res)
                    {
                          
                            Activity_Methods am=new Activity_Methods();
                   String cip=s1[3];
                   
                   String sserv="";
                     try{
       
         
       BufferedReader br=new BufferedReader(new FileReader("device.txt"));
       String line="";
       while((line=br.readLine())!=null)
       {
        
         sserv=sserv+line+"#\n";
       }
       }catch(Exception ex){}
                   
                   String mres=" your Signature :"+res+":"+sserv;
                    am.clientResponse(cip, mres);
                    }else{
                    Activity_Methods am=new Activity_Methods();
                   String cip=s1[3];
                    am.clientResponse(cip, " your Signature :"+res);
                    }
                }
                model.add(c, GRip);

                jTextArea1.append(message + "\n");

             
                jList1.setModel(model);

              
       
            }

        } catch (Exception ex) {
            Logger.getLogger(ProxyServer.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.setOpaque(false);

        jList1.setBorder(javax.swing.BorderFactory.createTitledBorder("dataowner"));
        jScrollPane1.setViewportView(jList1);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createTitledBorder("User Information"));
        jScrollPane2.setViewportView(jTextArea1);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setBorder(javax.swing.BorderFactory.createTitledBorder("Storage Server List"));
        jScrollPane3.setViewportView(jTextArea2);

        jButton1.setText("Referesh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("                                                                                                         Proxy  Server");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
           File f=new File("device.txt");
          if(f.isFile())
           {
         String Tagkey="";
       try{
            jTextArea2.setText("");
         
       BufferedReader br=new BufferedReader(new FileReader("device.txt"));
       String line="";
       while((line=br.readLine())!=null)
       {
        jTextArea2.append(line+"\n");
        
       }
       }catch(Exception ex){}
       }
        
    }

    
    public static void main(String args[]) {
        new ProxyServer().setVisible(true);
        serverAct();
       
    }

    
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    public static final javax.swing.JList jList1 = new javax.swing.JList();
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public static final javax.swing.JTextArea jTextArea1 = new javax.swing.JTextArea();
    private javax.swing.JTextArea jTextArea2;
    

}
