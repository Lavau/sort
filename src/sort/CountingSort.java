package sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * description: 计数排序
 * author: Leet
 * create: 2020-11-01 17:50
 **/
public class CountingSort implements Sort{

    @Test
    public void countingSortTest() {
        int[] nums = new int[10];

        // 随机数生成 10 个小于20的正整数
        Random random = new Random(10);
        for (int i = 0; i < 10; i++) {
            nums[i] = random.nextInt(20);
        }

        System.out.println(Arrays.toString(nums));

        sort(nums);
    }

    @Override
    public void sort(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        // 寻找最小值与最大值
        int minValue = nums[0];
        int maxValue = nums[0];
        for (int n : nums) {
            if (minValue > n) {
                minValue = n;
            } else if (maxValue < n) {
                maxValue = n;
            }
        }

        countingSort(nums, minValue, maxValue);
    }

    /**
     * 计数排序
     * @param nums 待排元素
     * @param minValue 最小值
     * @param maxValue 最大值
     */
    private void countingSort(int[] nums, int minValue, int maxValue) {
        int[] countingBucket = new int[maxValue - minValue + 1];

        // 计数
        for (int n : nums) {
            int key = n - minValue;
            countingBucket[key] = ++ countingBucket[key];
        }

        // 排序
        for (int i = 0, j = 0; i < countingBucket.length; i++) {
            if (countingBucket[i] > 0) {
                Arrays.fill(nums, j, j + countingBucket[i], minValue + i);
                j += countingBucket[i];
            }
        }

        System.out.println(Arrays.toString(nums));
    }
}
