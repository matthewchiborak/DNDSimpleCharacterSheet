package dndsimplecharacatersheetpackage;

import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ViewActions extends JPanel {

	public ViewActions(JSONObject obj, int level, ActionListener listener)
	{
		super();
		
		if(level == 0)
			slotsLabel = new JLabel("Cantrips: ");
		else
			slotsLabel = new JLabel("Level " + level + " (" + obj.get("CurrentSlots"+level) + "/" + obj.get("MaxSlots"+level) + "): ");
		
		this.add(slotsLabel);
		
		if(level > 0)
		{
			slotsUpButton = new JButton("^");
			slotsUpButton.setName("SlotsUp,"+level);
			slotsUpButton.addActionListener(listener);
			this.add(slotsUpButton);
			slotsDownButton = new JButton("V");
			slotsDownButton.setName("SlotsDown,"+level);
			slotsDownButton.addActionListener(listener);
			this.add(slotsDownButton);
		}
		
		JSONArray attacks = (JSONArray) obj.get("Attacks");
		
		int sizeToUse = 0;
		Iterator<JSONObject> iterator = attacks.iterator();
		while(iterator.hasNext())
		{
			if(iterator.next().get("level").toString().equals(String.valueOf(level)))
			{
				sizeToUse++;
			}
		}

		actionButtons = new JButton[sizeToUse];
		Iterator<JSONObject> iterator2 = attacks.iterator();
		
		int i = 0;
		while(iterator2.hasNext())
		{
			JSONObject temp = iterator2.next();
			
			if(temp.get("level").toString().equals(String.valueOf(level)))
			{
				actionButtons[i] = new JButton(temp.get("name").toString());
				actionButtons[i].setName("Action," + temp.get("id"));
				actionButtons[i].addActionListener(listener);
				this.add(actionButtons[i]);
				i++;
			}
		}
	}
	
	public int getNumberOfActions()
	{
		return actionButtons.length;
	}
	
	private JLabel slotsLabel;
	private JButton slotsUpButton;
	private JButton slotsDownButton;
	private JButton actionButtons[];
}
