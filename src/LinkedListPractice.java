/**
 * @Author asu
 * @Date 11/6/2020
 * @Description
 **/
public class LinkedListPractice {
    public static Node firstList;
    public static Node secondList;

    public static void main(String[] args) {
        initializeFirstList();
        initializeSecondList();
        String target = "yy";
        print("target: " + target);
        print("original: ");
        print(iterate(firstList));
        print(iterate(secondList));
        swap(target);
        print("after: ");
        print(iterate(firstList));
        print(iterate(secondList));
    }

    private static void print(String message) {
        System.out.println(message);
    }

    // finds the target in secondList, remove it and puts it at the front of firstList
    // also, moves the first node of first List to head of second list
    private static void swap(String target) {
        Node iterator = secondList;
        Node prev = secondList;
        Node found = null;
        if (iterator != null && iterator.name.equals(target)) {
            found = iterator;
        } else {
            while (iterator != null) {
                iterator = iterator.next;
                if (iterator.name.equals(target)) {
                    found = iterator;
                    break;
                }
                prev = prev.next;
            }
        }
        if (found == null) throw new IllegalArgumentException(target + " doesn't exist in second list");

        // removing the found node from the list
        prev.next = found.next;

        // putting found in the first of firstList
        prependToFirstList(found);

        // the head of original firstList will now be in the second position
        Node secondFirst = firstList.next;

        // remove the second element from firstList
        firstList.next = firstList.next.next;

        // put it at the head of second list
        prependToSecondList(secondFirst);
    }

    private static void prependToSecondList(Node n) {
        Node temp = secondList;
        n.next = temp;
        secondList = n;
    }

    /**
     * @param n the node to prepend to list
     */
    private static void prependToFirstList(Node n) {
        Node temp = firstList;
        n.next = temp;
        firstList = n;
    }

    private static String iterate(Node list) {
        StringBuilder sb = new StringBuilder();
        Node iterator = list;
        while (iterator != null) {
            sb.append(iterator.name);
            sb.append("->");
            iterator = iterator.next;
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    private static void initializeFirstList() {
        firstList = new Node("a", 0);
        Node n1 = new Node("b", 1);
        Node n2 = new Node("c", 2);
        n1.next = n2;
        firstList.next = n1;
    }

    private static void initializeSecondList() {
        secondList = new Node("ww", 0);
        Node n1 = new Node("xx", 1);
        Node n2 = new Node("yy", 2);
        n1.next = n2;
        secondList.next = n1;
    }

    public static class Node {
        String name;
        int val;
        Node next;

        public Node(String name, int val) {
            this.name = name;
            this.val = val;
        }
    }

}
