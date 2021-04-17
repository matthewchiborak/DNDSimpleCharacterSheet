package dndsimplecharacatersheetpackage;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import org.json.simple.JSONObject;

public class EventHandlerSavingThrows extends DNDEventHandler {

	public EventHandlerSavingThrows(JSONObject obj)
	{
		super(obj);
	}
	
	@Override
	public JSONObject handle(ActionEvent e)
	{
		if(((JButton)e.getSource()).getName().equals("SaveThrowStr"))
		{
			int mod = convertScoreToModifier(Integer.parseInt(obj.get("StrengthScore").toString()));
			if(obj.get("Strength").toString().equals("true"))
				mod += Integer.parseInt(obj.get("ProficiencyBonus").toString());
			copyToClipboard(buildRollString("/r 1d20", mod));
		}
		if(((JButton)e.getSource()).getName().equals("SaveThrowDex"))
		{
			int mod = convertScoreToModifier(Integer.parseInt(obj.get("DexterityScore").toString()));
			if(obj.get("Dexterity").toString().equals("true"))
				mod += Integer.parseInt(obj.get("ProficiencyBonus").toString());
			copyToClipboard(buildRollString("/r 1d20", mod));
		}
		if(((JButton)e.getSource()).getName().equals("SaveThrowCon"))
		{
			int mod = convertScoreToModifier(Integer.parseInt(obj.get("ConstitutionScore").toString()));
			if(obj.get("Constitution").toString().equals("true"))
				mod += Integer.parseInt(obj.get("ProficiencyBonus").toString());
			copyToClipboard(buildRollString("/r 1d20", mod));
		}
		if(((JButton)e.getSource()).getName().equals("SaveThrowInt"))
		{
			int mod = convertScoreToModifier(Integer.parseInt(obj.get("IntelligenceScore").toString()));
			if(obj.get("Intelligence").toString().equals("true"))
				mod += Integer.parseInt(obj.get("ProficiencyBonus").toString());
			copyToClipboard(buildRollString("/r 1d20", mod));
		}
		if(((JButton)e.getSource()).getName().equals("SaveThrowWis"))
		{
			int mod = convertScoreToModifier(Integer.parseInt(obj.get("WisdomScore").toString()));
			if(obj.get("Wisdom").toString().equals("true"))
				mod += Integer.parseInt(obj.get("ProficiencyBonus").toString());
			copyToClipboard(buildRollString("/r 1d20", mod));
		}
		if(((JButton)e.getSource()).getName().equals("SaveThrowCha"))
		{
			int mod = convertScoreToModifier(Integer.parseInt(obj.get("CharismaScore").toString()));
			if(obj.get("Charisma").toString().equals("true"))
				mod += Integer.parseInt(obj.get("ProficiencyBonus").toString());
			copyToClipboard(buildRollString("/r 1d20", mod));
		}
		
		return obj;
	}
	
}
