package com.vtcintecom.strickeforce.testscript;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.vtcintecom.strickeforce.entity.Login;
import com.vtcintecom.strickeforce.util.DataLogin;

public class FlowLogin {
	public static void main(String[] args) {

		Screen screen = new Screen();

		Pattern img_minimum = new Pattern("./image/minimum.png");
		Pattern img_user = new Pattern("./image/input_username.png");
		Pattern img_pass = new Pattern("./image/input_pass.png");
		Pattern img_login = new Pattern("./image/bt_login.png");
		// Pattern img_oki = new
		// Pattern("E:\\auto-test\\Auto_Test_Stricke_Force\\image\\bt_oki.png");
		Pattern img_close = new Pattern("./image/bt_close.png");

		DataLogin data = new DataLogin();
		try {
			screen.find(img_minimum);
			screen.click(img_minimum);
		} catch (FindFailed e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			for (int i = 0; i < data.getLogin().size(); i++) {

				Login login = new Login(data.getLogin().get(i));
				Pattern img_expect = new Pattern(login.getExpect());

				screen.find(img_user);
				screen.click(img_user);
				Thread.sleep(1000);

				screen.type(login.getUsername());

				screen.click(img_user);

				screen.find(img_pass);
				screen.click(img_pass);
				Thread.sleep(1000);

				screen.type(login.getPassword());
				screen.click(img_pass);

				screen.find(img_login);
				screen.click(img_login);

				try {
					screen.exists(img_expect);

					if (login.getExpect().equalsIgnoreCase("username and password is incorrect")) {
						screen.find(img_close);
						screen.click(img_close);
					}
				} catch (Exception ex) {
					JOptionPane.showConfirmDialog(null, "Không tìm thấy phần thấy kết quả mong muốn");
				}
			}
		} catch (IOException | FindFailed | InterruptedException e) {
			// TODO Auto-generated catch blocke
			e.printStackTrace();
		}

	}

}
