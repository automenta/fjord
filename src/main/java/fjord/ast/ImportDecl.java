package fjord.ast;

public class ImportDecl implements ModuleElem {

    private String ident;

    public ImportDecl(String ident) {
        this.ident = ident;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return String.format("open %s", ident);
    }
}
