    /** 문제 설명
    모든 트럭이 건너가는 시간 + 1(다리에서 내려오는 시간) 
    */
    import java.util.*;

    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            Queue<Integer> q = new LinkedList<>();

            int bridge_weight = 0;
            int time = 0;

            for (int i = 0; i < truck_weights.length; i++) {

                while(true) {
                    // 큐가 빈 경우
                    if (q.isEmpty()) {
                        // 큐(다리)에 트럭 올리기 (올리는 시간 1)
                        q.add(truck_weights[i]);
                        bridge_weight += truck_weights[i];
                        time += 1;
                        break; // 트럭을 올렸으니 다음 트럭으로 이동
                    }

                    // 큐(다리)가 가득차지 않은 경우
                    else if (q.size() == bridge_length) {
                        bridge_weight -= q.poll();

                    }

                    // 큐(다리)가 가득 찬 경우
                    // 맨 앞 트럭이 다 왔다는 뜻 -> 큐(다리)에서 맨 앞에 있는 트럭 뺴기
                    else { // q.size() == bridge_length
                        // 다음 트럭을 올릴 수 없는 경우 -> 기존의 트럭을 1칸(1초) 이동
                        if (bridge_weight+truck_weights[i] > weight) {
                            q.add(0);
                            time += 1;
                        }

                        // 다음 트럭을 올릴 수 있는 경우 -> 새로운 트럭 올리기(1초)
                        else {
                            q.add(truck_weights[i]);
                            bridge_weight += truck_weights[i];
                            time += 1;
                            break; // 트럭을 올렸으니 다음 트럭으로 이동
                        }
                        
                    }
                }
            }
            return time + bridge_length; 
        }
    }