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
		
		int[] R;
		int[] G;
		int[] B;
		
		for(int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				p = img.getRGB(i, j);
				// get alpha


				// get red
				R.add((p >> 16) & 0xff);

				// get green
				g = (p >> 8) & 0xff;

				// get blue
				b = p & 0xff;
				
			}
		}
		
		
		
		
		
		
	}
}
