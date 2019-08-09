package com.example.demo;

import com.example.demo.common.utils.TreeNode;

import java.text.DecimalFormat;
import java.util.*;

public class JavaDemo {
    static double[] list = new double[10];

    void listString(double[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }

    //    插入排序算法
    void insertionSort() {
        double key;
        long startTime = System.currentTimeMillis();
        for (int i = 1; i < list.length; i++) {
            key = list[i];
//            while (j + 1 > 0 && list[j] > key) {
//                list[j + 1] = list[j];
//                j = j - 1;
//                list[j + 1] = key;
//            }
            for (int j = i - 1; j + 1 > 0 && list[j] > key; j--) {
                list[j + 1] = list[j];
                list[j] = key;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("用时：" + (endTime - startTime) + "ms");
        listString(list);
    }

    /**
     * 分治排序
     */
    private static double[] result = new double[10];

    void mergeSort(double[] arr, int L, int R) {
        if (L < R) {
            int mid = L + ((R - L) >> 1);
            mergeSort(arr, L, mid);
            mergeSort(arr, mid + 1, R);
            mergeArray(arr, L, mid, R);
        }
        result = arr;
    }

    void mergeArray(double[] arr, int L, int mid, int R) {
        double[] temp = new double[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        // 比较左右两部分的元素，哪个小，把那个元素填入temp中
        while (p1 <= mid && p2 <= R) {
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 上面的循环退出后，把剩余的元素依次填入到temp中
        // 以下两个while只有一个会执行
        while (p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= R) {
            temp[i++] = arr[p2++];
        }
        // 把最终的排序的结果复制给原数组
        for (i = 0; i < temp.length; i++) {
            arr[L + i] = temp[i];
        }
    }

    private static List<Map> nameList = new ArrayList<>();

    /**
     * 递归查找所有路径
     *
     * @param root
     * @param num
     * @param nameMap
     */
    void treeTest(TreeNode root, int num, Map nameMap) {
        Map map = new HashMap();
        map.putAll(nameMap);
        map.put("name" + num, root.getName());
        if (root.getChildren().size() == 0) {
            nameList.add(map);
        }
        num++;
        for (int i = 0; i < root.getChildren().size(); i++) {
            treeTest(root.getChildren().get(i), num, map);
        }
    }

    /**
     * 冒泡排序算法
     *
     * @param arr
     * @return
     */
    public double[] bubbleSort(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    double temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 快速排序算法
     * @param arr
     * @param p
     * @param r
     */
    public void quickSort(double[] arr, int p, int r) {
        if (p < r) {
            int q = partition(arr, p, r);
            quickSort(arr, p, q - 1);
            quickSort(arr, q + 1, r);
        }
    }

    public int partition(double[] arr, int p, int r) {
        double x = arr[r];
        int j = p - 1;
        for (int i = p; i < r; i++) {
            if (arr[i] < x) {
                j++;
                double temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        double temp1 = arr[j + 1];
        arr[j + 1] = arr[r];
        arr[r] = temp1;
        return j + 1;
    }

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.000");
        double[] temp = {8.0, 2.0, 6.0, 1.0, 9.0, 10.0, 3.0, 7.0, 5.0, 4.0};

//        for (int i = 0; i < 10; i++) {
//            double num = Double.valueOf(df.format(Math.random())) * 1000;
//            list[i] = num;
//        }
        JavaDemo javaDemo = new JavaDemo();
//        插入排序
//        javaDemo.insertionSort();
//        归并排序
//        javaDemo.mergeSort(list, 0, 9);
//        javaDemo.listString(result);
//        List<TreeNode> nodeList = new ArrayList<>();
//        TreeNode treeNode1 = new TreeNode("1", "父节点", "#");
//        TreeNode treeNode2 = new TreeNode("2", "子节点1", "1");
//        TreeNode treeNode3 = new TreeNode("3", "子节点2", "1");
//        TreeNode treeNode4 = new TreeNode("4", "孙节点1", "2");
//        TreeNode treeNode5 = new TreeNode("5", "重孙节点1", "4");
//        nodeList.add(treeNode1);
//        nodeList.add(treeNode2);
//        nodeList.add(treeNode3);
//        nodeList.add(treeNode4);
//        nodeList.add(treeNode5);
//        List<TreeNode> treeList = TreeUtil.buildByRecursive(nodeList);
//        javaDemo.treeTest(treeList.get(0), 0, new HashMap());
//        System.out.println(nameList);

//        double[] arr = javaDemo.bubbleSort(temp);
//        javaDemo.listString(arr);

        javaDemo.quickSort(temp, 0, temp.length - 1);
        javaDemo.listString(temp);
    }
}
