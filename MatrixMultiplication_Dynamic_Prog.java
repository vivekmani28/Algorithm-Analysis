import java.util.Scanner;

public class MatrixMultiplication_Dynamic_Prog {
	public static int callCount=0;
	public static int mulplicationCount=0;

		public static int calculateMulplicationCnt ( int[] dimensions, int length){
			callCount++;
			int temp, temp1;
			int countArray[][] = new int[length][length];
			
			for(int i=1 ; i<length ; i++)
				countArray[i][i] = 0;
			
			for(int i=2;i<length; i++){
				for(int j=1; j< (length -i +1) ; j++){
					temp = i+j-1;
					if(temp == length)
						continue;
					countArray[j][temp] = Integer.MAX_VALUE;
					for( int k=j ; k<= temp-1; k++){
						temp1 = countArray[j][k] + countArray[k+1][temp] + dimensions[j-1]*dimensions[k]*dimensions[temp];
						mulplicationCount+=2;
						if(countArray[j][temp] > temp1)
							countArray[j][temp] = temp1;
					}
				}
			}
			return countArray[1][length-1];
		}

	 
		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			System.out.println("Enter the number of matrices");
	        int matrixCnt = in.nextInt();
	        int[] dimensions = new int[matrixCnt+1];
			System.out.println("Enter the dimensions for the "+matrixCnt+ " matrices");

	        for(int i=0; i < dimensions.length;i++)
	        	dimensions[i] = in.nextInt();
	        long startTime = System.nanoTime();
	        int result = calculateMulplicationCnt(dimensions , dimensions.length);
	        long endTime = System.nanoTime();
	        System.out.println("Minimum number of scalar multiplications required for mulplipying "+matrixCnt + " matrices of given dimensions :" + result );
	        System.out.println("Program completed in "+ (endTime - startTime) +"ns.");
	        System.out.println("Total number of recursive calls "+ --callCount);
	        System.out.println("Total number of muplications done by the algorithm "+ mulplicationCount);


		}
}
