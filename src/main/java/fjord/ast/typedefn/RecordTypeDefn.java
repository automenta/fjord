package fjord.ast.typedefn;

import fjord.ast.ModuleElem;
import fjord.ast.NodeVisitor;

import java.util.Collections;
import java.util.List;

public class RecordTypeDefn implements ModuleElem {

    private final TypeName typeName;

    private final List<RecordField> recordFields;

    private final List<TypeDefnElement> typeDefnElements;

    public RecordTypeDefn(TypeName typeName, List<RecordField> recordField, List<TypeDefnElement> typeDefnElements) {
        this.typeName = typeName;
        this.recordFields = recordField;
        this.typeDefnElements = typeDefnElements != null ? typeDefnElements : Collections.emptyList();
    }

    public TypeName getTypeName() {
        return typeName;
    }

    public List<RecordField> getRecordFields() {
        return recordFields;
    }

    public List<TypeDefnElement> getTypeDefnElements() {
        return typeDefnElements;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

}
