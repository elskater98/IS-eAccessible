package exceptions;

public class BasicException extends Exception{
	
	Integer codeError;
	String message;
	
	public BasicException(Integer codeError,String message) {
        super(message);
        this.codeError=codeError;
        this.message=message;
    }

	public Integer getCodeError() {
		return codeError;
	}

	public void setCodeError(Integer codeError) {
		this.codeError = codeError;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
