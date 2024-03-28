package ImageProcessing;
import java.util.Scanner;
import java.io.File;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Input image path: ");
        String imagePath = sc.nextLine();
        System.out.print("Input image name and format: ");
        String imageName = sc.nextLine();

        File imageFile = new File(imagePath + File.separator + imageName);
        String validImage = (imageFile.exists()) ? imageFile.getAbsolutePath() : "INVALID!";

        int[][][] myImage = ImageProcessing.ImageProcessor.readImageFromFile(validImage);

        System.out.println("Do you want to rotate image 90 degrees?");
        String userInput = sc.nextLine();

        // image rotation by 90 degrees
        if(userInput.equalsIgnoreCase("yes")) {
            try {
                assert myImage != null;
                int[][][] rotate = ImageProcessing.Functions.rotateImage(myImage);
                ImageProcessing.ImageProcessor.complexImageFunction("image_rotate", rotate);
            } catch (Exception e) {
                System.out.println("Rotate Complete!");
                e.printStackTrace();
            }   // end try-catch()
        } else {
            System.out.println("Rotation by 90 degrees skipped.");
        }

        System.out.println("Do you want to smooth the image?");
        userInput = sc.nextLine();

        // image smoothing
        if(userInput.equalsIgnoreCase("yes")) {
            try {
                assert myImage != null;
                int[][][] smooth = ImageProcessing.Functions.smoothImage(myImage, 3);
                ImageProcessing.ImageProcessor.complexImageFunction("image_smooth", smooth);
            }  catch(Exception e) {
                System.out.println("Smooth Complete!");
                e.printStackTrace();
            }   // end try-catch()
        } else {
            System.out.println("Image smoothing skipped.");
        }

        System.out.println("Do you want convert the image to grayscale?");
        userInput = sc.nextLine();

        // grayscale conversion
        if(userInput.equalsIgnoreCase("yes")) {
            try {
                assert myImage != null;
                int[][] grayImage = ImageProcessing.Functions.rgb2gray(myImage);
                ImageProcessing.ImageProcessor.scaleTheImage("grayImage",grayImage);
            }  catch(Exception e) {
                System.out.println("rgb2gray");
                e.printStackTrace();
            }   // end try-catch()
        } else {
            System.out.println("Image smoothing skipped.");
        }

        System.out.print("Do you want to scale up or scale down the image? (up/down): ");
        userInput = sc.nextLine();

        try {
            int[][] grayImage = ImageProcessing.Functions.rgb2gray(myImage);
            if (userInput.equalsIgnoreCase("up")) {
                int[][] scaledUpImage = ImageProcessing.Functions.scaleImg(2.2, 1.4, grayImage);
                ImageProcessing.ImageProcessor.scaleTheImage("scaledUpImage", scaledUpImage);
            } else if (userInput.equalsIgnoreCase("down")) {
                int[][] scaledDownImage = ImageProcessing.Functions.scaleImg(0.8, 1.3, grayImage);
                ImageProcessing.ImageProcessor.scaleTheImage("scaledDownImage", scaledDownImage);
            } else {
                System.out.println("Invalid input. Please enter 'up' or 'down'.");
            }
        } catch (Exception e) {
            System.out.println("Error during image scaling:");
            e.printStackTrace();
        }
    }
}
