package view;

import static org.junit.Assert.assertEquals;

import javax.swing.JButton;
import javax.swing.JTextField;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

class StatisticsTest {

	@Test // Method to be tested: getSearchField();
	void testFilter() {
		Statistics statisticsView = new Statistics();
		JTextField textField = statisticsView.getSearchTB();
		textField.setText("Lebron James");
		
		String actual = statisticsView.getSearchField();
		String expected = "Lebron James";
		
		assertEquals(expected, actual);
	}
	
	@Test // Method to be tested: getSearchField();
	void testFilter2() {
		Statistics statisticsView = new Statistics();
		JTextField textField = statisticsView.getSearchTB();
		textField.setText("1234");
		
		String actual = statisticsView.getSearchField();
		String expected = "1234";
		
		assertEquals(expected, actual);
	}
	
	@Test // Method to be tested: getMedBtn();
	void testGetMedBtn() {
		Statistics statisticsView = new Statistics();
		JButton actual = statisticsView.getMedBtn();
		
		assertEquals(statisticsView.getMedBtn(), actual);
	}
}
