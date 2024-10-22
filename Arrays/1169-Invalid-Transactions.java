class Solution {
    public class Transaction{
        String name,city;
        int time,amount;
         
         Transaction(String input){
           String[] arr = input.split(",");
          this.name = arr[0];
          this.time = Integer.parseInt(arr[1]);
          this.amount = Integer.parseInt(arr[2]);
          this.city = arr[3];
        }
    }
    public List<String> invalidTransactions(String[] transactions) {
        List<String> ans = new ArrayList<>();
        HashMap<String, List<Transaction>> map = new HashMap<>();

       for(String t : transactions){
        Transaction tran = new Transaction(t);
        map.putIfAbsent(tran.name,new ArrayList<>());
        map.get(tran.name).add(tran);
       }
       for(String t : transactions){
        Transaction tran = new Transaction(t);
        if(!isvalid(tran,map.get(tran.name))){
            ans.add(t);
        }
       }
       return ans;
    }
    private boolean isvalid(Transaction t, List<Transaction> list){
        if(t.amount>1000){
            return false;
        }
        for(Transaction l : list){
           if(!t.city.equals(l.city) && Math.abs(t.time-l.time) <= 60){
            return false;
           }
        }
        return true;
    }
}