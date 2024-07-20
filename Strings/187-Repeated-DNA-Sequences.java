class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
    /*    List<String> res = new ArrayList<>();
        if(s==null || s.length()<=10){
            return res;
        }
        HashMap<Character,Integer> map = new HashMap<>();

        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        int L = 10;
        int len = s.length();
        int a = 4;
        int h =(int) Math.pow(4,L);

        int hash = 0;
        for(int i=0;i<L;i++){
            hash = hash*a + map.get(s.charAt(i));
        }
        HashSet<Integer> seen = new HashSet<>();
        HashSet<String> added = new HashSet<>();

        seen.add(hash);

        for(int i=1;i<len-L+1;i++){
            hash = hash*a-map.get(s.charAt(i-1))*h + map.get(s.charAt(i+L-1));

        if(seen.contains(hash)){
            String xs = s.substring(i,i+L);
            if(!added.contains(xs)){
                added.add(xs);
                res.add(xs);
            }
            }else{
                seen.add(hash);
            }
        return res;*/
        List<String> list = new ArrayList<>();
     if(s==null || s.length()<=10){
        return list;
     }
     HashSet<String> set = new HashSet<>();
     for(int i=0;i<=s.length()-10;i++){
        String bc = s.substring(i,i+10);
        boolean flag = set.add(bc);
        if(!flag && !list.contains(bc)){
            list.add(bc);
        }
     }
     return list;
        
    }
}