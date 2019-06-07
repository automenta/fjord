package fjord.ast.typar;

import fjord.ast.NodeVisitor;
import fjord.ast.NodeWithChildren;
import fjord.ast.type.Type;
import fjord.ast.type.constraint.Constraint;

import java.util.Collections;
import java.util.List;

public class TyparDefns extends NodeWithChildren<TyparDefn> implements Type {

    private List<Constraint> typarConstraints = Collections.emptyList();

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

    public List<Constraint> getTyparConstraints() {
        return typarConstraints;
    }

    public void setTyparConstraints(List<Constraint> constraints) {
        this.typarConstraints = constraints != null ? constraints : Collections.emptyList();
    }

}
