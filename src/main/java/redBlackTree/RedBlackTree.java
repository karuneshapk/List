package redBlackTree;

import redBlackTree.enums.Color;
import redBlackTree.enums.Rib;

import java.util.Comparator;

import static redBlackTree.enums.Color.BLACK;
import static redBlackTree.enums.Color.RED;
import static redBlackTree.enums.Rib.*;

public class RedBlackTree {
    private Node vertex;
    private Node rightRib;
    private Node leftRib;
    private Node head;
    private Rib direction = NULL;

    public Node getVertex() {
        return vertex;
    }

    private void setVertex(Node node) {
        this.vertex = node;
    }

    public void add(int value) {
        // TODO: created new tree
        if (getVertex() == null) {
            head = new Node(BLACK, true, null, null, null, value);
            setVertex(head);
            return;
        }

        // TODO: continue work with the created tree
        head = getVertex();
        while (head != null) {
            boolean switcher = value >= head.getNumber();
            if (switcher) {
                direction = RIGHT;
            } else {
                direction = LEFT;
            }

            switch (direction) {
                // TODO: add item to left rib
                case LEFT: {
                    leftRib = head.getLeftNode();
                    if (leftRib == null) {
                        head.setLeftNode(new Node(RED, false, head, null, null, value));
                        if (head.isRed()) {
                            head = head.getLeftNode();
                            recoveryRBTree(head);
                        }
                        return;
                    }
                    head = leftRib;
                    break;
                }
                // TODO: add item to right rib
                case RIGHT: {
                    rightRib = head.getRightNode();
                    if (rightRib == null) {
                        head.setRightNode(new Node(RED, false, head, null, null, value));
                        if (head.isRed()) {
                            head = head.getRightNode();
                            recoveryRBTree(head);
                        }
                        return;
                    }
                    head = rightRib;
                    break;
                }
            }
        }
    }

    private void recoveryRBTree(Node head) {
        Node node = changeColors(head);
        if (node.isRed() && node.getParentNode().isRed()) {
            if (node.isRightDescendant()) {
                leftRotation(node);
            } else {
                rightRotation(node);
            }
        }
        return;
    }

    private void rightRotation(Node head) {
        Node parent = head.getParentNode();
        Node grandParent = parent.getParentNode();
        Node cousin = parent.getRightNode();
        Node uncle = parent.getRightNode();

        if (grandParent.isVertex) {
            grandParent.setVertex(false);
            parent.setVertex(true);
        }
        grandParent.setColor(RED);
        grandParent.setLeftNode(cousin);

        parent.setColor(BLACK);
        parent.setRightNode(grandParent);
        grandParent.setLeftNode(uncle);
    }

    private void leftRotation(Node head) {
        Node parent = head.getParentNode();
        parent.setRightNode(null);
        Node grandParent = parent.getParentNode();
        head.setLeftNode(parent);
        grandParent.setLeftNode(head);

        rightRotation(parent);
    }

    private Node changeColors(Node head) {
        Node parent = head.getParentNode();
        Node uncle = head.getUncleNode();
        if (uncle != null && head.isUncleRed()) {
            parent.setColor(BLACK);
            uncle.setColor(BLACK);
            Node grand = parent.getParentNode();
            if (!grand.isVertex) {
                grand.setColor(RED);
                Node grandGrandParent = grand.getParentNode();
                if (grandGrandParent.isRed()) {
                    changeColors(parent);
                }
            }
        }
        return head;
    }

    private class Node implements Comparator<Node> {
        private Color color;
        private Node parentNode;
        private Node leftRib;
        private Node rightRib;
        private int number;
        private boolean isVertex;

        private Node(Color color, boolean isVertex, Node parentNode, Node leftRib, Node rightRib, int number) {
            this.color = color;
            this.parentNode = parentNode;
            this.leftRib = leftRib;
            this.rightRib = rightRib;
            this.number = number;
            this.isVertex = isVertex;
        }

        private Node getUncleNode() {
            try {
                Node parent = this.getParentNode();

                if (parent.isRightDescendant()) {
                    return parent.getParentNode().getLeftNode();
                } else {
                    return parent.getParentNode().getRightNode();
                }
            } catch (NullPointerException e) {
                return null;
            }
        }

        private boolean isRightDescendant() {
            try {
                return compare(this.getParentNode().getRightNode(), this) == 0;
            } catch (NullPointerException e) {
                return false;
            }
        }

        private boolean isRed() {
            return this.getColor().equals(RED);
        }

        private boolean isUncleRed() {
            return this.getUncleNode().isRed();
        }

        private void setRightNode(Node node) {
            rightRib = node;
        }

        private boolean getVertex() {
            return isVertex;
        }

        private void setVertex(boolean vertex) {
            this.isVertex = vertex;
        }

        private Node getRightNode() {
            return rightRib;
        }

        private void setColor(Color color) {
            this.color = color;
        }

        private Color getColor() {
            return color;
        }

        private void setLeftNode(Node node) {
            leftRib = node;
        }

        private Node getLeftNode() {
            return leftRib;
        }

        private void setParentNode(Node node) {
            parentNode = node;
        }

        private Node getParentNode() {
            return parentNode;
        }

        private int getNumber() {
            return number;
        }

        @Override
        public int compare(Node o1, Node o2) {
            if (o1.getNumber() > o2.getNumber()) {
                return 1;
            } else if (o1.getNumber() == o2.getNumber()) {
                return 0;
            } else {
                return -1;
            }
        }
    }
}