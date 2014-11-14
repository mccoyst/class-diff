package mccoyst;

import java.util.*;

import org.objectweb.asm.*;

public class MethodCollector extends ClassVisitor{
	public final Set<Method> methods;

	public MethodCollector(){
		super(Opcodes.ASM5);
		methods = new HashSet<Method>();
	}

	public void visit(int version, int access, String name,
			String signature, String superName, String[] interfaces){
	}

	public void visitSource(String source, String debug){
	}

	public void visitOuterClass(String owner, String name, String desc){
	}

	public AnnotationVisitor visitAnnotation(String desc, boolean visible){
		return null;
	}

	public void visitAttribute(Attribute attr){
	}

	public void visitInnerClass(String name, String outerName,
			String innerName, int access){
	}

	public FieldVisitor visitField(int access, String name, String desc,
			String signature, Object value){
		return null;
	}

	public MethodVisitor visitMethod(int access, String name,
			String desc, String signature, String[] exceptions){
		methods.add(new Method(name, desc));
		return null;
	}

	public void visitEnd(){
	}
}
