package mochotexto.parsing.exception;

public class ParsingException extends Exception{
	public ParsingException(Exception e) {
		super(e);
	}

	public ParsingException(String message) {
		super(message);
	}
}
