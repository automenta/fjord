package fjord.ast;


import java.util.ArrayList;
import java.util.List;

public abstract class NodeWithChildren<T> implements Node {

    protected final List<T> children;

    public NodeWithChildren() {
        this(new ArrayList<>());
    }

    public NodeWithChildren(T children) {
        this(List.of(children));
    }

    public NodeWithChildren(T[] children) {
        this(List.of(children));
    }

    public NodeWithChildren(List<T> children) {
        this.children = children;
    }

    public void addChild(T child) {
        children.add(child);
    }

}
