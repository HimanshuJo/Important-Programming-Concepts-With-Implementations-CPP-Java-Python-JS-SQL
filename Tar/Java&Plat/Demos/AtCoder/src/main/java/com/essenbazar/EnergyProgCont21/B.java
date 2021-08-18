package com.essenbazar.EnergyProgCont21;

import java.util.Scanner;

/*

Problem Statement

You are now standing under a very high tower, of height 1000

At a position whose distance from the tower is D, there is a UFO up in the sky at height H 
    and you want to send it a radio wave.

There are N obstacles between the tower and the UFO. 
    The i-th obstacle stands at the position di meters from the tower towards the UFO, 
    and has a height of hi. You want to climb up the tower so that no obstacle crosses 
    the line between you and the UFO. Find the minimum height you need to climb.

We assume that the ground is a flat plane, and the towers and obstacles stand vertically from the ground.

Additionally, if the top of an obstacle lies exactly on the line connecting you and the UFO, 
    we assume that the obstacle does not cross that line.

*/
// Sign of friendship
/*

When there is a single obstacle, the slope of the line through the UFO and the top
    of the obstacle is (H - h) / (D - d)

    so the minimum height we can climb is max(0, h - d x (H - h) / (D - d))

    -------

    When there are multiple obstacles, the answer will be the minimum value of
        max(0, h - d x (H - hi) / (D -di))

        another words for all obstacles calculate the max and pick the min among them

*/

public class B {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			double N, D, H;
			N = sc.nextDouble();
			D = sc.nextDouble();
			H = sc.nextDouble();
			double res = 0;
			while (N-- > 0) {
				double d, h;
				d = sc.nextDouble();
				h = sc.nextDouble();
				double temp = h - d * (H - h) / (D - d);

				if (res < temp) {
					res = temp;
				}
			}
			System.out.println(res);
		}
	}
}
