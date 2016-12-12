



import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


public class CLoudnode extends javax.swing.JFrame {

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
    /** Creates new form Client */
    public CLoudnode() {
     
            initComponents();
           
           
      

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client Node");

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Main server IP");

        jButton6.setText("Connect Main server ");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addGap(113, 113, 113))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addGap(0, 57, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 20, 560, 110);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 200, 570, 200);
        jPanel1.add(jProgressBar1);
        jProgressBar1.setBounds(260, 160, 256, 14);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Receiving");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(160, 160, 69, 14);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void serverstorage() {
        try {
            int bytesRead;
            InputStream inStream;
            DataInputStream inDataStream;
            OutputStream outStream;
            DataOutputStream outDataStream;
            String message = "";
            String received = "";
            String[] temp = null;
           
            String ip = InetAddress.getLocalHost().getHostAddress();
            String PORT = JOptionPane.showInputDialog(null, "your IPAddress" + ip + "ENTER THE PORT NUMBER");
            ServerSocket serverSocket = null;
            csport=PORT;


            int prt = Integer.parseInt(PORT);
            
            serverSocket = new ServerSocket(prt);
            while (true) {
                Socket clientSocket = null;
                clientSocket = serverSocket.accept();
                inStream = clientSocket.getInputStream();
                inDataStream = new DataInputStream(inStream);
                 message = inDataStream.readUTF();
             
                    filn = message;
                    
                String s[]=message.split(":");
             
                InputStream in = clientSocket.getInputStream();
                String rip = clientSocket.getRemoteSocketAddress().toString();
                String ipn = rip.replace("/", "");
                int ls = ipn.lastIndexOf(":");
                String fol = ipn.substring(0, ls);
                File f = new File("D://server"+prt);
             
                if (f.exists() == false) {
                    f.mkdir();
                    System.out.println("Directory Created");
                } else {
                    System.out.println("Directory is not created");
                }
            
                String str = serverSocket.getLocalSocketAddress().toString();
                OutputStream output = new FileOutputStream(f.getAbsolutePath()+"//"+ s[0]);

                fz = clientSocket.getReceiveBufferSize();
                byte[] buffer = new byte[1024];
                start = java.util.Calendar.getInstance().getTime();
                while ((bytesRead = in.read(buffer)) != -1) {
                    output.write(buffer, 0, bytesRead);
                    current = current + 1;
                    jTextArea1.append(" \n packet size" + current);
                }
           
                output.close();
              
            }
        }  catch (IOException ex) {
            Logger.getLogger(CLoudnode.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void connectGatway()
    {
        
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            
            String mIP = jTextField4.getText().toString().trim();
             ippaddr = InetAddress.getLocalHost().getHostAddress().toString();
               this.setTitle("inode" + ippaddr + ":" + csport);
            sock1 = new Socket(mIP, 5000);
            
          
            DataInputStream dis = new DataInputStream(System.in);
                            message = ippaddr+":"+csport+":connected to Main server:0";
                            outStream = sock1.getOutputStream();
                            outDataStream = new DataOutputStream (outStream);
                            outDataStream.writeUTF(message);
                            ms=1;
        
        }  catch (Exception ex) {
            Logger.getLogger(CLoudnode.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton6ActionPerformed

    
    

  

  




     public static boolean ipcheck(String sip, String dip) {
        String fi[] = sip.split("\\.");
        String si[] = dip.split("\\.");
        boolean res = false;
        System.out.println(sip + "=====" + dip);
        if (sip.equalsIgnoreCase("*.*.*.*")) {
            res = true;
        } else {
            for (int d = 0; d < fi.length; d++) {
             
                if (fi[d].equalsIgnoreCase(si[d])) {
                    res = true;

                } else if ("*".equalsIgnoreCase(fi[d])) {
                    System.out.println("Enttt");
                    for (int i = 0; i < 255; i++) {
                        int comp = Integer.parseInt(si[d]);
                        if (i == comp) {
                            System.out.println("Enttt1");
                            res = true;
                        }
                    }
                } else {
                    res = false;
                }


            }
        }
        return res;
    }

    
    
    
    
    
    
    
    
   
    public static void main(String args[]) {

        new CLoudnode().setVisible(true);
        serverstorage();

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton6;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static final javax.swing.JProgressBar jProgressBar1 = new javax.swing.JProgressBar();
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
