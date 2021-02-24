/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




package com.methority.equbox2;
 
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
 
/**
 * This program demonstrates how to use JPanel in Swing.
 * @author www.codejava.net
 */
public class MainClass extends JFrame {
     
    private JLabel labelUsername = new JLabel("Register 1: ");
    private JLabel labelPassword = new JLabel("Register 2: ");
    private JLabel labelPassword2 = new JLabel("Register 3: ");
    private JLabel labelPassword3 = new JLabel("Register 4: ");
    private JLabel labelPassword4 = new JLabel("Equation 1: ");
    private JLabel labelPassword5 = new JLabel("Equation 2: ");
    private JLabel labelPassword6 = new JLabel("Equation 3: ");

    private JTextField eq1 = new JTextField(20);
    private JTextField eq2 = new JTextField(20);
    private JTextField eq3 = new JTextField(20);
    private JTextField eq4 = new JTextField(20);
    private JTextField eq5 = new JTextField(20);
    private JTextField eq6 = new JTextField(20);
    private JTextField eq7 = new JTextField(20);

    private JTextField act1 = new JTextField(5);
    private JTextField act2 = new JTextField(5);
    private JTextField act3 = new JTextField(5);
    private JTextField act4 = new JTextField(5);
    private JTextField act5 = new JTextField(5);
    private JTextField act6 = new JTextField(5);
    private JTextField act7 = new JTextField(5);

    private JButton buttonLogin = new JButton("Do it!");
    
    private JScrollPane log = new JScrollPane();
    
    public MainClass() {
        super("JPanel Demo Program");
         
        // create a new panel with GridBagLayout manager
        JPanel newPanel = new JPanel(new GridBagLayout());
         
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
         
        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;     
        newPanel.add(labelUsername, constraints);
 
        constraints.gridx = 1;
        newPanel.add(eq1, constraints);
         
        constraints.gridx = 0;
        constraints.gridy = 1;     
        newPanel.add(labelPassword, constraints);
    
        constraints.gridy = 2;     
        newPanel.add(labelPassword2, constraints);
        constraints.gridy = 3;     
        newPanel.add(labelPassword3, constraints);
        constraints.gridy = 4;     
        newPanel.add(labelPassword4, constraints);
        constraints.gridy = 5;     
        newPanel.add(labelPassword5, constraints);
        constraints.gridy = 6;     
        newPanel.add(labelPassword6, constraints);
        
        
        
        
        constraints.gridy = 1;             
        constraints.gridx = 1;
        newPanel.add(eq2, constraints);

        // Label
             
        
        constraints.gridx = 1;
        constraints.gridy = 2;     
        newPanel.add(eq3, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;     
        newPanel.add(eq4, constraints);

        constraints.gridx = 1;
        constraints.gridy = 4;     
        newPanel.add(eq5, constraints);

        constraints.gridx = 1;
        constraints.gridy = 5;     
        newPanel.add(eq6, constraints);

        constraints.gridx = 1;
        constraints.gridy = 6;     
        newPanel.add(eq7, constraints);

        //=====================================================


        constraints.gridx = 2;
        constraints.gridy = 0;     
        newPanel.add(act1, constraints);

        constraints.gridx = 2;
        constraints.gridy = 1;     
        newPanel.add(act2, constraints);

        constraints.gridx = 2;
        constraints.gridy = 2;     
        newPanel.add(act3, constraints);



        constraints.gridx = 2;
        constraints.gridy = 3;     
        newPanel.add(act4, constraints);

        constraints.gridx = 2;
        constraints.gridy = 4;     
        newPanel.add(act5, constraints);

        constraints.gridx = 2;
        constraints.gridy = 5;     
        newPanel.add(act6, constraints);

        constraints.gridx = 2;
        constraints.gridy = 6;     
        newPanel.add(act7, constraints);

        //=====================================================

        getRootPane().setDefaultButton(buttonLogin);
        
        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        newPanel.add(buttonLogin, constraints);
         
        //constraints.gridx = 0;
        //constraints.gridy = 4;
        //log.setBounds(50, 150, 40, 40);
        //log.setVisible(true);
        //newPanel.add(log, constraints);
        //newPanel.add(log);
        
        
        // set border for the panel
        newPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Login Panel"));
         
        // add the panel to this frame
        add(newPanel);
         
        pack();
        setLocationRelativeTo(null);

        buttonLogin.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
        // display/center the jdialog when the button is pressed
                //JDialog d = new JDialog(frame, "Hello", true);
                //d.setLocationRelativeTo(frame);
                //d.setVisible(true);
                int x = 1;
               
                
                Equation equ1 = new Equation();
                
                String text1 = eq1.getText();
                String op1 = act1.getText();
                
               
                String out1 = equ1.Do(text1, op1);
                if (out1.equals("ERR")) {
                    act1.setText("<= ERR");
                    
                } else {
                    act1.setText("");
                    if (!out1.equals(""))
                        eq1.setText(out1);
                }

                //=========================================
                //=========================================
                //=========================================
                Equation equ2 = new Equation();
                
                String text2 = eq2.getText();
                String op2 = act2.getText();
                
               
                String out2 = equ2.Do(text2, op2);
                if (out2.equals("ERR")) {
                    act2.setText("<= ERR");
                    
                } else {
                    if (op2.equals("add")) {
                        out2 = equ2.AddSub(equ1, 1);
                    }
                    if (op2.equals("sub")) {
                        out2 = equ2.AddSub(equ1, -1);
                    }
                    
                    act2.setText("");
                    if (!out2.equals(""))
                        eq2.setText(out2);
                }

             //=========================================
   
                //=========================================
                //=========================================
                Equation equ3 = new Equation();
                
                String text3 = eq3.getText();
                String op3 = act3.getText();
                
               
                String out3 = equ3.Do(text3, op3);
                if (out3.equals("ERR")) {
                    act3.setText("<= ERR");
                    
                } else {
                    if (op3.equals("add")) {
                        out3 = equ3.AddSub(equ2, 1);
                    }
                    if (op3.equals("sub")) {
                        out3 = equ3.AddSub(equ2, -1);
                    }
                    
                    act3.setText("");
                    if (!out3.equals(""))
                        eq3.setText(out3);
                }

             //=========================================
   
                Equation equ4 = new Equation();
                
                String text4 = eq4.getText();
                String op4 = act4.getText();
                
               
                String out4 = equ4.Do(text4, op4);
                if (out4.equals("ERR")) {
                    act4.setText("<= ERR");
                    
                } else {
                    if (op4.equals("add")) {
                        out4 = equ4.AddSub(equ3, 1);
                    }
                    if (op4.equals("sub")) {
                        out4 = equ4.AddSub(equ3, -1);
                    }
                    
                    act4.setText("");
                    if (!out4.equals(""))
                        eq4.setText(out4);
                }

             //=========================================


            }
        });


    }
     
    
    
    
    public static void main(String[] args) {
        // set look and feel to the system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
         
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainClass().setVisible(true);
            }
        });
    }
}


