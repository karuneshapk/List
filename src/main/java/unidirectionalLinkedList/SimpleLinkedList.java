package unidirectionalLinkedList;

public class SimpleLinkedList {
    Node head;
    Node end;
    public Node getHead() {return head;}

    public Node getEnd() {return end;}

    public void add(String value) {
        if (head == null) {
            head = new Node(value, null);
            end = head;
        } else {
            Node node = end;
            end = new Node(value, null);
            node.changeRef(end);
        }
    }

    @Override
    public String toString() {
        Node reference = head;
        final StringBuilder sb = new StringBuilder("[");
        boolean flagFirstItem = false;
        while (true) {
            if (reference == null) {
                sb.append("]");
                return sb.toString();
            } else {
                if (flagFirstItem) {
                    sb.append(", ");
                }
                sb.append(reference.getData());
                flagFirstItem = true;}
            reference = reference.nextRef();
        }
    }
    public void revert() {
        Node itemA = head;
        Node itemB = itemA.nextRef();
        if (itemB == null) {
            return;
        }
        itemA.changeRef(null);
        Node end = itemA;

        while (true) {
            Node itemC = itemB.nextRef();
            if (itemC == null) {
                itemB.changeRef(itemA);
                head = itemB;
                return;
            }
            itemB.changeRef(itemA);
            itemA = itemB;
            itemB = itemC;
        }
    }

    private class Node {
        String data;
        Node reference;

        private Node(String data, Node reference) {
            this.reference = reference;
            this.data = data;
        }

        private Node nextRef() { return reference;}

        private void changeRef(Node node) {this.reference = node;}

        private String getData() {return data;}
    }
}
