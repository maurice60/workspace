package pe034;

import processing.core.PApplet;

public class PE034 extends PApplet {

	public void settings() {
		size(300, 200);
	}
	public void setup() {
		fill(0);
		text(Long.toString(pe034()), 130, 100);
	}

	public void draw() {
	}
	
	public static void main(String _args[]) {
		PApplet.main(new String[] { pe034.PE034.class.getName() });
	}
	
	private long pe034() {
		long f[] = new long[10];
		long j, s, ans = 0;
		long upr = 1;
		f[0] = 1;
		for (int x = 1; x < 10; x++) {
			f[x] = f[x-1] * x;
			upr += f[x];
		}
		for (long i = 10; i < upr; i++) {
			j = i;
			s = 0;
			while (j > 0) {
				s += f[(int) j % 10];
				if (s > i) break;
				j /= 10;
			}
			if (s == i) ans += i;
		}
		return ans;
	}
}
