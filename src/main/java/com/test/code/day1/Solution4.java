package com.test.code.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution4 {

    static String inputStr;
    static boolean answer;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         1-4. 회문수열인지 아닌지 판단 하는 함수를 작성하라
         */
        System.out.print("inputStr : ");
        inputStr = br.readLine().replaceAll(" ","");
        answer = hasPalindrome(inputStr);
        System.out.println("answer : " + answer);

    }

    // 우선 회문에 대한 정의를 이해못하여 찾아봄 ,
    // -> 각 문자의 등장 횟수를 구하고 홀수 번 반복되는 수가 2개 이상이라면 회문이 아니다.
    private static boolean hasPalindrome(String inputStr) {
        // 중복되어 들어가는 단어 체크
        Map<Character ,Integer> map = new HashMap<>();
        inputStr = inputStr.toLowerCase();
        // Tact Coa, 입력 시 공백 제거, 소문자 적용
        // AaaBadef,
        // tactcoa t->1 , a-> 1
        for (char a : inputStr.toCharArray()) {
            // if a -> a , a -> values 는 1 이됨, 나머지 0
            map.put(a, map.getOrDefault(a,0) +1);
        }

        int oddCnt = 0; // 홀수 갯수
        // 맵의 모든 값을 순환 하여 홀수 갯수가 1개 이상인지 체크
        // 1(t), 1(a),0,0,0
        for (int count : map.values()) {
            if (count % 2 != 0) {
                oddCnt++;
            }
            if (oddCnt > 1) {
                return false;
            }
        }
        return true;
    }
}
