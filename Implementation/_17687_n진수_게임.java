package Implementation;

/* 헷갈린 부분
- 2, 10, 16진법만 계산하는 줄 알았음
    - toString(숫자, 진법): toString()이 진법도 바꿔주는 지 몰랐음
- 튜브의 순서인지 검증하는 부분에서 살짝 헤멤. 금방 찾긴 함
*/
// 1시간 40분;;;;;;
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        
        if (m == p) p = 0;
        int decimal = 0;
        int order = 1;
        while (true) {
            
            // toString(int 숫자, int 진법): 진법 변환도 해줌. toBinaryString(), toHexString() 필요 없음
            String num = Integer.toString(decimal, n).toUpperCase();

            // 숫자 길이만큼 반복
            for (int i = 0; i < num.length(); i++) {
                if (sb.length() == t) break;
                if (order % m == p) {
                    sb.append(num.charAt(i));
                }
                order++;
            }
            if (sb.length() == t) break;
            decimal++;
        }
        return sb.toString().toUpperCase();
    }
}


/* 풀이 방법
2진법, 10진법, 16진법 존재
2진수: Integer.toBinaryString(decimal);
16진수: Integer.toHexString(decimal);
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        
        if (m == p) p = 0;
        int decimal = 0;
        int order = 1;
        while (true) {
            if (sb.length() == t) break; // 탈출 조건
            
            String num = calNum(n, decimal); // 진법으로 변환한 수

            // 숫자 길이만큼 반복
            for (int i = 0; i < num.length(); i++) {
                if (sb.length() == t) break;
                if (order % m == p) {
                    sb.append(num.charAt(i));
                }
                order++;
            }
            if (sb.length() == t) break;
            decimal++;
        }
        
        return sb.toString().toUpperCase();
    }
    
    public String calNum(int n, int decimal) {
        if (n == 2) {
            return Integer.toBinaryString(decimal);

        } else if (n == 16) {
            return Integer.toHexString(decimal);

        } else {
            return Integer.toString(decimal);
        }
    }
}
*/