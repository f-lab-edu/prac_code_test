package com.test.code.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution2 {

    static String inputStrA;
    static String inputStrB;
    static boolean answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
         * 1-2. 문자열 2개가 주어졌을 때, 순열인지 확인
         */
        System.out.print("inputStrA : ");
        inputStrA = br.readLine();
        System.out.print("inputStrB : ");
        inputStrB = br.readLine();

        answer = compareString(inputStrA, inputStrB);
        System.out.println("answer : " + answer);

    }

    // 1-2 문자열 비교 (순열)
    // 대,소문자 및 공백 에 대한 조건이 있는지 없는지도 확인 필요, 현재 문제에는 요건없었음.
    // Arrays.Sort 를 바로 생각함.
    private static boolean compareString(String inputStrA, String inputStrB) {
        // ex. ABC , ADF
        if (inputStrA.length() != inputStrB.length()) return false;
        // 정렬
        char[] charArraysA = inputStrA.toCharArray();
        Arrays.sort(charArraysA);
        inputStrA = new String(charArraysA);

        char[] charArraysB = inputStrB.toCharArray();
        Arrays.sort(charArraysB);
        inputStrB = new String(charArraysB);

        return inputStrA.equals(inputStrB);
    }
}
