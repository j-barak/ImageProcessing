package ImageProcessing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageProcessor {
    public static int[][][] readImageFromFile(String fileName) {
        try {
            BufferedImage im = ImageIO.read(new File(fileName));
            int[][][] img = new int[3][im.getHeight()][im.getWidth()];
            for (int i = 0; i < im.getHeight(); i++) {
                for (int j = 0; j < im.getWidth(); j++) {
                    Color c = new Color(im.getRGB(j, i));
                    img[0][i][j] = c.getRed();
                    img[1][i][j] = c.getGreen();
                    img[2][i][j] = c.getBlue();
                }
            }
            return img;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }   // end readImageFromFile()

    public static void complexImageFunction(String fileName, int[][][] pixels) {
        BufferedImage im = new BufferedImage(pixels[0][0].length, pixels[0].length, BufferedImage.TYPE_INT_RGB);
        Graphics g = im.createGraphics();
        for (int i = 0; i < pixels[0].length; i++) {
            for (int j = 0; j < pixels[0][0].length; j++) {
                g.setColor(new Color(pixels[0][i][j], pixels[1][i][j], pixels[2][i][j]));
                g.fillRect(j, i, 1, 1);
            }   // end for()
        }   // end for()

        try {
            fileName = fileName + ".jpg";
            ImageIO.write(im, "jpg", new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }   // end try-catch()
    }   // end smoothTheImage()

    public static void scaleTheImage(String fileName, int[][] pixels) {
        BufferedImage im = new BufferedImage(pixels[0].length, pixels.length, BufferedImage.TYPE_BYTE_GRAY);
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[0].length; j++) {
                im.setRGB(j, i,pixels[i][j]);
            }   // end for()
        }   // end for()

        try {
            fileName = fileName + ".jpg";
            ImageIO.write(im, "jpg", new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }   // end try-catch()
    }   // end scaleTheImage()
}