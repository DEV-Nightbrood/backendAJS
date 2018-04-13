package dpmm.bsirh.buisness.exception;

public class UnmodifiableSessionExeception extends Exception
{
    private String message;

    UnmodifiableSessionExeception(String message)
    {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
