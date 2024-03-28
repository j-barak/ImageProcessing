package ImageProcessing;

public class Functions {
    public static int[][][] rotateImage(int[][][] img) {
        int height = img[0].length, width = img[0][0].length;
        int[][][] rotateImage = new int[3][width][height];
        for (int k = 0; k < 3; k++) {
            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {
                    rotateImage[k][col][height - row - 1] = img[k][row][col];
                }
            }
        }
        return rotateImage;
    }

    public static int[][][] smoothImage(int[][][] img, int n) {
        int height = img[0].length, width = img[0][0].length;
        int[][][] smoothImage = new int[3][height][width];
        smoothImage[0] = gaussBlur(img[0],n);
        smoothImage[1] = gaussBlur(img[1],n);
        smoothImage[2] = gaussBlur(img[2],n);
        return smoothImage;
    }

    public static int[][] rgb2gray(int[][][] img) {
        int height = img[0].length, width = img[0][0].length;
        int[][] grayImage = new int[height][width];

        for(int i = 0; i < height; i++)
            for(int j = 0; j < width; j++)
                grayImage[i][j] = ((int) Math.floor((((double)img[0][i][j]) * 0.3) + (((double)img[1][i][j]) * 0.59) + (((double)img[2][i][j])) * 0.11)) * 255 ;

        return grayImage;
    }

    // helper function(Gauss filter):
    public static int[][] gaussBlur(int[][] img, int n) {
        int height = img.length, width = img[0].length;
        int[][] blurred = new int[height][width];
        for(int row = 0; row < height; row++) {
            for(int col = 0; col < width; col++) {
                double avg = 0;
                double counter = 0;
                for(int i = row - n; i <= row + n; i++) {
                    for(int j = col - n; j <= col + n; j++) {
                        if((i >= 0 && j >= 0) && (i < height && j < width)) {
                            avg += img[i][j];
                            counter++;
                        }
                    }
                }
                blurred[row][col] = (int) Math.ceil(avg / counter);
            }
        }
        return blurred;
    }

    public static int[][] scaleImg(double h_factor, double w_factor, int[][] img) {
        int height = (int)(img.length * h_factor), width = (int)(img[0].length * w_factor);
        int[][] scaledImage = new int[height][width];

        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                //scaledImage[i][j] = img[(int) (i / h_factor)][(int) (j / w_factor)];
                int original_i = (int) (i / h_factor);
                int original_j = (int) (j / w_factor);
                scaledImage[i][j] = img[original_i][original_j];
            }
        }
        return scaledImage;
    }
}