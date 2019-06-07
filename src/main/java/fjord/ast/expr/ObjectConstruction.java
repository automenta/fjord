package fjord.ast.expr;

import fjord.ast.Node;
import fjord.ast.NodeVisitor;
import fjord.ast.type.Type;

import java.util.Optional;

public class ObjectConstruction implements Node {

    private final Type type;

    private final Optional<Expr> expr;

    public ObjectConstruction(Type type) {
        this(type, null);
    }

    public ObjectConstruction(Type type, Expr expr) {
        this.type = type;
        this.expr = Optional.ofNullable(expr);
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

    public Type getType() {
        return type;
    }

    public Optional<Expr> getExpr() {
        return expr;
    }

}
