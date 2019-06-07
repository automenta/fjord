package fjord.ast;

import java.util.List;

public class ScriptFragment implements Node {

    private List<Node> moduleElems;

    public ScriptFragment(List<Node> moduleElems) {
        this.moduleElems = moduleElems;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);

        for (Node moduleElem : moduleElems) {
            if (moduleElem != null)
                moduleElem.accept(visitor);
        }
    }
}
