package dndsimplecharacatersheetpackage;

import java.awt.event.ActionEvent;
import java.util.Iterator;

import javax.swing.JButton;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class EventHandlerCounters extends DNDEventHandler {

	public EventHandlerCounters(JSONObject obj)
	{
		super(obj);
	}
	
	@Override
	public JSONObject handle(ActionEvent e)
	{
		String splitCheck[] = ((JButton)e.getSource()).getName().split(",");
		if(splitCheck[0].equals("CountUp"))
		{
			JSONArray skills = (JSONArray) obj.get("Counters");
			Iterator<JSONObject> iterator = skills.iterator();
			
			while(iterator.hasNext())
			{
				JSONObject temp = iterator.next();
				
				if(temp.get("id").toString().equals(splitCheck[1]))
				{
					int currentHP = Integer.valueOf(temp.get("CurrentCount").toString()) + 1;
					if(currentHP > Integer.valueOf(temp.get("MaxCount").toString()))
						currentHP = Integer.valueOf(temp.get("MaxCount").toString());
					temp.put("CurrentCount", currentHP);
				}
			}
		}
		if(splitCheck[0].equals("CountDown"))
		{
			JSONArray skills = (JSONArray) obj.get("Counters");
			Iterator<JSONObject> iterator = skills.iterator();
			
			while(iterator.hasNext())
			{
				JSONObject temp = iterator.next();
				
				if(temp.get("id").toString().equals(splitCheck[1]))
				{
					int currentHP = Integer.valueOf(temp.get("CurrentCount").toString()) - 1;
					if(currentHP < 0)
						currentHP = 0;
					temp.put("CurrentCount", currentHP);
				}
			}
		}
				
		return obj;
	}
}
