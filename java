public class Main {
   public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       if (image[sr][sc] == color) return image; 
       fill(image, sr, sc, image[sr][sc], color);
       return image;
   }
   private void fill(int[][] image, int i, int j, int originalColor, int newColor) {
       if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != originalColor)
           return;

       image[i][j] = newColor;

       fill(image, i + 1, j, originalColor, newColor);
       fill(image, i - 1, j, originalColor, newColor);
       fill(image, i, j + 1, originalColor, newColor);
       fill(image, i, j - 1, originalColor, newColor);
   }
  
   public static void main(String[] args) {
       Main floodFill = new Main();
       int[][] image = {{1,1,1},
                        {1,1,0},
                        {1,0,1}};
       int sr = 1, sc = 1, color = 2;
       int[][] result = floodFill.floodFill(image, sr, sc, color);
       for (int[] row : result) {
           for (int pixel : row) {
               System.out.print(pixel + " ");
           }
           System.out.println();
       }
   }
}
