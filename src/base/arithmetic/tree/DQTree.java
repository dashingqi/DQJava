package base.arithmetic.tree;

import groovyjarjarantlr4.v4.runtime.misc.Nullable;

import java.util.LinkedList;
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

    static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data) {
            this.data = data;
        }
    }
}
