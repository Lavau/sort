package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * description: 堆排序
 * author: Leet
 * create: 2020-10-23 08:41
 **/
public class HeapSort {

    @Test
    public void heapSortTest() {
        int[] tree = new int[6];

        for (int i = 0; i < 6; i++){
            tree[i] = (int)(Math.random() * 10);
        }

        heapSort(tree);

        System.out.println(Arrays.toString(tree));
    }

    /**
     * 堆排序
     * @param tree 待排序的数组
     */
    public void heapSort(int[] tree) {
        // 先构建一个初始堆
        buildHeap(tree);

        for (int i = tree.length - 1; i >= 0; i--) {
            swap(tree, i, 0);

            heapify(tree, i, 0);
        }
    }

    /**
     * 堆化
     * 前提：
     *      当前节点的左子树或右子树已经是一个堆
     * @param tree 初始堆
     * @param treeLength 堆的大小
     * @param i 当前进行堆化的节点
     */
    private void heapify(int[] tree, int treeLength, int i) {
        // 如果进行堆化的当前节点超出树的节点总数，则结束递归
        if (i >= treeLength) return;

        int c1 = 2 * i + 1; // 当前节点的左孩子
        int c2 = 2 * i + 2; // 当前节点的右孩子

        int max = i; // 存储当前节点、它的左孩子、它的右孩子中最大的节点（先假设当前节点最大）
        if (c1 < treeLength && tree[c1] > tree[max]) {
            max = c1;
        }
        if (c2 < treeLength && tree[c2] > tree[max]) {
            max = c2;
        }

        // 交换最大节点与父节点的位置
        if(max != i) {
            swap(tree, max, i);

            // 递归：最大节点为当前节点
            heapify(tree, treeLength, max);
        }
    }

    /**
     * 从零开始，将一个无序的树构建成一个堆
     * @param tree 初始树
     */
    private void buildHeap(int[] tree) {
        int lastNode = tree.length - 1; // 最后一个结点
        int parent = (lastNode - 1) / 2; // 最后一个结点的父节点，并从它开始构建堆

        // 并从最后一个结点的父节点构建堆，并依次递减
        for (int i = parent; i >= 0; i--) {
            heapify(tree, tree.length, i);
        }
    }

    /**
     * 交换堆中两个数的位置
     */
    private void swap(int[] tree, int i, int j) {
        int temp = tree[i];
        tree[i] = tree[j];
        tree[j] = temp;
    }

}
