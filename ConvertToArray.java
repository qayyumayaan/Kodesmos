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
        String currentPath = null;
        try{currentPath=new java.io.File(".").getCanonicalPath();} catch(IOException e){System.out.println("Something's wrong here");}
        
        String fullPath = currentPath+path;
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(fullPath));
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

    public static String toTxt(BufferedImage result, int rgb) {
        int count = 0;
        int value = 0;
        String toReturn = "";
        for (int i = 0; i < result.getHeight(); i++) { // Y
            for (int j = result.getWidth() - 1; j >= 0; j--) { // X
                Color c = new Color(256-result.getRGB(i, j));
                if (rgb == 0)
                    value = c.getRed();
                else if (rgb == 1)
                    value = c.getGreen();
                else if (rgb == 2)
                    value = c.getBlue();
                count++;
                toReturn+=value;
                System.out.print(value);
                if (count < result.getHeight() * result.getWidth())
                    toReturn+=", ";
            }
        }
        return toReturn; 
        
    }

    public static BufferedImage toGrayScaleInt(BufferedImage image) {

        BufferedImage result = new BufferedImage(
                image.getWidth(),
                image.getHeight(),
                BufferedImage.TYPE_INT_RGB);

        try {
            // BufferedImage result = new BufferedImage(
            // image.getWidth(),
            // image.getHeight(),
            // BufferedImage.TYPE_INT_RGB);

            Graphics2D graphic = result.createGraphics();
            graphic.drawImage(image, 0, 0, Color.WHITE, null);

            for (int i = result.getHeight() - 1; i >= 0; i--) {
                for (int j = result.getWidth() - 1; j >= 0; j--) {
                    Color c = new Color(result.getRGB(j, i));
                    int red = (int) (c.getRed() * 0.299);
                    int green = (int) (c.getGreen() * 0.587);
                    int blue = (int) (c.getBlue() * 0.114);
                    Color newColor = new Color(
                            red + green + blue,
                            red + green + blue,
                            red + green + blue);
                    result.setRGB(j, i, newColor.getRGB());
                }
            }

            File output = new File("testImg.jpg");
            ImageIO.write(result, "jpg", output);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String imageToTxtGrayScale(String fileName, int size,int rgbChannel){
        BufferedImage unaugmentedImage = importImage(fileName);

        BufferedImage resizedImage = toGrayScaleInt(scaleTo(unaugmentedImage,size,size));

        return toTxt(resizedImage, rgbChannel);

    }
    public static String imageToTxt(String fileName, int size,int rgbChannel){
        BufferedImage unaugmentedImage = importImage(fileName);

        BufferedImage resizedImage = scaleTo(unaugmentedImage,size,size);

        return toTxt(resizedImage, rgbChannel);

    }

    public static void makeFrame(String fileName){
        System.out.print("Clipboard = b_0 = 0.00390625 * [");
        System.out.println(imageToTxt(fileName, 31, 0)+"]");

        System.out.println("Send, ^v \nSleep, 100 \nSend, {Enter}");

        System.out.print("Clipboard = b_1 = 0.00390625 * ");
        System.out.println(imageToTxt(fileName, 31, 1));
        System.out.println("Send, ^v \nSleep, 100 \nSend, {Enter}");


        System.out.print("Clipboard = b_1 = 0.00390625 * ");
        System.out.println(imageToTxt(fileName, 31, 2));
        System.out.println("Send, ^v \nSleep, 100 \nSend, {Enter}");

    }
    public static void main(String[] args){
   

        makeFrame("mario0.png");
    }
}