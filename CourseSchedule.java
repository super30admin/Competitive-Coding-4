/**
Daily Problem #57
Time Complexity : O(N)
Space Complexity : O(N) 
Did this code successfully run on Leetcode : Yes 
Any problem you faced while coding this: 
    I tried to implement the solution that was taught in class without looking at the lecture.
    I had problems with the logic for adding elements to the queue
 */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] remainingPrereqs = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            int[] course = prerequisites[i];
            int courseNum = course[0];
            remainingPrereqs[courseNum]++;
        }
        //find course with 0 prereqs
        int current = -1;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < remainingPrereqs.length; i++){
            if(remainingPrereqs[i] == 0){
                q.add(i);
                current = i;
            }
        }
        
        if(current == -1) return false;
        
        while(!q.isEmpty()) {
            current = q.poll();
            for(int i = 0; i < prerequisites.length; i++){
                int[] course = prerequisites[i];
                int courseNum = course[0];
                if(course[1] == current){
                    remainingPrereqs[courseNum]--;
                }
                if (remainingPrereqs[courseNum] == 0){
                        q.add(courseNum);
                        remainingPrereqs[courseNum]--;
                }  
            }
        }
        
        for(int i = 0; i < remainingPrereqs.length; i++){
            if(remainingPrereqs[i] > 0) return false;
        }
        
        return true;
    }
}
