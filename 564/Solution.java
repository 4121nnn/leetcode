class Solution {
    public String nearestPalindromic(String n) {
       long num = Long.parseLong(n);
       if(num <= 10) return String.valueOf(num - 1);
       if(num == 11) return "9";

       int length = n.length();
       long leftHalf = Long.parseLong(n.substring(0, (length + 1) / 2));

       long[] candidates = new long[5];

       candidates[0] = generatePalFromLeft(leftHalf -1, length % 2 == 0);
       candidates[1] = generatePalFromLeft(leftHalf, length % 2 == 0);
       candidates[2] = generatePalFromLeft(leftHalf +1, length % 2 == 0);
       candidates[3] = (long) Math.pow(10, length -1) - 1;
       candidates[4] = (long) Math.pow(10, length)+ 1;

       long nearestPal = 0;
       long minDif = Long.MAX_VALUE;

       for(long candidate : candidates){
            if(candidate == num) continue;
            long dif = Math.abs(candidate - num);
            if(dif < minDif || (dif == minDif && candidate < nearestPal)){
                minDif = dif;
                nearestPal = candidate;
            }
       }
       return String.valueOf(nearestPal);

    }
    private long generatePalFromLeft(long leftHalf, boolean even){
        long pal = leftHalf;
        if(!even) leftHalf /= 10;
        while(leftHalf > 0){
            pal = pal * 10 + leftHalf % 10;
            leftHalf /= 10;
        }
        return pal;
    }
}

// time O(1)
// space O(1)
