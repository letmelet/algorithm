class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
           if(!visited[i]){
               dfs(i, visited, computers);
               answer++;
           }
            
        }
        
        return answer;
    }
    
    static void dfs(int index, boolean[] visited, int[][] computers){
        visited[index] = true;
        
        for(int i = 0; i < computers.length; i++){
            if(index != i && computers[index][i] == 1 && !visited[i]){
                dfs(i, visited, computers);
            }
        }
    }
}
