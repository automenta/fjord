package fjord.ast;

import fjord.ast.expr.Expr;
import fjord.ast.pat.Pat;
import fjord.ast.typar.TyparDefns;
import fjord.ast.type.Type;
import fjord.types.TypeClass;

import java.util.Optional;

public class ValueDefn implements ModuleElem {

    private final boolean mutable;

    private final Access access;

    private final Pat pattern;

    private final Optional<TyparDefns> typarDefns;

    private final Optional<Type> returnType;

    private final Expr expr;

    private Optional<TypeClass> typeClass = Optional.empty();

    public ValueDefn(boolean mutable, Access access, Pat pattern, TyparDefns typarDefns, Type returnType, Expr expr) {
        this.mutable = mutable;
        this.access = access != null ? access : Access.Public;
        this.pattern = pattern;
        this.typarDefns = Optional.ofNullable(typarDefns);
        this.returnType = Optional.ofNullable(returnType);
        this.expr = expr;
    }

    public String pattern() {
        return pattern.toString();
    }

    public String expr() {
        return expr.toString();
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitBefore(this);

        if (pattern != null)
            pattern.accept(visitor);

        if (expr != null)
            expr.accept(visitor);

        visitor.visitAfter(this);
    }

    @Override
    public String toString() {
        return String.format("let %s = %s", pattern, expr);
    }

    public Pat getPattern() {
        return pattern;
    }

    public Expr getExpr() {
        return expr;
    }

    public boolean isMutable() {
        return mutable;
    }

    public Access getAccess() {
        return access;
    }

    public Optional<TyparDefns> getTyparDefns() {
        return typarDefns;
    }

    public Optional<Type> getReturnType() {
        return returnType;
    }

    public TypeClass getTypeClass() {
        return typeClass.get();
    }

    public void setTypeClass(TypeClass ty) {
        this.typeClass = Optional.of(ty);
    }
}
