package sort.insertsort;

import org.junit.Test;
import sort.Sort;
import sort.TestData;

/**
 * program: sort
 * description: 折半插入排序
 *              (与直接插入相比，区别在于：寻找插入位置的方式不同）
 * @author: Leet
 * create: 2020-10-18 10:32
 **/
public class BinaryInsertSortTest implements Sort {

    @Test
    public void binaryInsertSortTest() {
        TestData.testSort(new BinaryInsertSortTest());
    }

    @Override
    public void sort(int[] nums) {
        binaryInsertSort(nums);
    }

    /**
     * 折半插入排序
     * @param nums
     *        待排数组
     */
    private static void binaryInsertSort(int[] nums){
        for(int i = 0; i < nums.length; i++){

            // 寻找插入位置
            // left 被标记为最终插入的位置
            int left = 0;
            int right = i;
            int mid;
            int t = nums[i];
            while(left <= right){
                mid = (left + right) / 2;

                if(t == nums[mid]) {
                    left = mid; break;
                } else if(t < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            // 拷贝
            System.arraycopy(nums, left, nums, left + 1, i - left);

            // 插入
            nums[left] = t;
        }
    }
}
