package fjord.ast;

import fjord.ast.attribute.Attribute;
import fjord.ast.typedefn.FunctionDefn;

import java.util.Collections;
import java.util.List;

public class ModuleFunctionDefinition implements Node {

    private final List<Attribute> attributes;

    private final FunctionDefn functionDefn;

    public ModuleFunctionDefinition(List<Attribute> attributes, FunctionDefn fn) {
        this.attributes = attributes != null ? attributes : Collections.emptyList();
        this.functionDefn = fn;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public FunctionDefn getFunctionDefn() {
        return functionDefn;
    }

}
