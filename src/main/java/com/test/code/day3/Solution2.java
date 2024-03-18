package com.test.code.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2 {

    static String inputStrA;
    static String inputStrB;

    static Boolean answer;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("inputStrA : ");
        inputStrA = br.readLine();
        System.out.println("inputStrB : ");
        inputStrB = br.readLine();
        answer = isSubstring(inputStrA, inputStrB);
        System.out.println("answer : " + answer);
    }
    /*
        1-9 문자열 회전 , 한 단어가 다른 문자열 안에 포함되어있는지 확인하는 메서드
        s1, s2 두 문자열이 주어짐 -> s2가 s1 을 회전시킨 결과인지 판별하고자 한다.
        (ex, "waterbottle -> erbottlewat")
        // 힌트를 확인하니 생각보다 쉽게 풀렸지만 , 교재를 참고하여 비교해봐야겠다.
     */

    private static boolean isSubstring (String s1 , String s2){
        if ("".equals(s1) || s1 == null) return false;
        if ("".equals(s2) || s2 == null) return false;

        // 풀이 방식이 떠오르지 않아 HINT 참고
        // 어디서 잘렸을까? "waterbottle -> erbottlewat" , wat 이 뒤로감
        // x = wat ,+ y = erbottle -> 원본 (xy) , 회전 (yx)
        // 다시 원점으로 돌아가서 ,
        // s1 = "waterbottle" , s2 = "erbottlewat"
        // s2 + s2 = "erbottle'waterbottle'wat" 문자열이 포함되었다고 가정한다면 원본(s1)이 포함될 수 밖에 없다.
        s2 += s2;
        return s2.contains(s1);
    }
}
