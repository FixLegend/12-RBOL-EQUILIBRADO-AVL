package proje;

public class TestBusqueda {

    public static void main(String[] args) {
        try {
            BSTree<Integer> bst = new BSTree<>();
            AVLTree<Integer> avl = new AVLTree<>();
            for (int i = 1; i <= 10; i++) {
                bst.insert(i);
                avl.insert(i);
            }

            long startTimeBST = System.nanoTime();
            bst.search(10);
            long endTimeBST = System.nanoTime();
            long durationBST = (endTimeBST - startTimeBST);

            long startTimeAVL = System.nanoTime();
            avl.search(10);
            long endTimeAVL = System.nanoTime();
            long durationAVL = (endTimeAVL - startTimeAVL);

            System.out.println("Tiempo de búsqueda en el árbol BST: " + durationBST + " nanosegundos");
            System.out.println("Tiempo de búsqueda en el árbol AVL: " + durationAVL + " nanosegundos");
        } catch (ItemDuplicated e) {
            e.printStackTrace();
        }
    }
}

