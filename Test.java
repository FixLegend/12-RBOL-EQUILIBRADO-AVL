package proje;

public class Test {
    public static void main(String[] args) {
        try {
            AVLTree<Integer> tree = new AVLTree<>();
            tree.insert(39);
            tree.insert(27);
            tree.insert(50);
            tree.insert(18);
            tree.insert(35);
            tree.insert(46);
            tree.insert(87);
            tree.insert(7);
            tree.insert(24);
            
            System.out.println("Recorrido por amplitud:");
            tree.recorridoPorAmplitud();
        } catch (ItemDuplicated | IsEmpty e) {
            e.printStackTrace();
        }
    }
}