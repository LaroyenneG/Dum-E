package view;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ViewRobotController extends javax.swing.JFrame {

    private javax.swing.JButton button;
    private javax.swing.JMenu help;
    private javax.swing.JTextField inputTextField;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JMenuBar menu;
    private javax.swing.JTextArea outTextArea;
    private AutoScroller autoScroller;

    public ViewRobotController() {
        initComponents();
        setVisible(true);
        autoScroller = new AutoScroller(this);
        autoScroller.start();
    }

    private void initComponents() {

        inputTextField = new javax.swing.JTextField();
        button = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        outTextArea = new javax.swing.JTextArea();
        menu = new javax.swing.JMenuBar();
        help = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Robot Controller");
        setName("ViewRobotController");
        setResizable(false);

        button.setText("Fetch");
        button.setMnemonic(KeyEvent.VK_ENTER);

        outTextArea.setEditable(false);
        outTextArea.setColumns(20);
        outTextArea.setLineWrap(true);
        outTextArea.setRows(5);
        jScrollPane.setViewportView(outTextArea);

        help.setText("Help");
        help.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                helpMouseClicked(evt);
            }
        });

        menu.add(help);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 12, Short.MAX_VALUE)
                                .addComponent(inputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button)
                                .addGap(6, 6, 6))
                        .addComponent(jScrollPane)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(inputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
        );

        pack();
    }

    private synchronized void jScrollDown() {
        JScrollBar jsb = jScrollPane.getVerticalScrollBar();
        jsb.setValue(jsb.getMaximum());
    }

    private void helpMouseClicked(java.awt.event.MouseEvent evt) {
        JOptionPane.showMessageDialog(this, "Do you need help using this interface ?\n\t to see all commands enter help");
    }

    public void setActionEvent(ActionListener listener) {
        button.addActionListener(listener);
    }

    public String purgeInputText() {

        String text = inputTextField.getText();

        inputTextField.setText("");

        return text;
    }

    public synchronized void addTextInConsole(String text) {
        outTextArea.append(text + '\n');
    }

    public void disableInput() {
        button.setEnabled(false);
        inputTextField.setEnabled(false);
    }

    public void enableInput() {
        button.setEnabled(true);
        inputTextField.setEnabled(true);
    }

    private static class AutoScroller extends Thread {

        private final ViewRobotController viewRobotController;

        public AutoScroller(ViewRobotController viewRobotController) {
            this.viewRobotController = viewRobotController;
        }

        @Override
        public synchronized void run() {

            while (!interrupted()) {

                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }

                viewRobotController.jScrollDown();
            }
        }
    }
}
