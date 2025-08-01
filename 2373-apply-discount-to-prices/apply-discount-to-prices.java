import java.math.BigDecimal;
import java.math.RoundingMode;

class Solution {
    public String discountPrices(String sentence, int discount) {
        String s[] = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            String t = s[i];
            if (t.length() > 1 && t.charAt(0) == '$') {
                boolean found = true;
                BigDecimal price = BigDecimal.ZERO; // \U0001f501 FIXED: use BigDecimal instead of int
                for (int j = 1; j < t.length(); j++) {
                    int x = t.charAt(j) - '0';
                    if (x >= 0 && x <= 9)
                        price = price.multiply(BigDecimal.TEN).add(BigDecimal.valueOf(x)); // \U0001f501
                    else {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    BigDecimal disc = new BigDecimal(discount).divide(new BigDecimal(100));
                    BigDecimal discounted = price.multiply(BigDecimal.ONE.subtract(disc));
                    String add = "$" + discounted.setScale(2, RoundingMode.DOWN).toPlainString();
                    s[i] = add;
                }
            }
        }

        String ans = "";
        for (var ss : s) {
            ans += " " + ss;
        }

        return ans.trim();
    }
}
