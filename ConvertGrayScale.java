// package com.memorynotfound.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ConvertGrayScale {

    public static void toTxt(BufferedImage result, int rgb) {
        int count = 0;
        int value = 0;
        for (int i = 0; i < result.getHeight(); i++) { // Y
            for (int j = result.getWidth() - 1; j >= 0; j--) { // X
                Color c = new Color(result.getRGB(i, j));
                if (rgb == 0)
                    value = c.getRed();
                else if (rgb == 1)
                    value = c.getGreen();
                else if (rgb == 2)
                    value = c.getBlue();
                count++;
                System.out.print(value);
                if (count < result.getHeight() * result.getWidth())
                    System.out.print(", ");
            }
        }
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

    public static void main(String... args) {
        if (!args[0].isEmpty()) {
            String pathname = args[0];
            File input = new File(pathname);
            try {
                BufferedImage image = ImageIO.read(input);
                toTxt(image, 1);
            } catch (IOException e) {
            }
        }
    }

}