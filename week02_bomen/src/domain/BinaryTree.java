package domain;

public class BinaryTree<E> {
	private E data;
	private BinaryTree<E> leftTree, rightTree;
	private int result = 0;
	
	public BinaryTree(E data){
		this(data,null,null);
	}
	
	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree){
		if (data == null) {
			throw new IllegalArgumentException();
		}
		this.data= data;
		this.leftTree= leftTree;
		this.rightTree= rightTree;
	}
	
	public void printPreorder(){
			System.out.print(this.data + " ");
			if (this.leftTree != null) this.leftTree.printPreorder();
			if (this.rightTree != null) this.rightTree.printPreorder();
	}

	public void printInorder(){
			if (this.leftTree != null){
				this.leftTree.printInorder();
			}
			System.out.print(this.data + " ");
			if (this.rightTree != null) {
				this.rightTree.printInorder();
			}
	}
	public void printBeginNewLine(){
		System.out.println(" ");
	}

	public void printPostorder(){
		if(this.leftTree != null) {
			this.leftTree.printPostorder();
		}
		if(this.rightTree != null){
			this.rightTree.printPostorder();
		}
		System.out.print(this.data + " ");
	}
	public int countNodes(){
		if (boom == null){
			return 0;
		}

	}

}
