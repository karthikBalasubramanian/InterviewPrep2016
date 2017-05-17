package com.tutorials.dynamic;

public class MaximalSquare {

	public int maximalSquare(char[][] matrix) {

		int[][] computeMatrix = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < computeMatrix.length; i++) {
			 computeMatrix[i][0] = Integer.parseInt(String.valueOf(matrix[i][0]));
		}
		for (int j=0; j<computeMatrix[0].length; j++){
			computeMatrix[0][j] = Integer.parseInt(String.valueOf(matrix[0][j]));
		}
		
		for (int i=1; i<computeMatrix.length; i++){
			for(int j=1; j<computeMatrix[0].length; j++){
				if(Integer.parseInt(String.valueOf(matrix[i][j]))==1){
					computeMatrix[i][j] = Math.min(computeMatrix[i-1][j-1], Math.min(computeMatrix[i-1][j], computeMatrix[i][j-1]))+1;
				}
				else{
					computeMatrix[i][j] = 0;
				}
			}
		}
		int maximalSquare = Integer.MIN_VALUE;
		for(int i=0; i<computeMatrix.length;i++)
			for(int j=0;j<computeMatrix[0].length;j++){
				maximalSquare = Math.max(maximalSquare, computeMatrix[i][j]);
			}

		return maximalSquare*maximalSquare;
	}

	public static void main(String[] args) {
		char a = '1';
		System.out.println();
	}
}
