package com.ccsi;

import java.util.DoubleSummaryStatistics;

public class Main {

    public static void main(String[] args) {
	    TreeNode root=buildTree();
        System.out.println(closestValue1(root,13));
    }
    public static TreeNode buildTree(){
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(5);
        root.right=new TreeNode(15);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(8);
        root.right.left=new TreeNode(12);
        root.right.right=new TreeNode(18);
        return root;
    }
    //Given a non-empty binary search tree and a target value,find the value in the BST
    //that is closest to the target.
    //1.loop
    public static int closestValue1(TreeNode root,double target){
        TreeNode curr=root;
        int res=0;
        double dif= Double.MAX_VALUE;
        while(curr!=null){
            if(curr.val==target) return curr.val;
            else if(target<curr.val){
                if(dif>curr.val-target){
                    dif=curr.val-target;
                    res=curr.val;
                }
                curr=curr.left;
            }else{
                if(dif>target-curr.val){
                    dif=target-curr.val;
                    res=curr.val;
                }
                curr=curr.right;
            }
        }

        return res;
    }
   //2.recursion
    public static int closestValue(TreeNode root,double target){
        if(root==null)return -1;
        double closeValue=Double.MAX_VALUE;
        return (int)core(root,target,closeValue);

    }
    public static double core(TreeNode root,double target,double closeValue){
        double diff=Math.abs(target-root.val);
        double minDiff=Math.abs(closeValue-target);
        closeValue=minDiff<diff?closeValue:root.val;
        if(target<root.val&&root.left!=null)return core(root.left,target,closeValue);
        if(target>root.val&&root.right!=null)return core(root.right,target,closeValue);
        return closeValue;
    }
    //3.bfs
    public static int closestValue1(TreeNode root,double target){
        if(root==null)return -1;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int closeValue=Integer.MAX_VALUE;
        while(!queue.isEmpty()){                    //isEmpty()判断
            TreeNode curr=queue.poll();
            double diff=Math.abs(target-curr.val);
            closeValue=Math.abs(closeValue-target)<diff?closeValue:curr.val;
            if(target<curr.val&&curr.left!=null)queue.offer(curr.left);    //offer进queue时，注意不为空，null也是可以进queue的
            if(target>curr.val&&curr.right!=null)queue.offer(curr.right);
        }
        return closeValue;
    }
}
class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
