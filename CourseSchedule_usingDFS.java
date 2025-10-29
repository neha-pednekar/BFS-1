// Time Complexity : O(v+e) where v is the number of courses(vertices) and e is the number of prereqs(edges)
// Space Complexity : O(v+e) where v is the number of courses(vertices) and e is the number of prereqs(edges)
//                    The graph map, hashsets and recursive stack take up v+e space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * Problem: Course Schedule 1
 * */

/*
 * Approach: Using Depth First Search
 * In this approach, we use DFS for finding if we can complete all courses at a time. We create an adjacency list/map
 * for mapping the relationships between the courses. We maintain the visited and inStack to keep a track of the visited
 * nodes and to keep a track of visited nodes in a recursive path. If a node is already added to the inStack set,
 * it would mean that the current path is running into a cycle and there is an interdependency.
 * */

import java.util.*;
import TreeNode;

public class CourseSchedule_usingDFS {
    public static void main(String[] args) {
        int numCourses = 5;
        int[][] prerequisites = {{1,4},{2,4},{3,1},{3,2}};

        CourseSchedule_usingDFS courseScheduleUsingDFS = new CourseSchedule_usingDFS();
        System.out.println(courseScheduleUsingDFS.canFinish(numCourses, prerequisites));
    }

    Map<Integer, List<Integer>> map;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.map = new HashMap<>();

        for (int i=0; i<numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] prereq: prerequisites) {
            int dep = prereq[0];
            int ind = prereq[1];

            map.get(ind).add(dep);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> inStack = new HashSet<>();
        for (int i=0; i<numCourses; i++) {
            if (!dfsHelper(i, visited, inStack)) return false;
        }

        return true;
    }

    public boolean dfsHelper(Integer course, Set<Integer> visited, Set<Integer> inStack) {
        if (inStack.contains(course)) {
            return false;
        }

        if (visited.contains(course)) {
            return true;
        }

        visited.add(course);
        inStack.add(course);
        List<Integer> children = map.get(course);

        for (Integer child: children) {
            if (!dfsHelper(child, visited, inStack)) return false;
        }

        inStack.remove(course);

        return true;
    }
}
