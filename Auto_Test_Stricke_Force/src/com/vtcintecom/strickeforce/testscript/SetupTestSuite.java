package com.vtcintecom.strickeforce.testscript;

import java.awt.RenderingHints.Key;

import javax.swing.JOptionPane;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SetupTestSuite {
	// declare variable screen;
	public Screen screen;

	// uniti variable screen;
	public SetupTestSuite() {
		this.screen = new Screen();
	}

	public static void main(String[] args) {
		SetupTestSuite setup = new SetupTestSuite();
		// call method run of class
		setup.run();
	}

	public void run() {

		String img_bluestack = new String("./image/ico_bar_blue.png");
		String visul = new String("./image/bt_game.png");

		if (check_App(img_bluestack)) {
			System.out.println("bluestart exists");
			pn_main();
		} else {
			System.out.print("Bluestart not exists");
			start_visual();
		}

		if (check_App(visul)) {
			JOptionPane.showConfirmDialog(null, "app exists");

		} else {
			setup_app();
		}
	}

	public void start_visual() {
		Pattern img_minimum = new Pattern("./image/minimum.png");
		Pattern img_ico_bluestack = new Pattern("./image/ico_bluestacks.png");

		try {
			screen.find(img_minimum);
			screen.click(img_minimum);

			screen.find(img_ico_bluestack);
			screen.doubleClick(img_ico_bluestack);
			Thread.sleep(20000);

			pn_main();

		} catch (FindFailed | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void setup_app() {
		Pattern img_icon_folders = new Pattern("./image/ico_folders.png");
		Pattern img_input_path = new Pattern("./image/input_find_path.png");
		Pattern img_ico_game = new Pattern("./image/ico_game.png");

		try {
			screen.find(img_icon_folders);
			screen.click(img_icon_folders);

			screen.find(img_input_path);
			screen.type(img_input_path, "D:" + "\\" + "auto_test" + "\\" + "Auto_Test_Stricke_Force" + "\\" + "apk");
			screen.type(org.sikuli.script.Key.ENTER);

			screen.find(img_ico_game);
			screen.doubleClick(img_ico_game);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

	public void pn_main() {
		Pattern img_bt_bl_main = new Pattern("./image/bt_bl_main.png");
		try {
			screen.find(img_bt_bl_main);
			screen.click(img_bt_bl_main);

		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
