package dndsimplecharacatersheetpackage;

import org.json.simple.JSONObject;

public class Main {

	public static void main(String[] args) {
		
		DNDFileReader fr = new DNDFileReader();
		//JSONObject obj = fr.getContents("D:\\eclipse-workspace\\DNDSimpleCharacterSheet\\CharacterInfo.json");
		JSONObject obj = fr.getContents(args[0]);
		
		DNDController controller = new DNDController(obj, args[0]);
		controller.run();
	}

}
