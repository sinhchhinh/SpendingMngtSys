import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

public class CalendarDate extends JPanel
{
	private ArrayList<Integer> years = new ArrayList<Integer>();
	private Calendar  calendarInstance = Calendar.getInstance();
	private int curMonth;
	private int curYear;
	private String [] month = { "January", "February", "March", "April", "May", "June", "July", "August","September", "October", "November", "December" };

	private JLabel lblYear;
	private JLabel lblDay;
	private JLabel lblMonth;
	private JTable calendarTable;
	private JList <String>listOfMonths;
	private JComboBox <Object> comboBox;
	private JScrollPane scrollPane;
	private CalendarModel model;

	
	public CalendarDate()
	{
		initCalendarUI();	
	}
		
	/**
	 * Create the UI for Calendar
	 */
	public void initCalendarUI()
	{
		curYear = calendarInstance.get(Calendar.YEAR);
		curMonth = calendarInstance.get(Calendar.MONTH);
		 
		genYear();
		setBorder(new LineBorder(new Color(192,192,192), 1, true));
		setBackground(new Color(220,220,220));
		setBounds(380, 60, 340, 320);

		
		JLabel lblCalendar = new JLabel("Date of Phurcase: ");
		lblCalendar.setFont(new Font("American Typewriter", Font.PLAIN, 13));
		lblCalendar.setBounds(40, 10, 252, 16);
		add(lblCalendar);
		
		lblDay = new JLabel("DAY");
		lblDay.setFont(new Font("American Typewriter", Font.PLAIN, 13));
		lblDay.setBounds(10, 40, 100, 16);
		add(lblDay);

		lblMonth = new JLabel("MONTH");
		lblMonth.setFont(new Font("American Typewriter", Font.PLAIN, 13));
		lblMonth.setBounds(70, 40, 100, 16);
		add(lblMonth);
		
		lblYear = new JLabel(String.valueOf("Need Change"));
		lblYear.setFont(new Font("American Typewriter", Font.PLAIN, 13));
		lblYear.setBounds(150, 40, 50, 16);
		add(lblYear);
		
		/**
		 * Create the comboBox component
		 */
		int idx = searchYear(curYear);
		comboBox = new JComboBox<Object> (years.toArray());		
		comboBox.setSelectedIndex(idx);
		comboBox.setOpaque(true);
		comboBox.setLayout(null);
		comboBox.setBounds(150, 70, 50, 30);
		comboBox.addItemListener(new ComboHandler());
		add(comboBox);
			
		
	   /**
	    * Create the JList and put it in JScrollPane and create the JTable
	    */
		listOfMonths = new JList<String>(month);
		listOfMonths.setSelectedIndex(curMonth);
		listOfMonths.addListSelectionListener(new ListHandler());		
		
		scrollPane = new JScrollPane(listOfMonths);
		scrollPane.setBounds(50, 70, 100, 100);
		add(scrollPane);

		model = new CalendarModel();
		model.setMonth(curYear, curMonth);
		calendarTable = new JTable(model);
		calendarTable.setBounds(0,180,340,250);
		calendarTable.setShowGrid(true);
		calendarTable.setGridColor(Color.GRAY);
		add(calendarTable);				
	}
	
	/**
	 * Generate the year from 1990 to 4990
	 */
	public void genYear()
	{
		int startYear = 1990;
		for (int i = 0; i < 3000; i++)
		{
			years.add(startYear);
			startYear++;
		}
	}
	
	/**
	 * Search for current Year
	 */
	public int searchYear(int year)
	{
		int startIdx = 0;
		int endIdx = years.size()-1;
		int midIdx = (endIdx - startIdx)/2;
		int gapBtwYear = 0;
	
		if (year <= years.get(endIdx))
		{
			if (years.get(midIdx) == year)
			{
				return midIdx;
			}
			else
			{
				if (years.get(midIdx) > year)
				{
					gapBtwYear = years.get(midIdx) - year;
					return midIdx - gapBtwYear;
				}
				else
				{
					gapBtwYear = year - years.get(midIdx);
					return midIdx + gapBtwYear;
				}
			}
		}
		
			return curYear;		
	}
	
	
	public class CalendarModel extends AbstractTableModel
	{
		private int[] numOfDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String [] day = {"SUN", "MON", "TUE", "WED","THU", "FRI", "SAT" };
		String [][] calendar = new String [7][7];
	
	
		public CalendarModel()
		{
			/**
			 * Initialize the position of day
			 */
			for (int i = 0; i < 7; i++)
			{
				calendar[0][i] = day[i];
			}
			for (int i = 1; i < 7; ++i)
			{
				for (int j = 0; j < 7; ++j)
				{
			        calendar[i][j] = " ";
				}
			}
			   
			
		}
		
		@Override
		public int getRowCount() {
			return 7;
		}

		@Override
		public int getColumnCount() {
			return 7;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return calendar[rowIndex][columnIndex];
		}
		
		public void setMonth (int year, int month)
		{
			 for (int i = 1; i < 7; ++i)
			 {
				 for (int j = 0; j < 7; ++j)
				 {
				        calendar[i][j] = " "; 
				 }
			 }
			      	 
			java.util.GregorianCalendar cal = new java.util.GregorianCalendar();
			cal.set(year, month, 1);
			int offset = cal.get(java.util.GregorianCalendar.DAY_OF_WEEK) - 1 ;
			offset += 7;
			int num = daysInMonth(year, month);
			for (int i = 0; i < num ; ++i)
			{
				calendar[offset/ 7] [offset % 7] = Integer.toString(i +1);
				++offset;
			}
		}
		
		public boolean isLeapYear(int year)
		{
			if (year % 4 == 0)
			{
				return true;
			}
			return false;
		}
		
		/**
		 * add One more day on February if it is a Leap year
		 */	
		public int daysInMonth(int year, int month)
		{
			int days = numOfDay [month];
			if (month == 1 && isLeapYear(year))
				++days;
				return days;	
		}		
	}
	
	
	public class ListHandler implements ListSelectionListener
	{
		@Override
		public void valueChanged(ListSelectionEvent e) 
		{
			model.setMonth(years.get(comboBox.getSelectedIndex()), listOfMonths.getSelectedIndex());
			calendarTable.repaint();		
		}		
	}
	
	public class ComboHandler implements ItemListener 
	{
	    public void itemStateChanged(ItemEvent e)
	    {
	    	model.setMonth(years.get(comboBox.getSelectedIndex()) , listOfMonths.getSelectedIndex());
	    	calendarTable.repaint();
	    }
	 }
}

