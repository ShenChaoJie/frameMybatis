package org.frame.common.designPatterns.composite;

import java.util.Enumeration;

public class CompositeTest {

	public static void main(String[] args) {
		Tree tree = new Tree("A");
		
		TreeNode nodeB = new TreeNode("B");
		TreeNode nodeC = new TreeNode("C");
		
		nodeB.add(nodeC);
		tree.root.add(nodeB);
		
		/*System.out.println();
		for(TreeNode child:tree.root.getChildren()){
			
		}*/
		
		System.out.println("build the tree finished!");
		
	}
}
