	package view;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

/**
 * <p>This is the login view Class that extends a Jframe</p>
 * @author Marlon
 */
public class Login extends JFrame {
	private JTextField usernametxtf;
	private JTextField passwordtxtf;
	private JButton loginbtn;
	public Login() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setForeground(Color.LIGHT_GRAY);
		getContentPane().setForeground(Color.RED);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/images/youtube-logo.png")));
		lblNewLabel.setBounds(0, 0, 611, 145);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Youtube Trending Video Statistics");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(137, 197, 349, 50);
		getContentPane().add(lblNewLabel_1);
		
		usernametxtf = new JTextField();
		usernametxtf.setBounds(302, 289, 86, 20);
		getContentPane().add(usernametxtf);
		usernametxtf.setColumns(10);
		
		passwordtxtf = new JTextField();
		passwordtxtf.setBounds(302, 320, 86, 20);
		getContentPane().add(passwordtxtf);
		passwordtxtf.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(209, 290, 61, 17);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(209, 322, 61, 14);
		getContentPane().add(lblNewLabel_3);
		
		loginbtn = new JButton("Login");
		loginbtn.setBackground(Color.WHITE);
		loginbtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		loginbtn.setBounds(253, 370, 108, 37);
		getContentPane().add(loginbtn);
		
		this.setSize(611, 500);
		
		this.setVisible(true);
		
		this.setResizable(false);
	}
	/**
	 * <p>This method returns the user name text box</p>
	 * @author Marlon
	 * @return JTextField
	 */
	public JTextField getUsernametxtf() {
		return usernametxtf;
	}
	
	/**
	 * <p>This method returns the user password text box</p>
	 * @author Marlon
	 * @return JTextField
	 */
	public JTextField getPasswordtxtf() {
		return passwordtxtf;
	}
	
	/**
	 * <p>This method returns the login btn</p>
	 * @author Marlon
	 * @return JButton
	 */
	public JButton getLoginBtn() {
		return loginbtn;
	}
	
	
}
