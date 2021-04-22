package dndsimplecharacatersheetpackage;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.json.JSONObject;

public class DNDView {

	public DNDView(org.json.simple.JSONObject obj, ActionListener listener)
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
		
		viewInfo = new ViewInfo(obj, listener);
		viewGeneral = new ViewGeneral(obj, listener);
		viewSkills = new ViewSkills(obj, listener);
		viewActions = new ViewActions[10];
		for(int i = 0; i <= 9; i++)
			viewActions[i] = new ViewActions(obj, i, listener);
		viewCounter = new ViewCounter(obj, listener);
		
		addButton = new JButton("Add");
		addButton.setName("AddItem");
		addButton.addActionListener(listener);
	}
	
	private void setupLayouts()
	{
		totalPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		totalPanel.setLayout(new GridLayout(0, 1));
		
		totalPanel.add(viewInfo);
		totalPanel.add(viewGeneral);
		totalPanel.add(viewSkills);
		for(int i = 0; i <= 9; i++)
		{
			if(viewActions[i].getNumberOfActions() > 0)
				totalPanel.add(viewActions[i]);
		}
		totalPanel.add(viewCounter);
		totalPanel.add(addButton);
		
		frame.add(totalPanel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Character Sheet");
		frame.pack();
		frame.setVisible(false);
	}
	
	private JFrame frame;
	private JPanel totalPanel;
	
	private ViewInfo viewInfo;
	private ViewGeneral viewGeneral;
	private ViewSkills viewSkills;
	private ViewActions viewActions[];
	private ViewCounter viewCounter;
	
	private JButton addButton;
}
