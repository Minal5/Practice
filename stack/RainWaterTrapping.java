package stack;
//https://leetcode.com/problems/trapping-rain-water/description/

public class RainWaterTrapping {

	public static void main(String[] args) {
		int[] height = {4,2,0,3,2,5};
		System.out.println(trap(height));
	}

	public static int trap(int[] height) {
		int[] mxl = new int[height.length];
		int[] mxr = new int[height.length];
		int[] water = new int[height.length];
		int sum = 0;
		mxl[0] = height[0];
		for(int i=1;i<height.length;i++) {
			mxl[i] = Math.max(mxl[i-1], height[i]);
		}
		mxr[mxr.length-1] = height[height.length-1];
		for(int i = height.length-2 ; i >= 0;i--) {
			mxr[i] = Math.max(mxr[i+1], height[i]);
		}
		
		for(int i=0;i<height.length;i++) {
			water[i] = Math.min(mxl[i], mxr[i]) - height[i];
		}
		for(int i=0;i<height.length;i++) {
			sum += water[i];
		}
		return sum;
	}
	
}
