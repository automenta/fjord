package fjord.ast;

public class Operator {

    private final int op;

    public Operator(char op) {
        this.op = op;
    }

    public int op() {
        return op;
    }

}
