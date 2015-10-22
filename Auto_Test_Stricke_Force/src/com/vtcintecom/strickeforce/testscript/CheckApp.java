package com.vtcintecom.strickeforce.testscript;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class CheckApp {
	private Screen screen;

	public CheckApp() {
		this.screen = new Screen();
	}

	public boolean check_App(String img_app) {
		
		Pattern img_bt_app = new Pattern(img_app);

		try {
			// check have find link image img_app
			screen.find(img_bt_app);
			screen.click(img_bt_app);
			return true;

		} catch (FindFailed e) {
			return false;
		}
	}
}
