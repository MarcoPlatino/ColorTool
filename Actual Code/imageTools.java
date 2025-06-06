import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class imageTools {
	public static int a;
	public static int r;
	public static int b;
	public static int g;
	public static int p;
	
	public static int averageR;
	public static int averageG;
	public static int averageB;
	
	public static void getPixelColor(String Path, int x, int y) {
		BufferedImage img = null;
		File f = null;

		// read image
		try {
			f = new File(Path);
			img = ImageIO.read(f);
		} catch (IOException e) {
			System.out.println(e);
		}

		// get image width and height
//		int width = img.getWidth();
//		int height = img.getHeight();

		p = img.getRGB(0, 0);

		// get alpha
		a = (p >> 24) & 0xff;

		// get red
		r = (p >> 16) & 0xff;

		// get green
		g = (p >> 8) & 0xff;

		// get blue
		b = p & 0xff;

	}
	
	public static void getPixelColorAverage(String Path) {
		BufferedImage img = null;
		File f = null;
		
		try {
			f = new File(Path);
			img = ImageIO.read(f);
		} catch (IOException e) {
			System.out.println(e);
		}
		
		int width = img.getWidth();
		int height = img.getHeight();
		
		List<Integer> R;
		List<Integer> B;
		List<Integer> G;

		R = new ArrayList<>();
		G = new ArrayList<>();
		B = new ArrayList<>();

		for(int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				p = img.getRGB(i, j);
				
				//Get 
				R.add((p >> 16) & 0xff);

				// get green
				G.add((p >> 8) & 0xff);

				// get blue
				B.add((p & 0xff));
				
			}
		}

		int totalR = 0;
		int totalG = 0;
		int totalB = 0;

		for (int traverseR = 0; traverseR < R.size(); traverseR ++){
			totalR += R.get(traverseR);
		}
		
		for (int traverseG = 0; traverseG < G.size(); traverseG ++){
			totalG += G.get(traverseG);
		}

		for (int traverseB = 0; traverseB < B.size(); traverseB ++){
			totalB += B.get(traverseB);
		}

		averageR = totalR / R.size();
		averageG = totalG / G.size();
		averageB = totalB / B.size();
	}
}
