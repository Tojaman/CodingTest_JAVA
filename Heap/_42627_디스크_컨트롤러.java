package Heap; /**
jobs[][]: [[시작점1, 지속시간1], [시작점2, 지속시간2]]
*/

/** 풀이 방법
각 작업의 소요 시간을 계산하고 평균 소요 시간의 최솟값을 구하라
- 첫 번째 요청은 시작 지점을 고정으로 설정
- 나머지 요청들은 순서를 바꿔가며 배치하여 평균 소요 시간을 구한 후 최솟값을 찾아 반환
*/

/** 공식
- 종료 시점: 이전 요청 종료 시점 + 지속시간
- 소요 시간: 종료 시점 - 요청 시점
*/
import java.util.*;
class _42627_디스크_컨트롤러 {
    public int solution(int[][] jobs) {
        
        // 소요 시간이 적은 순으로 jobs[][] 오름차순 정렬
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        // 시작 시간 순으로 jobs[][] 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        int now = 0;
        int close = 0;
        int times = 0;;
        int idx = 0;
        int jobCount = 0;
        
        while (jobCount < jobs.length) {
            // 현재 실행중인 작업이 끝나는 시간 >= 새로운 작업이 시작하는 시간
            
            // for (int i = 0; i < jobs.length; i++) {
            //     if (now >= jobs[i][0])
            //         minHeap.add(jobs[i++]);
            // }
            while (idx < jobs.length && close >= jobs[idx][0])
                minHeap.add(jobs[idx++]);

            // 힙에 작업이 존재하면
            if (!minHeap.isEmpty()) {
                int[] job = minHeap.poll();
                close += job[1]; // 3, 3+9, 3+6+6
                times += close - job[0]; // 3-0, 3-0+9-1, 3-0+9-1+6-2
                jobCount++;
            }

            // close값 보다 멀리 작업이 있다면
            else {
                close = jobs[idx][0];
            }
        }
        return times/jobs.length;
    }
}