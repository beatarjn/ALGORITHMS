package exercises.recursion.tree;

public class Node {


    private Node leftNode;
    private Node rightNode;
    private int nodeNumber;

    Node() {
    }

    Node(int nodeNumber) {
        this.nodeNumber = nodeNumber;
    }

    public Node(Node leftNode, Node rightNode, int nodeNumber) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.nodeNumber = nodeNumber;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public int getNodeNumber() {
        return nodeNumber;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public void setNodeNumber(int nodeNumber) {
        this.nodeNumber = nodeNumber;
    }
}

