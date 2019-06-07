package fjord.ast.expr;

import fjord.ast.NodeVisitor;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class IfExpression implements Expr {

    private final Expr condition;

    private final Expr thenExpr;

    private final List<ElifBranch> elifBranches;

    private final Optional<Expr> elseExpr;

    public IfExpression(Expr condition, Expr thenExpr, List<ElifBranch> elifBranches, Expr elseExpr) {
        this.condition = condition;
        this.thenExpr = thenExpr;
        this.elifBranches = elifBranches != null ? elifBranches : Collections.emptyList();
        this.elseExpr = Optional.of(elseExpr);
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

    public Expr getCondition() {
        return condition;
    }

    public Expr getThenExpr() {
        return thenExpr;
    }

    public List<ElifBranch> getElifBranches() {
        return elifBranches;
    }

    public Optional<Expr> getElseExpr() {
        return elseExpr;
    }

}
