package proje;

public class AVLTreeTest {
    public static void main(String[] args) {
        try {
            AVLTree<Integer> avlTree = new AVLTree<>();

            System.out.println("Caso de prueba 1: Insertar elementos y verificar balanceo");
            avlTree.insert(10);
            avlTree.insert(20);
            avlTree.insert(30);
            avlTree.insert(40);
            avlTree.insert(50);
            avlTree.insert(25);

            System.out.println(avlTree);

            try {
                System.out.println("Caso de prueba 2: Insertar un elemento duplicado");
                avlTree.insert(10);  
            } catch (ItemDuplicated e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Caso de prueba 3: Recorrido por amplitud");
            avlTree.recorridoPorAmplitud();

            System.out.println("Caso de prueba 4: Árbol vacío");
            AVLTree<Integer> emptyTree = new AVLTree<>();
            emptyTree.recorridoPorAmplitud();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
