package com.interview.search;

public class BinarySearch {

	public int sortedArrayToBinarySearch(int[] nums, int valueToSearch) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			// int mid = (start + end)/2;
			// or to avoid integer overflow by not calculating high + low.
			int mid = start + (end - start) / 2;
			if (nums[mid] == valueToSearch) {
				return mid;
			} else if (valueToSearch < nums[mid]) {
				end = mid - 1;
			} else if (valueToSearch > nums[mid]) {
				start = mid + 1;
			}
		}
		return -1;
	}

	public int recursiveSearch(int value, int[] nums, int low, int high) {
		// base case
		if (low > high) {
			return -1;
		}
		int mid = low + (high - low) / 2;
		if (nums[mid] == value) {
			return mid;
		} else if (nums[mid] > value) {
			return recursiveSearch(value, nums, low, mid - 1);
		} else {
			return recursiveSearch(value, nums, mid + 1, high);
		}
	}

	public int sortedArrayToRecursiveBinarySearch(int[] nums, int valueToSearch) {
		int low = 0;
		int high = nums.length - 1;
		return recursiveSearch(valueToSearch, nums, low, high);
	}

	public int findLeftMostOrRightMostElement(int[] nums, int valueToSearch, int low, int high, int result,
			boolean leftMostFlag) {

		if (low > high) {
			return result;
		}
		int mid = low + (high - low) / 2;
		if (nums[mid] == valueToSearch) {
			result = mid;
			if (leftMostFlag) {
				return findLeftMostOrRightMostElement(nums, valueToSearch, low, mid - 1, result, leftMostFlag);
			} else {
				return findLeftMostOrRightMostElement(nums, valueToSearch, mid + 1, high, result, leftMostFlag);
			}
		} else if (nums[mid] > valueToSearch) {
			return findLeftMostOrRightMostElement(nums, valueToSearch, low, mid - 1, result, leftMostFlag);
		} else {
			return findLeftMostOrRightMostElement(nums, valueToSearch, mid + 1, high, result, leftMostFlag);
		}

	}

	public int findTotalOccurancesOfElementInArray(int nums[], int valueToCount) {
		int high = nums.length - 1;
		int low = 0;
		int result = -1;
		int lowestIndex = findLeftMostOrRightMostElement(nums, valueToCount, low, high, result, true);
		if (lowestIndex == -1) {
			System.out.println("sorry no element found");
			return -1;
		} else {
			int rightMostOccurence = findLeftMostOrRightMostElement(nums, valueToCount, low, high, result, false);
			System.out.println("total number of occurences " + (rightMostOccurence - lowestIndex + 1));
			return (rightMostOccurence - lowestIndex + 1);
		}

	}

	// public int findPeakElement(int[] nums,int low, int high){
	//
	// if (low>high){
	// return -1;
	// }
	// int mid = low + (high - low)/2;
	// if (nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
	// return mid;
	// }else {
	// return Math.max(findPeakElement(nums,low,mid-1),
	// findPeakElement(nums,mid+1,high));
	// }
	// }

	// public int findMin(int[] nums) {
	//
	// int low = 0;
	// int high = nums.length - 1;
	// int n = nums.length;
	//
	// while (low <= high) {
	// if (nums[low] < nums[high]) {
	// return low;
	// }
	//
	// int mid = low + (high - low) / 2;
	// int next_to_mid = (mid + 1) % n;
	// int prev_to_mid = (mid + n - 1) % n;
	//
	// if (nums[mid] < nums[next_to_mid] && nums[mid] < nums[prev_to_mid]) {
	// return mid;
	// } else if (nums[mid] < nums[high]) {
	// high = mid - 1;
	// } else if (nums[low] < nums[mid]) {
	// low = mid + 1;
	// }
	// }
	//
	// return -1;
	//
	// }

	public int findMinimum(int[] nums, int low, int high, int totalLength) {

		// # already sorted condition
		if (nums[low] < nums[high]) {
			return nums[low];
		}
		// only one element
		if (low == high) {
			return nums[low];
		}

		int mid = low + (high - low) / 2;
		int next_to_mid = (mid + 1) % (totalLength);
		int prev_to_mid = (mid + totalLength - 1) % (totalLength);
		if (nums[mid] < nums[prev_to_mid] && nums[mid] < nums[next_to_mid]) {
			return nums[mid];
		} else if (nums[mid] < nums[high]) {
			return findMinimum(nums, low, mid - 1, totalLength);
		} else {
			return findMinimum(nums, mid + 1, high, totalLength);
		}

	}

	public int findMin(int[] nums) {

		return findMinimum(nums, 0, nums.length - 1, nums.length);

	}
	
	public int findElementInCircularArray(int[] nums, int findNum, int low, int high) {

		while (low <= high) {
			int mid = low + (high - low) / 2;
			// case 1 if number is mid
			if (nums[mid] == findNum) {
				return mid;
			}
			// if mid is less than high?
			else if (nums[mid] <= nums[high]) {
				// if the number between mid and high?
				if (findNum > nums[mid] && findNum <= nums[high]) {
					// search in the sorted half
					low = mid + 1;

				} else {
					// else search in the unsorted half (may or may not be
					// unsorted half.
					high = mid - 1;

				}
			}
			// if low is less than mid?
			else if (nums[low] <= nums[mid]) {

				// if the x is between low and mid?
				if (findNum >= nums[low] && findNum < nums[mid]) {
					// search in the sorted half
					high = mid - 1;

				} else {
					// else search in the unsorted half
					low = mid + 1;
				}
			}
		}
		return -1;
	}

	public void moveZeroes(int[] nums) {
    
//		for(int i=0; i<nums.length; i++){
//			for(int j=i+1; j<nums.length; j++){
//				if (nums[i]==0 && nums[j]!=0){
//					int temp =  nums[j];
//					nums[j]=nums[i];
//					nums[i] = temp;
//					
//				}
//			}
//		}
		
//		also be implemented as
		
		int i = 0;
		for(int j=0; j<nums.length; j++){
			if(nums[j]!=0){
				int temp = nums[i];
				nums[i]= nums[j];
				nums[j]=temp;
				i++;
			}
			
		}
		for(int k=0; k<nums.length; k++){

			System.out.println(nums[k]);
		}
    }
	
	public int maxProfit(int[] prices) {
		int todaysProfit = 0;
		int totalProfit = 0;
		
		
        for(int i=1; i<prices.length; i++){
        	todaysProfit += prices[i]-prices[i-1];
        	todaysProfit = Math.max(0,todaysProfit);

        	totalProfit =  Math.max(totalProfit, todaysProfit);
        
        
        }
        return totalProfit;
    }
	public static void main(String[] args) {
		int[] myArray = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		BinarySearch obj = new BinarySearch();
		System.out.println("object 7 is found in position " + obj.sortedArrayToBinarySearch(myArray, 8));

		System.out.println("object 7 is found in position " + obj.sortedArrayToRecursiveBinarySearch(myArray, 8));
		int[] findArray = new int[] { 1, 10, 10, 10, 10, 13 };
		System.out.println("Occurances of 1  " + obj.findTotalOccurancesOfElementInArray(findArray, 1));
		int[] rotatedArray = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		System.out.println("min value index in the array is " + obj.findMin(rotatedArray));
		int [] nums = new int [] {0, 1, 0, 3, 12};
		obj.moveZeroes(nums);
		int []profitNums = new int [] {7,1,5,3,6,4};
		System.out.println(obj.maxProfit(profitNums));
	}

}
