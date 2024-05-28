package proje;

public class TestEliminacion {
    public static void main(String[] args) throws ItemDuplicated {
        BSTree<Integer> bst = new BSTree<>();
        AVLTree<Integer> avl = new AVLTree<>();
        
        for (int i = 1; i <= 10000; i++) {
            bst.insert(i);
            avl.insert(i);
        }
        
        long startTimeBST = System.nanoTime();
        bst.remove(5000);
        long endTimeBST = System.nanoTime();
        long durationBST = (endTimeBST - startTimeBST);
        
        long startTimeAVL = System.nanoTime();
        avl.remove(5000);
        long endTimeAVL = System.nanoTime();
        long durationAVL = (endTimeAVL - startTimeAVL);
        
        System.out.println("Tiempo para eliminar el elemento en el árbol BST: " + durationBST + " nanosegundos");
        System.out.println("Tiempo para eliminar el elemento en el árbol AVL: " + durationAVL + " nanosegundos");
    }
}