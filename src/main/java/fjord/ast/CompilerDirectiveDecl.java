package fjord.ast;

public class CompilerDirectiveDecl implements ModuleElem {

    private String ident;

    public CompilerDirectiveDecl(String ident) {
        this.ident = ident;
    }

    public String getIdent() {
        return ident;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "# " + ident;
    }
}
