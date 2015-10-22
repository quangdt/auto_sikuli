package com.vtcintecom.strickeforce.testscript;

import java.util.ArrayList;

import org.sikuli.script.Env;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.vtcintecom.strickeforce.entity.Register;
import com.vtcintecom.strickeforce.util.CheckTextInput;
import com.vtcintecom.strickeforce.util.DataRegister;

class FlowRegister {
	private Screen screen = new Screen();

	public FlowRegister(Screen screen) {
		super();
		this.screen = screen;
	}

	public FlowRegister() {
		screen = new Screen();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FlowRegister().run();
	}

	public void clk_register() {
		Pattern img_bt_register = new Pattern("./image/bt_register.png");

		try {

			screen.find(img_bt_register);
			screen.click(img_bt_register);
		} catch (FindFailed e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void run() {

		ArrayList<Register> list = new DataRegister().getRegister();

		Pattern img_minimum = new Pattern("./image/minimum.png");
		Pattern img_user = new Pattern("./image/input_username.png");
		Pattern img_pass = new Pattern("./image/input_pass.png");
		Pattern img_confirm_pass = new Pattern("./image/input_retype_pass.png");

		try {
			screen.find(img_minimum);
			screen.click(img_minimum);
		} catch (FindFailed e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		clk_register();

		CheckTextInput check = new CheckTextInput();
		for (int i = 0; i < list.size(); i++) {

			Register account = new Register();
			account = list.get(i);
			System.out.println("==================Testcase " + i + "================");
			try {
				screen.click(img_user);
				Thread.sleep(1000);
				screen.type(account.getUsername());
				screen.click(img_user);

				screen.click(img_pass);
				Thread.sleep(1000);
				screen.type(account.getPassword());
				screen.click(img_pass);

				screen.click(img_confirm_pass);
				Thread.sleep(1000);
				screen.type(account.getConfirm_pass());
				screen.click(img_confirm_pass);

				clk_register();

			} catch (FindFailed | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Pattern expect = new Pattern(account.getImg_expect());
			try {
				screen.find(expect);
			} catch (FindFailed e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				account.setResult1(account.getResult2());
				account.setResult2("Fail");
			}
			if (account.getExpect().equals("Register Successfully")) {

				Pattern confirm = new Pattern("./image/bt_confirm.png");
				try {
					screen.find(confirm);
					screen.click(confirm);
					System.out.print("testcase register successfully");
					clk_register();
					account.setResult1(account.getResult2());
					account.setResult2("Pass");
				} catch (FindFailed e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					account.setResult1(account.getResult2());
					account.setResult2("Fail");
				}

			} else {

				Pattern close = new Pattern("./image/bt_close.png");

				try {
					screen.find(close);
					screen.click(close);
					account.setResult1(account.getResult2());
					account.setResult2("Pass");
				} catch (FindFailed e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					account.setResult1(account.getResult2());
					account.setResult2("Fail");
				}

			}
		}
		new DataRegister().write(list);

	}

}
