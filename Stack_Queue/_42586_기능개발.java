package Stack_Queue;

import java.util.ArrayList;

    class _42586_기능개발 {
        public int[] solution(int[] progresses, int[] speeds) {

            // 작업 기간(end) 계산
            int[] end = new int[progresses.length];
            for (int i = 0; i < progresses.length; i++) {
                int intg = (100 - progresses[i]) / speeds[i];
                float flt = (100 - progresses[i]) % speeds[i];

                // 각 작업의 완료 기간 설정
                if (flt == 0) {
                    end[i] = intg;
                }
                else {
                    end[i] = intg+1;
                }
            }

            // 기능 배포 개수 계산
            ArrayList<Integer> answer = new ArrayList<>();
            int front = 0;
            while (front < end.length) {
                int cnt = 1;
                /**
                if, 비교 대상 < 배열 크기 && 앞 > 비교 대상
                then, 배포 개수++(자기 자신 + 비교 대상)
                **/

                // 이 부분 for로 했는데 막혀서 gpt 참조함
                // for 반복문 + if 조건문보단 while로 반복과 조건 한번에 하는 게 적절
                
                // 현재 요소보다 다음 요소가 작거나 같으면 현재 요소 배포 후 다음 요소 배포 해야하므로 
                while (front + cnt < end.length && end[front] >= end[front + cnt]) {
                    cnt++;
                }
                /**
                if, 비교 대상이 더 크다면
                then,
                지금까지 센 cnt를 answer에 삽입
                &&
                자기 자신을 비교 대상으로 전환
                **/
                answer.add(cnt);
                front += cnt;
            }

            // 출력을 위해 ArrayList<Integer>를 int[]로 변환
            int[] result = new int[answer.size()];
            for (int j = 0; j < answer.size(); j++) {
                result[j] = answer.get(j);
            }

            return result;
        }
    }