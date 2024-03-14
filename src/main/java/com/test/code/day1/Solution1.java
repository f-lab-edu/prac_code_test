package com.test.code.day1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// Desc :: 코딩 테스트 연습 1일차
public class Solution1 {

    static String input;
    static boolean answer;

    // 1. 배열과 문자열 해법
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        1-1. 중복이 업는가 ? 문자열이 주어졌을 때, 문자열에 같은 문자가 중복되어 등장하는지 확인
         */
        System.out.print("input_string : ");
        input = br.readLine();
        // 중복되는 문자가 존재하면 true 반환
        answer = hasDuplicated(input);
        System.out.println("answer : " + answer);

    }

    // 1-1 중복 체크
    // set -> 중복 관련 문제를 해결할 수 있는 자료구조임을 알고 있어 비교적 쉽게 해결
    private static boolean hasDuplicated(String input) {
        Set<Character> set = new HashSet<>();
        for (char a : input.toCharArray()) {
            if (!set.add(a)) { // set 에 이미 문자열이 존재한다면 false 를 반환
                return true;
            }
        }
        return false;
    }

}
