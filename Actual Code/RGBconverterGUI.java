import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.event.*;
import javax.swing.filechooser.*;
import javax.swing.*;



public class RGBconverterGUI extends JFrame implements ActionListener {
	
	public class filechooser implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int r = j.showOpenDialog(null);

        if (r == JFileChooser.APPROVE_OPTION) {
            Path = j.getSelectedFile().getAbsolutePath();
			l.setText(Path);

			getAverage.setText("Get average color of the file");
			refresh.setText("Data is not updated");
			//imageTools.getPixelColor(Path);  CHECk This Later !!!!!
// 			System.out.println(imageTools.a);
// 			System.out.println(imageTools.r);
// 			System.out.println(imageTools.g);
// 			System.out.println(imageTools.b);
// //			System.out.println(imageTools.p);
        } else {
            l.setText("the user cancelled the operation");
        }
    }
}

	JFrame frame;
	JPanel contentpane;
	JPanel imageUpload;
	JPanel fileStuff;
	JPanel imageColorAverages;

	JLabel RedLabel;
	JLabel GreenLabel;
	JLabel BlueLabel;

	JLabel HexadecimalLabel;
	JLabel BrightnessLabel;
	JLabel ASCIILabel;

	JLabel averageR;
	JLabel averageG;
	JLabel averageB;

	JLabel refresh;

	JButton ConvertButton;
	JButton getAverage;
	JButton brightnessHistogram;
	JButton redHistogram;
	JButton greenHistogram;
	JButton blueHistogram;


	JComboBox RedInput;
	JComboBox GreenInput;
	JComboBox BlueInput;

	static JLabel l;




	public static String Path;
	
	public static Color TEXTCOLOR = Color.BLACK;

	private static String Hexadecimal(int r, int g, int b, int output) {

		double r16 = r / 16.0;
		double g16 = g / 16.0;
		double b16 = b / 16.0;
		double Rd = r16 - ((int) r16);
		double Gd = g16 - ((int) g16);
		double Bd = b16 - ((int) b16);
		int Rl = (int) (Rd * 16);
		int Gl = (int) (Gd * 16);
		int Bl = (int) (Bd * 16);
		String letterR = Rl + "";
		String letterG = Gl + "";
		String letterB = Bl + "";
		if ((int) Rl == 10) {
			letterR = "A";
		} else if ((int) Rl == 11) {
			letterR = "B";
		} else if ((int) Rl == 12) {
			letterR = "C";
		} else if ((int) Rl == 13) {
			letterR = "D";
		} else if ((int) Rl == 14) {
			letterR = "E";
		} else if ((int) Rl == 15) {
			letterR = "F";
		}
		if ((int) Gl == 10) {
			letterG = "A";
		} else if ((int) Gl == 11) {
			letterG = "B";
		} else if ((int) Gl == 12) {
			letterG = "C";
		} else if ((int) Gl == 13) {
			letterG = "D";
		} else if ((int) Gl == 14) {
			letterG = "E";
		} else if ((int) Gl == 15) {
			letterG = "F";
		}
		if ((int) Bl == 10) {
			letterB = "A";
		} else if ((int) Bl == 11) {
			letterB = "B";
		} else if ((int) Bl == 12) {
			letterB = "C";
		} else if ((int) Bl == 13) {
			letterB = "D";
		} else if ((int) Bl == 14) {
			letterB = "E";
		} else if ((int) Bl == 15) {
			letterB = "F";
		}
		String firstR = (int) r16 + "";
		String firstG = (int) g16 + "";
		String firstB = (int) b16 + "";
		if ((int) r16 == 10) {
			firstR = "A";
		} else if ((int) r16 == 11) {
			firstR = "B";
		} else if ((int) r16 == 12) {
			firstR = "C";
		} else if ((int) r16 == 13) {
			firstR = "D";
		} else if ((int) r16 == 14) {
			firstR = "E";
		} else if ((int) r16 == 15) {
			firstR = "F";
		}
		if ((int) g16 == 10) {
			firstG = "A";
		} else if ((int) g16 == 11) {
			firstG = "B";
		} else if ((int) g16 == 12) {
			firstG = "C";
		} else if ((int) g16 == 13) {
			firstG = "D";
		} else if ((int) g16 == 14) {
			firstG = "E";
		} else if ((int) g16 == 15) {
			firstG = "F";
		}
		if ((int) b16 == 10) {
			firstB = "A";
		} else if ((int) b16 == 11) {
			firstB = "B";
		} else if ((int) b16 == 12) {
			firstB = "C";
		} else if ((int) b16 == 13) {
			firstB = "D";
		} else if ((int) b16 == 14) {
			firstB = "E";
		} else if ((int) b16 == 15) {
			firstB = "F";
		}

		double smallR = r / 255.0;
		double smallG = g / 255.0;
		double smallB = b / 255.0;

		double max = Math.max(smallR, Math.max(smallG, smallB));
		double min = Math.min(smallR, Math.min(smallG, smallB));

		double avg = (smallR + smallG + smallB) / 3.0;
		double brightness = (avg * 100);
		
		if (brightness > 50) {
			TEXTCOLOR = Color.BLACK;
		} else {
			TEXTCOLOR = Color.WHITE;
		}
		
		if (output == 1) {
			return (firstR + "" + letterR + "" + firstG + "" + letterG + "" + firstB + "" + letterB);
		} else if (output == 2) {
			return ("" + brightness);
		} else if (output == 3) {
			return ("\\u001B[38;2" + Integer.toString(r) + ";" + Integer.toString(g) + ";" + Integer.toString(b) + "m");
		} else {
			return null;
		}

	}

	public RGBconverterGUI() {
		frame = new JFrame("RGBconverterGUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(1000, 250));

		contentpane = new JPanel();
		contentpane.setLayout(new GridLayout(4, 4));

		imageUpload = new JPanel();
		imageUpload.setLayout(new BoxLayout(imageUpload, BoxLayout.X_AXIS));

		fileStuff = new JPanel();
		fileStuff.setLayout(new BoxLayout(fileStuff, BoxLayout.Y_AXIS));
		
		imageColorAverages = new JPanel();
		imageColorAverages.setLayout(new GridLayout(3, 3));


		RedLabel = new JLabel("Red value:");
		GreenLabel = new JLabel("Green value:");
		BlueLabel = new JLabel("Blue value:");
		
		RedLabel.setForeground(TEXTCOLOR);
		GreenLabel.setForeground(TEXTCOLOR);
		BlueLabel.setForeground(TEXTCOLOR);

		contentpane.add(RedLabel);
		contentpane.add(GreenLabel);
		contentpane.add(BlueLabel);

		String[] items = { "0", "255"};

		RedInput = new JComboBox(items);

		GreenInput = new JComboBox(items);

		BlueInput = new JComboBox(items);

		RedInput.setSelectedIndex(1);
		GreenInput.setSelectedIndex(1);
		BlueInput.setSelectedIndex(1);

		RedInput.setEditable(true);
		GreenInput.setEditable(true);
		BlueInput.setEditable(true);

		contentpane.add(RedInput);
		contentpane.add(GreenInput);
		contentpane.add(BlueInput);

		ConvertButton = new JButton("Convert");
		ConvertButton.setActionCommand("Convert");
		ConvertButton.addActionListener(this);
		contentpane.add(ConvertButton);

		HexadecimalLabel = new JLabel("");
		contentpane.add(HexadecimalLabel);

		BrightnessLabel = new JLabel("");
		contentpane.add(BrightnessLabel);

		ASCIILabel = new JLabel("");
		contentpane.add(ASCIILabel);

		
		JButton open = new JButton("open");

		filechooser f1 = new filechooser();

		open.addActionListener(f1);
		open.setAlignmentX(CENTER_ALIGNMENT);
		fileStuff.add(open);

		// imageColorAverages.add(Box.createVerticalGlue());
		
		averageR = new JLabel("R");
		averageG = new JLabel("G");
		averageB = new JLabel("B");

		imageColorAverages.add(new JLabel("Average R:"));
		imageColorAverages.add(new JLabel("Average G:"));
		imageColorAverages.add(new JLabel("Average B:"));

		imageColorAverages.add(averageR);
		imageColorAverages.add(averageG);
		imageColorAverages.add(averageB);

		getAverage = new JButton("No file selected yet");
		getAverage.setActionCommand("getInfo");
		getAverage.addActionListener(this);
		imageColorAverages.add(getAverage);

		refresh = new JLabel("No Data");
		imageColorAverages.add(refresh);

		brightnessHistogram = new JButton("Brightness Histogram");
		brightnessHistogram.setActionCommand("brightnessHist");
		brightnessHistogram.addActionListener(this);
		imageColorAverages.add(brightnessHistogram);

		redHistogram = new JButton("Red Histogram");
		redHistogram.setActionCommand("redHist");
		redHistogram.addActionListener(this);
		imageColorAverages.add(redHistogram);
		
		greenHistogram = new JButton("Green Histogram");
		greenHistogram.setActionCommand("greenHist");
		greenHistogram.addActionListener(this);
		imageColorAverages.add(greenHistogram);

		blueHistogram = new JButton("Blue Histogram");
		blueHistogram.setActionCommand("blueHist");
		blueHistogram.addActionListener(this);
		imageColorAverages.add(blueHistogram);


		l = new JLabel("No file Selected");
		l.setAlignmentX(CENTER_ALIGNMENT);
		fileStuff.add(l);
		// this is all of the stuff that has to do with the various JPanels... 
		// There is a lot of different stuff, because everything has to have a different layout and whatnot
		// Eventually what could be nice would be to add an organization chart, so that everything is understandable to other users
		// This might not be a useful comment anymore!
		// For now it doesn't matter though 
		imageUpload.add(fileStuff);
		imageUpload.add(Box.createHorizontalGlue());
		imageUpload.add(imageColorAverages);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(contentpane);
		mainPanel.add(imageUpload);

		frame.setContentPane(mainPanel);
		
		contentpane.setPreferredSize(new Dimension(750, 100));

		frame.pack();
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand();
		
		if (eventName.equals("Convert")) {
			String redString = (String) RedInput.getSelectedItem();
			String greenString = (String) GreenInput.getSelectedItem();
			String blueString = (String) BlueInput.getSelectedItem();
			
			
			
			int Red = Integer.parseInt(redString);
			int Green = Integer.parseInt(greenString);
			int Blue = Integer.parseInt(blueString);
			
			contentpane.setBackground(new Color(Red, Green, Blue));
			
			HexadecimalLabel.setText("Hexadecimal code: " + Hexadecimal(Red, Green, Blue, 1));
			BrightnessLabel.setText("Brightness: " + Hexadecimal(Red, Green, Blue, 2) + "%");
			ASCIILabel.setText("ASCII code: " + Hexadecimal(Red, Green, Blue, 3));
			
			RedLabel.setForeground(TEXTCOLOR);
			GreenLabel.setForeground(TEXTCOLOR);
			BlueLabel.setForeground(TEXTCOLOR);
			
			BrightnessLabel.setForeground(TEXTCOLOR);
			HexadecimalLabel.setForeground(TEXTCOLOR);
			ASCIILabel.setForeground(TEXTCOLOR);
		}

		if (eventName.equals("getInfo")){
			imageTools.getPixelColorAverage(Path); //Updating all the color values
			averageR.setText("" + imageTools.averageR);
			averageG.setText("" + imageTools.averageG);			
			averageB.setText("" + imageTools.averageB);
			System.out.println(imageTools.Brightness);

			refresh.setText("Data is up to date"); //Changing the up to date message

		}
		
		if (eventName.equals("brightnessHist")){
			imageTools.getPixelColorAverage(Path);
			new colorGraphMaker(imageTools.Brightness, "black");
		}
		if (eventName.equals("redHist")){
			imageTools.getPixelColorAverage(Path);
			new colorGraphMaker(imageTools.R, "red");
		}
		if (eventName.equals("greenHist")){
			imageTools.getPixelColorAverage(Path);
			new colorGraphMaker(imageTools.G, "green");
		}

		if (eventName.equals("blueHist")){
			imageTools.getPixelColorAverage(Path);
			new colorGraphMaker(imageTools.B, "blue");
		}

		
	}

	private static void runRGBconverterGUI() {
		JFrame.setDefaultLookAndFeelDecorated(false);
		RGBconverterGUI run = new RGBconverterGUI();
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				runRGBconverterGUI();
			}
		});

	}

}
