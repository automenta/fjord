package fjord;

import fjord.ast.CompilerDirectiveDecl;
import fjord.ast.DefaultNodeVisitor;
import fjord.ast.Node;
import fjord.ast.ValueDefn;
import fjord.types.TypeClass;
import fjord.types.TypeSystem;
import jline.console.ConsoleReader;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static int counter;

    public static void main(String[] args) throws Exception {
        ConsoleReader reader = new ConsoleReader();
        reader.setPrompt("> ");

        PrintWriter out = new PrintWriter(reader.getOutput());
        out.println(banner());

        Environment env = new Environment();

        while (!env.isHalted()) {
            String line = reader.readLine();
            if (line == null)
                break;

            String output = eval(env, line);

            out.println(output);
            out.flush();
        }
    }

    public static String eval(final Environment env, String input) throws Exception {
        final Compiler compiler = new Compiler(String.format("ScriptFragment$%d", counter++));

        Node node = compiler.parse(input);
        if (node == null)
            return "";

        final StringBuilder output = new StringBuilder();

        node.accept(new DefaultNodeVisitor() {
            @Override
            public void visit(CompilerDirectiveDecl decl) {
                if (decl.getIdent().equals("help"))
                    output.append(help());
                else if (decl.getIdent().equals("quit"))
                    env.halt();
                else
                    output.append(String.format("Invalid directive '%s'\n", decl));
            }
        });

        final Map<String, TypeClass> typeEnv = new HashMap<>();
        final TypeSystem typeSystem = new TypeSystem();

        node.accept(new DefaultNodeVisitor() {
            @Override
            public void visitAfter(ValueDefn defn) {
                TypeClass ty = typeSystem.analyse(typeEnv, defn);

                defn.setTypeClass(ty);

                Value val = compiler.codegen(defn);

                output.append(String.format("val %s : %s = %s\n", defn.pattern(), ty, val.eval()));
            }
        });

        return output.toString();
    }

    private static String banner() {
        StringBuilder output = new StringBuilder();
        String version = String.format(
                "Fjord (%s %s) [%s-%s]",
                System.getProperty("java.vm.name"),
                System.getProperty("java.runtime.version"),
                System.getProperty("os.name"),
                System.getProperty("os.arch")
        );
        output.append(String.format("%s\n\n", version));
        output.append("For help type #help\n");
        return output.toString();
    }

    private static String help() {
        StringBuilder output = new StringBuilder();
        output.append("\n");
        output.append("  Directives:\n");
        output.append("\n");
        output.append("    #help                Display help\n");
        output.append("    #quit                Exit\n");
        output.append("\n");
        return output.toString();
    }

    public static class Environment {
        private boolean halted;

        public void halt() {
            this.halted = true;
        }

        public boolean isHalted() {
            return halted;
        }
    }
}
