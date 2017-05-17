package com.tutorials.dynamic;

public class AllWaterProblems {

	public int maxArea(int[] height) {

		int left = 0;
		int right = height.length - 1;
		int maxArea = Integer.MIN_VALUE;
		while (left < right) {
			maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));

			if (height[left] <= height[right]) {
				left++;
			} else {
				right--;
			}

		}
		return maxArea;

	}

	public int trap(int[] height) {
		
		if (height.length<3){
			return 0;
		}
		int[] leftSideTallest = new int[height.length];
		
		int tallest = height[0];
		for(int i=1;i<leftSideTallest.length-1;i++){
			tallest = Math.max(tallest, height[i-1]);
			leftSideTallest[i] = tallest;
		}
		
		int howMuchWaterTrapped = 0;
		tallest =  height[height.length-1];
		for(int j=leftSideTallest.length-2; j>0;j--){
			tallest = Math.max(tallest, height[j+1]);
			int waterTrapped = (Math.min(tallest, leftSideTallest[j])-height[j]);
			if (waterTrapped>0){
			howMuchWaterTrapped+=waterTrapped ;
			}
		}
		
		
		return howMuchWaterTrapped;
	}

	public static void main(String[] args) {
		int[] array = { 2, 1, 3, 4, 1, 6 };
		AllWaterProblems obj = new AllWaterProblems();
		System.out.println(obj.maxArea(array));
		System.out.println(obj.trap(array));
	}

}
