import java.util.*;
class RotateImage{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the number of rows: ");
		int rows = sc.nextInt();
		System.out.println("Please enter the number of columns: ");
		int cols = sc.nextInt();
		System.out.println("Please enter elements of the image: ");
		int[][] image = new int[rows][cols]; 
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				image[i][j] = sc.nextInt();
			}
		}
		System.out.println("The elements of the image are: ");
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				System.out.print(image[i][j] + " ");
			}
			System.out.println();
		}
		RotateImage ri = new RotateImage();
		image = ri.rotateImage(image);
		System.out.println("The elements of the rotated image are: ");
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				System.out.print(image[i][j] + " ");
			}
			System.out.println();
		}
	}
	private int[][] rotateImage(int[][] input){
		if(input != null){
			for(int i = 0; i < input.length; i++){
				for(int j = i; j < input[0].length; j++){
					int temp = input[i][j];
					input[i][j] = input[j][i];
					input[j][i] = temp;
				}
			}
			for(int i = 0; i < input.length; i++){
				for(int j = 0; j < input[0].length/2; j++){
					int temp = input[i][j];
					input[i][j] = input[i][input[0].length - j - 1];
					input[i][input[0].length - j - 1] = temp;
				}
			}
		}
		return input;
	}
}