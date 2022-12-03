import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class test {

    public static int[][] loadPixelsFromFile(File file) throws IOException {

        BufferedImage image = ImageIO.read(file);
        Color[][] colors = new Color[image.getWidth()][image.getHeight()];
        int[][] grayscale = new int[image.getWidth()][image.getHeight()];

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int color = image.getRGB(x, y);
                int blue = color & 0xff;
                int green = (color & 0xff00) >> 8;
                int red = (color & 0xff000) >> 16;
                grayscale[x][y] = (int) Math.round(.2126 * red + .7152 * green + .0722 * blue);
                colors[x][y] = new Color(image.getRGB(x, y));
            }
        }

        return grayscale;
    }

    public static void main(String[] args) throws IOException {
        int[][] colors = loadPixelsFromFile(new File("pink.jpg"));
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[i].length; j++) {
                System.out.println(colors[i][j]);
            }
        }
    }
}