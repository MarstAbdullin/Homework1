package iterators;

import models.Node;

import java.util.Stack;

public class IteratorDFS implements Iterator{

    private Stack<Node> lookedTree = new Stack<>();
    private Node currentNode;

    public IteratorDFS(Node root, Node currentNode) {

        lookedTree.push(root);
        while (true)
            if (next() == currentNode)
                break;
    }

    @Override
    public Node next() {
        Node someNode = lookedTree.peek();

        if (lookedTree.peek().getChild() == null) {
            lookedTree.pop();
            currentNode = lookedTree.peek();
            return someNode;
        } else {
            lookedTree.pop();
            for (int i = someNode.getChild().size() - 1; i >= 0; i--) {
                lookedTree.push(someNode.getChild().get(i));
            }
            currentNode = lookedTree.peek();
            return someNode;
        }
    }

    @Override
    public Boolean hasNext() {
        Node someNode;

        if (lookedTree.peek().getChild() == null) {
            return true;
        } else {
            someNode = lookedTree.pop();
            if (lookedTree.peek() != null){
                lookedTree.push(someNode);
                return true;
            } else {
                lookedTree.push(someNode);
                return false;
            }
        }
    }

    @Override
    public Node getValue() {
        return currentNode;
    }
}
