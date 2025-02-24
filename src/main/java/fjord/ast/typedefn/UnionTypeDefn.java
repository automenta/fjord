package fjord.ast.typedefn;

import fjord.ast.ModuleElem;
import fjord.ast.NodeVisitor;

import java.util.Collections;
import java.util.List;

public class UnionTypeDefn implements ModuleElem {

    private final TypeName typeName;

    private final List<UnionTypeCase> unionTypeCases;

    private final List<TypeDefnElement> typeDefnElements;

    public UnionTypeDefn(TypeName typeName, List<UnionTypeCase> unionTypeCases, List<TypeDefnElement> typeDefnElements) {
        this.typeName = typeName;
        this.unionTypeCases = unionTypeCases;
        this.typeDefnElements = typeDefnElements != null ? typeDefnElements : Collections.emptyList();
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

    public TypeName getTypeName() {
        return typeName;
    }

    public List<UnionTypeCase> getUnionTypeCases() {
        return unionTypeCases;
    }

    public List<TypeDefnElement> getTypeDefnElements() {
        return typeDefnElements;
    }

}
