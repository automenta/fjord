package fjord.ast.typedefn;

import fjord.ast.NodeVisitor;
import fjord.ast.NodeWithChildren;
import fjord.ast.type.Type;

import java.util.List;

public class CurriedSig extends NodeWithChildren<List<ArgSpec>> {

    private Type type;

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}
