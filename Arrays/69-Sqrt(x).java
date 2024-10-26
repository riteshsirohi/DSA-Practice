class Solution {
    public int mySqrt(int x) {
        long ans = 0;
        long start = 1;
        long end = x;

        while(start<=end){
            long mid = start + (end-start) / 2;
            if(mid*mid == x){
                ans = (int)mid;
                break;
            }else if(mid * mid < x){
                start = mid+1;
                ans = mid;
            }else{
                end = mid - 1;
            }
        }
        return (int)ans;
    }
}