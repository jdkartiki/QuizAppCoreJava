package Quiz.application;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Rules extends JFrame implements ActionListener {
	
	 String name;  //globaly declare
	 JButton start,back;
	 Rules(String name)//constructor
	 {
	    this.name=name;
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("Welcome " + name + " to Simple Minds");
        heading.setBounds(50, 20, 700, 30);
        heading.setFont(new Font("Castellar", Font.BOLD,28));
        heading.setForeground(new Color(20,90,50));
        add(heading);
        
        JLabel rules = new JLabel();
        rules.setBounds(20, 90,700, 350);
        rules.setFont(new Font("Calibri(Body)", Font.PLAIN,16));
        
        rules.setText(
        		"<html>"+
        				"1.No cell phones or other secondary devices in the room or test areat" + "<br><br>" +
        				"2.Your desk/table must be clear or any materials except your test-taking devicet" + "<br><br>" +
        				"3.No one else can be in the room with yout" + "<br><br>" +
        				"4.No talkingt" + "<br><br>" +
        				"5.The testing room must be well-lit and you must be clearly visiblet" + "<br><br>" +
        				"6.No dual screens/monitorst" + "<br><br>" +
        				"7.Do not leave the camerat" + "<br><br>" +
        				"8.No use of additional applications or internett" + "<br><br>" +
        		"<html>"

          );
        add(rules);
        
        back=new JButton("Back");
        back.setBounds(250, 500, 100, 30);
        back.setBackground(new Color(30,144,254));
        back.setForeground(Color.YELLOW);
        back.addActionListener(this);
        add(back);

        start =new JButton("Start");
        start.setBounds(400, 500, 100, 30);
        start.setBackground(new Color(30,144,254));
        start.setForeground(Color.YELLOW);
        start.addActionListener(this);
        add(start);
        
        		
        rules.setForeground(new Color(20,90,50));
        add(heading);
        
        
		setSize(800,650);
		setLocation(350,100);
		setVisible(true);
	}
	 public void actionPerformed(ActionEvent ae) {
	    	if(ae.getSource()== start) {
	    		setVisible(false);
	    		new Quiz(name);
	    		
	    	}else {
	    		setVisible(false);
	    		new Login();// object create
	    		
	    	}
	    }

	
	public static void main(String[] args) {
		new Rules("User");
	}

}
