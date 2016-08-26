package unidirectionalLinkedList;

public class SimpleLinkedList {
    private Node headNode;
    private Node endNode;
    public Node getHeadNode() {return headNode;}

    public Node getEndNode() {return endNode;}

    public void add(String value) {
        if (headNode == null) {
            headNode = new Node(value, null);
            endNode = headNode;
        } else {
            Node node = endNode;
            endNode = new Node(value, null);
            node.changeRefOnPreviousNode(endNode);
        }
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof SimpleLinkedList)) return false;
//
//        SimpleLinkedList that = (SimpleLinkedList) o;
//
//        if (getHeadNode() != null ? !getHeadNode().equals(that.getHeadNode()) : that.getHeadNode() != null)
//            return false;
//        return getEndNode() != null ? getEndNode().equals(that.getEndNode()) : that.getEndNode() == null;
//    }

    @Override
    public String toString() {
        Node currentlyObservedNode = headNode;
        final StringBuilder sb = new StringBuilder("[");
        boolean flagFirstItem = false;
        while (currentlyObservedNode != null) {
            if (flagFirstItem) {
                sb.append(", ");
            }
            sb.append(currentlyObservedNode.getData());
            flagFirstItem = true;
            currentlyObservedNode = currentlyObservedNode.nextNode();
        }
        sb.append("]");
        return sb.toString();
    }

    public void revert() {
        if (headNode == null) {
            return;
        }
        Node firstCurrentlyObservedNode = headNode;
        Node secondObservedNode = firstCurrentlyObservedNode.nextNode();
        if (secondObservedNode == null) {
            return;
        }
        firstCurrentlyObservedNode.changeRefOnPreviousNode(null);
        endNode = firstCurrentlyObservedNode;

        while (true) {
            Node thirdObservedNode = secondObservedNode.nextNode();
            if (thirdObservedNode == null) {
                secondObservedNode.changeRefOnPreviousNode(firstCurrentlyObservedNode);
                headNode = secondObservedNode;
                return;
            }
            secondObservedNode.changeRefOnPreviousNode(firstCurrentlyObservedNode);
            firstCurrentlyObservedNode = secondObservedNode;
            secondObservedNode = thirdObservedNode;
        }
    }

    private class Node {
        private String data;
        private Node nextNode;

        private Node(String data, Node referenceOnNextNode) {
            this.nextNode = referenceOnNextNode;
            this.data = data;
        }

        private Node nextNode() { return nextNode;}

        private void changeRefOnPreviousNode(Node node) {this.nextNode = node;}

        private String getData() {return data;}
    }
}
