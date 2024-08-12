class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];

        for(int[] prerequisite : prerequisites){
           int course= prerequisite[0];
           int precourse = prerequisite[1];

           graph.get(precourse).add(course);

           inDegree[course]++;

        }
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
              q.offer(i);

            }
        }
        int[] result= new int[numCourses];
        int index=0;

        while(!q.isEmpty()){
            int course=q.poll();

            result[index++]=course;

            for(int nextcourse:graph.get(course)){
                inDegree[nextcourse]--;

                if(inDegree[nextcourse]==0){
                    q.offer(nextcourse);
                }
            }
        }
        if(index==numCourses){
            return result;
        }else{
            return new int[0];
        }
    }
}