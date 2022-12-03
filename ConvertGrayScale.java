// package com.memorynotfound.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ConvertGrayScale {

    public static void main(String... args) {

        try {
            String pathname = args[0];
            File input = new File(pathname);
            BufferedImage image = ImageIO.read(input);

            BufferedImage result = new BufferedImage(
                    image.getWidth(),
                    image.getHeight(),
                    BufferedImage.TYPE_INT_RGB);

            Graphics2D graphic = result.createGraphics();
            graphic.drawImage(image, 0, 0, Color.WHITE, null);

            for (int i = 0; i < result.getHeight(); i++) {
                for (int j = 0; j < result.getWidth(); j++) {
                    Color c = new Color(result.getRGB(j, i));
                    int red = (int) (c.getRed() * 0.299);
                    int green = (int) (c.getGreen() * 0.587);
                    int blue = (int) (c.getBlue() * 0.114);
                    Color newColor = new Color(
                            red + green + blue,
                            red + green + blue,
                            red + green + blue);
                    result.setRGB(j, i, newColor.getRGB());
                    int grayscaleBlue = result.getRGB(j, i) & 0xff;
                    System.out.print(grayscaleBlue);
                    if ((i + 1) * (j + 1) < result.getWidth() * result.getHeight()) 
                        System.out.print(", ");
                }
            }

            File output = new File("testImg.jpg");
            ImageIO.write(result, "jpg", output);

        }  catch (IOException e) {
            e.printStackTrace();
        }

    }

}