package com.rxx.designpattern.composite;
/**
 * @Title      :TestComposite
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月6日 下午5:36:41
 */
public class TestComposite {

	public static void main(String[] args) {
		Tree treeA = new Tree("A");
		TreeNode treeNodeB = new TreeNode("B");
		TreeNode treeNodeC = new TreeNode("c");
		treeNodeB.add(treeNodeC);
		treeA.getRoot().add(treeNodeB);
		System.out.println("build the tree finished!");  
	}
}
