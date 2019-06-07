package fjord.ast.expr;

import fjord.ast.NodeVisitor;
import fjord.ast.type.Type;

import java.util.List;

public class TypeApplicationExpression implements Expr {

    private final Expr expr;

    private final List<Type> types;

    public TypeApplicationExpression(Expr expr, List<Type> types) {
        this.expr = expr;
        this.types = types;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

    public Expr getExpr() {
        return expr;
    }

    public List<Type> getTypes() {
        return types;
    }

}
