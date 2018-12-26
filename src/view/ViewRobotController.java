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
        JOptionPane.showMessageDialog(this,
                "Guide d'utilisation.\n" +
                        "1) Principe d'utilisation.\n" +
                        "* Pour manipuler le robot, entrez une commande et cliquer sur le bouton \"Fetch\".\n" +
                        "2) Installation de base.\n" +
                        "* Pour configurer simplement l’environnement 3D, lancer la commande auto. Vous pouvez utiliser la souris pour vous déplacer dans l’environnement 3D.\n" +
                        "3) Manipulations de base.\n" +
                        "* Pour lancer l'animation, utilisez la commande \"animation\".\n" +
                        "* Pour positionner l'organe terminal sur un point particulier utiliser la commande \"reach\" suivi des trois coordonnées x, y, z\n Exemple : reach 0.2 0.3 0.4\n" +
                        "* Pour déplacer l'organe terminal vers un autre point en suivant une trajectoire linéaire utilisez la commande \"go\".\n Exemple : go 0.3 0.3 0.2\n" +
                        "4) Commandes avancées\n" +
                        "* Pour afficher les matrices de transformations utilisez la commande \"matrix\"\n" +
                        "* Pour tester le débattement des articulations utilisez la commande \"test\" suivi du numéro d'articulation à tester. Ou rien si vous voulez les tester toutes.\n" +
                        "* Pour changer le pas de traitement du robot utiliser la commande \"step\" suivi de la valeur à affecter.\n Exemple : step 0.01\n" +
                        "* Pour connaitre l'emplacement actuel de l’organe terminal utiliser la commande \"where\".\n"
        );
    }

    public void setActionEvent(ActionListener listener) {
        button.addActionListener(listener);
    }

    public String purgeInputText() {

        String text = inputTextField.getText();

        inputTextField.setText("");

        return text;
    }

    public void addTextInConsole(String text) {
        outTextArea.append(text + '\n');
        autoScroller.release();
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

            while (!isInterrupted()) {

                pause();

                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                viewRobotController.jScrollDown();
            }
        }


        public void pause() {
            synchronized (this) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void release() {
            synchronized (this) {
                this.notify();
            }
        }
    }
}
