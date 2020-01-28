import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalTree {
    public ArrayList<Integer> traverse(Node root) {
        StringBuilder sb = new StringBuilder();
        Queue<Node> queue = new LinkedList();
        ArrayList<Integer> result = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            result.add(node.value);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return result;
    }

}
