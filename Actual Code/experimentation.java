public class experimentation{
    public static void main(String[] args){
        System.out.println("Values Concerning BLLUE");
        imageTools.getPixelColorAverage("/media/marco/PRINTING/ColorTool/ExampleColors/BLUE.png");
        System.out.println(imageTools.averageR);
        System.out.println(imageTools.averageG);
        System.out.println(imageTools.averageB);

        System.out.println("Values Concerning RED");
        imageTools.getPixelColorAverage("/media/marco/PRINTING/ColorTool/ExampleColors/GREEN.png");
        System.out.println(imageTools.averageR);
        System.out.println(imageTools.averageG);
        System.out.println(imageTools.averageB);

        System.out.println("Values Concerning YELLOW");
        imageTools.getPixelColorAverage("/media/marco/PRINTING/ColorTool/ExampleColors/YELLOW.png");
        System.out.println(imageTools.averageR);
        System.out.println(imageTools.averageG);
        System.out.println(imageTools.averageB);
    }
    }