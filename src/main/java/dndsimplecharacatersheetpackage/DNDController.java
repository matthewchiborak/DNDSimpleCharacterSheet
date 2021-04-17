package dndsimplecharacatersheetpackage;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.json.simple.JSONObject;

public class DNDController implements ActionListener {

	public DNDController(JSONObject obj)
	{
		this.obj = obj;
		view = new DNDView(obj, this);
	}
	
	public void run()
	{
		view.show();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		EventHandlerSavingThrows saveThrow = new EventHandlerSavingThrows(obj); 
		obj = saveThrow.handle(e);
		EventHandlerGeneral general = new EventHandlerGeneral(obj);
		obj = general.handle(e);
		EventHandlerSkills skills = new EventHandlerSkills(obj);
		obj = skills.handle(e);
		EventHandlerActions actions = new EventHandlerActions(obj);
		obj = actions.handle(e);
		EventHandlerCounters counters = new EventHandlerCounters(obj);
		obj = counters.handle(e);
		
		//Save
		if(((JButton)e.getSource()).getName().equals("Save"))
		{
			DNDFileReader fr = new DNDFileReader();
			fr.writeContents(obj, "D:\\eclipse-workspace\\DNDSimpleCharacterSheet\\CharacterInfo.json");
		}
		
		view.hide();
		view = new DNDView(obj, this);
		view.show();
	}
	
	JSONObject obj;
	DNDView view;
}
