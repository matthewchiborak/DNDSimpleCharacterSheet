package dndsimplecharacatersheetpackage;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import org.json.simple.JSONObject;

public class EventHandlerGeneral extends DNDEventHandler {
	
	public EventHandlerGeneral(JSONObject obj)
	{
		super(obj);
	}
	
	@Override
	public JSONObject handle(ActionEvent e)
	{
		if(((JButton)e.getSource()).getName().equals("Inititive"))
		{
			int mod = convertScoreToModifier(Integer.parseInt(obj.get("DexterityScore").toString()));
			copyToClipboard(buildRollString("/r 1d20", mod));
		}
		if(((JButton)e.getSource()).getName().equals("HPUp"))
		{
			int currentHP = Integer.valueOf(obj.get("CurrentHP").toString()) + 1;
			if(currentHP > Integer.valueOf(obj.get("MaxHP").toString()))
				currentHP = Integer.valueOf(obj.get("MaxHP").toString());
			obj.put("CurrentHP", currentHP);
		}
		if(((JButton)e.getSource()).getName().equals("HPDown"))
		{
			int currentHP = Integer.valueOf(obj.get("CurrentHP").toString()) - 1;
			if(currentHP < 0)
				currentHP = 0;
			obj.put("CurrentHP", currentHP);
		}
		if(((JButton)e.getSource()).getName().equals("HitDieUp"))
		{
			int currentHP = Integer.valueOf(obj.get("CurrentHitDie").toString()) + 1;
			if(currentHP > Integer.valueOf(obj.get("MaxHitDie").toString()))
				currentHP = Integer.valueOf(obj.get("MaxHitDie").toString());
			obj.put("CurrentHitDie", currentHP);
		}
		if(((JButton)e.getSource()).getName().equals("HitDieDown"))
		{
			int currentHP = Integer.valueOf(obj.get("CurrentHitDie").toString()) - 1;
			if(currentHP < 0)
				currentHP = 0;
			obj.put("CurrentHitDie", currentHP);
		}
		
		String splitCheck[] = ((JButton)e.getSource()).getName().split(",");
		if(splitCheck[0].equals("HitDieRoll"))
		{			
			int bonusMod = convertScoreToModifier(Integer.valueOf(obj.get("ConstitutionScore").toString()));
			if(bonusMod > 0)
				copyToClipboard("/r " + splitCheck[1] + "d" + obj.get("MaxHitDie").toString() + " + " + String.valueOf(bonusMod * Integer.parseInt(splitCheck[1])));
			else if(bonusMod < 0)
				copyToClipboard("/r " + splitCheck[1] + "d" + obj.get("MaxHitDie").toString() + " " + String.valueOf(bonusMod * Integer.parseInt(splitCheck[1])));
			else
				copyToClipboard("/r " + splitCheck[1] + "d" + obj.get("MaxHitDie").toString());
		}
		
		return obj;
	}
}
