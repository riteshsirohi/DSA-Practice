class Solution {
    public boolean isNumber(String s) {
        boolean digitseen = false, eseen = false, 
        dotseen = false;
        int minplucount = 0;

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                digitseen = true;
            }
            else if(ch=='+' || ch=='-'){
                if(minplucount==2){
                    return false;
                }
                if(i>0 && (s.charAt(i-1)!='e' && s.charAt(i-1)!='E')){
                    return false;
                }
                if(i==s.length()-1){
                    return false;
                }
                minplucount++;
            }
            else if(ch == '.'){
                if(eseen || dotseen){
                    return false;
                }
                if(i==s.length()-1 && !digitseen){
                    return false;
                }
                dotseen = true;
            }
            else if(ch == 'e' || ch== 'E'){
                if(eseen || !digitseen){
                    return false;
                }
                if(i==s.length()-1){
                    return false;
                }
                eseen = true;
            }
            else {
                return false;
            }
        }
          return true;
    }
}