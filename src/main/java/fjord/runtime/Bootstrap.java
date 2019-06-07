package fjord.runtime;

import me.qmx.jitescript.internal.org.objectweb.asm.Handle;
import org.objectweb.asm.Opcodes;

import java.lang.invoke.CallSite;
import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;

import static me.qmx.jitescript.util.CodegenUtils.p;

public class Bootstrap {
    public static Handle HANDLE;

    static {
        HANDLE = new Handle(
                Opcodes.H_INVOKESTATIC,
                p(Bootstrap.class),
                "bootstrap",
                MethodType.methodType(CallSite.class, Lookup.class, String.class, MethodType.class, String.class).toMethodDescriptorString());
    }

    public static CallSite bootstrap(Lookup lookup, String name, MethodType type, String klass) throws Throwable {
        MethodHandle target = lookup.findStatic(JiteClassLoader.INSTANCE.loadClass(klass), name, type);
        return new ConstantCallSite(target);
    }

}
