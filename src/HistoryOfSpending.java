import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class HistoryOfSpending extends JPanel
{
	private JList <String> listOfMonth;

	private JScrollPane scrolPanelMonth;

	private Calendar  calendarInstance = Calendar.getInstance();
	
	int curMonth = calendarInstance.get(Calendar.MONTH);
	int curYear = calendarInstance.get(Calendar.YEAR);

	private String [] month = { "January", "February", "March", "April", "May", "June", "July", "August","September", "October", "November", "December" };
	
	public HistoryOfSpending()
	{
		initPastSpendingUI();
	}
	
	public void initPastSpendingUI()
	{
		
		setBorder(new LineBorder(new Color(192,192,192), 1, true));
		setBackground(new Color(240, 240, 245));
		setBounds(721, 60, 613, 670);
			
		JLabel lblHistoryTopic = new JLabel("Receipt of spending in ");
		lblHistoryTopic.setFont(new Font("American Typewriter", Font.PLAIN, 13));
		lblHistoryTopic.setBounds(36, 10, 252, 16);
		add(lblHistoryTopic);
		
		listOfMonth = new JList <String>(month);
		listOfMonth.setSelectedIndex(curMonth);
		listOfMonth.addListSelectionListener(new ListHandler());		

		scrolPanelMonth = new JScrollPane(listOfMonth);
		scrolPanelMonth.setBounds(180, 10, 100, 100);
		add(scrolPanelMonth);
	}
	
	public class ListHandler implements ListSelectionListener
	{
		@Override
		public void valueChanged(ListSelectionEvent e) 
		{
			
		}
		
	}
}
