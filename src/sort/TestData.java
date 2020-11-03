package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * description: 排序测试数据
 * author: Leet
 * create: 2020-11-02 16:36
 **/
public class TestData {

    public static void testSort(Sort sort) {
        int[] nums = new int[10];

        // 随机数生成 10 个小于20的正整数
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            nums[i] = random.nextInt(20);
        }

        System.out.println(Arrays.toString(nums));

        // 排序
        sort.sort(nums);

        System.out.println(Arrays.toString(nums));
    }
}
