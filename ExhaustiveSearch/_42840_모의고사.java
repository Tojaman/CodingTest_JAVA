package ExhaustiveSearch;

import java.util.*;
class _42840_모의고사 {
    public int[] solution(int[] answers) {
        Queue<Integer> q1 = new LinkedList<>();
        int[] q1Values = {1, 2, 3, 4, 5};
        for (int v : q1Values)
            q1.add(v);
        Queue<Integer> q2 = new LinkedList<>();
        int[] q2Values = {2, 1, 2, 3, 2, 4, 2, 5};
        for (int v : q2Values)
            q2.add(v);
        Queue<Integer> q3 = new LinkedList<>();
        int[] q3Values = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        for (int v : q3Values)
            q3.add(v);
        
        int[] max = new int[3];
        for (int answer : answers) {
            int aq1Answer = q1.poll();
            q1.add(aq1Answer);
            if (answer == aq1Answer)
                max[0] += 1;
            int aq2Answer = q2.poll();
            q2.add(aq2Answer);
            if (answer == aq2Answer)
                max[1] += 1;
            int aq3Answer = q3.poll();
            q3.add(aq3Answer);
            if (answer == aq3Answer)
                max[2] += 1;
        }
        
//         int[] m1 = {1, 2, 3, 4, 5};
//         int[] m2 = {2, 1, 2, 3, 2, 4, 2, 5};
//         int[] m3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
//         int[] max = new int[3];
//         for (int i = 0; i < answers.length; i++) {
//             if (answers[i] == m1[i % 5]) max[0]++;
//             if (answers[i] == m2[i % 8]) max[1]++;
//             if (answers[i] == m3[i % 10]) max[2]++;
//         }
        
        int maxValue = Math.max(max[0], Math.max(max[1], max[2]));
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < max.length; i++) {
            if (max[i] == maxValue) {
                answer.add(i+1);
            }
        }
        
        int[] result = new int[answer.size()];
        int cnt = 0;
        for(int num : answer)
            result[cnt++] = num;
        
        return result;
        
        
        // return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}