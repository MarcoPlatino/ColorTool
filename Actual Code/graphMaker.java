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
        this.setPreferredSize(new Dimension(400, 400));
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (data != null){
            for (int i = 0; i < data.size(); i++){
                int value = data.get(i);;
                int x = i;
                int y = 400 - value;
                g.drawLine(x, y, x, y);
            }
            }
            }

    public static void main(String[] args) {
        List<Integer> sampleData = Arrays.asList(10, 50, 100, 200, 350, 390);
        new graphMaker(sampleData);
    }
}
