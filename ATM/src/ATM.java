import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ATM extends JFrame 
{
	
	private static final long serialVersionUID = 1L;
	public JLabel jlabel;
	public JPanel buttonPanel = new JPanel();
	private JTextField item1;
	private JPasswordField passwordField;
	String correctPassword, Input="";
	int chances = 1;
	
	public ATM()
	{
		super("ATM");
		setLayout(new FlowLayout());
		
		item1 = new JTextField(4);
		add(item1);
		
		jlabel = new JLabel("Enter Pin (Pin is 1234):");
		add(jlabel);
		jlabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		passwordField = new JPasswordField("");
		add(passwordField);
		passwordField.setVisible(false);
		
		
		JPanel p = new JPanel();
		JPanel p2 = new JPanel();
		
		p.add(jlabel);
		p2.add(item1);
		
		add(p, BorderLayout.WEST);
		add(p2, BorderLayout.EAST);
		
		
		thehandler handler = new thehandler();
		item1.addActionListener(handler);
		passwordField.addActionListener(handler);
	}
	
	private class thehandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			
			if(event.getSource()==item1)
				correctPassword = item1.getText();
			
			if(Authentication.authentication(correctPassword))
			{
				JOptionPane.showMessageDialog(null, "Correct Pin");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Incorrect Pin");
				if (chances<3)
				{
					chances++;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Contact administrator to reset PIN");
					System.exit(0);
				}
			}
			
		}
	}
	
}
