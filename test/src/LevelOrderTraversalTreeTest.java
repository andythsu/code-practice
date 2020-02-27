import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class LevelOrderTraversalTreeTest {
    LevelOrderTraversalTree.Node node_1, node_2, node_3, node_4, node_5;
    LevelOrderTraversalTree levelOrderTraversalTree;

    @BeforeEach
    public void setup() {
        node_1 = new LevelOrderTraversalTree.Node(1);
        node_2 = new LevelOrderTraversalTree.Node(2);
        node_3 = new LevelOrderTraversalTree.Node(3);
        node_4 = new LevelOrderTraversalTree.Node(4);
        node_5 = new LevelOrderTraversalTree.Node(5);
        levelOrderTraversalTree = new LevelOrderTraversalTree();
    }

    @Test
    @DisplayName("tree with 2 layers")
    public void treeWithTwoLayers() {
        node_1.addLeft(node_2);
        node_1.addRight(node_3);
        ArrayList<Integer> actual = levelOrderTraversalTree.traverse(node_1);
        int[] expected = {1, 2, 3};
        for (int i = 0; i < actual.size(); i++) {
            Assertions.assertEquals(expected[i], actual.get(i));
        }
    }

    @Test
    @DisplayName("tree with 3 layers")
    public void treeWithThreeLayers() {
        node_1.addLeft(node_2);
        node_1.addRight(node_3);
        node_3.addLeft(node_4);
        node_3.addRight(node_5);
        ArrayList<Integer> actual = levelOrderTraversalTree.traverse(node_1);
        int[] expected = {1, 2, 3, 4, 5};
        for (int i = 0; i < actual.size(); i++) {
            Assertions.assertEquals(expected[i], actual.get(i));
        }
    }
}
