package com.sumit.ds.leetcode.june2023;

import java.util.*;

/**
 * ThousandEyes: 1st Coding Round
 *
 * /*
 *  ### Statement
 *
 * We want to do a project estimation tool to determine how long a project should take based on the tasks that compose it.
 * As expected, there are some tasks that cannot start until others have finished while others can be done in parallel.
 *
 * Write a program that: given a list of tasks, where each of them will have an identifier, the tasks it depends on and how long that task is estimated to take, it returns the following elements:
 *
 * 1) What is the project's expected length.
 *
 * ### Example
 *
 * Task Id, Deps, Duration/Length
 *
 * Project1:
 * A, (), 5 *
 * B, (), 7 *
 * F, (B, C, E), 5 (7,10,9) (10+5) (15)
 * C, (), 10 *
 * D, (), 15 *
 * E, (A, B), 2 (5,7) (7+2) (9)
 * G, (D, F), 1 (15,10) (15+1) (16)
 * H, (), 9
 *
 *
 * Max(all the computations)
 *
 * Project2:
 * A, (), 5
 * B, (), 7
 * total: 7
 *
 * Project3:
 * A, (), 5
 * B, (), 7
 * E, (A, B), 2 (w: 7, r: 2 = 9)
 * total: 9
 *
 * */

public class ProjectMaxDuration {
    public static void main(String[] args) {
        // input structure
        List<Task> tasks = new ArrayList<>();

        tasks.add(new Task("A", new ArrayList<>(), 5));
        tasks.add(new Task("B", new ArrayList<>(), 7));
        tasks.add(new Task("F", Arrays.asList("B", "C", "E"), 5));
        tasks.add(new Task("C", new ArrayList<>(), 10));
        tasks.add(new Task("D", new ArrayList<>(), 15));
        tasks.add(new Task("E", Arrays.asList("A", "B"), 2));
        tasks.add(new Task("G", Arrays.asList("D", "F"), 1));
        tasks.add(new Task("H", new ArrayList<>(), 9));

        // Helper hashmap (key: taskId, value: Task)
        Map<String, Task> taskIdToTask = new HashMap<>();
        for (Task task: tasks) {
            taskIdToTask.put(task.getTaskId(), task);
        }

        int totalDuration = findTotalDuration(taskIdToTask);
        System.out.println("Total Duration of project: "+totalDuration);

    }

    public static int findTotalDuration(Map<String, Task> taskIdToTask){
        int totalDuration = 0;

        //iterate over the map and compute results
        // any independent task
        Map<String,Integer> computedMap = new HashMap<>();
        List<Task> tasks = new ArrayList<>();
        for(String id:taskIdToTask.keySet()){
            Task task = taskIdToTask.get(id);
            if(task.getDependencies().size() > 0){
                tasks.add(task);
            }
            else{
                computedMap.put(id,task.getDuration());
            }
        }
        // map (id, computedValue) A:5, B:7,c:10,D:15 ,E:9, H:9: F:15: G:16
        // F, (B, C, E) //List (G)
        // G, (D, F)
        //When list is empty
        int i=0;
        while(tasks.size() > 0){
            Task task = tasks.get(i);
            Set<String> dependencies = task.getDependencies();
            boolean canCompute = true;
            int maxLength = 0;
            for(String id:dependencies){
                if(!computedMap.containsKey(id)){
                    canCompute=false;
                }
                maxLength = Math.max(maxLength,computedMap.get(id));
            }
            if(canCompute){
                computedMap.put(task.taskId,maxLength+task.getDuration());
                tasks.remove(i);
            }else{
                i++;
                i = i % tasks.size(); // ensure that i doesn't go out of bounds
            }
        }

        // Get max of the computedmap
        for(String id:computedMap.keySet()){
            totalDuration = Math.max(totalDuration,computedMap.get(id));
        }
        return totalDuration;
    }

}



class Task {
    String taskId;
    Set<String> dependencies;
    int duration;

    public Task(String taskId, List<String> dependencies, int duration) {
        this.taskId = taskId;
        this.dependencies = new HashSet<>(dependencies);
        this.duration = duration;

    }

    public String getTaskId() {
        return taskId;
    }

    public Set<String> getDependencies() {
        return dependencies;
    }

    public int getDuration() {
        return duration;
    }
}




