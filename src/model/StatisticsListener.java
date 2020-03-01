package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import view.Statistics;
import controller.StatisticsController;

/**
 * <p>Statistics Listener class, This hooks the view with the controller to allow the communication of classes</p>
 * @author Marlon
 * @param KeyEvent e
 * @return void
 */
public class StatisticsListener implements KeyListener {
	private Statistics statisticsView;
	private StatisticsController statisticsController;
	
	/**
	 * <p>Statistics Listener Class Constructor</p>
	 * @param Statistics statisticsView, StatisticsController statisticsController
	 * @author Marlon
	 */
	public StatisticsListener(Statistics statisticsView, StatisticsController statisticsController) {
		this.statisticsView = statisticsView;
		this.statisticsController = statisticsController;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * <p>Key Release Listener Method</p>
	 * @author Marlon
	 * @param KeyEvent e
	 * @return void
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("key released");
		String query = statisticsView.getSearchField();
		statisticsView.filter(query);
	}
}
