package sort;

import java.util.Random;

/**
 * program: sort
 * description: 快速排序
 *              概括一下，方便记忆：
 *                              超级秘技：坂本左右反复横跳
 * author: Leet
 * create: 2020-10-15 22:57
 **/
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[10];

        // 随机数生成 10 个小于20的正整数
        Random random = new Random(10);
        for (int i = 0; i < 10; i++) {
            nums[i] = random.nextInt(20);
        }

        // 排序
        quickSort(nums, 0, nums.length - 1);

        // 打印结果
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }

    public static void quickSort(int[] nums, int begin, int end){
        if(begin < end){
            int i = partition(nums, begin, end);
            quickSort(nums, begin, i - 1);
            quickSort(nums, i + 1, end);
        }
    }

    private static int partition(int[] nums,int low, int high){
        int i = low;
        int j = high;
        int baseNum = nums[low];

        while(i < j){
            //先从后向前寻找第一个小于等于 baseNum 的数
            while(i < j && nums[j] >= baseNum)
                j--;

            //把从后面找到的数赋给 nums[i],
            nums[i] = nums[j];

            //接着从前往后寻找第一个大于 baseNum 的数
            while(i < j && nums[i] < baseNum)
                i++;

            //把从前面找到的数赋给 num[j]
            nums[j] = nums[i];
        }

        //循环结束：i == j
        nums[i] = baseNum;

        return i;
    }
}
