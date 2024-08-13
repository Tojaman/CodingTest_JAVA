package Greedy;

import java.util.HashMap;

class _42860_조이스틱 {
    public int solution(String name) {

        int result = 0;
        int cnt = 0; // 다음 커서가 A인 경우

        HashMap<Character, Integer> map1 = new HashMap<>(); // A부터 N까지
        HashMap<Character, Integer> map2 = new HashMap<>(); // Z부터 O까지

        int value1 = 0; // A부터 N까지 값
        int value2 = 1; // Z부터 O까지 값
        int move = name.length() - 1; // 기본 최소 좌우이동 횟수 (좌, 우 커서)


        for (char ch = 'A'; ch <= 'N'; ch++) {
            map1.put(ch, value1++);
        }

        for (char ch = 'Z'; ch >= 'O'; ch--) {
            map2.put(ch, value2++);
        }

        for (int i = 0; i < name.length(); i++) {
            // 연속된 'A'가 끝나는 지점 찾기
            int next = i + 1;
            while(next < name.length() && name.charAt(next) == 'A')             {
                next++;
            }

            // 좌우이동 최소 횟수 구하기
            // 정방향으로 가기 vs 정방향으로 갔다가 역박향으로 돌아가 'A'가 끝나는 지점까지 가기
            move = Math.min(move, (i * 2) + name.length() - next);
            // 정방향으로 갔다가 역박향으로 돌아가 'A'가 끝나는 지점까지 가기 vs 'A'가 끝나는 지점까지 역방향으로 갔다가 다시 돌아가 정방향으로 가기
            move = Math.min(move, (name.length() - next) * 2 + i);

            // 조건문3: 알파벳 순서, 역순서 중 뭐가 더 효율적인지 판단
            // 정방향 > 역방향 : 역방향이 효율적
            if (map1.containsKey(name.charAt(i))) { // A~N : 정방향
                result += map1.get(name.charAt(i));
            }
            else { // M~Z : 역방향
                result += map2.get(name.charAt(i));
            }
        }
        result += move;

        return result;
    }
}