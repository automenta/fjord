package fjord.ast.typedefn;

import fjord.ast.Node;
import fjord.ast.NodeVisitor;
import fjord.ast.attribute.Attribute;

import java.util.Collections;
import java.util.List;

public class ExceptionAbbreviation implements Node {

    private final String alias;
    private final String exceptionName;
    private List<Attribute> attributes;

    public ExceptionAbbreviation(List<Attribute> attributes, String alias, String exceptionName) {
        this.setAttributes(attributes != null ? attributes : Collections.emptyList());
        this.alias = alias;
        this.exceptionName = exceptionName;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

    public String getExceptionName() {
        return exceptionName;
    }

    public String getAlias() {
        return alias;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

}
