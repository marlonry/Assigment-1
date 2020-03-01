package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import view.Statistics;

/**
 * <p>ComboBox Class that implement an action listener hook</p>
 * @author Marlon
 */
public class ComboBoxListener implements ActionListener  {
	private Statistics statisticsView;
	
	public ComboBoxListener(Statistics statisticsView) {
		this.statisticsView = statisticsView;
	}

	/**
	 * <p>Login Listener Class that implements an action listener method</p>
	 * @author Marlon
	 * @param ActionEvent e
	 * @return void
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// all values initialization
		int value = 0;
		
		System.out.println("HELLO THIS WORKS ----------------------");
		String Text = statisticsView.getComboBoxText();
		int max = 0;
		String title = "";
		
		// depending on the text displayed it runs a different function that will be stored on the max value
		if(Text.equals("Most views")) {
			// number: 
			// 5 => views
			// 6 => likes 
			// 7 => dislikes
			// 8 => comments
			max = statisticsView.getMax(5);
		} else if(Text.equals("Most likes")) {
			max = statisticsView.getMax(6);
		} else if(Text.equals("Most dislikes")) {
			max = statisticsView.getMax(7);
		} else if(Text.equals("Most comments")) {
			max = statisticsView.getMax(8);
		} else if(Text.equals("Longest title")) {
			title = statisticsView.findLongestTitle();
			statisticsView.filter(title);
			return;
		}
		
		// filters the data on the search bar
		statisticsView.filter(Integer.toString(max));
	
		// depending on which button it will run a different method and then it will store the value on the value attribute
		if(e.getSource() == statisticsView.getMaxBtn()) {
			System.out.println("MAX");
			value = statisticsView.videoInteractions("max");
			JTextField maxField = statisticsView.getMaxField();
			maxField.setText(Integer.toString(value));
		} else if(e.getSource() == statisticsView.getMinBtn()) {
			System.out.println("MIN");
			value = statisticsView.videoInteractions("min");
			statisticsView.getMinField().setText(Integer.toString(value));
		} else if(e.getSource() == statisticsView.getMedBtn()) {
			System.out.println("MED");
			value = statisticsView.videoInteractions("med");
			JTextField medTextField = statisticsView.getMedField();
			medTextField.setText(Integer.toString(value));
		}
	}
}
