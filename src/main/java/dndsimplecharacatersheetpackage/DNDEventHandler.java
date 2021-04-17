package dndsimplecharacatersheetpackage;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;

import org.json.simple.JSONObject;

public class DNDEventHandler {

	public DNDEventHandler(JSONObject obj)
	{
		this.obj = obj;
	}
	
	public JSONObject handle(ActionEvent e)
	{
		return obj;
	}
	
	protected void copyToClipboard(String s)
	{
		StringSelection stringSelection = new StringSelection(s);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
	}
	
	protected int convertScoreToModifier(int score)
	{
		return (int) (Math.floor(score / 2) - 5);
	}
	
	protected String buildRollString(String base, int mod)
	{
		if(mod < 0)
			return (base + String.valueOf(mod));
		else if(mod > 0)
			return (base + "+" + String.valueOf(mod));
		
		return (base);
	}
	
	JSONObject obj;
}
