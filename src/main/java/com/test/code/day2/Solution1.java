package com.test.code.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1 {

    static String inputStrA;
    static String inputStrB;
    static boolean answer;

    // 1. 배열과 문자열 해법
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("inputStrA : ");
        inputStrA = br.readLine();
        System.out.print("inputStrB : ");
        inputStrB = br.readLine();

        answer = stringEditing(inputStrA, inputStrB);
        System.out.println("answer : " + answer);
    }

         /*
        1-5. 문자열 편집
         문자열 2개 (pale, ple ) -> 문자열을 같게 만들기 위한 편집횟수가 1회 이내인지 확인
         삽입 , 삭제 , 교체
         */
    private static boolean stringEditing(String inputStrA, String inputStrB) {
        // 수정 대상과 비교대상을 나누어준다
        String strA = inputStrA.length() >= inputStrB.length() ? inputStrA :inputStrB;
        String strB = inputStrB.length() >= inputStrA.length() ? inputStrA :inputStrB;
        int lengthA = strA.length();
        int lengthB = strB.length();
        // 길이의 차이가 1 이상이면 1회 이상의 삽입이 발생한다고 판단
        if ( lengthA - lengthB > 1 ) return true;

        int indexA = 0;
        int indexB = 0;
        int cnt = 0;
        while (indexA < lengthA && indexB < lengthB) {
            if (cnt > 1) return true;
            // 문자가 다르면 교체 및 삭제가 일어남
            if (strA.charAt(indexA) != strB.charAt(indexB)) cnt++;
            indexA++;
            indexB++;
        }
        return false;
    }

    // 접근방식 자체는 비슷했지만 처리부가 상이
    boolean oneEditAway (String first, String second) {
        // 절댓값을 구하는 함수를 사용 ,
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int index1 = 0;
        int index2 = 0;
        boolean fountDiffer = false;

        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                // 반드시 첫 번째로 다른 문자여야함
                if (fountDiffer) return false;
                fountDiffer = true;

                if (s1.length() == s2.length()) {
                    index1 ++; // 교체의 경우 짧은 문자열의 포인터 증가
                }
            } else {
                index1 ++; // 동일하다면 짧은 문자열 포인터 증가
            }
            index2++; //긴 문자열의 포인터는 언제나 증가
        }
        return true;
    }
}
