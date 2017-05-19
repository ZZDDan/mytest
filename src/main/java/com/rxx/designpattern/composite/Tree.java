package com.rxx.designpattern.composite;
/**
 * @Title      :Tree
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月6日 下午5:35:26
 */
public class Tree {
	TreeNode root = null;  
	
    public Tree(String name) {  
        root = new TreeNode(name);  
    }  
    
    public TreeNode getRoot() {
		return root;
	}
}
