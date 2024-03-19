/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ui;

public class Bonus {
	
	
	public int maxN(double t) {
		double s = 0;
		if (t <= 0)
			return 1;
		for (int i = 1;; i++) {
			s += 1.0 / i;
			if (s > t) {
				System.out.println(s - 1.0/i);
				return --i;
			}
		}
	}
	public int maxN2(double t) {
		double s = 0.0;
		int n = 0;
		if (t <= 0)
			return 1;
		while (s <= t) {
			n++;
			s += 1.0/n;
		}
		return --n;
	}
	
	public static void main(String[] args) {
		System.out.println(new Bonus().maxN(1.8));
	}
}

