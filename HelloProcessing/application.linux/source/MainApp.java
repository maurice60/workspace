import numbers.*;
import processing.core.*;

//@SuppressWarnings("serial")
public class MainApp extends PApplet {

    // Your global variables goes here
    float diameter = 100.0f;
    long pe33 = pe033();

    public static void main(String[] args) {
        String[] a = {"MAIN"};
        PApplet.runSketch(a, new MainApp());
    }

    // Processing setup method
    public void settings(){
        size(200, 200);     
    }

    public void setup() {
        pe033();
    }
    
    // Processing draw method
    public void draw() {
//        ellipse(width * 0.5f, height * 0.5f, diameter, diameter);
        fill(0);
        text(Long.toString(pe33), width *.4f, height * .5f);
    }

    private long pe033() {
		long div, num, den, tnum = 1, tden = 1, factr;
		Numbers nums = new Numbers();
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				for (int k = 1; k < 10; k++) {
					if (j == k) continue;
					div = j * 1000000 / k;
		            num = 10*i+j;
		            den = 10*k+i;
		            if (num < den) {
						if (num * 1000000 / den == div) { //System.out.println(i+" "+j+" "+k);
							tnum *= num;
							tden *= den;
							factr = nums.hcf(tnum, tden);
							tnum /= factr;
							tden /= factr;
						}
		            }
		            num = 10*j+i;
		            den = 10*i+k;
		            if (num < den) {
						if (num * 1000000 / den == div) { //System.out.println(i+" "+j+" "+k);
							tnum *= num;
							tden *= den;
							factr = nums.hcf(tnum, tden);
							tnum /= factr;
							tden /= factr;
						}
		            }
				}
			}
		}
		return tden;
    }


}
