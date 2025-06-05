import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class imageTools {
	public static int a;
	public static int r;
	public static int b;
	public static int g;
	public static int p;
	
	public static void getPixelColor(String Path) {
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
		int width = img.getWidth();
		int height = img.getHeight();

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
}
