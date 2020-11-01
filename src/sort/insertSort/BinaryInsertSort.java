package sort.insertSort;

import java.util.Random;

/**
 * program: sort
 * description: 折半插入排序
 *              (与直接插入相比，区别在于：寻找插入位置的方式不同）
 * author: Leet
 * create: 2020-10-18 10:32
 **/
public class BinaryInsertSort {

    public static void main(String[] args) {
        int[] nums = new int[5];

        // 随机数生成 10 个小于20的正整数
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            nums[i] = random.nextInt(100);
        }

        // 打印数组
        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();

        // 排序
        binaryInsertSort(nums);

        // 打印结果
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }

    /**
     * 折半插入排序
     * @param nums
     *        待排数组
     */
    public static void binaryInsertSort(int[] nums){
        for(int i = 0; i < nums.length; i++){

            // 寻找插入位置
            // left 被标记为最终插入的位置
            int left = 0;
            int right = i;
            int mid;
            int t = nums[i];
            while(left <= right){
                mid = (left + right) / 2;

                if(t == nums[mid]) {left = mid; break;}
                else if(t < nums[mid]) right = mid - 1;
                else left = mid + 1;
            }

            // 拷贝
            System.arraycopy(nums, left, nums, left + 1, i - left);

            // 插入
            nums[left] = t;
        }
    }
}
