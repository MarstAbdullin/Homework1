import builder.NodeBuilderImpl;
import builder.NodeDirector;
import iterators.Iterator;
import iterators.IteratorPriorityBFS;
import models.Node;
import models.Type;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {

        NodeDirector nodeDirector = new NodeDirector(new NodeBuilderImpl());

        Node a = nodeDirector.createFullNode("Russia", Type.COUNTRY, 10, null);
        Node b = nodeDirector.createFullNode("Tatarstan", Type.REGION, 35, a);
        Node c = nodeDirector.createFullNode("Bashkortostan", Type.REGION, 17, a);
        Node d = nodeDirector.createFullNode("Moskovskaya oblast", Type.REGION, 100, a);
        Node e = nodeDirector.createFullNode("Moscow", Type.CITY, 100, d);
        Node f = nodeDirector.createFullNode("Kazan", Type.CITY, 100, b);
        Node g = nodeDirector.createFullNode("Lenina", Type.STREET, 50, e);//
        Node h = nodeDirector.createFullNode("Dolgoprudny", Type.CITY, 10, d);
        Node z = nodeDirector.createFullNode("9", Type.HOUSE, 10, g);//

        ArrayList<Node> russiasChildren = new ArrayList<>();
        russiasChildren.add(b);
        russiasChildren.add(c);
        russiasChildren.add(d);
        a.setChild(russiasChildren);

        ArrayList<Node> tatarstansChildren = new ArrayList<>();
        tatarstansChildren.add(f);
        b.setChild(tatarstansChildren);

        ArrayList<Node> oblastChildren = new ArrayList<>();
        oblastChildren.add(e);
        oblastChildren.add(h);
        d.setChild(oblastChildren);

        ArrayList<Node> moscowChildren = new ArrayList<>();
        moscowChildren.add(g);
        e.setChild(moscowChildren);

        ArrayList<Node> leninaChildren = new ArrayList<>();
        leninaChildren.add(z);
        g.setChild(leninaChildren);

        Iterator iteratorBFS = new IteratorPriorityBFS(a, a);


        for (int i = 0; i < 7; i++) {
            System.out.println(iteratorBFS.getValue().getName());
            iteratorBFS.next();
        }

        Scanner scanner = new Scanner(System.in);
        Interpreter interpreter = new Interpreter();
        File fileXml = new File("");
        File fileJson = new File("");

        while (true){
            interpreter.handle(a, scanner.nextLine(), fileXml, fileJson);
        }
    }
}
