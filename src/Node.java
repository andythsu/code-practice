public class Node {
    Integer value;
    Node left;
    Node right;

    public Node(Integer value) {
        this.value = value;
    }

    public void addLeft(Node left) {
        this.left = left;
    }

    public void addRight(Node right) {
        this.right = right;
    }
}
