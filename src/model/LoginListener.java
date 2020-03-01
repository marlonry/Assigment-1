package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import controller.LoginController;
import controller.StatisticsController;
import view.Login;
import view.Statistics;

/**
 * <p>Login Listener Class that implements an action listener method</p>
 * @author Marlon
 */
public class LoginListener implements ActionListener {
	private Login loginView;
	private LoginController loginController;
	
	/**
	 * <p>Login Listener Class Constructor</p>
	 * @author Marlon
	 * @param Login loginView,LoginController loginController
	 */
	public LoginListener(Login loginView,LoginController loginController)
	{
		this.loginView = loginView;
		this.loginController = loginController;
	}
	
	/**
	 * <p>Action perform hook that acts on an event</p>
	 * @author Marlon
	 * @param ActionEvent e
	 * @return void
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == loginView.getLoginBtn()) {
				String controllerUsername= loginController.getUsername(); 
				String viewUsername = loginView.getUsernametxtf().getText();
						
				String controllerPassword = loginController.getPassword();
				String viewPassword = loginView.getPasswordtxtf().getText();
				
				System.out.println("works");
//				System.out.println(controllerUsername);
//				System.out.println(viewUsername);
//				System.out.println(controllerPassword);
//				System.out.println(viewPassword);
				
				if((controllerUsername.equals(viewUsername)) && (controllerPassword.equals(viewPassword))) {
					System.out.println("Access Granted");
					// creates view for statistics panel
					Statistics statisticsView = new Statistics();
					// creates controller for the statistics panel
					StatisticsController statisticsController = new StatisticsController();
					
					// user the statistics controller method readData to read the data from the file, returns data
					ArrayList<String> statisticsDataArraylist;
					try {
						statisticsDataArraylist = statisticsController.readData();
						// populates the table with the data array list
						statisticsView.populateTable(statisticsDataArraylist);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					
					// statistics listener
					StatisticsListener statisticsListener = new StatisticsListener(statisticsView, statisticsController);
					
					//hooks event for search
					JTextField searchTB = statisticsView.getSearchTB();
					
					searchTB.addKeyListener(statisticsListener);
					
					// set statistics window visibility to true to display the window
					statisticsView.setVisible(true);
					loginView.setVisible(false);
					
					statisticsView.getComboBoxText();
					
					// Combo box listener
					ComboBoxListener comboBoxListener = new ComboBoxListener(statisticsView);
					
					JComboBox<String[]> comboBox = statisticsView.getComboBox();
					JButton maxBtn = statisticsView.getMaxBtn();
					JButton minBtn = statisticsView.getMinBtn();
					JButton medBtn = statisticsView.getMedBtn();
					
					comboBox.addActionListener(comboBoxListener);
					maxBtn.addActionListener(comboBoxListener);
					minBtn.addActionListener(comboBoxListener);
					medBtn.addActionListener(comboBoxListener);
					
					
//					statisticsView.getMed();
				} else {
					System.out.println("Incorrect Password");
				}
		}
	}
}

