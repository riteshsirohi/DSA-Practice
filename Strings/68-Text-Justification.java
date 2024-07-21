class Solution {
    int max;
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        max = maxWidth;
        int i = 0;

        while(i<n){
          int lettercount = words[i].length();
          int j = i+1;
          int space = 0;

          while(j<n && words[j].length()+1+space+lettercount<=maxWidth){
            lettercount += words[j].length();
            space+=1;
            j++;
          } 
          int remainingslots = maxWidth - lettercount;
          int eachspace = space==0 ? 0: remainingslots/space;
          int extraspace = space==0 ? 0 : remainingslots %space;

          if(j==n){
            eachspace=1;
            extraspace=0;
          }
          res.add(find(i,j,eachspace,extraspace,words));
          i=j;
        }
        return res;

    }
    private String find(int i, int j, int eachspace, int extraspace,String[] words){
     StringBuilder sb = new StringBuilder();
     for(int k=i;k<j;k++){
          sb.append(words[k]);

          if(k==j-1){
            continue;
          }
          for(int space = 1; space<=eachspace; space++){
              sb.append(" ");
          }
          if(extraspace>0){
            sb.append(" ");
            extraspace--;
          }
     }
     while(sb.length()<max){
        sb.append(" ");
     }
     return sb.toString();
    }
}