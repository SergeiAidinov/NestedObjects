package ru.yandex.incoming34.NestedObjects.components;

import java.util.List;

public class Node{

    private final Node previousNode;
    private final List<Node> childrenNodes;
    private final int value;

    public Node(Node previousNode, List<Node> childrenNodes, int value) {
        this.previousNode = previousNode;
        this.childrenNodes = childrenNodes;
        this.value = value;
    }

    public Node getPreviousNode() {
        return previousNode;
    }

    public List<Node> getChildrenNodes() {
        return childrenNodes;
    }

    public int getValue() {
        return value;
    }


    public void addChildNode(Node node) {
        childrenNodes.add(node);
    }
}
