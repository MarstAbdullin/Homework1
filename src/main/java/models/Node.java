package models;

import java.util.ArrayList;

public class Node implements Comparable<Node>{
    String name;
    Type type;
    Integer priority;
    Node parent;
    ArrayList<Node> child;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public ArrayList<Node> getChild() {
        return child;
    }

    public void setChild(ArrayList<Node> child) {
        this.child = child;
    }

    @Override
    public int compareTo(Node o) {
        return (this.priority - o.priority);
    }
}
