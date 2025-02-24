package fjord.ast.typedefn;

import fjord.ast.Access;
import fjord.ast.attribute.Attribute;
import fjord.ast.typar.TyparDefns;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TypeName {

    private final List<Attribute> attributes;

    private final Access access;

    private final String ident;

    private final Optional<TyparDefns> typarDefns;

    public TypeName(List<Attribute> attributes, Access access, String ident, TyparDefns typarDefns) {
        this.attributes = attributes != null ? attributes : Collections.emptyList();
        this.access = access != null ? access : Access.Public;
        this.ident = ident;
        this.typarDefns = Optional.ofNullable(typarDefns);
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public Access getAccess() {
        return access;
    }

    public String getIdent() {
        return ident;
    }

    public Optional<TyparDefns> getTyparDefns() {
        return typarDefns;
    }

}
