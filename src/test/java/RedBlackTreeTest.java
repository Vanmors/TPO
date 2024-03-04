import org.example.task2.RedBlackTree;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.hierarchical.Node;

import static java.awt.Color.BLACK;
import static org.junit.jupiter.api.Assertions.*;

public class RedBlackTreeTest {

    @Test
    public void insertTest() {
        RedBlackTree tree = new RedBlackTree();

        assertNull(tree.find(4));
        tree.remove(4);

        // Проверка вставки в пустое дерево
        tree.insert(10);
        assertEquals(10, tree.getRoot().getKey());


        tree.insert(5);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(18);
        tree.insert(-3);
        tree.insert(23);

        // Проверка свойств дерева
        assertTrue(isRedBlackTree(tree.getRoot()));

        // Проверка поиска элемента
        assertEquals(tree.find(23).getKey(), 23);

        tree.remove(5);
        tree.remove(23);
        tree.remove(18);
        tree.remove(15);
        tree.remove(3);
        tree.remove(7);
        tree.remove(12);
        tree.remove(-3);
        tree.remove(5);

        assertTrue(isRedBlackTree(tree.getRoot()));
        assertNull(tree.find(23));

        // Добавление элементов в порядке возрастания
        tree = new RedBlackTree();
        for (int i = 1; i <= 10; i++) {
            tree.insert(i);
        }
        assertTrue(isRedBlackTree(tree.getRoot()));

        // Добавление элементов в порядке убывания
        tree = new RedBlackTree();
        for (int i = 10; i >= 1; i--) {
            tree.insert(i);
        }
        assertTrue(isRedBlackTree(tree.getRoot()));

    }

    public boolean isRedBlackTree(RedBlackTree.Node root) {
        if (root.isColor()) {
            System.out.println("Root is not black.");
            return false;
        }

        // Проверка, что все листья черные (NIL узлы)
        if (!checkBlackRootToLeaf(root)) {
            System.out.println("Not all paths from root to leaf contain the same number of black nodes.");
            return false;
        }

        // Проверка, что нет двух красных узлов подряд
        if (!checkNoConsecutiveRed(root)) {
            System.out.println("Found two consecutive red nodes.");
            return false;
        }

        return true;
    }

    // все пути от корня до листьев содержат одинаковое количество черных узлов
    private boolean checkBlackRootToLeaf(RedBlackTree.Node node) {
        if (node == null) {
            return true;
        }

        if (!node.isColor()) {
            return checkBlackRootToLeaf(node.getLeft()) && checkBlackRootToLeaf(node.getRight());
        }

        return checkBlackRootToLeaf(node.getLeft()) && checkBlackRootToLeaf(node.getRight());
    }

    // нет двух красных узлов подряд
    private boolean checkNoConsecutiveRed(RedBlackTree.Node node) {
        if (node == null) {
            return true;
        }

        if (node.isColor()) {
            if (node.getLeft() != null && node.getLeft().isColor()) {
                return false;
            }
        }

        return checkNoConsecutiveRed(node.getLeft()) && checkNoConsecutiveRed(node.getRight());

    }

}
