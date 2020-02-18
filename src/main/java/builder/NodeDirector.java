package builder;

import models.Node;
import models.Type;

import java.util.ArrayList;

public class NodeDirector {
    private NodeBuilderImpl nodeBuilder;

    public NodeDirector(NodeBuilderImpl nodeBuilder) {
        this.nodeBuilder = nodeBuilder;
    }

    public Node createFullNode(String name, Type type, Integer priority, Node parent){
        nodeBuilder.reset();
        nodeBuilder.setName(name);
        nodeBuilder.setParent(parent);
        nodeBuilder.setPriority(priority);
        nodeBuilder.setType(type);
        //nodeBuilder.setChild(child);
        return nodeBuilder.getResult();
    }
}
