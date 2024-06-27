import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Arrays;


/** 문제 설명
 * 강의의 시작 시간과 종료 시간을 참고해서 최대한 적은 수의 강의실을 사용하여 강의를 해야 할 때 최소 강의실 수는?
 */

/** 문제 풀이
 * "특정 강의 종료 시간 >= 특정 강의 시작 시간"
 */
public class Main {
    private static class Lecture implements Comparable<Lecture> {
        int no, start, end;
        boolean isRemoved = false;

        public Lecture(int no, int start, int end) {
            this.no = no;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            // return Integer.compare(this.start, o.start);
            return this.start - o.start;
        }
    }
    
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // HashMap Key 오름차순 우선순위 정렬
        PriorityQueue<Lecture> pq = new PriorityQueue<>();
        
        int N = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            
            // StringTokenizer를 사용하여 문자열을 공백으로 분리
            StringTokenizer tokenizer = new StringTokenizer(input);
            
            // 각 토큰을 정수로 변환
            int lecnum = Integer.parseInt(tokenizer.nextToken());
            int lecstart = Integer.parseInt(tokenizer.nextToken());
            int lecend = Integer.parseInt(tokenizer.nextToken());
            // lectures[i] = new Lecture(lecnum, lecstart, lecend);
            pq.add(new Lecture(lecnum, lecstart, lecend));
        }

        // Arrays.sort(lectures);
        // for (int i = 0; i < N; i++) {
        //     pq.add(lectures[i]);
        // }

        int result = 0;
        // while (!pq.isEmpty()) {
        //     Lecture lec = pq.poll();
        //     int end = lec.end;
        //     lec.isRemoved = true;
        //     result += 1;
        //     for (Lecture lecture : lectures) {
        //         if (!lecture.isRemoved && end <= lecture.start) {
        //             lecture.isRemoved = true;
        //             // 실제 remove를 시켜야 함
        //             pq.remove(lecture);
        //             end = lecture.end;
        //         } 
        //     }
        // }
        PriorityQueue<Integer> endTimeQueue = new PriorityQueue<>();
        while (!pq.isEmpty()) {
            Lecture lecture = pq.poll();
            while (!endTimeQueue.isEmpty() && endTimeQueue.peek() <= lecture.start) {
                endTimeQueue.poll();
            }
            endTimeQueue.offer(lecture.end);
            result = Math.max(result, endTimeQueue.size());
        }
        System.out.println(result);
    }
    
}
