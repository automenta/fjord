package fjord.ast.typedefn;

import fjord.ast.ModuleElem;
import fjord.ast.NodeVisitor;

import java.util.List;

public class InterfaceTypeDefn implements ModuleElem {

    private final TypeName typeName;

    private final List<TypeDefnElement> interfaceTypeBody;

    public InterfaceTypeDefn(TypeName typeName, List<TypeDefnElement> interfaceTypeBody) {
        this.typeName = typeName;
        this.interfaceTypeBody = interfaceTypeBody;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

    public TypeName getTypeName() {
        return typeName;
    }

    public List<TypeDefnElement> getInterfaceTypeBody() {
        return interfaceTypeBody;
    }

}
