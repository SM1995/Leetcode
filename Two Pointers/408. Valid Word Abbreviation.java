class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if(word.length() == 1 && abbr.length() ==1){
            if(word.equals(abbr)) return true;
            else if(abbr.length() == 1 && word.length()==abbr.charAt(0)-'0') return true;
            else return false;
        }
        int i = 0, j = 0;
        while(i < word.length() && j< abbr.length()){
            char first = word.charAt(i);
            char second = abbr.charAt(j);
            //System.out.println(first);
            //System.out.println(second);
            if(first == second) {
                i++;
                j++;
            }
            else if(second-'0'==0 || !Character.isDigit(second)) return false;
            else if(Character.isDigit(second)){
                int start=j;
         while(j<=abbr.length()-1 && Character.isDigit(abbr.charAt(j))){
            ++j;
         }
             //second=abbr.charAt(j);
                int num = Integer.valueOf(abbr.substring(start,j));
                i+=num;
        }
        }
        if(i == word.length() && j>= abbr.length())
         return true;
        else return false;
    }
}
