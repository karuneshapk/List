package unidirectionalLinkedList;

public class Node {
    String data;
    Node reference;

    public Node(String data, Node reference) {
        this.reference = reference;
        this.data = data;
    }

    public Node getReference() { return reference;}

    public void setReference(Node node) {this.reference = node;}

    public String getData() {return data;}
}
