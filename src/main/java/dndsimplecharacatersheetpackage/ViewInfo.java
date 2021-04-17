package dndsimplecharacatersheetpackage;

import org.json.JSONObject;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.json.JSONArray;

public class ViewInfo extends JPanel {

	public ViewInfo(org.json.simple.JSONObject obj, ActionListener listener)
	{
		super();
		
		nameLabel = new JLabel(obj.get("name").toString());
		
		strButton = new JButton("Str: " + obj.get("StrengthScore").toString());
		strButton.setName("SaveThrowStr");
		strButton.addActionListener(listener);
		dexButton = new JButton("Dex: " + obj.get("DexterityScore").toString());
		dexButton.setName("SaveThrowDex");
		dexButton.addActionListener(listener);
		conButton = new JButton("Con: " + obj.get("ConstitutionScore").toString());
		conButton.setName("SaveThrowCon");
		conButton.addActionListener(listener);
		intButton = new JButton("Int: " + obj.get("IntelligenceScore").toString());
		intButton.setName("SaveThrowInt");
		intButton.addActionListener(listener);
		wisButton = new JButton("Wis: " + obj.get("WisdomScore").toString());
		wisButton.setName("SaveThrowWis");
		wisButton.addActionListener(listener);
		chaButton = new JButton("Cha: " + obj.get("CharismaScore").toString());
		chaButton.setName("SaveThrowCha");
		chaButton.addActionListener(listener);
		
		ACLabel = new JLabel("AC: " + obj.get("AC").toString());
		speedLabel = new JLabel("Speed: " + obj.get("Speed").toString());
		
		saveButton = new JButton("Save");
		saveButton.setName("Save");
		saveButton.addActionListener(listener);
		
		setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		setLayout(new GridLayout(1, 0));
		
		this.add(nameLabel);
		this.add(strButton);
		this.add(dexButton);
		this.add(conButton);
		this.add(intButton);
		this.add(wisButton);
		this.add(chaButton);
		this.add(ACLabel);
		this.add(speedLabel);
		this.add(saveButton);
	}
	
	private JLabel nameLabel;
	private JButton strButton;
	private JButton dexButton;
	private JButton conButton;
	private JButton intButton;
	private JButton wisButton;
	private JButton chaButton;
	private JLabel ACLabel;
	private JLabel speedLabel;
	private JButton saveButton;
}
