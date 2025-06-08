import javax.swing.JFrame;
import java.awt.*;
import java.util.List;
import java.util.Arrays;

public class colorGraphMaker extends JFrame {
    private List<Integer> data;
    private String color;

    public colorGraphMaker(List<Integer> data, String color) {
        this.color = color;
        this.data = data;
        this.setPreferredSize(new Dimension(510, 400));
        this.setTitle(RGBconverterGUI.Path);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (data == null || data.isEmpty()) return;

        switch (color) {
            case "red": g.setColor(Color.RED); break;
            case "green": g.setColor(Color.GREEN); break;
            case "blue": g.setColor(Color.BLUE); break;  
            default: g.setColor(Color.BLACK); break;
        }

        int height = getHeight();
        int width = getWidth();
        int bins = 256;
        int[] histogram = new int[bins];

        for (int value : data){
            if (value >= 0 && value < bins){
                histogram[value]++;
            }
        }
        int maxCount = 1;
        for (int count: histogram){
            if (count > maxCount) maxCount = count;
        }

        for (int i = 0; i < bins; i++){
            int x = i * width / bins;
            int barHeight = (int)((histogram[i] / (double)maxCount) * (height - 20));
            int y = height - 10 - barHeight;
            // g.drawLine(x, y, x, y);
            g.fillRect(x, y, 4, height-y);
        }
        
            }

    public static void main(String[] args) {
        //In here are a few demo, so when you run just this file you can see some examples
        //You will definetely have to change the paths, but for now it is fine
        List<Integer> sampleData = imageTools.getBrightness("/media/marco/PRINTING/ColorTool/ExampleColors/Correct-Exposure.jpg");
        new graphMaker(sampleData);
        List<Integer> sampleData2 = imageTools.getBrightness("/media/marco/PRINTING/ColorTool/ExampleColors/Overexposure.jpg");
        new graphMaker(sampleData2);
        List<Integer> sampleData3 = imageTools.getBrightness("/media/marco/PRINTING/ColorTool/ExampleColors/Underexposure.jpg");
        new graphMaker(sampleData3);


    }
}
