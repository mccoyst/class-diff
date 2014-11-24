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
		InputStream b = new FileInputStream(args[1]);

		Set<Method> nm = findNewMethods(a, b);
		for(Method m : nm){
			System.out.println(m);
		}
	}

	public static Set<Method> findNewMethods(InputStream a, InputStream b) throws Exception{
		Set<Method> ma = null, mb = null;
		try{
			ma = readMethods(a);
			mb = readMethods(b);
		}finally{
			a.close();
			b.close();
		}

		mb.removeAll(ma);
		return mb;
    }

	public static Set<Method> readMethods(InputStream in) throws Exception{
		MethodCollector mc = new MethodCollector();
		ClassReader cr = new ClassReader(in);
		cr.accept(mc, 0);
		return mc.methods;
	}
}
