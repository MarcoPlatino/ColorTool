// call this method by doing this:
// List<integer> myData = ...;
// new graphMaker(myData);


import javax.swing.JFrame;
import java.awt.*;
import java.util.List;
import java.util.Arrays;
//The Graphs open in a new window...

public class graphMaker extends JFrame {
    private List<Integer> data;

    public graphMaker(List<Integer> data) {
        this.data = data;
        this.setPreferredSize(new Dimension(510, 400));
        this.setTitle(RGBconverterGUI.Path);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // private int[] computeHistogram(List<Integer> data, int binCount){
    //     int[] histogram = new int[binCount];
    //     for (int value : data) {
    //         int bin = (int) ((value / 256.0) * binCount);
    //         if (bin == binCount) bin = binCount - 1;
    //         histogram[bin] ++;
    //     }
    //     return histogram;
    // }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (data == null || data.isEmpty()) return;

        // g.setColor(Color.ORANGE);        

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
