package HashTable; /** 문제 설명
phone_book[]의 요소로 전화번호가 들어 있다.
한 번호가 다른 번호의 접두사인지 확인하고
있다면 false, 없다면 true 반환
*/

/** 풀이 방법
- 특정 값의 크기로 나머지를 자른 후 비교
    phone_book의 모든 값을 순회하며 그 값의 길이만큼 나머지 값을 자르고 비교하여 존재한다면 false 반환
- 특정 값을 처음부터 순회하면서 HashSet에 있나 비교
*/
import java.util.HashSet;

class _42577_전화번호_목록 {
    public boolean solution(String[] phone_book) {

        HashSet<String> hs = new HashSet<>();
        for (String phone : phone_book) 
            hs.add(phone);
        
        for (String phone : phone_book) {
            for (int i = 0; i < phone.length(); i++) {
                if (hs.contains(phone.substring(0, i)))
                    return false;
            }
        }
        return true;
    }
}