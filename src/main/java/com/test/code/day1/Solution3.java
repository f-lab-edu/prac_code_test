package com.test.code.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3 {

    static String inputStr;
    static int inputNum;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         1-3. URL화, 문자열에 들어있는 모든 공백을 %20 으로 바꿔주는 메서드를 작성해라
         제시되는 문자열의 길이와 문자열이 주어짐.
         */
        System.out.print("inputStr : ");
        inputStr = br.readLine();
        System.out.print("inputNum : ");
        inputNum = Integer.parseInt(br.readLine());

        //replaceSpaces_old(inputStr,inputNum);

    }

    /**
     1-3. 문자열 치환
     // NOTE -> 문제를 전혀 잘못이해함, 입력되는 수가 문자열의 길이와 일치하는지 비교하는 것인줄 착각..
                추가적으로 자바인 경우 String 이 아닌 char[] 를 이용하라고 제시하였는데 사용하지않음 ,
                정답과 비교 시 ,접근방식이 ...
     */
    private static void replaceSpaces_old(String inputStrA, int inputNumB) {
        StringBuilder sb = new StringBuilder();
        String result = "";

        char[] charArraysA = inputStrA.toCharArray();
        if (charArraysA.length != inputNumB) return;

        for (char a : charArraysA) {
            if (String.valueOf(a).equals(" ")) {
                sb.append("%20");
            }
            sb.append(a);
        }
        result = String.valueOf(sb).replaceAll(" ","");
        System.out.println(result);
    }


    private static void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0 , index,i = 0;
        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++; // 공백 갯수
            }
        }
        // 공백 갯수 만큼 공간을 늘린다.
        index = trueLength + spaceCount * 2;
        // 실제 길이 이후의 값은 고려하지않는다.
        if (trueLength < str.length) str[trueLength] = '\0'; // 배열의 끝
        // i -> 13,12,11 ...
        // 뒤 -> 앞 인덱스 단위 문자열 치환 , 공백이 아닌경우 문자열 복사
        for(i = trueLength; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index -1] = str[i];
                index--;
            }
        }
    }

}
