package com.ccn.userapi.support;

import org.springframework.stereotype.Service;

@Service
public class SmellDemoService {

    // (1) 사용되지 않는 필드 (Unused private field)
    private String neverUsed = "I am unused";

    // (2) public static mutable (전역 가변 상태)
    public static String globalState = "MUTABLE";

    // (3) 하드 코딩된 매직 넘버 (Magic numbers) + System.out 사용
    public int calcScore(int level) {
        int bonus = 7; // <- 매직 넘버
        System.out.println("calcScore called"); // <- 로거 미사용
        return level * 42 + bonus; // <- 매직 넘버
    }

    // (4) 빈 catch (swallowed exception)
    public void swallow() {
        try {
            risky();
        } catch (Exception e) {  // <- 비어있는 catch
        }
    }

    private void risky() {
        throw new RuntimeException("boom");
    }

    // (5) 중복 코드 (Duplicated blocks)
    public String formatUser(String name) {
        String trimmed = name.trim();
        if (trimmed.isEmpty()) return "N/A";
        return "User: " + trimmed;
    }

    public String formatAdmin(String name) { // <- 위와 거의 동일 (복붙)
        String trimmed = name.trim();
        if (trimmed.isEmpty()) return "N/A";
        return "User: " + trimmed;
    }

    // (6) 루프 내 문자열 결합 (성능 스멜)
    public String joinBadly(Iterable<String> items) {
        String result = "";
        for (String s : items) {
            result += s; // <- StringBuilder 권장
        }
        return result;
    }

    // (7) 과도한 복잡도 (Cognitive/Cyclomatic)
    public boolean complexLogic(int a, int b, int c) {
        boolean ok = false;
        if (a > 0) {
            if (b > 0) {
                if (c > 0) {
                    ok = true;
                } else if (c == 0) {
                    ok = (a + b) > 10;
                } else {
                    ok = (a * b) > 100;
                }
            } else if (b == 0) {
                if (a > 10) {
                    ok = c >= 5;
                } else {
                    ok = c <= 5;
                }
            } else {
                ok = a % 2 == 0 && c != 3;
            }
        } else if (a == 0) {
            ok = b == c;
        } else {
            ok = (b < 0 && c < 0) || (b == 1 && c == 1);
        }
        return ok;
    }

    // (8) 주석 처리된 코드 (commented-out code)
    // TODO: remove commented code
    // public void legacy() {
    //     doSomethingOld();
    // }
}
