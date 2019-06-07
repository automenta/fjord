package fjord.ast;

public class Ident implements Node {
    private final String value;

    public Ident(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return value;
    }
}
