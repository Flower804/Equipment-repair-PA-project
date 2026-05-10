package view;

import java.awt.*;
import javax.swing.*;

import database.SQLconnect;

/**
 *@author Flower 
 *A login page where the user can insert their email and password for 
 *comparisson with the database to execute a loggin
 */ 

public class LoginFrame extends JFrame{
  private SQLconnect db = new SQLconnect();
  
  private JTextField temail;
  private JPasswordField tpassword;

  private JButton buttonlog;
  private JButton buttoncancel;

  public LoginFrame() {
    setTitle("login");

    JPanel p1 = new JPanel();

    p1.setLayout(new GridLayout(4, 2));
    FlowLayout layout = new FlowLayout();

    JPanel p2 = new JPanel();

    p2.setLayout(layout);

    JLabel one, two;

    one = new JLabel("email");

    temail = new JTextField(20);

    two = new JLabel("password");

    tpassword = new JPasswordField(20);

    buttonlog = new JButton("Log in");

    buttoncancel = new JButton("Cancel");

    p1.add(one);
    p1.add(temail);
    p1.add(two);
    p1.add(tpassword);
    p2.add(buttonlog);
    p2.add(buttoncancel);

    add(p1, "North");
    add(p2, "South");

    setVisible(true);
    this.setSize(400, 180);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
    //TODO: register Listeners
    buttonlog.addActionListener(new ActionListener(){
      //TODO: finish this
    });

  }
}
