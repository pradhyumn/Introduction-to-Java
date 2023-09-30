class FindMinimumLength {
    public static int minSubArrayLen(int goal, int[] nums) {
        int minimumLength=Integer.MAX_VALUE;
        int lp = 0, sum = 0;
        for(int i = 0; i < nums.length; i++) {
        	sum += nums[i];
        	while(sum >= goal && lp < i) {
        		minimumLength = Math.min(minimumLength, i - lp);
        		sum -= nums[lp++];
        	}
        }
        return minimumLength;
    }
    
    public static void main(String[] args) {
    	int[] array1 =   {10, 2, 3, 11};
    	System.out.println(minSubArrayLen(11, array1)); 
    	int[] array2 =   {5, 6, 8, 2};
    	System.out.println(minSubArrayLen(7, array2));
    }
}
