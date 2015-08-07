package pl.spring.demo.service;

public class UnknownParameterException extends Exception {
	private static final long serialVersionUID = 6704583267173628033L;
	public UnknownParameterException() {
		super();
	}

	public UnknownParameterException(String paramName) {
		super("Unknown parameter \'" + paramName + "\'");
	}
}
