package mccoyst;

public class Method{
	public final String name;
	public final String desc;

	public Method(String name, String desc){
		if(name == null){
			throw new IllegalArgumentException("name");
		}
		if(desc == null){
			throw new IllegalArgumentException("desc");
		}
		this.name = name;
		this.desc = desc;
	}

	@Override
	public boolean equals(Object o){
		if(o == this){
			return true;
		}

		if(!(o instanceof Method)){
			return false;
		}

		Method that = (Method)o;
		return that.name.equals(this.name) && that.desc.equals(this.desc);
	}

	@Override
	public int hashCode(){
		int h = 1;
		h = h * 31 + name.hashCode();
		h = h * 31 + desc.hashCode();
		return h;
	}

	@Override
	public String toString(){
		return name + desc;
	}
}
