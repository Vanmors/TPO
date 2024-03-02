import org.example.task2.RedBlackTree;
import org.junit.jupiter.api.Test;

public class RedBlackTreeTest {

    @Test
    public void insertTest() {
        RedBlackTree tree = new RedBlackTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(7);
        tree.visualize();
    }
}
