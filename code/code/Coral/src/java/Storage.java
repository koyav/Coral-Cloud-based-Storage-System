
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Storage extends javax.swing.JFrame implements Runnable {

    String fileToSplitName;
    int parts;
    File fileToSplit;
    public static String filname;

   
    public Storage() {
        initComponents();
        this.setLocation(250, 100);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        fileNameLabel = new javax.swing.JLabel();
        fileName = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        noOfPartsLabel = new javax.swing.JLabel();
        noOfParts = new javax.swing.JTextField();
        splitButton = new javax.swing.JButton();
        resultLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setDividerLocation(300);
        jSplitPane1.setDividerSize(10);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jSplitPane1.setOneTouchExpandable(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Spilt and Encryption with storage", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        fileNameLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        fileNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        fileNameLabel.setText("File:(F)");

        browseButton.setBackground(new java.awt.Color(204, 0, 102));
        browseButton.setForeground(new java.awt.Color(255, 255, 255));
        browseButton.setText("Get File");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        noOfPartsLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        noOfPartsLabel.setForeground(new java.awt.Color(255, 255, 255));
        noOfPartsLabel.setText("No. Of SPlit Data:");

        splitButton.setBackground(new java.awt.Color(204, 0, 102));
        splitButton.setForeground(new java.awt.Color(255, 255, 255));
        splitButton.setText("Split & Secure Storage");
        splitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                splitButtonActionPerformed(evt);
            }
        });

        resultLabel.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noOfPartsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(fileNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(splitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(noOfParts)
                            .addComponent(fileName, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browseButton))
                    .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileNameLabel)
                    .addComponent(fileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noOfPartsLabel)
                    .addComponent(noOfParts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(splitButton)
                .addGap(29, 29, 29)
                .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(jPanel1);

        jScrollPane1.setBackground(new java.awt.Color(0, 153, 153));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        jTable1.setBackground(new java.awt.Color(0, 102, 102));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
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
        jTable1.setGridColor(new java.awt.Color(0, 153, 204));
        jScrollPane1.setViewportView(jTable1);

        jSplitPane1.setRightComponent(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
       
        String path = getDoa_Data();
        File f = new File(path);

        fileToSplit = new File(f.getAbsolutePath());
        fileToSplitName = f.getName();
        fileName.setText(fileToSplitName);
       
}//GEN-LAST:event_browseButtonActionPerformed

    private void splitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_splitButtonActionPerformed
        
        String fn = fileToSplitName;
        if (fn.equalsIgnoreCase(filname) == false) {
            Thread t = new Thread(this);
            t.start();
        } else {
            JOptionPane.showMessageDialog(this, "already process has done. once close this apps after try it.");
        }


    }//GEN-LAST:event_splitButtonActionPerformed


    public void run() {
        boolean partsBool = true;
        long maxSizeL = 0;
        long sizeSelectL = 1024;
        resultLabel.setText("Splitting..Please Wait..");
        try {
            if (!(noOfParts.getText() == null || noOfParts.getText().equals(""))) {
                parts = Integer.parseInt(noOfParts.getText());
            } else {

            }
        } finally {
            JOptionPane.showMessageDialog(null, maxSizeL + "   " + parts);
            Splitter split = new Splitter(fileToSplit, parts, maxSizeL, partsBool);
            filname = fileToSplit.getName();
            Vector col = new Vector();
            Vector data = new Vector();
            col.addElement("BId");
            col.addElement("SId");
            col.addElement("Offset");
            col.addElement("File Name");
            col.addElement("Spilted Size");
            col.addElement("File creation Time");
            ArrayList li = split.split();
            for (int i = 0; i < li.size(); i++) {
                Vector v = new Vector();
                String line = li.get(i).toString();
                String s[] = line.split(",");
                v.addElement((i + 1));
                v.addElement((i + 10));
                v.addElement((sizeSelectL + 10));
                v.addElement(s[0]);
                v.addElement(s[2]);
                v.addElement(s[3]);
                data.add(v);

            }
            resultLabel.setText("Done..");
            DefaultTableModel model = new DefaultTableModel(data, col);
            jTable1.setModel(model);
            try {
                KDTreeMain.main();
            } catch (IOException ex) {
                Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

   
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            
        } catch (InstantiationException ex) {
            
        } catch (IllegalAccessException ex) {
            
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Storage().setVisible(true);
            }
        });
    }

    public static String getDoa_Data() {
        String data = "";
        try {

            String line = "";
            BufferedReader br = new BufferedReader(new FileReader("D:/upload.db"));
            while ((line = br.readLine()) != null) {
                data = line;
            }

        } catch (Exception ex) {
        }
        return data;

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JTextField fileName;
    private javax.swing.JLabel fileNameLabel;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField noOfParts;
    private javax.swing.JLabel noOfPartsLabel;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JButton splitButton;
    // End of variables declaration//GEN-END:variables

}
