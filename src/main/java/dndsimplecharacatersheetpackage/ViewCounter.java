package dndsimplecharacatersheetpackage;

import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ViewCounter extends JPanel {

	public ViewCounter(JSONObject obj, ActionListener listener)
	{
		super();
		
		JSONArray counters = (JSONArray) obj.get("Counters");
		
		countLabels = new JLabel[counters.size()];
		upButtons = new JButton[counters.size()];
		downButtons = new JButton[counters.size()];
		
		int i = 0;
		Iterator<JSONObject> iterator = counters.iterator();
		while(iterator.hasNext())
		{
			JSONObject focus = iterator.next();
			countLabels[i] = new JLabel(focus.get("name").toString() + " (" + focus.get("CurrentCount") + "/" + focus.get("MaxCount") + ")");
			this.add(countLabels[i]);
			upButtons[i] = new JButton("^");
			upButtons[i].setName("CountUp," + focus.get("id"));
			upButtons[i].addActionListener(listener);
			this.add(upButtons[i]);
			downButtons[i] = new JButton("V");
			downButtons[i].setName("CountDown," + focus.get("id"));
			downButtons[i].addActionListener(listener);
			this.add(downButtons[i]);
			
			i++;
		}
	}
	
	private JLabel countLabels[];
	private JButton upButtons[];
	private JButton downButtons[];
	
}
