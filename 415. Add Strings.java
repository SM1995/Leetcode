class Solution {
    public String addStrings(String num1, String num2) {
        int i=num1.length(), j=num2.length();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(i>0 && j>0){
            int left = num1.charAt(i-1) - '0';
            int right = num2.charAt(j-1) - '0';
            int temp = left + right + carry;
            System.out.println(left);
            sb.append(temp%10);
            carry = temp/10;
            i--;j--;
        }
        while(i > 0){
            int left = num1.charAt(i-1) - '0' + carry;
            sb.append(left%10);
            carry = left/10;
            i--;
        }
        while(j > 0){
            int right = num2.charAt(j-1) - '0' + carry;
            sb.append(right%10);
            carry = right/10;
            j--;
        }
        if(carry!=0) sb.append(carry);
        return sb.reverse().toString();
    }
}
