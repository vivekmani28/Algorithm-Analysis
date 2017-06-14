import java.util.Scanner;

public class MatrixMultiplication_Recursive {
	public static int callCount=0;
	public static int mulplicationCount=0;

	public static int calculateMulplicationCnt ( int[] dimensions, int start, int end){
		callCount++;
		if(start == end)
			return 0;
		
		int mulplicationCnt = Integer.MAX_VALUE;
		
		for( int i = start; i<end; i++){
			int tempCnt = calculateMulplicationCnt(dimensions,start,i) + calculateMulplicationCnt(dimensions, i+1, end) 
										+  dimensions[start-1]*dimensions[i]*dimensions[end];
			mulplicationCount+=2;
			if(tempCnt < mulplicationCnt)
				mulplicationCnt = tempCnt;
		}
		return mulplicationCnt;
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
        int result = calculateMulplicationCnt(dimensions ,1, dimensions.length-1);
        long endTime = System.nanoTime();
        System.out.println("Minimum number of scalar multiplications required for mulplipying "+matrixCnt + " matrices of given dimensions :" + result );
        System.out.println("Program completed in "+ (endTime - startTime) +"ns.");
        System.out.println("Total number of recursive calls "+ --callCount);
        System.out.println("Total number of muplications done by the algorithm "+ mulplicationCount);


        
	}
}
