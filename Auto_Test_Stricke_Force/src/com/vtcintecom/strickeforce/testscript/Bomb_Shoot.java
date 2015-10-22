package com.vtcintecom.strickeforce.testscript;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Location;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

public class Bomb_Shoot {
	private Screen screen=new Screen();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Screen screen = new Screen();
		Pattern img_minimum = new Pattern("./image/minimum.png");
		// Pattern img_max_min = new Pattern("./image/bt_max_min.png");

		try {
			screen.find(img_minimum);
			screen.click(img_minimum);

			// screen.find(img_max_min);
			// Thread.sleep(1000);
			// screen.click(img_max_min);

		} catch (FindFailed e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Location local_op = new Location(933, 284);
		Location local_mu = new Location(753, 378);
		Location local_khoi = new Location(843, 378);
		Location local_dan = new Location(953, 378);
		Location local_fly = new Location(888, 482);
		Location local_ban = new Location(773, 538);
		
		Bomb_Shoot bomb_Shoot=new Bomb_Shoot();
//		bomb_Shoot.option_shoot(local_ban, 2);
//		bomb_Shoot.option_shoot(local_op, 5);
//		bomb_Shoot.option_shoot(local_khoi, 6);
//		bomb_Shoot.option_shoot(local_dan, 4);
//		bomb_Shoot.option_shoot(local_fly, 3);
		bomb_Shoot.option_shoot(local_mu, 200);
	}

	public void option_shoot(Location local, int n) {
		// Location local = new Location(1000, 425);
		// screen.cli
		// screen.wheel(local, W, steps);
		for (int i = 0; i < n; i++) {
			try {
				Thread.sleep(1000);
				screen.click(new Region(local.x, local.y, 2, 2));

			} catch (FindFailed | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
