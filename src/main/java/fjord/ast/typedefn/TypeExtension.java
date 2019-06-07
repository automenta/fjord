package fjord.ast.typedefn;

import fjord.ast.ModuleElem;
import fjord.ast.NodeVisitor;

import java.util.List;

public class TypeExtension implements ModuleElem {

    private final TypeName typeName;

    private final List<TypeDefnElement> typeDefnElements;

    public TypeExtension(TypeName typeName, List<TypeDefnElement> typeDefnElements) {
        this.typeName = typeName;
        this.typeDefnElements = typeDefnElements;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

    public List<TypeDefnElement> getTypeDefnElements() {
        return typeDefnElements;
    }

    public TypeName getTypeName() {
        return typeName;
    }

}
