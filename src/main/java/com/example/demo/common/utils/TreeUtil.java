package com.example.demo.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeUtil {

    /**
     * 使用递归方法建树
     *
     * @param treeNodes
     * @return
     */
    public static List<TreeNode> buildByRecursive(List<TreeNode> treeNodes) {
        List<TreeNode> trees = new ArrayList<TreeNode>();
        for (TreeNode treeNode : treeNodes) {
            if ("#".equals(treeNode.getParentId())) {
                trees.add(findChildren(treeNode, treeNodes));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     *
     * @param treeNodes
     * @return
     */
    public static TreeNode findChildren(TreeNode treeNode, List<TreeNode> treeNodes) {
        treeNode.setChildren(new ArrayList<TreeNode>());

        for (TreeNode it : treeNodes) {
            if (treeNode.getId().equals(it.getParentId())) {
                if (treeNode.getChildren() == null) {
                    treeNode.setChildren(new ArrayList<TreeNode>());
                }
                treeNode.getChildren().add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }

    // 查询递归遍历路径
    public static List<String> FindAllPaths(TreeNode treeNode, String path, List<String> paths) {
        path += treeNode.getName() + "->";
        if (treeNode == null
                || treeNode.getChildren().size() == 0) {
            String leafPath = path.substring(0, path.length() - 2);
            paths.add(leafPath);
        }
        for (int i = 0, len = treeNode.getChildren().size(); i < len; i++) {
            FindAllPaths(treeNode.getChildren().get(i), path, paths);
        }
        return paths;
    }

    private static int titleNum = 0;

    public static void FindAllPaths1(TreeNode root, int num, Map nameMap, List<Map> nameList) {
        Map map = new HashMap();
        map.putAll(nameMap);
        map.put("NAME" + num, root.getName());
        if (root.getChildren().size() == 0) {
            nameList.add(map);
            if (num + 1 >= titleNum) {
                titleNum = num + 1;
            }
        }
        num++;
        for (int i = 0; i < root.getChildren().size(); i++) {
            FindAllPaths1(root.getChildren().get(i), num, map, nameList);
        }
    }
}
