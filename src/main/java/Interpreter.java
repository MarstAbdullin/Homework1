import builder.NodeBuilderImpl;
import builder.NodeDirector;
import iterators.Iterator;
import iterators.IteratorDFS;
import models.Node;
import models.Type;
import service.FacadeJsonImpl;
import service.FacadeXmlImpl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Interpreter {

    public void handle (Node headNode, String query, File fileXml, File fileJson) throws IOException {
        String[] parsedQuery = query.split("");
        if (parsedQuery[0].equals("ReadTree")){
            FacadeJsonImpl.getInstance().readTree(fileJson);
            FacadeXmlImpl.getInstance().readTree(fileXml);
        }
        if (parsedQuery[0].equals("WriteTree") || parsedQuery[0].equals("save")){
            FacadeJsonImpl.getInstance().writeTree(headNode);
            FacadeXmlImpl.getInstance().writeTree(headNode);
        }
        if (parsedQuery[0].equals("return")){
            System.out.println(returnChildren(parsedQuery, headNode).toString());
        }
        if (parsedQuery[0].equals("add")){
            addNode(parsedQuery, headNode);
        }
        if (parsedQuery[0].equals("delete")){
            if (!deleteNode(parsedQuery, headNode)){
                System.out.println("There is no such Node");
            }
        }
    }

    private Boolean deleteNode(String[] parsedQuery, Node headNode) {
        Iterator iterator = new IteratorDFS(headNode, headNode);
        while (iterator.hasNext()){
            Node someNode = iterator.next();
            if (someNode.getType().toString().equals(parsedQuery[1]) && someNode.getName().equals(parsedQuery[2])){
                if(someNode.getParent() == null){
                    someNode = null;
                    return true;
                } else {
                    someNode.getParent().getChild().remove(someNode.getParent().getChild().indexOf(someNode));
                    return true;
                }
            }
        }
        return false;
    }

    private void addNode(String[] parsedQuery, Node headNode) {
        Iterator iterator = new IteratorDFS(headNode, headNode);
        while (iterator.hasNext()){
            Node someNode = iterator.next();
            if (someNode.getType().toString().equals(parsedQuery[1]) && someNode.getName().equals(parsedQuery[2])){
                NodeDirector nodeDirector = new NodeDirector(new NodeBuilderImpl());
                Node a = nodeDirector.createFullNode(parsedQuery[3], Type.valueOf(parsedQuery[4]), Integer.getInteger(parsedQuery[5]), someNode);
                someNode.getChild().add(a);
            }
        }
    }

    private ArrayList<Node> returnChildren(String[] parsedQuery, Node headNode){
        Iterator iterator = new IteratorDFS(headNode, headNode);
        while (iterator.hasNext()){
            Node someNode = iterator.next();
            if (someNode.getType().toString().equals(parsedQuery[2]) && someNode.getName().equals(parsedQuery[3])){
                return someNode.getChild();
            }
        }
        return null;
    }


}
