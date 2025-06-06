// Short Note:
// This file is for just messing around to make sure that everything works
// It is ok to change it or delete all the content and replace it with something else.
// If it is not, just add a comment at the top to indicate that preserving the content of the file
// Is important to somethant that you are working on.

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