package sort.insertsort;

import org.junit.Test;
import sort.Sort;
import sort.TestData;

/**
 * program: sort
 * description: 直接插入排序
 * @author: Leet
 * create: 2020-10-18 10:10
 **/
public class InsertSortTest implements Sort {

    @Test
    public void test() {
        TestData.testSort(new InsertSortTest());
    }

    @Override
    public void sort(int[] nums) {
        insertSort(nums);
    }

    /**
     * 直接插入排序
     * @param nums
     *        待排数组
     */
    public void insertSort(int[] nums){
        for (int i = 1, j; i < nums.length; i++) {
            j = i;
            int t = nums[i];

            while (j > 0 && nums[j - 1] > t) {
                nums[j] = nums[j - 1];
                j--;
            }

            if (j != i) {
                nums[j] = t;
            }
        }
    }
}
