public class experimentation{
    public static void main(String[] args){
        System.out.println("Values Concerning BLLUE");
        imageTools.getPixelColorAverage("/workspaces/ColorTool/ExampleColors/BLUE.png");
        System.out.println(imageTools.averageR);
        System.out.println(imageTools.averageG);
        System.out.println(imageTools.averageB);

        System.out.println("Values Concerning RED");
        imageTools.getPixelColorAverage("/workspaces/ColorTool/ExampleColors/RED.png");
        System.out.println(imageTools.averageR);
        System.out.println(imageTools.averageG);
        System.out.println(imageTools.averageB);

        System.out.println("Values Concerning YELLOW");
        imageTools.getPixelColorAverage("/workspaces/ColorTool/ExampleColors/YEllOW.png");
        System.out.println(imageTools.averageR);
        System.out.println(imageTools.averageG);
        System.out.println(imageTools.averageB);
    }
    }