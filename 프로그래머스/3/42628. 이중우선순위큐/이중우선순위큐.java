/** 문제 설명
명령어에 따라 입력값을 삽입, 최댓값/최솟값 삭제를 진행한다.
만약 우선순위 큐가 비어 있는데 삭제 연산이 들어오면 무시한다.
모든 연산을 처리한 후 우선순위 큐가 비어 있다면 [0. 0] / 비어있지 않다면 [최댓값, 최솟값]을 return
*/
// import java.util.*;
// class Solution {
//     public int[] solution(String[] operations) {
//         // 최소 힙
//         PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//         // 최대 힙
//         PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
//         for (String operation : operations) {
//             String[] parts = operation.split(" ");
//             // Integer.parseInt 기억하기
//             if (parts[0].equals("I")) {
//                 minHeap.add(Integer.parseInt(parts[1]));
//                 maxHeap.add(Integer.parseInt(parts[1]));
//             }
//             else { // "D"
//                 if (parts[1].equals("1")) {
//                     if (!maxHeap.isEmpty()) {
//                         maxHeap.poll();
//                     }
//                 }
//                 else {// "-1"
//                     if (!minHeap.isEmpty()) {
//                         minHeap.poll();
//                     }
//                 }
//             }
//         }
//         // 공통된 값을 저장할 리스트
//         List<Integer> commonValues = new ArrayList<>();
//         int[] result = new int[2];
//         if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
//             // 두 큐를 리스트로 변환
//             List<Integer> list1 = new ArrayList<>(minHeap);
//             List<Integer> list2 = new ArrayList<>(maxHeap);

//             // 오름차순 리스트 정렬
//             /**
//             list1이 [-45,45,97,653,333] 형태로 저장된다.
//             ArrayList는 힙 구조를 가지고 있지 않다.
//             따라서 PriorityQueue에서 ArrayList로 변환하면, 힙 속성이 유지되지 않을 수 있다.
//             그래서 for문을 통해 PriorityQueue의 값들을 ArrayList로 하나하나 저장하거나 sort를 이용해야 한다. 
//             */
//             Collections.sort(list1);
//             Collections.sort(list2);

//             // 두 리스트를 순회하면서 공통된 값을 찾기
//             int i = 0, j = 0;
//             while (i < list1.size() && j < list2.size()) {
//                 int val1 = list1.get(i);
//                 int val2 = list2.get(j);

//                 if (val1 == val2) {
//                     commonValues.add(val1);
//                     i++;
//                     j++;
//                 } else if (val1 < val2) {
//                     i++;
//                 } else {
//                     j++;
//                 }
//             }
//         }
//         if (!commonValues.isEmpty()) {
//                 result[0] = commonValues.get(commonValues.size() - 1);
//                 result[1] = commonValues.get(0);
//         }
//         else {
//             result[0] = 0;
//             result[1] = 0;
//         }
//         return result;
//     }
// }

// import java.util.*;

// class Solution {
//     public int[] solution(String[] operations) {
//         // 최소 힙
//         PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//         // 최대 힙
//         PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

//         for (String operation : operations) {
//             String[] parts = operation.split(" ");
//             // Integer.parseInt 기억하기
//             if (parts[0].equals("I")) {
//                 minHeap.add(Integer.parseInt(parts[1]));
//                 maxHeap.add(Integer.parseInt(parts[1]));
//             } else { // "D"
//                 if (parts[1].equals("1")) {
//                     if (!maxHeap.isEmpty()) {
//                         maxHeap.poll();
//                     }
//                 } else { // "-1"
//                     if (!minHeap.isEmpty()) {
//                         minHeap.poll();
//                     }
//                 }
//             }
//         }

//         // 공통된 값을 저장할 배열
//         int[] commonValues = new int[Math.min(minHeap.size(), maxHeap.size())];
//         int count = 0;

//         // 두 큐를 배열로 변환
//         int[] arr1 = new int[minHeap.size()];
//         int[] arr2 = new int[maxHeap.size()];
//         for (int i = 0; i < arr1.length; i++) {
//             arr1[i] = minHeap.poll();
//         }
//         for (int i = 0; i < arr2.length; i++) {
//             arr2[i] = maxHeap.poll();
//         }

//         // 오름차순 배열 정렬
//         Arrays.sort(arr1);
//         Arrays.sort(arr2);

//         // 두 배열을 순회하면서 공통된 값을 찾기
//         int i = 0, j = 0;
//         while (i < arr1.length && j < arr2.length) {
//             if (arr1[i] == arr2[j]) {
//                 commonValues[count++] = arr1[i];
//                 i++;
//                 j++;
//             } else if (arr1[i] < arr2[j]) {
//                 i++;
//             } else {
//                 j++;
//             }
//         }

//         int[] result = new int[2];
//         if (count > 0) {
//             result[0] = commonValues[count - 1];
//             result[1] = commonValues[0];
//         } else {
//             result[0] = 0;
//             result[1] = 0;
//         }

//         return result;
//     }
// }

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        // 최소 힙
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // 최대 힙
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        for (String operation : operations) {
            String[] parts = operation.split(" ");
            if (parts[0].equals("I")) {
                int num = Integer.parseInt(parts[1]);
                minHeap.offer(num);
                maxHeap.offer(num);
            }
            else { // "D"
                if (parts[1].equals("1")) { // 최대값 삭제
                    if (!maxHeap.isEmpty()) {
                        int max = maxHeap.poll();
                        minHeap.remove(max); // remove() 메소드가 있는지 몰랐어 !!!
                    }
                }
                else { // "-1" 최소값 삭제
                    if (!minHeap.isEmpty()) {
                        int min = minHeap.poll();
                        maxHeap.remove(min); // remove() 메소드가 있는지 몰랐어 !!!
                    }
                }
            }
        }
        
        int[] result = new int[2];
        // if (minHeap.size() >= 2 && maxHeap.size() >= 2) {
        if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
            result[0] = maxHeap.poll();
            result[1] = minHeap.poll();
        }
        else {
            result[0] = 0;
            result[1] = 0;
        }
        
        return result;
    }
}
