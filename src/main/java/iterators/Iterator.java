package iterators;

import models.Node;

public interface Iterator {
    Node next();
    Boolean hasNext();
    Node getValue();
}
