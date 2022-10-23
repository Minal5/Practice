//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int w = cardPoints.length-k;
		int sum = 0;
        for(int l = 0;l<cardPoints.length;l++){
            sum+=cardPoints[l];
        }
        if(k == cardPoints.length ) return sum;
        int m = sum; 
        int sum1=0;
		for(int i = 0;i<w;i++) {
			sum1 = sum1 + cardPoints[i];
			m=Math.min(sum1, m);
		}
		return sum - m;
    }
}
