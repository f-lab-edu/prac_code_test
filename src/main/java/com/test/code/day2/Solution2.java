package com.test.code.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2 {

    static String inputStr;
    static String answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("inputStrA : ");
        inputStr = br.readLine();
        answer = compressString(inputStr);
        System.out.println("answer : " + answer);

    }

    /*
    1-6. 문자열 압축
        반복되는 문자의 개수를 세는 방식의 기본적인 문자열 압축 메서드 작성
        aabcccccaaa 압축 -> a2b1c5a3
        기존문자열보다 길어진다면 기존문자열 반환
        -> 카카오톡에서도 좀 더 심화된(?) 문자열 압축 문제 나온적있음!.
        // Set 을 활용하여 중복 단어 제거 후 매칭되는 알파벳의 갯수를 세는 방향으로도 접근해봤지만 ..복잡도가 올라가는 것 같다..
     */
    private static String compressString(String inputStr) {

        StringBuilder sb = new StringBuilder();
        char currentChar = inputStr.charAt(0); // a
        int len = inputStr.length();
        int count = 1;

        //  aabcccccaaa 압축 -> a2b1c5a3
        for (int i = 0; i < len; i ++) {
            if (currentChar == inputStr.charAt(i)) {
                count++;
            }
            else {
                sb.append(currentChar).append(count);
                currentChar = inputStr.charAt(i);
                count = 1;
            }
        }
        // FIX -> 마지막 단어의 갯수가 빠짐 ,
        sb.append(currentChar).append(count);


        if(sb.length() > inputStr.length()) return inputStr;
        return sb.toString();
    }
}
