package dndsimplecharacatersheetpackage;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.json.simple.JSONObject;

public class ViewGeneral extends JPanel {
	
	public ViewGeneral(JSONObject obj, ActionListener listener)
	{
		super();
		
		initButton = new JButton("Inititive");
		initButton.setName("Inititive");
		initButton.addActionListener(listener);
		this.add(initButton);
		
		HPLabel = new JLabel("HP: " + obj.get("CurrentHP") + "/" + obj.get("MaxHP"));
		HPUpButton = new JButton("^");
		HPDownButton = new JButton("V");
		HPUpButton.setName("HPUp");
		HPUpButton.addActionListener(listener);
		HPDownButton.setName("HPDown");
		HPDownButton.addActionListener(listener);
		this.add(HPLabel);
		this.add(HPUpButton);
		this.add(HPDownButton);
		
		hitDieLabel = new JLabel("HitDie: " + obj.get("CurrentHitDie") + "/" + obj.get("MaxHitDie"));
		this.add(hitDieLabel);
		hitDieButtons = new JButton[Integer.parseInt(obj.get("MaxHitDie").toString())];
		for(int i = 0; i < hitDieButtons.length; i++)
		{
			hitDieButtons[i] = new JButton(String.valueOf(i+1));
			hitDieButtons[i].setName("HitDieRoll,"+(i+1));
			hitDieButtons[i].addActionListener(listener);
			this.add(hitDieButtons[i]);
		}
		
		hitDieUpButton = new JButton("^");
		hitDieUpButton.setName("HitDieUp");
		hitDieUpButton.addActionListener(listener);
		this.add(hitDieUpButton);
		hitDieDownButton = new JButton("V");
		hitDieDownButton.setName("HitDieDown");
		hitDieDownButton.addActionListener(listener);
		this.add(hitDieDownButton);
	}
	
	private JButton initButton;
	
	private JLabel HPLabel;
	private JButton HPUpButton;
	private JButton HPDownButton;
	
	private JLabel hitDieLabel;
	private JButton hitDieButtons[];
	private JButton hitDieUpButton;
	private JButton hitDieDownButton;
	
}
