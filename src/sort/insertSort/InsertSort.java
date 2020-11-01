package sort.insertSort;

import java.util.Random;

/**
 * program: sort
 * description: 直接插入排序
 * author: Leet
 * create: 2020-10-18 10:10
 **/
public class InsertSort {

    public static void main(String[] args) {
        int[] nums = new int[10];

        // 随机数生成 10 个小于20的正整数
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            nums[i] = random.nextInt(100);
        }

        // 打印数组
        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();

        // 排序
        insertSort(nums);

        // 打印结果
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }

    /**
     * 直接插入排序
     * @param nums
     *        待排数组
     */
    public static void insertSort(int[] nums){
        for(int i = 0, j; i < nums.length; i++){

            // 寻找插入位置
            int t = nums[i];
            for(j = 0; j < i; j++){
                if(t <= nums[j])
                    break;
            }

            // 拷贝
            System.arraycopy(nums, j, nums, j + 1, i - j);

            // 插入
            nums[j] = t;
        }
    }
}
