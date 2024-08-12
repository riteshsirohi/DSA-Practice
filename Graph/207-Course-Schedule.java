class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       List<List<Integer>> graph=new ArrayList<>(numCourses);

       for(int i=0;i<numCourses;i++){
           graph.add(new ArrayList<>());
       }

       for(int[] prerequisite:prerequisites){
           int course=prerequisite[0];
           int precourse=prerequisite[1];
           graph.get(course).add(precourse);
       }

       int[] visited = new int[numCourses];

       for(int i=0;i<numCourses;i++){
           if(visited[i]==0 && hascycle(graph,i,visited)){
               return false;
           }
       }
       return true;
    }
    private boolean hascycle(List<List<Integer>> graph,int course,int[] visited){
        if(visited[course]==1){
            return true;
        }
        if(visited[course]==2){
            return false;
        }
        visited[course]=1;

        for(int precourse: graph.get(course)){
              if(hascycle(graph,precourse,visited)){
                  return true;
              }
        }
        visited[course]=2;
       return false;
    }
}