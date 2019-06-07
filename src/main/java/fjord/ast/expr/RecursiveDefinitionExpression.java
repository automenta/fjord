package fjord.ast.expr;

import fjord.ast.Node;
import fjord.ast.NodeVisitor;

import java.util.List;


public class RecursiveDefinitionExpression implements Expr {

    private final List<Node> functionOrValueDefns;

    private final Expr expr;

    public RecursiveDefinitionExpression(List<Node> functionOrValueDefns, Expr expr) {
        this.functionOrValueDefns = functionOrValueDefns;
        this.expr = expr;
    }

    public List<Node> getFunctionOrValueDefns() {
        return functionOrValueDefns;
    }

    public Expr getExpr() {
        return expr;
    }

    @Override
    public void accept(NodeVisitor visitor) {
    }

}
