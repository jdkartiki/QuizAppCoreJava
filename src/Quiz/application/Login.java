package Quiz.application;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
    // Constructor
	JButton rules,back;
    JTextField tfname;
    Login() {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        JLabel image = new JLabel(i1); // Corrected JLabel instantiation
        image.setBounds(0, 0, 600, 500);
        add(image);
       
        JLabel heading = new JLabel("Simple Minds");
        heading.setBounds(750, 60, 300, 45);
        heading.setFont(new Font("Calibri Light", Font.BOLD,40));
        heading.setForeground(new Color(169,50,38));
        add(heading);
        
        JLabel name = new JLabel("Enter your name");
        name.setBounds(810, 150, 300, 20);
        name.setFont(new Font("Times New Roman", Font.BOLD,18));
        name.setForeground(new Color(77,86,86));
        add(name);
        
        tfname = new JTextField();
        tfname.setBounds(735, 200, 300, 25);
        tfname.setFont(new Font("Times New Roman", Font.BOLD,20));
        add(tfname);
        
        rules=new JButton("Rules");
        rules.setBounds(735, 270, 120, 25);
        rules.setBackground(new Color(30,144,254));
        rules.setForeground(Color.YELLOW);
        rules.addActionListener(this);
        add(rules);
        
        back=new JButton("Back");
        back.setBounds(915, 270, 120, 25);
        back.setBackground(new Color(30,144,254));
        back.setForeground(Color.YELLOW);
        back.addActionListener(this);
        add(back);

        setSize(1200, 500);
        setLocation(200, 150);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
    	if(ae.getSource()== rules) {
    		String name= tfname.getText();
    		new Rules(name);
    	}else if(ae.getSource()==back){
    		setVisible(false);
    		
    	}
    }

    public static void main(String[] args) {
        new Login();
    }
}