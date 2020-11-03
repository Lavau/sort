package sort.insertsort;

import org.junit.Test;
import sort.Sort;
import sort.TestData;

/**
 * description: 希尔排序
 *                一种特殊的插入排序
 * @author: Leet
 * create: 2020-10-20 21:04
 **/
public class ShellSortTest implements Sort {

    @Test
    public void test() {
        TestData.testSort(new ShellSortTest());
    }


    @Override
    public void sort(int[] nums) {
        shellSort(nums);
    }

    public void shellSort(int[] nums){
//        for (int step = length / 2; step >= 1; step /= 2) {
//            for (int i = step; i < length; i++) {
//                temp = arr[i];
//                int j = i - step;
//                while (j >= 0 && arr[j] > temp) {
//                    arr[j + step] = arr[j];
//                    j -= step;
//                }
//                arr[j + step] = temp;
//            }
//        }
//
//        int gap = nums.length / 3 + 1;
        for (int gap = nums.length / 3 + 1; gap > 0; gap = gap / 3 + 1){
            for (int i = gap, j; i < nums.length; i++) {
                j = i;
                int t = nums[i];

                while (j > 0 && nums[j - gap] > t) {
                    nums[j] = nums[j - gap];
                    j -= gap;
                }

//                if (j != i) nums[j] = t;
            }
        }

    }
}
