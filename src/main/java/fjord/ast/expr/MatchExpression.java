package fjord.ast.expr;

import fjord.ast.NodeVisitor;
import fjord.ast.pat.Rule;

import java.util.List;

public class MatchExpression implements Expr {

    private final Expr matchExpr;

    private final List<Rule> rules;

    public MatchExpression(Expr matchExpr, List<Rule> rules) {
        this.matchExpr = matchExpr;
        this.rules = rules;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

    public Expr getMatchExpr() {
        return matchExpr;
    }

    public List<Rule> getRules() {
        return rules;
    }

}
