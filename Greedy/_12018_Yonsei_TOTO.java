import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/** 반성
 * 처음 문제를 보고 과목 별로 수강 인원, 신청 인원, 신청 마일리지의 값들들이 있으니 이 값들을 객체로 캡슐화해서 관리하려고 했다.
 * 다른 사람들의 풀이를 보니 문제를 풀기 위해서는 불필요한 작업이었다.(물론 나쁜건 아닌 것 같지만)
 * 어쨋든 다음부턴 최대한 짧고 가독성 좋게 풀어보자자
 */

// 두 번째 풀이(클래스 제거)
public class _12018_Yonsei_TOTO {
    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 총 과목 수
        int m = Integer.parseInt(st.nextToken()); // 총 마일리지

        int[] optimalMileage = new int[n];
        // 각 과목 당 신청 사람 수(applicantCnt), 과목 수강 인원(enrolledCnt)
        // 신청한 사람이 넣은 마일리지

        /** 풀이 방법
         * 과목별로로
         * - 수강 인원이 신청 인원보다 크다면 마일리지 1 분배
         * - 수강 인원보다 신청 인원이 크다면 커트라인 마일리지 분배
         *    커트라인 구하기: 마일리지를 오름차순으로 정렬한 후 (신청 인원 - 수강 인원)번째 인원의 마일리지
         */
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int applicantCnt = Integer.parseInt(st.nextToken());
            int enrolledCnt = Integer.parseInt(st.nextToken());

            int[] optimalM = new int[applicantCnt];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < applicantCnt; j++) {
                optimalM[j] = Integer.parseInt(st.nextToken());
            }

            // 수강 인원 > 신청 인원 -> 최저 마일리지 1로 수강 신청
            if (applicantCnt < enrolledCnt) optimalMileage[i] = 1;
            // 수강 인원 <= 신청 인원 -> 커트라인 마일리지로 지원
            else {
                Arrays.sort(optimalM);
                optimalMileage[i] = optimalM[applicantCnt - enrolledCnt];
            }
        }

        int result = 0;
        // 위에서 구한 최소 마일리지를 오름차순으로 정렬하여 작은 값부터 순환하며 보유 마일리지 내에서 신청 가능하다면 신청
        Arrays.sort(optimalMileage);
        for (int i = 0; i < n; i++) {
            if (m >= optimalMileage[i]) {
                m -= optimalMileage[i];
                result++;
            } else break;
        }

        System.out.println(result);
    }
}

// 첫 번째 풀이
/*
public class Main {
    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 총 과목 수
        int m = Integer.parseInt(st.nextToken()); // 총 마일리지

        subject[] subjects = new subject[n];
        // 각 과목 당 신청 사람 수(applicantCnt), 과목 수강 인원(enrolledCnt)
        // 신청한 사람이 넣은 마일리지
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int applicantCnt = Integer.parseInt(st.nextToken());
            int enrolledCnt = Integer.parseInt(st.nextToken());
            subjects[i] = new subject(enrolledCnt, new int[applicantCnt]);

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < applicantCnt; j++) {
                subjects[i].applicantCount[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(subjects[i].applicantCount); // 오름차순 정렬
        }

        // 각 과목을 순환하면서 수강할 수 있는 최저 마일리지를 계산하여 optimalMileage 배열에 삽입
        int[] optimalMileage = new int[n];
        for (int i = 0; i < n; i++) {
            optimalMileage[i] = subjects[i].optimal();
        }

        // optimalMileage를 오름차순 정렬하여 최대로 들을 수 있는 과목 개수 출력
        // optimalMileage를 순환하며 최대로 들을 수 있는 과목 개수 출력
        int result = 0;
        Arrays.sort(optimalMileage);
        for (int i = 0; i < n; i++) {
            if (optimalMileage[i] <= m) {
                m -= optimalMileage[i];
                result++;
            } else {
                break;
            }
        }
        System.out.println(result);
    }
    
}

// 과목별 수강 인원, 신청 인원별 마일리지, 최솟값으로 
class subject {
    public int enrolledCount; // 수강 인원
    public int[] applicantCount; // 신청 인원 별 마일리지
    public int index; // 목표 마일리지 인덱스 -> 이 값보다 1 크게 마일리지 분배

    public subject(int enrolledCount, int[] applicantCount) {
        this.enrolledCount = enrolledCount;
        this.applicantCount = applicantCount;
        this.index = applicantCount.length - enrolledCount;
    }

    // 만약 수강 인원보다 신청 인원이 적다면(index < 0) -> 마일리지 1 분배
    // 수강 인원보다 신청 인원이 많다면(index >= 0) -> "현재 신청한 인원 중 마지막 순서인 사람 마일리지" + 1 분배
    public int optimal() {
        if (index >= 0) {
            return applicantCount[index];
        } else {
            return 1;
        }
    }
}
*/

// 두 번째 풀이 -> 첫번째 풀이 subject 클래스 optimal() 메소드 살짝 변형형
/*
public class Main {
    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 총 과목 수
        int m = Integer.parseInt(st.nextToken()); // 총 마일리지

        subject[] subjects = new subject[n];
        // 각 과목 당 신청 사람 수(applicantCnt), 과목 수강 인원(enrolledCnt)
        // 신청한 사람이 넣은 마일리지
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int applicantCnt = Integer.parseInt(st.nextToken());
            int enrolledCnt = Integer.parseInt(st.nextToken());
            subjects[i] = new subject(enrolledCnt, new int[applicantCnt]);

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < applicantCnt; j++) {
                subjects[i].applicantCount[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(subjects[i].applicantCount); // 오름차순 정렬
        }

        // 각 과목을 순환하면서 수강할 수 있는 최저 마일리지를 계산하여 optimalMileage 배열에 삽입
        int[] optimalMileage = new int[n];
        for (int i = 0; i < n; i++) {
            optimalMileage[i] = subjects[i].optimal();
        }

        // optimalMileage를 오름차순 정렬하여 최대로 들을 수 있는 과목 개수 출력
        // optimalMileage를 순환하며 최대로 들을 수 있는 과목 개수 출력
        int result = 0;
        Arrays.sort(optimalMileage);
        for (int i = 0; i < n; i++) {
            if (optimalMileage[i] <= m) {
                m -= optimalMileage[i];
                result++;
            } else {
                break;
            }
        }
        System.out.println(result);
    }
    
}

// 과목별 수강 인원, 신청 인원별 마일리지, 최솟값으로 
class subject {
    public int enrolledCount; // 수강 인원
    public int[] applicantCount; // 신청 인원 별 마일리지
    public int index; // 목표 마일리지 인덱스 -> 이 값보다 1 크게 마일리지 분배

    public subject(int enrolledCount, int[] applicantCount) {
        this.enrolledCount = enrolledCount;
        this.applicantCount = applicantCount;
        this.index = applicantCount.length - enrolledCount;
    }

    // 만약 수강 인원보다 신청 인원이 적다면(index < 0) -> 마일리지 1 분배
    // 수강 인원보다 신청 인원이 많거나 같다면(index >= 0) -> "현재 신청한 인원 중 마지막 순서인 사람 마일리지" + 1 분배
    public int optimal() {
        if (applicantCount.length >= enrolledCount) {
            return applicantCount[index];
        } else {
            return 1;
        }
    }
}
 */