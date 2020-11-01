package sort;

import java.util.Random;

/**
 * program: sort
 * description: 归并排序
 *              概括一下，方便自己记忆：原数组拷贝，三个while循环
 * author: Leet
 * create: 2020-10-15 22:56
 **/
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = new int[10];

        // 随机数生成 10 个小于20的正整数
        Random random = new Random(10);
        for (int i = 0; i < 10; i++) {
            nums[i] = random.nextInt(20);
        }

        // 排序
        mergeSort(nums);

        // 打印结果
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }

    public static void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    /**
     * 选择排序（从小到大）
     *
     * @param nums int[] 待排数组
     */
    public static void mergeSort(int[] nums, int first, int last) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergeSort(nums, first, mid);
            mergeSort(nums, mid + 1, last);
            merge(nums, first, last);
        }
    }

    public static void merge(int[] nums, int first, int last) {
        // 拷贝数组
        int[] numsCopy = new int[nums.length];
        System.arraycopy(nums, first, numsCopy, first, last - first + 1);

        // 指针准备
        int mid = (first + last) / 2;
        int i = first;
        int iLeft = first;
        int iRight = mid + 1;

        // 开始比较
        while (iLeft <= mid && iRight <= last) {
            while(iLeft <= mid && iRight <= last && numsCopy[iLeft] <= numsCopy[iRight]){
                nums[i++] = numsCopy[iLeft++];
            }

            if(iLeft > mid || iRight > last) break;

            while(iRight <= last && numsCopy[iLeft] >= numsCopy[iRight]){
                nums[i++] = numsCopy[iRight++];
            }
        }

        // 结尾处理
        if(iLeft > mid) while(iRight <= last) nums[i++] = numsCopy[iRight++];
        else while(iLeft <= mid) nums[i++] = numsCopy[iLeft++];
    }
}
