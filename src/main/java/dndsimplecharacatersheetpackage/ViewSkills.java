package dndsimplecharacatersheetpackage;

import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class ViewSkills extends JPanel {

	public ViewSkills(JSONObject obj, ActionListener listener)
	{
		super();
		
		JSONArray skills = (JSONArray) obj.get("Skills");
		
		skillButtons = new JButton[skills.size()];
		Iterator<JSONObject> iterator = skills.iterator();
		
		for(int i = 0; i < skills.size(); i++)
		{
			JSONObject temp = iterator.next();
			skillButtons[i] = new JButton(temp.get("name").toString());
			skillButtons[i].setName("Skill," + temp.get("id"));
			skillButtons[i].addActionListener(listener);
			this.add(skillButtons[i]);
		}
	}
	
	private JButton skillButtons[];
}
