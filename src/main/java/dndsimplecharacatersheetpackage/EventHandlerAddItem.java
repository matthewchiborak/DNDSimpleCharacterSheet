package dndsimplecharacatersheetpackage;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class EventHandlerAddItem extends DNDEventHandler {

	public EventHandlerAddItem(JSONObject obj, AddItemView view) {
		super(obj);
		
		this.view = view;
	}

	@Override
	public JSONObject handle(ActionEvent e) {
		
		if(((JButton)e.getSource()).getName().equals("AddActionButton"))
		{
			JSONArray attacks = (JSONArray) obj.get("Attacks");
			JSONObject newObj = new JSONObject();
			newObj.put("id", attacks.size()+1);
			newObj.put("level", view.attackLevelBox.getSelectedIndex());
			newObj.put("name", view.attackNameEdit.getText());
			newObj.put("attackroll", view.attackAttackRollEdit.getText());
			newObj.put("damageroll", view.attackDamageRollEdit.getText());
			attacks.add(newObj);
		}
		
		if(((JButton)e.getSource()).getName().equals("AddCounterButton"))
		{
			JSONArray counters = (JSONArray) obj.get("Counters");
			JSONObject newObj = new JSONObject();
			newObj.put("id", counters.size()+1);
			newObj.put("name", view.counterNameEdit.getText());
			newObj.put("CurrentCount", view.counterMinEdit.getValue());
			newObj.put("MaxCount", view.counterMaxEdit.getValue());
			counters.add(newObj);
		}
		
		return obj;
	}

	 AddItemView view;
}
