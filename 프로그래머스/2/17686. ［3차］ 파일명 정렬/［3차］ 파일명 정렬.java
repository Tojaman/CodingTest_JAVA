/** 문제 설명
이름순 정렬이 아닌 숫자순 정렬로 바꿔라
파일 이름: HEAD(문자) + NUMBER(숫자) + TAIL(아무거나)
정렬 방법
1. HEAD 기준으로 사전 순 정렬(대소문자 구분X)
2. HEAD가 같을 경우 NUMBER 숫자 순으로 정렬(맨 앞이 0이라면 무시)
3. HEAD, NUMBER가 모두 같을 경우 원래 순서 유지
*/

/** 문제 풀이1
1. 파일명을 HEAD, NUMBER, TAIL로 나눈다. (숫자가 나올 떄까지 HRAD, 숫자가 끝날 떄까지 NUMBER, 이후 TAIL)
2. HEAD를 기준으로 사전 순 정렬한다.
3. HEAD가 같다면 NUMBER를 기준으로 정렬한다.
4. HEAD, NUMBER 모두 같다면 원래 순서를 유지한다.
*/

/** 문제 풀이2
1. Arrays.sort()에서 HEAD를 기준으로 정렬하고 만약 같다면 NUMBER를 기준으로 정렬한다.
*/
import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        
        // 1. Arrays.sort()에서 HEAD를 기준으로 정렬하고 만약 같다면 NUMBER를 기준으로 정렬한다.
        Arrays.sort(files, (o1, o2) -> {
            /** 정규 표현식을 이용하여 숫자 이전과 이후를 나눔
            ex. "img12.png"를 split("[0-9]")하면 head1[0] = "img", head1[1] = ".png"로 나뉨(숫자를 기준으로 앞 뒤 문자를 나누기 때문에 숫자는 포함되지 않음)*/
            String head1 = o1.split("[0-9]")[0].toLowerCase(); // 대소문자를 구분하지 않기 때문에 소문자로 일관되게 바꿔준다.
            String head2 = o2.split("[0-9]")[0].toLowerCase();
            // 같다면(0: 사전적 동일, 양수: head1이 head2보다 뒤, 음수: head1이 head2보다 앞) NUMBER 비교
            if (head1.compareTo(head2) == 0) {
                int num1 = getNumber(o1);
                int num2 = getNumber(o2);
                // return num1.compareTo(num2); // int 자료형은 객체가 아니라서 compareTo() 메소드 사용 불가능(Integer 자료형은 객체라서 가능)
                return num1 - num2;
            }
            // HEAD가 다른 경우 HEAD끼리 비교
            else {
                return head1.compareTo(head2);
            }
        });
        
        return files;
    
    
        
//         String[][] head = new String[2][files.length];
//         String[][] number = new String[2][files.length];
//         String[][] tail = new String[2][files.length];
        
//         // 1. 파일명을 HEAD, NUMBER, TAIL로 나눈다.
//         int[][] endPointer = new int[3][String.length]
//         for (int i = 0; i < files.length; i++) {
//             char[] arr = files[i].toCharArray();
//             int headEnd = 0;
//             int numberEnd = 0;
//             // for (int i = 0; i < arr.length; i++) {
//             StringBuilder sb1 = new StringBuilder();
//             while (!Character.isDigit(arr[headEnd])) // 숫자가 아니면
//                 headEnd++;
//                 sb1.append(arr[headEnd]);
//             }
//             head[0][i] = i;
//             head[1][i] = sb1.toString();
//             numberEnd = headEnd;
        
//             StringBuilder sb2 = new StringBuilder();
//             while (Character.isDigit(arr[numberEnd])) {// 숫자일 때
//                 numberEnd++;
//                 sb2.append(arr[numberEnd]);
//             }
//             number[0][i] = i;
//             number[1][i] = sb1.toString();
        
//             tail[0][i] = i;
//             tail[1][i] = new String(arr, numberEnd+1 , arr.length -1 - numberEnd+1);
        
        
//             // endPointer[0][i] = headEnd;
//             // endPointer[1][i] = numberEnd;
//             // endPointer[2][i] = files[i].length - 1;
//         }
    }
    public static int getNumber(String str) {
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        // 첫 번째 숫자를 발견할 때까지 인덱스를 이동시킴
        while (idx < arr.length && !Character.isDigit(arr[idx])) {
            idx++;
        }
        while (idx < arr.length && Character.isDigit(arr[idx])) {
            sb.append(arr[idx]);
            idx++;
        }
        // for (int i = 0; i < arr.length; i++) {
        //     if (Character.isDigit(arr[i])) { // ** Character.isDigit() **
        //         sb.append(arr[i]);
        //     }
        // }
        return Integer.parseInt(sb.toString());
    }
}