/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ServerForm extends javax.swing.JFrame {
    
    // Mouse event
    private MouseEvent getPositionEvent;
    // Server sockeet
    private static ServerSocket serverSocket;
    // Socket to get and to transfer data to clients
    private static Socket dataSocket;
    
    private boolean running;
    
    // List of clients
    protected static ArrayList<ServerConnection> serverConnection = new ArrayList<>();

    /**
     * Creates new form ClientForm
     */
    public ServerForm() {
        initComponents();

        // Set start server button to off
        jPanelServerStatus.setBackground(Color.red);
        jLabelServerStatus.setText("OFF");
        
        jTextPaneLog.setText("\n\n");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTextFieldPort = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanelServerStatus = new javax.swing.JPanel();
        jLabelServerStatus = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneLog = new javax.swing.JTextPane();
        jPanelDragWindow = new javax.swing.JPanel();
        jPanelCloseWindow = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(92, 151, 191));

        jTextFieldPort.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPort.setText("1234");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Port:");

        jPanelServerStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelServerStatusMousePressed(evt);
            }
        });

        jLabelServerStatus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelServerStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelServerStatus.setText("Off");

        javax.swing.GroupLayout jPanelServerStatusLayout = new javax.swing.GroupLayout(jPanelServerStatus);
        jPanelServerStatus.setLayout(jPanelServerStatusLayout);
        jPanelServerStatusLayout.setHorizontalGroup(
            jPanelServerStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelServerStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );
        jPanelServerStatusLayout.setVerticalGroup(
            jPanelServerStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelServerStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldPort, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 321, Short.MAX_VALUE)
                .addComponent(jPanelServerStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPort, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(11, Short.MAX_VALUE))
            .addComponent(jPanelServerStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 500, 50));

        jTextPaneLog.setEditable(false);
        jTextPaneLog.setBackground(new java.awt.Color(34, 49, 63));
        jTextPaneLog.setBorder(null);
        jTextPaneLog.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextPaneLog.setForeground(new java.awt.Color(228, 241, 254));
        jScrollPane1.setViewportView(jTextPaneLog);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 500, 300));

        jPanelDragWindow.setBackground(new java.awt.Color(1, 50, 67));
        jPanelDragWindow.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanelDragWindowMouseDragged(evt);
            }
        });
        jPanelDragWindow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelDragWindowMousePressed(evt);
            }
        });

        jPanelCloseWindow.setBackground(new java.awt.Color(228, 241, 254));
        jPanelCloseWindow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelCloseWindowMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCloseWindowLayout = new javax.swing.GroupLayout(jPanelCloseWindow);
        jPanelCloseWindow.setLayout(jPanelCloseWindowLayout);
        jPanelCloseWindowLayout.setHorizontalGroup(
            jPanelCloseWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
        );
        jPanelCloseWindowLayout.setVerticalGroup(
            jPanelCloseWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelDragWindowLayout = new javax.swing.GroupLayout(jPanelDragWindow);
        jPanelDragWindow.setLayout(jPanelDragWindowLayout);
        jPanelDragWindowLayout.setHorizontalGroup(
            jPanelDragWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDragWindowLayout.createSequentialGroup()
                .addGap(0, 447, Short.MAX_VALUE)
                .addComponent(jPanelCloseWindow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelDragWindowLayout.setVerticalGroup(
            jPanelDragWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCloseWindow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelDragWindow, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanelCloseWindowMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelCloseWindowMousePressed
        System.exit(0);
    }//GEN-LAST:event_jPanelCloseWindowMousePressed

    private void jPanelDragWindowMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelDragWindowMouseDragged
        // Set new location
        setLocation(evt.getXOnScreen() - getPositionEvent.getX(),
                evt.getYOnScreen() - getPositionEvent.getY());
    }//GEN-LAST:event_jPanelDragWindowMouseDragged

    private void jPanelDragWindowMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelDragWindowMousePressed
        // Get current position
        getPositionEvent = evt;
    }//GEN-LAST:event_jPanelDragWindowMousePressed

    private void jPanelServerStatusMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelServerStatusMousePressed
        // Set background color for server status panel
        if (jPanelServerStatus.getBackground() == Color.red) {
            jPanelServerStatus.setBackground(Color.green);
            int port = Integer.parseInt(jTextFieldPort.getText());
            startServer(port);
        } else {
            jPanelServerStatus.setBackground(Color.red);
            stopServer();
        }

        // Set text for server status labe;
        if (jLabelServerStatus.getText().equals("OFF")) {
            jLabelServerStatus.setText("ON");
        } else {
            jLabelServerStatus.setText("OFF");
        }

    }//GEN-LAST:event_jPanelServerStatusMousePressed

    public void startServer(int port) {
        try {
            // Create server socket
            serverSocket = new ServerSocket(port);
            
            running = true;

            // Add message to log panel
            addToLogPanel("Server", "Server started!");

            waitForClient();

        } catch (IOException ex) {
            System.err.println("Couldn't listen on port " + port);
        }
    }

    public void waitForClient() {
        new Thread("Client listener") {
            @Override
            public void run() {
                try {
                    while (running) {
                        dataSocket = serverSocket.accept();
                        serverConnection.add(new ServerConnection(dataSocket));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    // Stop server
    private void stopServer() {
        try {
            // Close server socket
            serverSocket.close();

            running = false;
            
            // Add message to log panel
            addToLogPanel("Server", "Server closed!");

            // Close window
            System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(ServerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Add message to log panel
    protected static void addToLogPanel(String name, String message) {
        // Get current date
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        // Create message
        String messageToAdd = "    " + dateFormat.format(date) + "   ["
                + name + "]  :  " + message + "\n";

        // Add message to log panel
        jTextPaneLog.setText(jTextPaneLog.getText().concat(messageToAdd));
    }

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
            java.util.logging.Logger.getLogger(ServerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelServerStatus;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelCloseWindow;
    private javax.swing.JPanel jPanelDragWindow;
    private javax.swing.JPanel jPanelServerStatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldPort;
    private static javax.swing.JTextPane jTextPaneLog;
    // End of variables declaration//GEN-END:variables
}
