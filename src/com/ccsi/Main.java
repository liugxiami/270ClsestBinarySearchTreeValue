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
    /*public static int closestValue2(TreeNode root,double target){
        double dif= Double.MAX_VALUE;
        int res=0;
        bs(root,target,dif,res);
        return res;
    }
    public static void bs(TreeNode curr,double target,double dif,int res){
        if(target==curr.val) {
            res=curr.val;
            return;
        }

        if(dif>Math.abs(curr.val-target)){
            dif=Math.abs(curr.val-target);
            res=curr.val;
        }

        if(target<curr.val) bs(curr.left,target,dif,res);
        else bs(curr.right,target,dif,res);
    }*/
}
class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
