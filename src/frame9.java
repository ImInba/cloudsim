
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User112
 */
public class frame9 extends javax.swing.JFrame {

    /**
     * Creates new form frame9
     */
     int count = 0;
    ArrayList<Integer> minthres = new ArrayList<Integer>();
    ArrayList<Integer> maxthres = new ArrayList<Integer>();
    Statement st;
    Connection con;

    public frame9() {
        initComponents();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
            st = con.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Profit/Resource Availability Maximization  on Confederated Cloud Environment");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 570, 50));

        jButton1.setText("Alloted Jobs");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 100, 30));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 570, 380));

        jButton2.setText("Job Not alloted");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 110, 30));

        jButton5.setText("allote job in FDC");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 140, 30));

        jButton6.setText("Next");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 70, 30));

        jButton4.setText("Execute Jobs");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            jTextArea1.setText("");
            jTextArea1.append("\tJobs allocated to the respective Vm's\n");
            jTextArea1.append("JobId\tBrokerId\t JobSize\tPriority\tAllocated VM\n");
            jTextArea1.append("************************************************************************************\n");
            ResultSet rs = st.executeQuery("select * from cloudlet where not allotedvm='vm not alloted'");
            while (rs.next()) {
                jTextArea1.append(rs.getInt(1) + "\t" + rs.getInt(2) + "\t" + rs.getInt(4) + "\t" + rs.getString(6) + "\t" + rs.getString(8) + "\n\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            jTextArea1.setText("");
           
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select count(*) from cloudlet where allotedvm='vm not alloted'");
            while (rs.next()) {
                count = rs.getInt(1);
            }
            if (count == 0) {
                JOptionPane.showMessageDialog(null, " All Job's Are alloted, No need of scheduling the Jobs's to VM's ");

            }
            if (count > 0) {
                JOptionPane.showMessageDialog(null, count + " Job's not Are alloted ");
                try{
                    st.executeUpdate("create table notalloted (jid int(10),brokerid int(10),jobsize int(10), priority varchar(50), value int(10),status varchar(50))");
                }
                catch(Exception e){
                    st.execute("delete from notalloted");
                    System.out.println("Table notalloted existing..");
                }
                jTextArea1.append("\tJobs allocated to the respective Vm's\n");
                jTextArea1.append("JobId\tBrokerId\t JobSize\tPriority\tAllocated VM\n");
                jTextArea1.append("************************************************************************************\n");
                Statement str = con.createStatement();
                ResultSet rst = str.executeQuery("select * from cloudlet where allotedvm='vm not alloted' order by value ASC");
                while (rst.next()) {
                    jTextArea1.append(rst.getInt(1) + "\t" + rst.getInt(2) + "\t" + rst.getInt(4) + "\t" + rst.getString(6) + "\t" + rst.getInt(7) + "\t" + rst.getString(8) + "\n\n");
                    Statement sr = con.createStatement();
                    sr.executeUpdate("insert into notalloted values('" + rst.getInt(1) + "','" + rst.getInt(2) + "','" + rst.getInt(4) + "','" + rst.getString(6) + "','" + rst.getInt(7) + "','Not alloted')");
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {
            int allotedcount=0;int c=0;
            jTextArea1.setText("");
            jTextArea1.append("Job Id\tBroker Exchange\tVM Id\tFederated Center\n");
            ArrayList<String> dclist = new ArrayList<String>();
            String dc = null;
            String fed = null;
            Statement st = con.createStatement();

            ResultSet rt = st.executeQuery("select * from notalloted order by value ASC");
            while (rt.next()) {
                int flag = 0;
                int jid = rt.getInt(1);
                int brid = rt.getInt(2);
                int js = rt.getInt(3);
                System.out.print(jid+"\t"+brid+"\t"+js);
                Statement st1 = con.createStatement();
                ResultSet rt1 = st1.executeQuery("select placed from vtable where brokerid='" + brid + "'");
                while (rt1.next()) {
                    dc = rt1.getString(1);
                    System.out.print("\t"+dc+"\t");
                }
                Statement st2 = con.createStatement();
                ResultSet rt2 = st2.executeQuery("select federation from datacenter where dcname='" + dc + "'");
                while (rt2.next()) {
                    fed = rt2.getString(1);
                    System.out.print(fed+"\t");
                }
                Statement st3 = con.createStatement();
                ResultSet rt3 = st3.executeQuery("select dcname from " + fed + "");
                while (rt3.next()) {
                    dclist.add(rt3.getString(1));
                }
                for (int i = 0; i < dclist.size(); i++) {
                    
                    Statement st4 = con.createStatement();
                    ResultSet rt4 = st4.executeQuery("select vmid,brokerid,capacity from vtable where placed='" + dclist.get(i) + "'");
                    while (rt4.next()) {
                        int vmid = rt4.getInt(1);
                        int bid = rt4.getInt(2);
                        int cap = rt4.getInt(3);
                        if (js < cap) {
                            cap = cap - js;
                            allotedcount++;
                            System.out.println(jid + " with broker id" + brid + "is transfered to brid" + bid + "and alloted to vm" + vmid + "by" + fed);
                            jTextArea1.append(jid + "\t" + brid + "to" + bid + "\t" + vmid + "\t" + fed + "\n");
                            Statement st5 = con.createStatement();
                            String v = "vm" + vmid;
                            st5.executeUpdate("update vtable set capacity='" + cap + "' where vmid='" + vmid + "'");
                            Statement st6 = con.createStatement();
                            st6.executeUpdate("update cloudlet set allotedvm='" + v + "',brokerid='" + bid + "' where id='" + jid + "'");
                            Statement st7 = con.createStatement();
                            st7.executeUpdate("update notalloted set status='alloted' where jid='" + jid + "'");
                            flag = 1;
                        }
                        if (flag == 1) {
                            break;
                        }
                    }
                    if (flag == 1) {
                        break;
                    }
                }
                
                c++;
                if(c!=allotedcount)
                {
                    jTextArea1.append("Job:"+jid+" not alloted, Resources Not Available\n");
                }
            }
            if(allotedcount!=count)
                {
                    JOptionPane.showMessageDialog(null, " Some Resources not available ");

                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        frame10 f10 = new frame10();
        f10.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {
            jTextArea1.setText("");
            Random r = new Random();
            Statement st = con.createStatement();
            jTextArea1.append("\tCalculating Execution Time\n\n");
            jTextArea1.append("Job Id\tJob Size\t Execution Time\n");
            jTextArea1.append("********************************************************************\n");
            ResultSet rs = st.executeQuery("select * from cloudlet");
            while (rs.next()) {
                int id = rs.getInt(1);
                int fs = rs.getInt(4);
                int value = rs.getInt(7);

                if (fs > 4000) {
                    int exec = r.nextInt(5000);
                    jTextArea1.append(id + "\t" + fs + "\t" + exec + "\n");
                    Statement st1 = con.createStatement();
                    st1.executeUpdate("update cloudlet set exectime='" + exec + "' where id='" + id + "'");
                } else if (fs < 4000 && fs > 2000) {
                    int exec = r.nextInt(2000);
                    jTextArea1.append(id + "\t" + fs + "\t" + exec + "\n");
                    Statement st1 = con.createStatement();
                    st1.executeUpdate("update cloudlet set exectime='" + exec + "' where id='" + id + "'");
                } else {
                    int exec = r.nextInt(1000);
                    jTextArea1.append(id + "\t" + fs + "\t" + exec + "\n");
                    Statement st1 = con.createStatement();
                    st1.executeUpdate("update cloudlet set exectime='" + exec + "' where id='" + id + "'");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frame9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frame9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frame9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frame9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frame9().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
