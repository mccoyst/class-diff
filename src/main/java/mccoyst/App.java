package mccoyst;

import java.io.*;
import java.util.*;

import org.objectweb.asm.*;

public class App{
    public static void main(String[] args) throws Exception{
		if(args.length < 2){
			System.err.println("I need the names of two class files.");
			System.exit(1);
		}

		InputStream a = new FileInputStream(args[0]);
		MethodCollector ma = new MethodCollector();
		InputStream b = new FileInputStream(args[1]);
		MethodCollector mb = new MethodCollector();

		try{
			ClassReader cra = new ClassReader(a);
			cra.accept(ma, 0);

			ClassReader crb = new ClassReader(b);
			crb.accept(mb, 0);
		}finally{
			a.close();
			b.close();
		}

		mb.methods.removeAll(ma.methods);
		for(Method m : mb.methods){
			System.out.println(m);
		}
    }
}
