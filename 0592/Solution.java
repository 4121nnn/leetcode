import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public String fractionAddition(String s) {
        int numerator = 0, denominator = 1;
        
        Pattern pattern = Pattern.compile("([+-]?\\d+)/(\\d+)");
        Matcher matcher = pattern.matcher(s);
        
        while(matcher.find()){
            int num = Integer.parseInt(matcher.group(1));
            int den = Integer.parseInt(matcher.group(2));
            
            numerator = numerator * den + num * denominator;
            denominator *= den;
            
            int gcdVal = gcd(Math.abs(numerator), denominator);
            numerator /= gcdVal;
            denominator /= gcdVal;
        }

        return numerator + "/" + denominator;
    }
    private int gcd(int a, int b){
       if(b == 0) return a;
       return gcd(b, a % b);
    }
}
// time O(n)
// space O(1)
