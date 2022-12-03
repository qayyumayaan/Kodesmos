import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;


class ConvertToArray{
    public static BufferedImage importImage(String path){
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return img;
    }
    public static BufferedImage scaleTo(BufferedImage originalImage, int targetWidth, int targetHeight){
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
        return outputImage;
    }

    public static void printImage(BufferedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();
        System.out.println("width, height: " + w + ", " + h);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.println("x,y: " + j + ", " + i);
                int pixel = image.getRGB(j, i);
                printPixelARGB(pixel);/*www . j a  va  2s.  c  om*/
                System.out.println("");
            }
        }
    }

    public static void printPixelARGB(int pixel) {
        int alpha = (pixel >> 24) & 0xff;
        int red = (pixel >> 16) & 0xff;
        int green = (pixel >> 8) & 0xff;
        int blue = (pixel) & 0xff;
        System.out.println("argb: " + alpha + ", " + red + ", " + green+ ", " + blue);
    }

    public static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight){
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
        return outputImage;
    }

    public static void exportToFile(BufferedImage img, String name){
        File outputfile = new File(name+".jpg");
        try{
            ImageIO.write(img, "jpg", outputfile);
        }
        catch(IOException e){
            System.out.println("Seems something went wrong there");
        }
    }
    public static void main(String[] args){
        String currentPath = null;
        try{currentPath=new java.io.File(".").getCanonicalPath();} catch(IOException e){System.out.println("Something's wrong here");}
        
        String fullPath = currentPath+"\\Mario-Star-black.jpg";

        BufferedImage unaugmentedImage = importImage(fullPath);

        BufferedImage resizedImage = scaleTo(unaugmentedImage,21,21);

        printImage(resizedImage);

        exportToFile(resizedImage,"someFile");
    }
}