package proje;

public class AVLTree<E extends Comparable<E>> extends BSTree<E> {

    @Override
    public void insert(E x) throws ItemDuplicated {
        this.root = insertRec(x, (NodeAVL<E>) this.root);//actual
    }

    private NodeAVL<E> insertRec(E x, NodeAVL<E> node) throws ItemDuplicated { //recursivo
        if (node == null) { // nodo es nulo
            return new NodeAVL<>(x); //crea nuevo nodo
        }
        int resC = node.getData().compareTo(x); // compara x con el actual
        if (resC == 0) { // existe lanza excepcion
            throw new ItemDuplicated("Item duplicated");
        }
        if (resC > 0) {
            node.setLeft(insertRec(x, (NodeAVL<E>) node.getLeft())); //inserta en la lado izquierdo
        } else {
            node.setRight(insertRec(x, (NodeAVL<E>) node.getRight())); //inserta en la lado derecho
        }
        node = balance(node);
        return node; //nodo
    }

    private NodeAVL<E> balance(NodeAVL<E> node) {
        updateBalanceFactor(node); //actuliza factor de balance
        if (node.bf == -2) { //subarbol izquiero es mayor que 1
            if (((NodeAVL<E>) node.getLeft()).bf <= 0) { // verifica factor de balance
                node = rotateRight(node); 
            } else { // desbalanceado a la derecha
                node.setLeft(rotateLeft((NodeAVL<E>) node.getLeft())); //arbol izquierdo
                node = rotateRight(node);
            }
        } else if (node.bf == 2) { //subarbol derecho es mas alto que 1
            if (((NodeAVL<E>) node.getRight()).bf >= 0) { // verifica el balance
                node = rotateLeft(node);
            } else {
                node.setRight(rotateRight((NodeAVL<E>) node.getRight())); //arbol derecho
                node = rotateLeft(node);
            }
        }
        return node; // nodo 
    }

    private void updateBalanceFactor(NodeAVL<E> node) {
        // Calcular la altura del subárbol izquierdo. Si no hay subárbol izquierdo, la altura es -1.
        int leftHeight = (node.getLeft() == null) ? -1 : ((NodeAVL<E>) node.getLeft()).height;
        // Calcular la altura del subárbol derecho. Si no hay subárbol derecho, la altura es -1.
        int rightHeight = (node.getRight() == null) ? -1 : ((NodeAVL<E>) node.getRight()).height;
        // Actualizar la altura del nodo actual. La altura es 1 más la altura del subárbol más alto.
        node.height = 1 + Math.max(leftHeight, rightHeight);
        // Calcular el factor de balance del nodo actual
        node.bf = rightHeight - leftHeight;
    }

    private NodeAVL<E> rotateRight(NodeAVL<E> y) {
        NodeAVL<E> x = (NodeAVL<E>) y.getLeft();
        Node<E> T2 = x.getRight();
        x.setRight(y);
        y.setLeft(T2);
        updateBalanceFactor(y);
        updateBalanceFactor(x);
        return x;
    }

    private NodeAVL<E> rotateLeft(NodeAVL<E> x) {
        // Guardar el nodo derecho de x en y.
        NodeAVL<E> y = (NodeAVL<E>) x.getRight();
        // Guardar el subárbol izquierdo de y en T2.
        Node<E> T2 = y.getLeft();
        // Realizar la rotación: establecer x como el hijo izquierdo de y.
        y.setLeft(x);
        // Establecer T2 como el hijo derecho de x.
        x.setRight(T2);
        // Actualizar los factores de balance y las alturas de los nodos involucrados.
        updateBalanceFactor(x);
        updateBalanceFactor(y);
        
        // Devolver la nueva raíz del subárbol.
        return y;
    }

    private class NodeAVL<E extends Comparable<E>> extends Node<E> {
        private int bf;
        private int height;

        public NodeAVL(E data) {
            super(data);
            this.bf = 0;
            this.height = 0;
        }

		public void setData(E minValue) {
			// TODO Auto-generated method stub
			
		}
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toStringRec((NodeAVL<E>) this.root, sb, "");
        return sb.toString();
    }

    private void toStringRec(NodeAVL<E> node, StringBuilder sb, String indent) {
        if (node != null) {
            sb.append(indent).append(node.getData().toString()).append(" (Height: ").append(node.height).append(")\n");
            if (node.getLeft() != null) {
                toStringRec((NodeAVL<E>) node.getLeft(), sb, indent + " ");
            }
            if (node.getRight() != null) {
                toStringRec((NodeAVL<E>) node.getRight(), sb, indent + " ");
            }
        }
    }

    public void recorridoPorAmplitud() throws IsEmpty {
        if (root == null) {
            throw new IsEmpty("The tree is empty.");
        }
        QueueLink<NodeAVL<E>> queue = new QueueLink<>();
        queue.enqueue((NodeAVL<E>) root);
        int level = 0;
        while (!queue.isEmpty()) {
            int nodesAtCurrentLevel = queue.size();
            System.out.println("Nivel " + level + ":");
            for (int i = 0; i < nodesAtCurrentLevel; i++) {
                NodeAVL<E> current = queue.dequeue();
                System.out.print(current.getData() + " ");
                if (current.getLeft() != null) {
                    queue.enqueue((NodeAVL<E>) current.getLeft());
                }
                if (current.getRight() != null) {
                    queue.enqueue((NodeAVL<E>) current.getRight());
                }
            }
            System.out.println();
            level++;
        }
    }

	public void search(int i) {
		// TODO Auto-generated method stub
		
	}
	public void remove(E x) {
	    this.root = removeRec(x, (NodeAVL<E>) this.root);
	}

	private NodeAVL<E> removeRec(E x, NodeAVL<E> node) {
	    if (node == null) {
	        return null;
	    }

	    int resC = node.getData().compareTo(x);

	    if (resC > 0) {
	        node.setLeft(removeRec(x, (NodeAVL<E>) node.getLeft()));
	    } else if (resC < 0) {
	        node.setRight(removeRec(x, (NodeAVL<E>) node.getRight()));
	    } else {
	        if (node.getLeft() == null) {
	            return (NodeAVL<E>) node.getRight();
	        } else if (node.getRight() == null) {
	            return (NodeAVL<E>) node.getLeft();
	        }

	        node.setData(minValue((NodeAVL<E>) node.getRight()));
	        node.setRight(removeRec(node.getData(), (NodeAVL<E>) node.getRight()));
	    }

	    return balance(node);
	}

	private E minValue(NodeAVL<E> node) {
	    E minValue = node.getData();
	    while (node.getLeft() != null) {
	        minValue = node.getLeft().getData();
	        node = (NodeAVL<E>) node.getLeft();
	    }
	    return minValue;
	}
}
