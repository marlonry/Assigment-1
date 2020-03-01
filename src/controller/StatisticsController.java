package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * <p>This is the Statistics Controller</p>
 * @author Marlon
 */
public class StatisticsController {
	private final String FILE_LOCATION = "data/videos.csv";
	
	/**
	 * <p>Reads Data From an specific file path given</p>
	 * @author Marlon
	 * @return ArrayList<String>
	 */
	public ArrayList<String> readData() throws FileNotFoundException
	{
		// creates array list to story future data coming from the buffered reader
		ArrayList<String> ArrayOfString = new ArrayList<String>();
		String line = "";  
		
		// creates the buffer reader
		BufferedReader Reader = new BufferedReader(new FileReader(FILE_LOCATION));
			
			try {
				// reads first line
				line = Reader.readLine();
				
				// runs loop to read all data from the buffer reader
				while( line!= null )
				{
//					System.out.println(line);
					ArrayOfString.add(line);
					line = Reader.readLine(); // read next row
				}
				
				// closes reader to avoid data leaks
				Reader.close();
			
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		return ArrayOfString;
	}
}
