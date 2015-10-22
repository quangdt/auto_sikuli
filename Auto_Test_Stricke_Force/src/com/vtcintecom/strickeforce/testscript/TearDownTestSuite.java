package com.vtcintecom.strickeforce.testscript;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

public class TearDownTestSuite {
	private Screen screen;

	public TearDownTestSuite() {
		this.screen = new Screen();
	}

	public void deleteApp() {
		Pattern img_setting = new Pattern("./image/bt_Setting.png");
		Pattern img_Manage_App=new Pattern("./image/bt_Manage_App.png");

		try {
			screen.find(img_setting);
			screen.click(img_setting);
			
			screen.find(img_Manage_App);
			screen.click(img_Manage_App);
			
//			Region.
			
			
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
