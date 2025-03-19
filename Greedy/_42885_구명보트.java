import java.util.Arrays;
/** 문제 해설
- 구명 보트에 최대 두 명까지 탑승 가능
- 구명 보트에 탑승하는 사람의 몸무게 <= limit
- 최소한의 구명 보트로 모든 사람 구출
*/

/** 풀이 방법
구명보트를 최소화하기 위해서는 가능한 구명보트에 두 명의 인원을 태워서 보내야 함
핵심 목표: 구명보트에 두 명의 인원을 태워 보내기
세 가지 경우가 존재
1. 가장 큰 사람과 남은 사람들 중 가장 무거운 사람부터 차례대로 확인하여 태울 수 있으면 태워 보내는 경우 -> 이 방법이나 3번 방법이나 결국엔 2명을 태우는 건 똑같음.
2. 가장 작은 두 사람 태워 보내는 경우 -> 비효율적임.
3. 가장 큰 사람과 가장 작은 사람을 태워 보내는 경우 -> 구명 보트에 2명을 채워 보낼 수 있는 가장 가능성이 높은 방법임.
의문: 3번이 1번에 비해 구명보트에 태워 보내는 사람의 몸무게의 합이 적어질 수 있기 때문에 비효율적일 수 있지 않은가?
해결: 이 문제에서 원하는 것은 구명보트에 최대한의 몸무게를 태워 보내는 것이 아닌 구명보트에 2명을 태워 보내는 게 우선이다. 따라서 이건 내 알빠가 아니다. 따라서 구현이 복잡한 1번 방법보다 3번 방법이 더 효율적이다.
*/
class Solution {
    public int solution(int[] people, int limit) {
        int result = 0;
        
        // 오름차순으로 정렬
        Arrays.sort(people);
        
        int max = people.length - 1; // 가장 작은 값
        int min = 0; // 가장 작은 값
        
        while (max >= min) {
            if (max == min) {
                result++;
                break;
            }
            // 가장 무거운 사람과 가장 가벼운 사람 모두 구명보트에 태우는 경우
            if (people[max] + people[min] <= limit) {
                result++;
                max--;
                min++;
            }
            // 가장 무거운 사람과 가장 가벼운 사람의 합이 limit를 넘기는 경우 -> 가장 무거운 사람만 태워 보냄
            else {
                result++;
                max--;
            }
        }
        
        return result;
    }
}

//--------------------------------------------------------------------------------------------
/** 핵심
두 명을 합쳐서 100에 최대한 가깝게 만들어야 한다.
이를 위해서 people 배열을 오름차순으로정렬한 뒤 최소 몸무게+최대 몸무게가 100 이하라면 두 명을 탈출하도록 한다.
이때 100 이하라면 min++, max-- / 100 이상이라면 max--(몸무게가 적은 사람을 남겨 둬야 다음에 두 명을 한번에 태워 보낼 가능성이 높아지기 때문)
*/

/** 로직
1. people을 오름차순으로 정렬한다.
2. 가장 가벼운 사람과 가장 무거운 사람을 더하여 100 이하라면 탈출시키고(min++, max--) 크다면 무거운 사람만 탈출(max--)
3. 마지막 두 사람을 함께 탈출시킨 경우(min>max) result 그대로 return / 마지막 두 사람을 각각 탈출시킨 경우(min==max) result + 1 return
*/
// import java.util.Arrays;
// class Solution {
//     public int solution(int[] people, int limit) {
//         int result = 0;
        
//         // 오름차순으로 정렬
//         Arrays.sort(people);
        
//         int min = 0;
//         int max = people.length - 1;
//         /** min max가 같아질 때까지
//         반복문을 돌면서 min, max가 100 이하인지 확인한 후 탈출시킨다.
//         이때 탈출한 사람은 제외하기 위해 min, max를 설정한다.
//         while 조건문 설정
//         - max-- 돼서 min==max 되는 경우
//         - min++ max-- 돼서 min>max가 되는 경우
//         */
//         while (min<=max) {
            
//             // 탈출 가능한 경우
//             if (people[min] + people[max] <= limit) {
//                 min++;
//                 max--;
//             }
//             // 두 명이 동시에 탈출하지 못하는 경우 -> 무거운 사람만 혼자 탈출
//             else {
//                 max--;
//             }
//             result++;
//         }
//         //if (min == max)
//             //result++;
        
//         return result;
//     }
// }