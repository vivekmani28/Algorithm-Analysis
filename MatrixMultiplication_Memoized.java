import java.util.Scanner;

public class MatrixMultiplication_Memoized {
	public static int callCount=0;
	public static int mulplicationCount=0;

	public static int calculateMulplicationCnt ( int[] dimensions){
		int length = dimensions.length;
		int countArray[][] = new int[length][length];
		
		for(int i=1 ; i<length ; i++)	
			for(int j=1 ; j<length ; j++)
				countArray[i][j] = Integer.MAX_VALUE;
		
		return findMultiplyCnt(dimensions,1,length-1,countArray);
	}

 
	public static int findMultiplyCnt(int[] dimensions, int i, int j, int[][] countArray) {
		callCount++;
		if(countArray[i][j] < Integer.MAX_VALUE)
			return countArray[i][j];
		if(i == j)
			countArray[i][i] = 0;
		else{
			for(int a =i ; a < j ; a++){
				int temp = findMultiplyCnt(dimensions,i,a,countArray) + findMultiplyCnt(dimensions,a+1,j,countArray) 
								+ dimensions[i-1] * dimensions[a] * dimensions[j];
				mulplicationCount+=2;
				if(temp < countArray[i][j])
					countArray[i][j] = temp;
			}
		}
		return  countArray[i][j];
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
        int result = calculateMulplicationCnt(dimensions);
        long endTime = System.nanoTime();
        System.out.println("Minimum number of scalar multiplications required for mulplipying "+matrixCnt + " matrices of given dimensions :" + result );
        System.out.println("Program completed in "+ (endTime - startTime) +"ns.");
        System.out.println("Total number of recursive calls "+ --callCount);
        System.out.println("Total number of muplications done by the algorithm "+ mulplicationCount);

        
	}
}
