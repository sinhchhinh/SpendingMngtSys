import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SpendingMngtUI {

	
	private JFrame frame;	
	private JTextField jtfGrocery;
	private JTextField jtfFuel;
	private JTextField jtfLaundry;
	private JTextField jtfEatOut;
	private JTextField jtfAirbnb;
	private JTextField jtfDrink;
	private JTextField jtfOther;
	private JTextField jtfbudgGrocery;
	private JTextField jtfbudgFuel;
	private JTextField jtfbudgLaundry;
	private JTextField jtfbudgEatOut;
	private JTextField jtfbudgAirbnb;
	private JTextField jtfbudgDrink;
	private JTextField jtfbudgOther;
	
	private JLabel lblIntTotalGrocery;
	private JLabel lblIntTotalFuel;
	private JLabel lblIntTotalLaundry;
	private JLabel lblIntTotalAirbnb;
	private JLabel lblIntTotalEatOut;
	private JLabel lblIntTotalDrink;
	private JLabel lblIntTotalOther;
	private JLabel lblRemainGrocery;
	private JLabel lblRemainFuel;
	private JLabel lblRemainLaundry;
	private JLabel lblRemainAirbnb;
	private JLabel lblRemainEatOut;
	private JLabel lblRemainDrink;
	private JLabel lblRemainOther;
	
	private Double tolValGrocery = 0.0;
	private Double tolValFuel = 0.0;
	private Double tolValLaundry = 0.0;
	private Double tolValEatOut = 0.0;
	private Double tolValAirbnb = 0.0;
	private Double tolValDrink = 0.0;
	private Double tolValOther = 0.0;
	
	private Double budgGrocery = 60.00;
	private Double budgFuel = 100.0;
	private Double budgLaundry = 40.0;
	private Double budgEatOut = 30.0;
	private Double budgAirbnb = 250.0;
	private Double budgDrink = 11.0;
	private Double budgOther = 0.0;

	private Double remainGrocery = 0.0;
	private Double remainFuel = 0.0;
	private Double remainLaundry = 0.0;
	private Double remainEatOut = 0.0;
	private Double remainAirbnb = 0.0;
	private Double remainDrink = 0.0;
	private Double remainOther = 0.0;
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					SpendingMngtUI window = new SpendingMngtUI();
					window.frame.setVisible(true);
					
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SpendingMngtUI() 
	{
		initialize();
		frame.setTitle("Spending Note");
		frame.setPreferredSize(new Dimension(2000, 2000));
		frame.pack();
		frame.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(0, 0, 1400, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(59, 24, 117, 29);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		frame.getContentPane().add(btnExit);
		
		JLabel lblNewLabel = new JLabel("Spending Managment System");
		lblNewLabel.setFont(new Font("American Typewriter", Font.PLAIN, 30));
		lblNewLabel.setBounds(380, 18, 468, 30);
		frame.getContentPane().add(lblNewLabel);
		
		/*******************************************************
		 * First Panel: Total cost of spending in each portion
		 * *****************************************************
		 */
		JPanel record_panel = new JPanel();
		record_panel.setBorder(new LineBorder(new Color(192,192,192), 1, true));
		record_panel.setBackground(new Color(225, 234, 234));
		record_panel.setBounds(59, 60, 320, 320);
		frame.getContentPane().add(record_panel);
		record_panel.setLayout(null);
		
		JLabel lblCostOf = new JLabel("Add cost of spending in any portion :");
		lblCostOf.setFont(new Font("American Typewriter", Font.PLAIN, 13));
		lblCostOf.setBounds(36, 10, 252, 16);
		record_panel.add(lblCostOf);
		
		JLabel lblGrocery = new JLabel("Grocery");
		lblGrocery.setBounds(17, 60, 61, 16);
		record_panel.add(lblGrocery);
		
		JLabel lblFuel = new JLabel("Fuel");
		lblFuel.setBounds(17, 90, 61, 16);
		record_panel.add(lblFuel);
		
		JLabel lblLaundary = new JLabel("Laundry");
		lblLaundary.setBounds(17, 120, 61, 16);
		record_panel.add(lblLaundary);
		
		JLabel lblAirbnb = new JLabel("Airbnb");
		lblAirbnb.setBounds(17,150,61,16);
		record_panel.add(lblAirbnb);
		
		JLabel lblEatOut = new JLabel("Eat Out");
		lblEatOut.setBounds(17,180,61,16);
		record_panel.add(lblEatOut);
		
		JLabel lblDrink = new JLabel("Drink");
		lblDrink.setBounds(17,210,61,16);
		record_panel.add(lblDrink);
		
		JLabel lblOther = new JLabel("Others");
		lblOther.setBounds(17,240,61,16);
		record_panel.add(lblOther);		
		
		jtfGrocery = new JTextField();
		jtfGrocery.setBounds(110, 60, 130, 26);
		jtfGrocery.setColumns(10);
		jtfGrocery.setText("0.0");
		record_panel.add(jtfGrocery);
		
		jtfFuel = new JTextField();
		jtfFuel.setColumns(10);
		jtfFuel.setText("0.0");
		jtfFuel.setBounds(110, 90, 130, 26);
		record_panel.add(jtfFuel);
		
		jtfLaundry = new JTextField();
		jtfLaundry.setColumns(10);
		jtfLaundry.setText("0.0");
		jtfLaundry.setBounds(110, 120, 130, 26);
		record_panel.add(jtfLaundry);
		
		jtfAirbnb = new JTextField();
		jtfAirbnb.setColumns(10);
		jtfAirbnb.setText("0.0");
		jtfAirbnb.setBounds(110, 150, 130, 26);
		record_panel.add(jtfAirbnb);
		
		jtfEatOut = new JTextField();
		jtfEatOut.setColumns(10);
		jtfEatOut.setText("0.0");
		jtfEatOut.setBounds(110, 180, 130, 26);
		record_panel.add(jtfEatOut);
		
		jtfDrink = new JTextField();
		jtfDrink.setColumns(10);
		jtfDrink.setText("0.0");
		jtfDrink.setBounds(110, 210, 130, 26);
		record_panel.add(jtfDrink);
		
		jtfOther = new JTextField();
		jtfOther.setColumns(10);
		jtfOther.setText("0.0");
		jtfOther.setBounds(110, 240, 130, 26);
		record_panel.add(jtfOther);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				double valGrocery = Double.parseDouble(jtfGrocery.getText());
				double valFuel =   Double.parseDouble(jtfFuel.getText());
				double valLaundry = Double.parseDouble(jtfLaundry.getText());
				double valAirbnb = Double.parseDouble(jtfAirbnb.getText());
				double valEatOut = Double.parseDouble(jtfEatOut.getText());
				double valDrink = Double.parseDouble(jtfDrink.getText());
				double valOther = Double.parseDouble(jtfOther.getText());
				
				tolValGrocery = tolValGrocery + valGrocery;
				tolValFuel = tolValFuel + valFuel;
				tolValLaundry = tolValLaundry + valLaundry;
				tolValAirbnb = tolValAirbnb + valAirbnb;
				tolValEatOut = tolValEatOut + valEatOut;
				tolValDrink = tolValDrink + valDrink;
				tolValOther = tolValOther + valOther;

				remainGrocery = budgGrocery - tolValGrocery;
				remainFuel = budgFuel - tolValFuel;
				remainLaundry = budgLaundry - tolValLaundry;
				remainAirbnb = budgAirbnb - tolValAirbnb;
				remainEatOut = budgEatOut - tolValEatOut;
				remainDrink = budgDrink - tolValDrink;
				remainOther = budgOther - tolValOther;
				
				lblIntTotalGrocery.setText(tolValGrocery.toString());
				lblIntTotalFuel.setText(tolValFuel.toString());
				lblIntTotalLaundry.setText(tolValLaundry.toString());
				lblIntTotalAirbnb.setText(tolValAirbnb.toString());
				lblIntTotalEatOut.setText(tolValEatOut.toString());
				lblIntTotalDrink.setText(tolValDrink.toString());
				lblIntTotalOther.setText(tolValOther.toString());		
				
				lblRemainGrocery.setText(remainGrocery.toString());
				lblRemainFuel.setText(remainFuel.toString());
				lblRemainLaundry.setText(remainLaundry.toString());
				lblRemainAirbnb.setText(remainAirbnb.toString());
				lblRemainEatOut.setText(remainEatOut.toString());
				lblRemainDrink.setText(remainDrink.toString());
				lblRemainOther.setText(remainOther.toString());
			}
		});
		btnSubmit.setBounds(37, 285, 117, 29);
		record_panel.add(btnSubmit);
			
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				jtfGrocery.setText("0.0");
				jtfLaundry.setText("0.0");
				jtfFuel.setText("0.0");
				jtfAirbnb.setText("0.0");
				jtfEatOut.setText("0.0");
				jtfDrink.setText("0.0");
				jtfOther.setText("0.0");
			}
		});
		btnReset.setBounds(146, 285, 117, 29);
		record_panel.add(btnReset);		
		
		/*******************************************************
		 * Second Panel: Total cost of spending in this week
		 * *****************************************************
		 */		
		JPanel spendingSum_panel = new JPanel();
		spendingSum_panel.setBorder(new LineBorder(new Color(192,192,192), 1, true));
		spendingSum_panel.setBackground(new Color(232, 211, 212));
		spendingSum_panel.setBounds(59, 380, 660, 350);
		spendingSum_panel.setLayout(null);
		frame.getContentPane().add(spendingSum_panel);

		JLabel lblTotalCostOf = new JLabel("Total cost of spending this week is:");
		lblTotalCostOf.setFont(new Font("American Typewriter", Font.PLAIN, 13));
		lblTotalCostOf.setBounds(36, 10, 252, 16);
		spendingSum_panel.add(lblTotalCostOf);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("American Typewriter", Font.PLAIN, 13));
		lblDescription.setBounds(17, 35, 250, 16);
		spendingSum_panel.add(lblDescription);
		
		JLabel lblTotalCost = new JLabel("Total");
		lblTotalCost.setFont(new Font("American Typewriter", Font.PLAIN, 13));
		lblTotalCost.setBounds(180, 35, 250, 16);
		spendingSum_panel.add(lblTotalCost);
		
		JLabel lblBudget = new JLabel("Budget");
		lblBudget.setFont(new Font("American Typewriter", Font.PLAIN, 13));
		lblBudget.setBounds(340, 35, 250, 16);
		spendingSum_panel.add(lblBudget);
		
		JLabel lblRemain = new JLabel("Remainder");
		lblRemain.setFont(new Font("American Typewriter", Font.PLAIN, 13));
		lblRemain.setBounds(500, 35, 250, 16);
		spendingSum_panel.add(lblRemain);
		
		JLabel lblTotalGrocery = new JLabel("Grocery");
		lblTotalGrocery.setBounds(17, 60, 61, 16);
		spendingSum_panel.add(lblTotalGrocery);
		
		JLabel lblTotalFuel = new JLabel("Fuel");
		lblTotalFuel.setBounds(17, 90, 61, 16);
		spendingSum_panel.add(lblTotalFuel);
		
		JLabel lblTotalLaundary = new JLabel("Laundry");
		lblTotalLaundary.setBounds(17, 120, 61, 16);
		spendingSum_panel.add(lblTotalLaundary);
		
		JLabel lblTotalAirbnb = new JLabel("Airbnb");
		lblTotalAirbnb.setBounds(17,150,61,16);
		spendingSum_panel.add(lblTotalAirbnb);
		
		JLabel lblTotalEatOut = new JLabel("Eat Out");
		lblTotalEatOut.setBounds(17,180,61,16);
		spendingSum_panel.add(lblTotalEatOut);
		
		JLabel lblTotalDrink = new JLabel("Drink");
		lblTotalDrink.setBounds(17,210,61,16);
		spendingSum_panel.add(lblTotalDrink);
		
		JLabel lblTotalOther = new JLabel("Others");
		lblTotalOther.setBounds(17,240,61,16);
		spendingSum_panel.add(lblTotalOther);	
		
		/*
		 * JLabel for Total spending in each part
		 */
		lblIntTotalGrocery = new JLabel(tolValGrocery.toString());
		lblIntTotalGrocery.setBounds(180, 60, 61, 16);
		spendingSum_panel.add(lblIntTotalGrocery);
		
		lblIntTotalFuel = new JLabel(tolValFuel.toString());
		lblIntTotalFuel.setBounds(180, 90, 61, 16);
		spendingSum_panel.add(lblIntTotalFuel);
		
		lblIntTotalLaundry = new JLabel(tolValLaundry.toString());
		lblIntTotalLaundry.setBounds(180, 120, 61, 16);
		spendingSum_panel.add(lblIntTotalLaundry);
		
		lblIntTotalAirbnb = new JLabel(tolValAirbnb.toString());
		lblIntTotalAirbnb.setBounds(180,150,61,16);
		spendingSum_panel.add(lblIntTotalAirbnb);
		
		lblIntTotalEatOut = new JLabel(tolValEatOut.toString());
		lblIntTotalEatOut.setBounds(180,180,61,16);
		spendingSum_panel.add(lblIntTotalEatOut);
		
		lblIntTotalDrink = new JLabel(tolValDrink.toString());
		lblIntTotalDrink.setBounds(180,210,61,16);
		spendingSum_panel.add(lblIntTotalDrink);
		
		lblIntTotalOther = new JLabel(tolValOther.toString());
		lblIntTotalOther.setBounds(180,240,61,16);
		spendingSum_panel.add(lblIntTotalOther);
		
		/*
		 * JLabel for Remain money in each part
		 */
		lblRemainGrocery = new JLabel(remainGrocery.toString());
		lblRemainGrocery.setBounds(500, 60, 61, 16);
		spendingSum_panel.add(lblRemainGrocery);
		
		lblRemainFuel = new JLabel(remainFuel.toString());
		lblRemainFuel.setBounds(500, 90, 61, 16);
		spendingSum_panel.add(lblRemainFuel);
		
		lblRemainLaundry = new JLabel(remainLaundry.toString());
		lblRemainLaundry.setBounds(500, 120, 61, 16);
		spendingSum_panel.add(lblRemainLaundry);
		
		lblRemainAirbnb = new JLabel(remainAirbnb.toString());
		lblRemainAirbnb.setBounds(500,150,61,16);
		spendingSum_panel.add(lblRemainAirbnb);
		
		lblRemainEatOut = new JLabel(remainEatOut.toString());
		lblRemainEatOut.setBounds(500,180,61,16);
		spendingSum_panel.add(lblRemainEatOut);
		
		lblRemainDrink = new JLabel(remainDrink.toString());
		lblRemainDrink.setBounds(500,210,61,16);
		spendingSum_panel.add(lblRemainDrink);
		
		lblRemainOther = new JLabel(remainOther.toString());
		lblRemainOther.setBounds(500,240,61,16);
		spendingSum_panel.add(lblRemainOther);				
		
		jtfbudgGrocery = new JTextField();
		jtfbudgGrocery.setBounds(300, 60, 130, 26);
		jtfbudgGrocery.setText(budgGrocery.toString());
		spendingSum_panel.add(jtfbudgGrocery);
		jtfbudgGrocery.setColumns(10);
		
		jtfbudgFuel = new JTextField();
		jtfbudgFuel.setColumns(10);
		jtfbudgFuel.setText(budgFuel.toString());
		jtfbudgFuel.setBounds(300, 90, 130, 26);
		spendingSum_panel.add(jtfbudgFuel);
		
		jtfbudgLaundry = new JTextField();
		jtfbudgLaundry.setColumns(10);
		jtfbudgLaundry.setText(budgLaundry.toString());
		jtfbudgLaundry.setBounds(300, 120, 130, 26);
		spendingSum_panel.add(jtfbudgLaundry);
		
		jtfbudgAirbnb = new JTextField();
		jtfbudgAirbnb.setColumns(10);
		jtfbudgAirbnb.setText(budgAirbnb.toString());
		jtfbudgAirbnb.setBounds(300, 150, 130, 26);
		spendingSum_panel.add(jtfbudgAirbnb);
		
		jtfbudgEatOut = new JTextField();
		jtfbudgEatOut.setColumns(10);
		jtfbudgEatOut.setText(budgEatOut.toString());
		jtfbudgEatOut.setBounds(300, 180, 130, 26);
		spendingSum_panel.add(jtfbudgEatOut);
		
		jtfbudgDrink = new JTextField();
		jtfbudgDrink.setColumns(10);
		jtfbudgDrink.setText(budgDrink.toString());
		jtfbudgDrink.setBounds(300, 210, 130, 26);
		spendingSum_panel.add(jtfbudgDrink);
		
		jtfbudgOther = new JTextField();
		jtfbudgOther.setColumns(10);
		jtfbudgOther.setBounds(300, 240, 130, 26);
		jtfbudgOther.setText(budgOther.toString());
		spendingSum_panel.add(jtfbudgOther);
		
		JButton btnChangeBudget = new JButton("Change Budget");
		btnChangeBudget.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{				
								
				lblIntTotalGrocery.setText(jtfbudgGrocery.getText().toString());
				lblIntTotalFuel.setText(jtfbudgFuel.getText().toString());
				lblIntTotalLaundry.setText(jtfbudgLaundry.getText().toString());
				lblIntTotalAirbnb.setText(jtfbudgAirbnb.getText().toString());
				lblIntTotalEatOut.setText(jtfbudgEatOut.getText().toString());
				lblIntTotalDrink.setText(jtfbudgDrink.getText().toString());
				lblIntTotalOther.setText(jtfbudgOther.getText().toString());		
				
				
				double newBudgGrocery = Double.parseDouble(jtfbudgGrocery.getText());
				double newBudgvalFuel =   Double.parseDouble(jtfbudgFuel.getText());
				double newBudgvalLaundry = Double.parseDouble(jtfbudgLaundry.getText());
				double newBudgvalAirbnb = Double.parseDouble(jtfbudgAirbnb.getText());
				double newBudgvalEatOut = Double.parseDouble(jtfbudgEatOut.getText());
				double newBudgvalDrink = Double.parseDouble(jtfbudgDrink.getText());
				double newBudgvalOther = Double.parseDouble(jtfbudgOther.getText());

				remainGrocery = newBudgGrocery - tolValGrocery;
				remainFuel = newBudgvalFuel - tolValFuel;
				remainLaundry = newBudgvalLaundry - tolValLaundry;
				remainAirbnb = newBudgvalAirbnb - tolValAirbnb;
				remainEatOut = newBudgvalEatOut - tolValEatOut;
				remainDrink = newBudgvalDrink - tolValDrink;
				remainOther = newBudgvalOther - tolValOther;
			
				lblRemainGrocery.setText(remainGrocery.toString());
				lblRemainFuel.setText(remainFuel.toString());
				lblRemainLaundry.setText(remainLaundry.toString());
				lblRemainAirbnb.setText(remainAirbnb.toString());
				lblRemainEatOut.setText(remainEatOut.toString());
				lblRemainDrink.setText(remainDrink.toString());
				lblRemainOther.setText(remainOther.toString());				
	
			}
				});
		btnChangeBudget.setBounds(300, 285, 130, 26);
		spendingSum_panel.add(btnChangeBudget);
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jtfbudgGrocery.setText(budgGrocery.toString());
				jtfbudgFuel.setText(budgFuel.toString());
				jtfbudgLaundry.setText(budgLaundry.toString());
				jtfbudgEatOut.setText(budgEatOut.toString());
				jtfbudgAirbnb.setText(budgAirbnb.toString());
				jtfbudgDrink.setText(budgDrink.toString());
				jtfbudgOther.setText(budgOther.toString());
			}
		});
		btnCancel.setBounds(300, 310, 130, 26);
		spendingSum_panel.add(btnCancel);

		/*******************************************************
		 * Third Panel: Calendar
		 * *****************************************************
		 */	
		CalendarDate calendarDate = new CalendarDate();
		calendarDate.setLayout(null);
		frame.getContentPane().add(calendarDate);
		
		/*******************************************************
		 * Fourth Panel: History of Spending
		 * *****************************************************
		 */	
		
		HistoryOfSpending  history_panel = new HistoryOfSpending();
		history_panel.setLayout(null);
		frame.getContentPane().add(history_panel);

		
		

	}
}
