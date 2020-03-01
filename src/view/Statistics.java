package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * <p>This is the statistics view Class that extends a Jframe</p>
 * @author Marlon
 */
public class Statistics extends JFrame {
	
	private JTable youtubeTD;
	private String[] columnNames = {"Video ID", "Trending", "Title", "Channel Title", "Publish Time", "Views", "Likes", "Dislikes", "Comments"};
	private Object[][] data = new Object[][]{};
	
	private JTextField searchtxtf;
	
	private DefaultTableModel model;
	
	private JComboBox<String[]> sortbycb;
	private JTextField maxTotal;
	private JTextField minTotal;
	private JTextField medTotal;
	private JButton maxbtn;
	private JButton minbtn;
	private JButton medbtn;
	
	/**
	 * <p>This is the statistics view constructor that extends a Jframe</p>
	 * @author Marlon
	 */
	public Statistics() {
		
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 884, 145);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Statistics.class.getResource("/images/youtube-logo.png")));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Search");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(44, 196, 103, 25);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblSearchBy = new JLabel("Find by");
		lblSearchBy.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSearchBy.setBounds(44, 271, 103, 25);
		getContentPane().add(lblSearchBy);
		
		JLabel lblFind = new JLabel("Video Interactions Total");
		lblFind.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFind.setBounds(44, 379, 250, 25);
		getContentPane().add(lblFind);
		
		searchtxtf = new JTextField();
		searchtxtf.setBounds(44, 232, 241, 28);
		getContentPane().add(searchtxtf);
		searchtxtf.setColumns(10);
		
		String[] petStrings = {"----", 	"Most views", "Most likes", "Most dislikes", "Most comments", "Longest title" };
		sortbycb = new JComboBox(petStrings);
		sortbycb.setSelectedIndex(0);
		sortbycb.setBounds(44, 307, 241, 25);
		getContentPane().add(sortbycb);
		
		maxbtn = new JButton("Max");
		maxbtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		maxbtn.setBounds(44, 419, 141, 41);
		getContentPane().add(maxbtn);
		
		minbtn = new JButton("Min");
		minbtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		minbtn.setBounds(44, 471, 141, 41);
		getContentPane().add(minbtn);
		
		medbtn = new JButton("Med");
		medbtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		medbtn.setBounds(44, 523, 141, 41);
		getContentPane().add(medbtn);
		
		this.youtubeTD = new JTable();
		youtubeTD.setModel( new DefaultTableModel(data,  columnNames));
		
		JScrollPane scrollPane = new JScrollPane(youtubeTD);
		youtubeTD.setFillsViewportHeight(true);
		youtubeTD.setEnabled(false);
		youtubeTD.setDragEnabled(false);
		scrollPane.setBounds(355, 232, 506, 418);
		
		getContentPane().add(scrollPane);
		
		maxTotal = new JTextField();
		maxTotal.setHorizontalAlignment(SwingConstants.CENTER);
		maxTotal.setFont(new Font("Tahoma", Font.PLAIN, 17));
		maxTotal.setBounds(195, 417, 99, 41);
		getContentPane().add(maxTotal);
		maxTotal.setColumns(10);
		
		minTotal = new JTextField();
		minTotal.setHorizontalAlignment(SwingConstants.CENTER);
		minTotal.setFont(new Font("Tahoma", Font.PLAIN, 17));
		minTotal.setColumns(10);
		minTotal.setBounds(195, 469, 99, 41);
		getContentPane().add(minTotal);
		
		medTotal = new JTextField();
		medTotal.setHorizontalAlignment(SwingConstants.CENTER);
		medTotal.setFont(new Font("Tahoma", Font.PLAIN, 17));
		medTotal.setColumns(10);
		medTotal.setBounds(195, 521, 99, 41);
		getContentPane().add(medTotal);
		
		//set visible
		this.setVisible(true);
		
		//cannot be resize
		this.setResizable(false);
		
		// title
		this.setTitle("Dashboard");
		
		// window size
		this.setSize(900, 800);
		
		System.out.println(youtubeTD.getModel().getRowCount());
		
	}
	
	/**
	 * <p>This method populates a Jtable when an array of data is given</p>
	 * @author Marlon
	 * @param ArrayList<String> dataArraylist
	 * @return void
	 */
	public void populateTable(ArrayList<String> dataArraylist)
	{
		for(String line: dataArraylist)
		{
			StringTokenizer tokenizer = new StringTokenizer(line, ","); 
			
			String video_id = tokenizer.nextToken();
			String trending_date = tokenizer.nextToken();
			String title = tokenizer.nextToken();
			String channel_title = tokenizer.nextToken();
			String publish_time = tokenizer.nextToken();
			String views = tokenizer.nextToken();
			String likes = tokenizer.nextToken();
			String dislikes = tokenizer.nextToken();
			String comment_count = tokenizer.nextToken();
			
			Object[] row = {video_id, trending_date, title, channel_title, publish_time, views, likes, dislikes, comment_count};
			
			//creates the model
			model = (DefaultTableModel) this.youtubeTD.getModel();
			
			// add the row that was parsed form the array list
			model.addRow(row);
		}
	}
	
	/**
	 * <p>This is the statistics view Class that extends a Jframe</p>
	 * @author Marlon
	 * @return String search
	 */
	public String getSearchField() {
		String search = searchtxtf.getText();
		return search;
	}
	
	/**
	 * <p>This method filters the the Jtable depending on the query</p>
	 * @author Marlon
	 * @param String query 
	 * @return void
	 */
	public void filter(String query) {
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
		youtubeTD.setRowSorter(tr);
		tr.setRowFilter(RowFilter.regexFilter(query));
	}
	
	/**
	 * <p>This method returns the search textbox </p>
	 * @author Marlon
	 * @return JTextField
	 */
	public JTextField getSearchTB() {
		return searchtxtf;
	}
	
	/**
	 * <p>This method returns the search combo box text box </p>
	 * @author Marlon
	 * @return String
	 */
	public String getComboBoxText() {
		String text = sortbycb.getSelectedItem().toString();
		System.out.println(text);
		return text;
	}
	
	/**
	 * <p>This method gets the maximum number of array list </p>
	 * @author Marlon
	 * @param int number
	 * @return int
	 */
	public int getMax(int number) {
		
		//gets column
		ArrayList list = this.getColumnList(number);
		
		int max = 0;
		
		for(int i=0; i<list.size();i++) {
			int current = Integer.parseInt((String) (list.get(i)));
			if(current > max) {
				max = current;		
			}
		}
		
		return max;
	}
	
	/**
	 * <p>This method gets the minimum number of array list</p>
	 * @author Marlon
	 * @param int number
	 * @return int
	 */
	public int getMin(int number) {
		
		//gets column
		ArrayList list = this.getColumnList(number);
	
		int min = Integer.parseInt((String) (list.get(0)));
		
		for(int i=0; i<list.size();i++) {
			int current = Integer.parseInt((String) (list.get(i)));
			if(current < min) {
				min = current;		
			}
		}
		
		return min;
	}
	
	/**
	 * <p>This method gets the media number of an array</p>
	 * @author Marlon
	 * @return void
	 */
	public int getMed() {
		ArrayList views = this.getColumnList(5);
		ArrayList likes = this.getColumnList(6);
		ArrayList dislikes = this.getColumnList(7);
		ArrayList comments = this.getColumnList(8);
		
		ArrayList<Integer> totals = new ArrayList<Integer>();
		
		int rowTotal = 0;
		int view = 0;
		int like= 0;
		int dislike = 0;
		int comment = 0;
		
		for(int i = 0; i < views.size(); i++ ) {
			view = Integer.parseInt((String) views.get(i));
			like = Integer.parseInt((String) likes.get(i));
			dislike = Integer.parseInt((String) dislikes.get(i));
			comment = Integer.parseInt((String) comments.get(i));
			rowTotal = view + like + dislike + comment;
			totals.add(rowTotal);
		}
		
		Collections.sort(totals);
		
		int middle = totals.size()/2;
        if (totals.size()%2 == 1) {
        	middle = (totals.get(totals.size()/2) + totals.get(totals.size()/2 - 1))/2;
        } else {
            middle = totals.get(totals.size() / 2);
        }
        
//        JTextField medTextField = getMedField();
        
//        medTextField.setText(Integer.toString(middle));
        
        return middle;
	}
	
	/**
	 * <p>This method returns a column list of a Jtable based on the position</p>
	 * @author Marlon
	 * @return void
	 * @param int position
	 */
	public ArrayList getColumnList(int position) {
		ArrayList list = new ArrayList();
		for(int i = 0;i<youtubeTD.getModel().getRowCount();i++) {
			list.add(youtubeTD.getModel().getValueAt(i,position)); //get the all row values at column index 0
		}
		
		return list;
	}
	
	/**
	 * <p>This method finds the longest string title of an array list</p>
	 * @author Marlon
	 * @return String title
	 */
	public String findLongestTitle() {
		
		//gets column
		ArrayList<String> list = this.getColumnList(2);
		System.out.println(list);
		for(int i = 0; i < list.size(); i++) {
			int maxLength = 0;
		      String longestString = null;
		      for (String s : list) {
		          if (s.length() > maxLength) {
		              maxLength = s.length();
		              longestString = s;
		          }
		      }
		      return longestString;
		}
		
		String title = "";
		
		return title;
	}
	
	/**
	 * <p>This method returns the sum of all the video interaction of a video, these are: views, likes, dislikes, comments</p>
	 * @author Marlon
	 * @return int total
	 * @param String type
	 */
	public int videoInteractions(String type) {
		// number: 
		// 5 => views
		// 6 => likes 
		// 7 => dislikes
		// 8 => comments
		JComboBox<String[]> comboBox = getComboBox();
		int size = comboBox.getItemCount();
		int total = 0;
		
		if(type.equals("max")) {
			for(int i = 5; i < size; i++ ) {
				total += getMax(i);
			}
		} else if(type.equals("min")) {
			for(int i = 5; i < size; i++ ) {
				total += getMin(i);
			}
		} else if(type.equals("med")) {
			total = getMed();
		}
		 System.out.println(total);
		return total;
	}
	
	/**
	 * <p>This method returns the combo box </p>
	 * @author Marlon
	 * @return JComboBox<String[]> sortbycb
	 */
	public JComboBox<String[]> getComboBox() {
		return sortbycb;
	}

	/**
	 * <p>This method returns the max button </p>
	 * @author Marlon
	 * @return JButton maxbtn
	 */
	public JButton getMaxBtn() {
		return maxbtn;
	}
	
	/**
	 * <p>This method returns the min button </p>
	 * @author Marlon
	 * @return JButton minbtn
	 */
	public JButton getMinBtn() {
		return minbtn;
	}
	
	/**
	 * <p>This method returns the med button </p>
	 * @author Marlon
	 * @return JButton medbtn
	 */
	public JButton getMedBtn() {
		return medbtn;
	}
	
	/**
	 * <p>This method returns the max field text box</p>
	 * @author Marlon
	 * @return JTextField maxTotal
	 */
	public JTextField getMaxField() {
		return maxTotal;
	}
	
	/**
	 * <p>This method returns the min field text box</p>
	 * @author Marlon
	 * @return JTextField minTotal
	 */
	public JTextField getMinField() {
		return minTotal;
	}
	
	/**
	 * <p>This method returns the med field text box</p>
	 * @author Marlon
	 * @return JTextField medTotal
	 */
	public JTextField getMedField() {
		return medTotal;
	}
}
