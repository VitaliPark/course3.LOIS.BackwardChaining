package model.parameters;

public abstract class Parameter {
	protected String name;

	public Parameter(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object arg0) {
		if (this == arg0) {
			return true;
		}
		if (!(arg0 instanceof Parameter)) {
			return false;
		}
		return name.equals(((Parameter) arg0).getName());
	}

}
