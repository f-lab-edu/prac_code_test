package com.test.code.day3;

import java.util.Arrays;

public class Solution1 {

    public static void main(String[] args) {


        Integer[][] matrix = {{1,1}, {0,1}, {1,1}};
        // 행 , 열 ,배열
        getZero(matrix.length,matrix[0].length,matrix);

    }

    /**
     * 1-8. 행렬
     * M X N 행렬의 한 원소가 0일 경우 , 해당 원소가 속한 행과 열의 모든 원소를 0으로 설정하는 알고리즘 작성
     * M -> 3 , N -> 2 3행 2열
     * 탐색 (?)
     * 우선 , 0의 위치를 찾자...
     *
     */
    private static void getZero (Integer M , Integer N, Integer[][] matrix) {
        // FIX -> 행/ 열 크기 만큼의 boolean 배열 생성
        boolean[] rows = new boolean[M];
        boolean[] cols = new boolean[N];

        // 시간복잡도를 고려해서 .. 문제와 관계없이 이중 for 문은 피하려햇으나..생각이 안남..
        for (int i=0; i < M; i++) {
            for (int j=0; j < N; j++) {
                if(matrix[i][j] == 0) {
                    System.out.printf("idx i : %d , idx j : %d " + "\n",i,j);
                    rows[i] = true;
                    cols[j] = true;
                    //setZero() -> 위치 기억 -> 열 반복
                    //return
                }
            }
        }

        // 이런 방법도 있었다..
        // rows[1] -> true
        // cols[0] -> true
        for (int i=0; i< M; i++) {
            for (int j=0; j < N; j++) {
                // (0.0) 0.1
                // (1.0) (1.1)
                // (2.0) 2.1
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 결과 출력
        System.out.println(Arrays.deepToString(matrix));
    }

    /**
     * 0 의 위치를 찾았다면 -> 해당 하는 행과 열의 값 변경
     */
    // 0 이 1 개 이상일 경우에는 이런식으로는 풀지못한다..
    private static void setZero (Integer i , Integer j , Integer[][] matrix) {
        //
    }
}
