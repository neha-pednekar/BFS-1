// Time Complexity : O(v+e) where v is the number of courses(vertices) and e is the number of prereqs(edges)
// Space Complexity : O(v+e) where v is the number of courses(vertices) and e is the number of prereqs(edges)
//                    The graph map, indegree and queue take up v+e space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * Problem: Course Schedule 1
 * */

/*
 * Approach: Using Topological sort
 * In this approach, we do a topological sort on the indegree relationships formed by the courses and their prereqs.
 * We process the courses which do not have any dependencies by adding them to a queue. We then starting popping every
 * course from the queue and process their children. While processing their children, we reduce one dependency and check
 * if they are independent, if yes we add them to the queue.
 *
 * It is important that we start by adding ALL independent courses in the beginning to the queue.
 * */

import java.util.*;
import TreeNode;

public class CourseSchedule_usingTopologicalSort {
    public static void main(String[] args) {
        int numCourses = 5;
        int[][] prerequisites = {{1,4},{2,4},{3,1},{3,2}};

        CourseSchedule_usingTopologicalSort courseScheduleUsingTopologicalSort = new CourseSchedule_usingTopologicalSort();
        System.out.println(courseScheduleUsingTopologicalSort.canFinish(numCourses, prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int[] prereq: prerequisites) {
            int dep = prereq[0];
            int ind = prereq[1];

            if (!map.containsKey(ind)) {
                map.put(ind, new ArrayList<>());
            }

            map.get(ind).add(dep);
            indegree[dep]++;
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                count++;
            }
        }

        while (!queue.isEmpty()) {
            Integer node = queue.poll();

            List<Integer> children = map.get(node);

            if (children == null) continue;

            for (Integer child: children) {
                indegree[child]--;
                if (indegree[child] == 0) {
                    count++;
                    queue.offer(child);
                }
            }
        }

        return count == numCourses;
    }
}
