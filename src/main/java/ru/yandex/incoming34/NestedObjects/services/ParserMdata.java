package ru.yandex.incoming34.NestedObjects.services;

import org.springframework.stereotype.Service;
import ru.yandex.incoming34.NestedObjects.components.Attr;
import ru.yandex.incoming34.NestedObjects.components.Mdata;
import ru.yandex.incoming34.NestedObjects.components.Node;

import java.util.*;

@Service
public class ParserMdata {

    private final char DownwardsArrowWithTipRightwards = '\u21B3';
    private String initGap = "";

    Queue<Node> nodeQueue = new ArrayDeque<>();


    public void parseMdata(Mdata mdata) {

        Node rootNode = new Node(null, new ArrayList<>(), mdata.getValue());
        nodeQueue.add(rootNode);


        recursiveCircuit(rootNode, mdata.getAttrs());
        System.out.println(nodeQueue);
        display();
        System.out.println();

    }

    private void display() {

        Node rootNode = nodeQueue.poll();
        initGap = "  ";

        System.out.println(rootNode.getValue());


        for (Node node : rootNode.getChildrenNodes()) {
            circuitDisplay(new StringBuilder().append(initGap).append(DownwardsArrowWithTipRightwards), node);
        }

    }

    private String calculateGap(int value, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < value; i++) {
            stringBuilder.append(string);
        }

        return stringBuilder.toString();
    }

    private void circuitDisplay(StringBuilder stringBuilder, Node node) {


        System.out.println(stringBuilder.toString() + node.getValue());

        String additionalGap = calculateGap(String.valueOf(node.getValue()).length(), " ");
        stringBuilder = new StringBuilder()
                .append(additionalGap)
                .append(stringBuilder);

        for (Node childNode : node.getChildrenNodes()) {
            System.out.println(stringBuilder.toString() + childNode.getValue());

            for (Node nextChildNode : childNode.getChildrenNodes()) {
                StringBuilder newStringBuilder = new StringBuilder();
                String nextAdditionalGap = calculateGap(String.valueOf(nextChildNode.getValue()).length(), " ");
                newStringBuilder
                        .append(initGap)
                        .append("  ")
                        .append(nextAdditionalGap)
                        .append(DownwardsArrowWithTipRightwards);
                circuitDisplay(newStringBuilder, nextChildNode);
            }

        }

    }


    private void recursiveCircuit(Node previousNode, List<Attr> attrsListOfCurrentNode) {


        for (Attr attr : attrsListOfCurrentNode) {

            Node node = new Node(previousNode, new ArrayList<>(), attr.getValue());
            previousNode.addChildNode(node);
            nodeQueue.add(node);

            if (!attr.getNestedAttrs().isEmpty()) {
                recursiveCircuit(node, attr.getAttrs());
            }
        }

    }

}

