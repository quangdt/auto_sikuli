package com.vtcintecom.strickeforce.testscript;

import org.sikuli.script.Key;
import org.sikuli.script.Screen;

public class DemoKeyEvent {
	public static void main(String[] args) {
		SetupTestSuite setup = new SetupTestSuite();
		setup.run();
		Screen screen = new Screen();
		// screen.type("click", keyb)
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 3; i++) {
				screen.type(Key.RIGHT);
			}
			for (int i = 0; i < 100; i++) {
				screen.type(Key.LEFT);
			}
		}
	}
}
