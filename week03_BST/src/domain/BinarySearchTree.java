package domain;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

	public BinarySearchTree(E data, BinarySearchTree<E> leftTree, BinarySearchTree<E> rightTree) {
		super(data, leftTree, rightTree);
	}
			
	public BinarySearchTree(E data) {
		super(data);
	}

	public boolean lookup(E data) {
		if (data.compareTo(this.data) == 0) {
			return true;
		}else if (data.compareTo(this.data) < 0) {
			if (leftTree == null){
				return false;
			}else {
				return leftTree.lookup(data);
			}
		}else {
			if (rightTree == null){
				return false;
			}else {
				return rightTree.lookup(data);
			}
		}
	}

	public boolean addNode(E data) {
		if (data.compareTo(this.data) == 0){
			return true;
		}else if(data.compareTo(this.data ) < 0){
			if (this.leftTree == null){
				this.leftTree = new BinarySearchTree<>(data);
				return true;
			}else{
				return leftTree.addNode(data);
			}
		}else {
			if (this.rightTree == null){
				this.rightTree = new  BinarySearchTree<>(data);
				return true;
			}else {
				return rightTree.addNode(data);
			}
		}
	}

	public boolean removeNode(E data){
		if (data == null){
			throw new IllegalArgumentException();
		}
		if (this.data == null){
			return false;
		}
		if (data.compareTo(this.data) == 0){
			if (leftTree == null && rightTree == null){
				this.data = null;
				return true;
			}else {
				if (this.leftTree != null){
					E gl = this.leftTree.searchGreatest();
					this.data = gl;

				}
			}
		}else if (data.compareTo(this.data) < 0) {
			if (leftTree == null) {
				return false;
			} else {
				return leftTree.removeNode(data);
			}
		}else {
			if (rightTree == null) {
				return false;
			}else {
				return rightTree.removeNode(data);
			}
		}
		return false;
	}

	public E searchSmallest(){
		if (this.leftTree == null){
			return this.data;
		}else {
			return this.leftTree.searchSmallest();
		}
	}

	public E searchGreatest(){
		if (this.rightTree == null){
			return this.data;
		}else {
			return this.rightTree.searchGreatest();
		}
	}
}


