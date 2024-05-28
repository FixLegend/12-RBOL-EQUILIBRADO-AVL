package proje;

public class BSTree<E extends Comparable<E>> {
    protected Node<E> root;

    public void insert(E x) throws ItemDuplicated {
        root = insertRec(x, root);
    }

    protected Node<E> insertRec(E x, Node<E> node) throws ItemDuplicated {
        if (node == null) {
            return new Node<>(x);
        }
        int cmp = x.compareTo(node.data);
        if (cmp == 0) {
            throw new ItemDuplicated("Item duplicated");
        } else if (cmp < 0) {
            node.left = insertRec(x, node.left);
        } else {
            node.right = insertRec(x, node.right);
        }
        return node;
    }

    protected static class Node<E> {
        protected E data;
        protected Node<E> left, right;

        public Node(E data) {
            this.data = data;
            left = right = null;
        }

        public E getData() {
            return data;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }
    }

	public void search(int i) {
		// TODO Auto-generated method stub
		
	}

	public void remove(int i) {
		// TODO Auto-generated method stub
		
	}
}
