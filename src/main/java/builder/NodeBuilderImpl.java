package builder;

import models.Node;
import models.Type;

import java.util.ArrayList;

public class NodeBuilderImpl implements NodeBuilder{
    private Node node;

    @Override
    public void setName(String name) {
        node.setName(name);
    }

    @Override
    public void setType(Type type) {
        node.setType(type);
    }

    @Override
    public void setPriority(Integer priority) {
        node.setPriority(priority);
    }

    @Override
    public void setParent(Node parent) {
        node.setParent(parent);
    }

    @Override
    public void setChild(ArrayList<Node> child) {
        node.setChild(child);
    }

    @Override
    public void reset() {
        node = new Node();
    }

    @Override
    public Node getResult() {
        return node;
    }
}
