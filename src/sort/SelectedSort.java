package sort;

import java.util.Random;

/**
 * program: sort
 * description: 选择排序
 * author: Leet
 * create: 2020-10-11 19:56
 **/
public class SelectedSort {

    public static void main(String[] args) {
        int[] nums = new int[10];

        // 随机数生成 10 个小于20的正整数
        Random random = new Random(10);
        for (int i = 0; i < 10; i++) {
            nums[i] = random.nextInt(20);
        }

        // 排序
        selectedSort(nums);

        // 打印结果
        for (int n: nums) {
            System.out.print(n + " ");
        }
    }

    /**
     * 选择排序（从小到大）
     * @param nums
     *        int[] 待排数组
     */
    public static void selectedSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            // 初始化参数，假定下标为 0 的元素值最大
            int maxI = 0;
            int j = 1;

            // 查找最大的元素的下标
            for (; j < nums.length - i; j++) {
                if(nums[maxI] < nums[j])
                    maxI = j;
            }

            // 进行转换
            int t = nums[maxI];
            nums[maxI] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = t;
        }
    }
}
