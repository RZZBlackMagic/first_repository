package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test03_31 {

	public static void main(String[] args) {
		/*int [] arr = {1,2,3,4,9};
		int i = Search_bin(arr,5);
		System.out.println(i);*/
		BinaryTreeNode Node8 = new BinaryTreeNode(8,null,null);
		BinaryTreeNode Node7 = new BinaryTreeNode(7,null,null);
		BinaryTreeNode Node6 = new BinaryTreeNode(6,null,null);
		BinaryTreeNode Node5 = new BinaryTreeNode(5,Node6,Node7);
		BinaryTreeNode Node4 = new BinaryTreeNode(4,null,null);
		BinaryTreeNode Node3 = new BinaryTreeNode(3,null,Node8);
		BinaryTreeNode Node2 = new BinaryTreeNode(2,Node4,Node5);
		BinaryTreeNode root = new BinaryTreeNode(1,Node2,Node3);
		//BinaryTreeNode root = new BinaryTreeNode(1,);
		//pre_order(root);
		ceng_order(root);
	}

	/**
	 * ¶þ·Ö²éÕÒ
	 * @param arr
	 * @param target
	 * @return
	 */
	public static int Search_bin(int arr[],int target){
		int mid = arr.length/2;
		if(arr.length==1&&target!=arr[0]){
			return 11;
		}
		if(arr[mid]>target){
			int[] arr_qian = Arrays.copyOfRange(arr, 0, mid-1);
			return Search_bin(arr_qian,target);
		}else if(arr[mid]<target){
			int[] arr_qian = Arrays.copyOfRange(arr, mid+1, arr.length-1);
			return Search_bin(arr_qian,target);
		}else if(arr[mid]==target){
			return mid;
		}else{
			return 11;
		}
	}
	

	public static void visit(BinaryTreeNode root){
		if(root==null){
			return;
		}
		System.out.print(root.getVal());
	}
	public static void pre_order(BinaryTreeNode root){
		visit(root);
		if(root.getLeftNode()!=null){
			pre_order(root.getLeftNode());
		}
		if(root.getRightNode()!=null){
			pre_order(root.getRightNode());
		}
	}
	
	public static void ceng_order(BinaryTreeNode root){
		List<Integer> lengthList = new ArrayList<Integer>();
		List<BinaryTreeNode> list = new ArrayList<BinaryTreeNode>();
		if(root == null){
			return ;
		}
		list.add(root);
		lengthList.add(1);
		//int length = 0;
		while(true){
			int length = list.size();
			if(length==0){
				break;
			}
			while(length>0){
				BinaryTreeNode deque = list.get(0);
				list.remove(0);
				length--;
				visit(deque);
				if(deque.getLeftNode()!=null){
					list.add(deque.getLeftNode());
				}
				if(deque.getRightNode()!=null){
					list.add(deque.getRightNode());
				}
			}
			System.out.println();
			lengthList.add(list.size());
		}
		
	}
}

class BinaryTreeNode {
	private int val;
	
	private BinaryTreeNode leftNode;
	
	private BinaryTreeNode rightNode;

	
	public int getVal() {
		return val;
	}


	public void setVal(int val) {
		this.val = val;
	}


	public BinaryTreeNode getLeftNode() {
		return leftNode;
	}


	public void setLeftNode(BinaryTreeNode leftNode) {
		this.leftNode = leftNode;
	}


	public BinaryTreeNode getRightNode() {
		return rightNode;
	}


	public void setRightNode(BinaryTreeNode rightNode) {
		this.rightNode = rightNode;
	}


	public BinaryTreeNode(int val, BinaryTreeNode leftNode, BinaryTreeNode rightNode) {
		super();
		this.val = val;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}
	
	
}

