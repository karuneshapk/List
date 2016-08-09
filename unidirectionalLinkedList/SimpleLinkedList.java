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
            node.setReference(end);
        }
    }
    @Override
    public String toString() {
        Node reference = head;
        final StringBuilder sb = new StringBuilder("[");
        boolean flagFerstItem = false;
        while (true) {
            if (reference == null) { sb.append("]"); return sb.toString();
            } else {
                if (flagFerstItem) { sb.append(", ");}
                sb.append(reference.getData());
                flagFerstItem = true;}
            reference = reference.getReference();
        }
    }
    public void revert() {
        Node item_1i = head;
        Node item_2i = item_1i.getReference();
        if (item_2i == null) {return;}
        item_1i.setReference(null);
        Node end = item_1i;
        while (true) {
            Node item_3i = item_2i.getReference();
            if (item_3i == null) {
                item_2i.setReference(item_1i);
                head = item_2i;
                return;
            }
            item_2i.setReference(item_1i);
            item_1i = item_2i;
            item_2i = item_3i;
        }
    }
}
