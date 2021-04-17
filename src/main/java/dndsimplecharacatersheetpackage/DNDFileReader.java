package dndsimplecharacatersheetpackage;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class DNDFileReader {

	public DNDFileReader()
	{

	}
	
	public JSONObject getContents(String path)
	{
		JSONObject jsonObject = null;
		
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(path));
			 
			jsonObject = (JSONObject) obj;

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return jsonObject;
	}
	
	public void writeContents(JSONObject obj, String path)
	{
		try {
			FileWriter file = new FileWriter(path);
			file.write(obj.toJSONString());
            file.flush();
            file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}
