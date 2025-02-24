package fjord.ast.expr;

import fjord.ast.NodeVisitor;

public class AssignmentExpression implements Expr {

    private final Expr left;

    private final Expr right;

    public AssignmentExpression(Expr left, Expr right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

    public Expr getLeft() {
        return left;
    }

    public Expr getRight() {
        return right;
    }

}
