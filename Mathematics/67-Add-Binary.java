class Solution {
    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = m - 1, j = n - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            sb.insert(0, sum % 2);
            carry = sum / 2;
        }

        return sb.toString();
    }
}
