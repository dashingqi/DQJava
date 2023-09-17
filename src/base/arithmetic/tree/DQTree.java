package base.arithmetic.tree;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树
 */
public class DQTree {


    /**
     * 二叉树前序遍历
     * 根节点 左节点 右节点
     *
     * @param node 二叉树节点
     */
    public static void preOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    /**
     * 二叉树中序遍历 （左节点、根节点、右节点）
     *
     * @param node 二叉树节点
     */
    public static void inOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrderTraverse(node.leftChild);
        System.out.println(node.data);
        inOrderTraverse(node.rightChild);

    }

    /**
     * 后序遍历 (左子树、右子树、根节点)
     *
     * @param node 二叉树节点
     */
    public static void postOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        System.out.println(node.data);
    }

    /**
     * 创建一个树形结构
     *
     * @param inputList 节点结合
     * @return 树
     */
    @Nullable
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * 前序排列使用栈
     *
     * @param node 树节点
     */
    public static void preOrderTraverseWithStack(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = node;
        while (treeNode != null || !stack.isEmpty()) {

            while (treeNode != null) {
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }

            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 广度优先遍历
     *
     * @param node 树节点
     */
    public static void levelOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            System.out.println(treeNode.data);
            if (treeNode.leftChild != null) {
                queue.offer(treeNode.leftChild);
            }

            if (treeNode.rightChild != null) {
                queue.offer(treeNode.rightChild);
            }
        }
    }

    static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data) {
            this.data = data;
        }
    }

    /**
     * "上浮"调整 最小堆的实现
     *
     * @param array 待调整的堆
     */
    public static void upAdjust(int[] array) {
        // 插入新节点的角标（孩子树的角标）
        int childIndex = array.length - 1;
        // 获取到父节点的角标
        int parentIndex = (childIndex - 1) / 2;
        // 拿到插入节点数据
        int temp = array[childIndex];
        // 子节点角标有效、插入的数据要小于父节点对应的数据 就需要进行上浮
        while (childIndex > 0 && temp < array[parentIndex]) {
            // 将父节点的数据防止到子节点位置
            array[childIndex] = array[parentIndex];
            // 子节点角标更新
            childIndex = parentIndex;
            // 重新计算父节点角标
            parentIndex = (parentIndex - 1) / 2;
        }
        // 将插入节点放置到对应位置
        array[childIndex] = temp;
    }

    /**
     * "下沉" -- 删除节点
     *
     * @param array       调整的堆
     * @param parentIndex 下沉的父节点
     * @param length      堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }

            if (temp <= array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = childIndex * 2 + 1;
        }
        array[parentIndex] = temp;
    }
}
