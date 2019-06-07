package fjord.ast.typedefn;

import fjord.ast.ModuleElem;
import fjord.ast.NodeVisitor;

import java.util.List;

public class EnumTypeDefn implements ModuleElem {

    private final TypeName typeName;

    private final List<EnumTypeCase> enumTypeCases;

    public EnumTypeDefn(TypeName typeName, List<EnumTypeCase> enumTypeCases) {
        this.typeName = typeName;
        this.enumTypeCases = enumTypeCases;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

    public TypeName getTypeName() {
        return typeName;
    }

    public List<EnumTypeCase> getEnumTypeCase() {
        return enumTypeCases;
    }

}
