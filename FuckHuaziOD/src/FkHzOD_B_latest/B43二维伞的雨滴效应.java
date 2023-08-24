package FkHzOD_B_latest;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * B|43|二维伞的雨滴效应|二叉树|100|
 * 普通的伞在二维平面世界中，左右两侧均有一条边，而两侧伞边最下面各有一个伞坠子，雨滴落到伞面，逐步流到伞坠处，
 * 会将伞坠的信息携带并落到地面，随着日积月累，地面会呈现伞坠的信息。
 * 1、为了模拟伞状雨滴效应，用二叉树来模拟二维平面伞(如下图所示)，现在输入一串正整数数组序列(不含0，数组成员至少是1个) ，
 * 若此数组序列是二叉搜索树的前序遍历的结果，那么请输出一个返回值1，否则输出0.
 * 2、同时请将此序列构成的伞状效应携带到地面的数字信息输出来(左边伞坠信息，右边伞坠信息，详细参考示例图地面上数字)，
 * 若此树不存在左或右扇坠，则对应位置返回0。同时若非 二叉排序树那么左右伞坠信息也返回0。
 * 输入描述:
 * 1个通过空格分割的整数序列字符串，数组不含0，数组成员至少1个，输入的数组的任意两个数字都互不相同，最多1000个正整数，正整数值范围1~655350
 * 输出描述:
 * 输出如下三个值，以空格分隔: 是否二叉排序树，左侧地面呈现的伞坠数字值，右侧地面呈现的伞坠数字值.
 * 若是二叉排序树，则输出1，否则输出0 (其左右伞坠值也直接赋值0) 。
 * 若不存存在左侧或者右侧伞坠值，那么对应伞坠值直接赋值0。
 * 示例1
 * 输入:
 * 8 3 1 6 4 7 10 14 13
 * 输出:
 * 1 1 13
 * 说明:
 * 1表示是二叉搜索树前序遍历结果，1表示左侧地面呈现的伞坠数字值，13表示右侧地面呈现的伞坠数字值
 *
 * */
public class B43二维伞的雨滴效应 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] inputs = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        TreeNode root = new TreeNode(inputs[0]);


        // 用一个栈保存节点
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root); //push为队首入栈
        // 辅助节点，判断是否为BST
        TreeNode helper = new TreeNode(-1);
        boolean isBST = true;
        // 判断，构造BST
        for (int i = 0; i < inputs.length; i++) {
            // node总是peekLast，deque的最后/上一个节点
            TreeNode node = stack.peekLast();
            TreeNode currentNode = new TreeNode(inputs[i]);

            System.out.println("------------------------");
            System.out.println("node: " + node.val);
            System.out.println("currentNode: " + currentNode.val);
            stack.forEach(o -> System.out.println(o.val));

            // 只要当前节点比上一个大的，弹栈
            while (!stack.isEmpty() && stack.peekLast().val < currentNode.val) {
                node = stack.removeLast();
                if (!stack.isEmpty())
                    helper = stack.peekLast();
            }

            // 不满足BST的直接跳出
            // 当前节点比上一个大的，作为右子节点，
            // 否则作为左子节点，
            // 不算 BST的条件是什么？上一个比当前的大？
            if (node.val < currentNode.val) {
                node.right = currentNode;
                helper = node;
            } else {
                if (currentNode.val < helper.val) {
                    isBST = false;
                    break;
                }
                node.left = currentNode;
            }

            stack.addLast(currentNode);
        }



        if(isBST) {
            TreeNode leftNode = root;
            while (leftNode.left != null || leftNode.right != null) {
                if (leftNode.left != null)
                    leftNode = leftNode.left;
                else
                    leftNode = leftNode.right;
                System.out.println("leftNode: " + leftNode.val);
            }

            TreeNode rightNode = root;
            while (rightNode.left != null || rightNode.right != null) {
                if (rightNode.right != null)
                    rightNode = rightNode.right;
                else
                    rightNode = rightNode.left;
                System.out.println("rightNode: " + rightNode.val);
            }

            System.out.println("1 " +
                    (leftNode.val == root.val ? 0 : leftNode.val) + " " +
                    (rightNode.val == root.val ? 0 : rightNode.val));
        } else {
            System.out.println("0 0 0");
        }


    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {

        }

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
