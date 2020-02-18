package builder;

import models.Node;
import models.Type;

import java.util.ArrayList;

public interface NodeBuilder extends Builder<Node> {
    void setName(String name);
    void setType(Type type);
    void setPriority(Integer priority);
    void setParent(Node parent);
    void setChild(ArrayList<Node> child);
}