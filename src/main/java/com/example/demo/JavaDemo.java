package com.example.demo;

import com.example.demo.common.utils.TreeNode;
import com.example.demo.common.utils.TreeUtil;

import java.sql.Timestamp;
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

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.000");
        double[] temp = new double[10];

        for (int i = 0; i < 10; i++) {
            double num = Double.valueOf(df.format(Math.random())) * 1000;
            list[i] = num;
        }
        JavaDemo javaDemo = new JavaDemo();
//        插入排序
//        javaDemo.insertionSort();
//        归并排序
        javaDemo.mergeSort(list, 0, 9);
        javaDemo.listString(result);
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
    }
}
