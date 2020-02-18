package iterators;

import models.Node;

import java.util.ArrayDeque;

public class IteratorPriorityBFS implements Iterator {
    private ArrayDeque<Node> lookedTree = new ArrayDeque<>();
    private Node currentNode;

    public IteratorPriorityBFS(Node root, Node currentNode) {

        lookedTree.addLast(root);
        while (true)
            if (next() == currentNode)
                break;
    }

    @Override
    public Node next() {
        Node someNode = lookedTree.pollFirst();
        if (someNode.getChild() != null) {
            someNode.getChild().sort(Node::compareTo);
            for (int i = 0; i < someNode.getChild().size(); i++) {
                lookedTree.addLast(someNode.getChild().get(i));
            }
        }
        currentNode = lookedTree.peekFirst();
        return someNode;
    }

    @Override
    public Boolean hasNext() {
        Node someNode = lookedTree.pollFirst();
        if (lookedTree.peekFirst() != null) {
            lookedTree.addFirst(someNode);
            return true;
        } else {
            lookedTree.addFirst(someNode);
            return false;
        }
    }

    @Override
    public Node getValue() {
        return currentNode;
    }

}
