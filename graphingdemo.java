import javax.swing.JFrame;
import java.awt.*;

public class graphingdemo extends JFrame {

    public graphingdemo() {
        this.setPreferredSize(new Dimension(400, 400));
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int locX = 0;
        int locY = 0;
        // define the position
        for (int i = 0; i < 400; i ++){
            locX = i;
            locY = i;
            g.drawLine(locX, locY, locX, locY); 

    }
    }

    public static void main(String[] args) {
        graphingdemo run = new graphingdemo(); 
    }
}
