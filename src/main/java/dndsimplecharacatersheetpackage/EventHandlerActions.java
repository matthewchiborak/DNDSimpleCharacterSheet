package dndsimplecharacatersheetpackage;

import java.awt.event.ActionEvent;
import java.util.Iterator;

import javax.swing.JButton;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class EventHandlerActions extends DNDEventHandler {

	public EventHandlerActions(JSONObject obj)
	{
		super(obj);
	}
	
	@Override
	public JSONObject handle(ActionEvent e)
	{
		String splitCheck[] = ((JButton)e.getSource()).getName().split(",");
		if(splitCheck[0].equals("Action"))
		{
			JSONArray skills = (JSONArray) obj.get("Attacks");
			Iterator<JSONObject> iterator = skills.iterator();
			
			while(iterator.hasNext())
			{
				JSONObject temp = iterator.next();
				
				if(temp.get("id").toString().equals(splitCheck[1]))
				{
					copyToClipboard(temp.get("attackroll").toString() + "\n" + temp.get("damageroll").toString());
				}
			}
		}
		if(splitCheck[0].equals("SlotsUp"))
		{
			int currentHP = Integer.valueOf(obj.get("CurrentSlots"+splitCheck[1]).toString()) + 1;
			if(currentHP > Integer.valueOf(obj.get("MaxSlots"+splitCheck[1]).toString()))
				currentHP = Integer.valueOf(obj.get("MaxSlots"+splitCheck[1]).toString());
			obj.put("CurrentSlots"+splitCheck[1], currentHP);
		}
		if(splitCheck[0].equals("SlotsDown"))
		{
			int currentHP = Integer.valueOf(obj.get("CurrentSlots"+splitCheck[1]).toString()) - 1;
			if(currentHP < 0)
				currentHP = 0;
			obj.put("CurrentSlots"+splitCheck[1], currentHP);
		}
		
		return obj;
	}
}
