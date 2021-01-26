package src;

import java.util.Arrays;

public class MutilArray {
    public static void main(String[] args) {
        // 用二维数组表示的学生成绩:
        int[][] scores = {
                { 82, 90, 91 },
                { 68, 72, 64 },
                { 95, 91, 89 },
                { 67, 52, 60 },
                { 79, 81, 85 },
        };
        //
        double average = 0;
        double sum=0;
//        for(int[] arr:scores){
//          for(int n:arr){
//              sum=sum+n;
//          }
//        }
        for(int i=0;i<=scores.length-1;i++){
            for(int j=0;j<=scores[i].length-1;j++){
                sum=sum+scores[i][j];
            }
        }
        System.out.println(sum);
        average=sum/(scores[0].length*scores.length);
        System.out.println(average);

        if (Math.abs(average - 77.733333) < 0.000001) {
            System.out.println("测试成功");
        } else {
            System.out.println("测试失败");
        }


        /**
         * 三维数组
         */
        int[][][] ns = {
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                },
                {
                        {10, 11},
                        {12, 13}
                },
                {
                        {14, 15, 16},
                        {17, 18}
                }
        };

        System.out.println(Arrays.deepToString(ns[0]));
    }
}

