package dndsimplecharacatersheetpackage;

import java.awt.event.ActionEvent;
import java.util.Iterator;

import javax.swing.JButton;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class EventHandlerSkills extends DNDEventHandler {

	public EventHandlerSkills(JSONObject obj)
	{
		super(obj);
	}
	
	@Override
	public JSONObject handle(ActionEvent e)
	{
		String splitCheck[] = ((JButton)e.getSource()).getName().split(",");
		if(splitCheck[0].equals("Skill"))
		{
			JSONArray skills = (JSONArray) obj.get("Skills");
			Iterator<JSONObject> iterator = skills.iterator();
			
			while(iterator.hasNext())
			{
				JSONObject temp = iterator.next();
				
				if(temp.get("id").toString().equals(splitCheck[1]))
				{
					int mod = convertScoreToModifier(Integer.parseInt(obj.get(temp.get("skill").toString() + "Score").toString()));
					if(temp.get("proficient").toString().equals("true"))
						mod += Integer.parseInt(obj.get("ProficiencyBonus").toString());
					copyToClipboard(buildRollString("/r 1d20", mod));
				}
			}
		}
		
		return obj;
	}
}
