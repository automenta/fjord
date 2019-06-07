package fjord.ast.expr;

import fjord.ast.NodeVisitor;
import fjord.ast.pat.Rule;

import java.util.List;

public class TryWithExpression implements Expr {

    private final Expr tryExpr;

    private final List<Rule> rules;

    public TryWithExpression(Expr tryExpr, List<Rule> rules) {
        this.tryExpr = tryExpr;
        this.rules = rules;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

    public Expr getTryExpr() {
        return tryExpr;
    }

    public List<Rule> getRules() {
        return rules;
    }

}
