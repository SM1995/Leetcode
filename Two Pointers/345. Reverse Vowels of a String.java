class Solution {
    public String reverseVowels(String s) {
        Character[] vo = new Character[]{'a','e','i','o','u','A','E','I','O','U'};
        List<Character> vowels = Arrays.asList(vo);
        
        int start = 0, end = s.length()-1;
        
        StringBuilder sb = new StringBuilder(s);
        
        while(start<=end){
            if(!vowels.contains(sb.charAt(start))) start++;
            if(!vowels.contains(sb.charAt(end))) end--;
            
            else if(vowels.contains(sb.charAt(start)) && vowels.contains(sb.charAt(end))){
                String temp = sb.substring(start,start+1);
                sb.replace(start, start+1, sb.substring(end,end+1));
                sb.replace(end, end+1,temp);
                start++;
                end--;
            }
        }
        
        return sb.toString();
    }
}
