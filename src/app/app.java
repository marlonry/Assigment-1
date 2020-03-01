package app;

import model.LoginListener;
import view.Login;
import view.Statistics;

import javax.swing.JButton;

import controller.LoginController;

 

/**
 * <p>This is the main method of the application</p>
 * @author Marlon
 * @param String[] args
 * @return void
 */
public class app {

	public static void main(String[] args) {
//		// Login View and Login Controller
		Login login = new Login(); 
		LoginController loginController = new LoginController();
		
		// Pass the view and the controller to the model - Listener
		LoginListener listener = new LoginListener(login,loginController); 
		
		//buttons that will be sources of event - hooks the event 
		JButton loginButton = login.getLoginBtn();
		
		//add a listener to each button
		loginButton.addActionListener(listener);
	}
}
