package sort;

import java.util.Random;

/**
 * program: sort
 * description: 冒泡排序
 * author: Leet
 * create: 2020-10-11 19:47
 **/
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = new int[10];

        // 随机数生成 10 个小于20的正整数
        Random random = new Random(10);
        for (int i = 0; i < 10; i++) {
            nums[i] = random.nextInt(20);
        }

        // 排序
        bubbleSort(nums);

        // 打印结果
        for (int n: nums) {
            System.out.print(n + " ");
        }
    }

    /**
     * 冒泡排序（从小到大）
     * @param nums
     *        int[] 待排数组
     */
    public static void bubbleSort(int[] nums){
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length - i - 1; j++){
                if(nums[j] > nums[j + 1]){
                    int t = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = t;
                }
            }
        }
    }
}
