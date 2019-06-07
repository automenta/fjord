package fjord.ast;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Map;
import java.util.stream.Collectors;

public class OperatorStringifier {

    private static final String OP_NAME_PREFIX = "op_";

    private static final java.util.function.Function<Character, @Nullable String> OPERATOR_MAPPER = new OperatorMapper();

    private static final Map<String, String> SYMBOLIC_OPERATOR_MAPPING = Maps.newHashMap();

    private static final Map<Character, String> OPERATOR_NAME_MAPPING = Maps.newHashMap();

    static {
        Map<String, String> M = SYMBOLIC_OPERATOR_MAPPING;

        M.put("[]", "op_Nil");
        M.put("::", "op_ColonColon");
        M.put("+", "op_Addition");
        M.put("-", "op_Substraction");
        M.put("*", "op_Multiply");
        M.put("/", "op_Division");
        M.put("**", "op_Exponentiation");
        M.put("@", "op_Append");
        M.put("^", "op_Concatenate");
        M.put("%", "op_Modulus");
        M.put("&&&", "op_BitwiseAnd");
        M.put("|||", "op_BitwiseOr");
        M.put("^^^", "op_ExlusiveOr");
        M.put("<<<", "op_LeftShift");
        M.put("~~~", "op_LogicalNot");
        M.put(">>>", "op_ShiftRight");
        M.put("~-", "op_UnaryNegation");
        M.put("=", "op_Equality");
        M.put("<>", "op_Inequality");
        M.put("<=", "op_LessThanOrEqual");
        M.put(">=", "op_GreaterThanOrEqual");
        M.put("<", "op_LessThan");
        M.put(">", "op_GreaterThan");
        M.put("?", "op_Dynamic");
        M.put("?<-", "op_DynamicAssignment");
        M.put("|>", "op_PipeRight");
        M.put("||>", "op_PipeRight2");
        M.put("|||>", "op_PipeRight3");
        M.put("<|", "op_PipeLeft");
        M.put("<||", "op_PipeLeft2");
        M.put("<|||", "op_PipeLeft3");
        M.put("!", "op_Dereference");
        M.put(">>", "op_ComposeRight");
        M.put("<<", "op_ComposeLeft");
        M.put("<@ @>", "op_Quotation");
        M.put("<@@ @@>", "op_QuotationUntyped");
        M.put("~%", "op_Splice");
        M.put("~%%", "op_SpliceUntyped");
        M.put("~&", "op_AddressOf");
        M.put("~&&", "op_IntegerAddressOf");
        M.put("||", "op_BooleanOr");
        M.put("&&", "op_BooleanAnd");
        M.put("+=", "op_AdditionAssignment");
        M.put("-=", "op_SubstractionAssignment");
        M.put("*=", "op_MultiplyAssignment");
        M.put("/=", "op_DivisionAssignment");
        M.put("..", "op_Range");
        M.put(".. ..", "op_RangeStep");

        Map<Character, String> M1 = OPERATOR_NAME_MAPPING;

        M1.put('>', "Greater");
        M1.put('<', "Less");
        M1.put('+', "Plus");
        M1.put('-', "Minus");
        M1.put('*', "Multiply");
        M1.put('=', "Equals");
        M1.put('~', "Twiddle");
        M1.put('%', "Percent");
        M1.put('.', "Dot");
        M1.put('&', "Amp");
        M1.put('|', "Bar");
        M1.put('@', "At");
        M1.put('#', "Hash");
        M1.put('^', "Hat");
        M1.put('!', "Bang");
        M1.put('?', "Qmark");
        M1.put('/', "Divide");
        M1.put(':', "Colon");
        M1.put('(', "LParen");
        M1.put(',', "Comma");
        M1.put(')', "RParen");
        M1.put('[', "LBrack");
        M1.put(']', "RBrack");
    }

    public static String stringifyOperator(String operator) {

        String opStr = stringifySymbolicOperator(operator);

        return opStr != null ? opStr : stringifyNonSymbolicOperator(operator);
    }

    private static String stringifySymbolicOperator(String symbolicOp) {
        return SYMBOLIC_OPERATOR_MAPPING.get(symbolicOp);
    }

    private static String stringifyNonSymbolicOperator(String op) {
        return OP_NAME_PREFIX + Joiner.on("").join(Lists.charactersOf(op).stream().map(OPERATOR_MAPPER::apply).collect(Collectors.toList()));
    }

    private static class OperatorMapper implements Function<Character, String> {

        @Override
        public String apply(Character c) {
            return OPERATOR_NAME_MAPPING.get(c);
        }

    }

}
