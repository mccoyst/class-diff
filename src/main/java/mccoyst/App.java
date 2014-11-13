package mccoyst;

import org.objectweb.asm.*;

public class App{
    public static void main(String[] args) throws Exception{
		ClassPrinter cp = new ClassPrinter();
		ClassReader cr = new ClassReader("java.lang.String");
		cr.accept(cp, 0);
    }
}
