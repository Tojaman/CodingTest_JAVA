package Implementation;

/**
- 멜로디가 끝부분~첫부분 순으로 이어진 걸 수도 있음: "ABCDEFG" == "CDEFGAB"
- 음은 1분에 한개씩 재생: "ABCD"는 4분
- 제목, 재생 시작 ~ 종료 시간, 악보
- 음악 길이 < 재생 시간: 재생 시간만큼 반복 재생
- 음악 길이 > 재생 시간: 재생 시간만큼 재생
- 조건 일치 음악 여러 개 -> max(재생 시간) 반환 && previus(등록 시간)
- 조건 일치 음악X -> return "(None)"
**/

// 시도3: 2시간 걸렸고 시도3은 chatGPT가 했음 ;;
class _17683_3차_방금그곡 {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        // m 정규화
        String target = normalize(m);
        
        int lastDuration = -1; // 시간, 제목
        for (int i = 0; i < musicinfos.length; i++) {
            String[] musicinfo = musicinfos[i].split(","); // 시작, 종료, 제목, 음
            String title = musicinfo[2];
            String score = normalize(musicinfo[3]); // # 정규화 -> 소문자로
            int duration = diffMinutes(musicinfo[0], musicinfo[1]);
            
            // 재생 시간에 맞는 음(score) 생성
            String playedScore = buildPlayedMelody(score, duration);
            
            System.out.println(playedScore);
            // 곡 정보 검증
            // m이 라디오에 나온 실제 음에 포함 && 전에 포함되는 곡보다 재생 길이가 큼
            if (playedScore.contains(target) && lastDuration < duration) {
                lastDuration = duration;
                answer = title;
            }
        }
        
        return answer;
    }
    
    private int diffMinutes(String start, String end) {
        String[] s = start.split(":");
        String[] e = end.split(":");
        int sm = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
        int em = Integer.parseInt(e[0]) * 60 + Integer.parseInt(e[1]);
        return em - sm;
    }
    
    private String normalize(String s) {
        return s.replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g")
                .replaceAll("A#", "a");
    }
    
    private String buildPlayedMelody(String score, int duration) {
        StringBuilder newScore = new StringBuilder();
        
        int scoreCnt = score.length();
        for (int i = 0; i < duration; i++) newScore.append(score.charAt(i % scoreCnt));
        
        return newScore.toString();
    }
}


/** 시도2 O: 가독성 너무 안좋다 ;;
 * 반성하렴
    * 실제 재생 음 구하는 로직 쓸대없이 복잡함
    * 코드가 너무 길어지면 메서드화 하기
class _17683_3차_방금그곡 {
    // m: 멜로디 담은 문자열(음: C, C#, D, D#, E, F, F#, G, G#, A, A#, B) (1 <= m <= 1439)
    // musicinfos: 곡 정보(시작한 시각, 끝난 시각, 음악 제목, 악보) 곡 정보 (musicinfos <= 100)
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        String target = normalize(m);
        String[][] actualMusic = new String[musicinfos.length][2]; // 실제 재생 음
        
        int lastDuration = -1; // 시간, 제목
        for (int i = 0; i < musicinfos.length; i++) {
            String[] musicinfo = musicinfos[i].split(","); // 시작, 종료, 제목, 음
            String[] start = musicinfo[0].split(":");
            String[] end = musicinfo[1].split(":");
            musicinfo[3] = normalize(musicinfo[3]); // # 정규화 -> 소문자로
            int duration = (Integer.parseInt(end[0]) - Integer.parseInt(start[0])) * 60
                            + Integer.parseInt(end[1]) - Integer.parseInt(start[1]);
                
            if (musicinfo[3].length() >= duration) { // 재생 시간 <= 저장된 음 -> 자르기
                actualMusic[i][0] = musicinfo[3].substring(0, duration);
                actualMusic[i][1] = musicinfo[2];
            } else { // 재생 시간 > 저장된 음 -> 이어서 더하기(처음 ~ 끝 + 처음~실제 재생 시간까지)
                StringBuilder newTune = new StringBuilder(); // 실제 저장된 음
                
                int plus1 = duration/(musicinfo[3].length()); // 배수
                int plus2 = duration%(musicinfo[3].length()); // 나머지

                for (int j = 0; j < plus1; j++) {
                    newTune.append(musicinfo[3].substring(0));
                }
                newTune.append(musicinfo[3].substring(0, plus2));
                actualMusic[i][0] = newTune.toString();
                actualMusic[i][1] = musicinfo[2];
            }
            
            // 곡 정보 검증
            // m이 라디오에 나온 실제 음에 포함 && 전에 포함되는 곡보다 재생 길이가 큼
            if (actualMusic[i][0].contains(target) && lastDuration < duration) {
                answer = actualMusic[i][1];
                lastDuration = duration;
            }
        }
        
        return answer;
    }
    private String normalize(String s) {
        return s.replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g")
                .replaceAll("A#", "a");
    }
}
**/

/* 시도1 X: 정규화 생각 못함
public class _17683_3차_방금그곡 {
    // m: 멜로디 담은 문자열(음: C, C#, D, D#, E, F, F#, G, G#, A, A#, B) (1 <= m <= 1439)
    // musicinfos: 곡 정보(시작한 시각, 끝난 시각, 음악 제목, 악보) 곡 정보 (musicinfos <= 100)
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        String[][] actualMusic = new String[musicinfos.length][2]; // 실제 재생 음
        
        for (int i = 0; i < musicinfos.length; i++) {
            String[] musicinfo = musicinfos[i].split(","); // 시작, 종료, 제목, 음
            String[] start = musicinfo[0].split(":");
            String[] end = musicinfo[1].split(":");
            int duration = (Integer.parseInt(end[0]) - Integer.parseInt(start[0])) * 60
                            + Integer.parseInt(end[1]) - Integer.parseInt(start[1]);
            
            int showCnt = 0;
            for (int j = 0; j < musicinfo[3].length(); j++) {
                if (musicinfo[3].charAt(i) == '#') showCnt++;   
            }
                
            if (musicinfo[3].length() >= duration) { // 재생 시간 <= 저장된 음 -> 자르기
                actualMusic[i][0] = musicinfo[3].substring(0, duration+showCnt);
                actualMusic[i][1] = musicinfo[2];
            } else { // 재생 시간 > 저장된 음 -> 이어서 더하기(처음 ~ 끝 + 처음~실제 재생 시간까지)
                StringBuilder newTune = new StringBuilder(musicinfo[3]); // 실제 저장된 음
                
                int plus1 = duration/(musicinfo[3].length() - showCnt); // 배수
                int plus2 = duration%(musicinfo[3].length() - showCnt); // 나머지
                for (int j = 0; j < plus2; j++) { // 나머지 중 #이 있다면 포함시키기 위해 plus2++
                    if (musicinfo[3].charAt(j) == '#') plus2++;
                }
                for (int j = 0; j < plus1; j++) {
                    newTune.append(musicinfo[3].substring(0));
                }
                newTune.append(musicinfo[3].substring(0, plus2));
                actualMusic[i][0] = newTune.toString();
                actualMusic[i][1] = musicinfo[2];
            }
        }
        
        int answerIndex = -1;
        for (int i = 0; i < actualMusic.length; i++) {
            if (actualMusic[i][0].contains(m)) {
                answer = actualMusic[i][1];
            }   
        }
        return answer;
    }
}
*/