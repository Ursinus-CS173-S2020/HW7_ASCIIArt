package asciiart;


public class Drawing {
    /**
     * Use the Princeton algs4cs Picture library to draw
     * this as an RGB color image
     * 
     * @param r A 2D array of the red values between 0 and 0xFF
     * @param g A 2D array of the green values between 0 and 0xFF
     * @param b A 2D array of the blue values between 0 and 0xFF
     */
    public static void showPic(int[][] r, int[][] g, int[][] b) {
        int height = r.length;
        int width = r[0].length;
        Picture pic = new Picture(width, height);
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int rgb = r[row][col] << 16 | g[row][col] << 8 | b[row][col];
                pic.setRGB(col, row, rgb);
            }
        }
        pic.show();
    }
    
    public static void main(String[] args) {
        // Initialize the red, green, and blue channels
        int[][] r = new int[400][500];
        int[][] g = new int[400][500];
        int[][] b = new int[400][500];
        // Draw a vertical red rectangle
        for (int i = 20; i < 100; i++) {
            for (int j = 50; j < 80; j++) {
                r[i][j] = 0xFF;
            }
        }
        // Draw a horizontal blue rectangle
        for (int i = 50; i < 80; i++) {
            for (int j = 20; j < 100; j++) {
                b[i][j] = 0xFF;
            }
        }
        // Draw a gray diagonal
        int index = 0;
        while (index < r.length && index < r[0].length) {
            int value = index;
            if (value > 0xFF) {
                value = 0xFF;
            }
            r[index][index] = value;
            g[index][index] = value;
            b[index][index] = value;
            index++;
        }
        showPic(r, g, b);
    }
}
