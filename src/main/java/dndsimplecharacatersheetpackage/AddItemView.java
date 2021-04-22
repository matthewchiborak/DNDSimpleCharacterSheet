package dndsimplecharacatersheetpackage;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class AddItemView {
	
	public AddItemView(org.json.simple.JSONObject obj, ActionListener listener)
	{
		createComponents(obj, listener);
		setupLayouts();
	}
	
	public void show()
	{
		frame.setVisible(true);
	}
	public void hide()
	{
		frame.setVisible(false);
	}
	
	private void createComponents(org.json.simple.JSONObject obj, ActionListener listener)
	{
		frame = new JFrame();
		totalPanel = new JPanel();
		attackPanel = new JPanel();
		counterPanel = new JPanel();
				
		String[] levelValues = new String[] {"0","1","2","3","4","5","6","7","8","9"};
		attackLevelBox = new JComboBox(levelValues);
		attackNameEdit = new JTextField();
		attackNameEdit.setText("ActionName");
		attackAttackRollEdit = new JTextField();
		attackAttackRollEdit.setText("/r attackroll");
		attackDamageRollEdit = new JTextField();
		attackDamageRollEdit.setText("/r damageroll");
		attackAddButton = new JButton("Add Action");
		attackAddButton.setName("AddActionButton");
		attackAddButton.addActionListener(listener);
		
		counterNameEdit = new JTextField();
		counterNameEdit.setText("CounterName");
		counterMinEdit = new JSpinner();
		counterMaxEdit = new JSpinner();
		counterAddButton = new JButton("Add Counter");
		counterAddButton.setName("AddCounterButton");
		counterAddButton.addActionListener(listener);
	}
	
	private void setupLayouts()
	{
		totalPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		totalPanel.setLayout(new GridLayout(0, 1));
		
		attackPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		attackPanel.setLayout(new GridLayout(1, 0));
		attackPanel.add(attackLevelBox);
		attackPanel.add(attackNameEdit);
		attackPanel.add(attackAttackRollEdit);
		attackPanel.add(attackDamageRollEdit);
		attackPanel.add(attackAddButton);
		totalPanel.add(attackPanel);
		
		counterPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		counterPanel.setLayout(new GridLayout(1, 0));
		counterPanel.add(counterNameEdit);
		counterPanel.add(counterMinEdit);
		counterPanel.add(counterMaxEdit);
		counterPanel.add(counterAddButton);
		totalPanel.add(counterPanel);
		
		frame.add(totalPanel, BorderLayout.CENTER);
		frame.setTitle("Add Item");
		frame.pack();
		frame.setVisible(false);
	}
	
	private JFrame frame;
	private JPanel totalPanel;
	
	JPanel attackPanel;
	JPanel counterPanel;
	
	public JComboBox attackLevelBox;
	public JTextField attackNameEdit;
	public JTextField attackAttackRollEdit;
	public JTextField attackDamageRollEdit;
	public JButton attackAddButton;
	
	public JTextField counterNameEdit;
	public JSpinner counterMinEdit;
	public JSpinner counterMaxEdit;
	public JButton counterAddButton;
}
