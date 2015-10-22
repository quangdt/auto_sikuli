package com.vtcintecom.strickeforce.util;

import java.util.Random;

import org.sikuli.script.Env;
import org.sikuli.script.FindFailed;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class CheckTextInput {

	private Screen screen = new Screen();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CheckTextInput().random();

	}

	public String getText(Pattern image) {
		String result = "";
		screen.type("a", KeyModifier.CTRL);
		screen.type("c", KeyModifier.CTRL);
		result = Env.getClipboard();
		return result;

	}

	public boolean compare(String comp1, String comp2) {
		if (comp1.equals(comp2)) {
			return true;
		} else
			return false;
	}

	public String random() {
		Random ran = new Random();
		int top = 6;
		char data = ' ';
		String dat = "";

		for (int i = 0; i < top; i++) {
			boolean flag = true;
			while (flag) {
				int rand = ran.nextInt(90);
				if (rand <= 25) {
					data = (char) (rand + 97);
					flag = false;
				} else if (rand <= 90 && rand >= 48) {
					data = (char) rand;
					flag = false;

				} else {
					flag = true;
				}
			}
			dat = data + dat;
		}

		return dat;
	}
}
