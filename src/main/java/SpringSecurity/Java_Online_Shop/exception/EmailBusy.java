package SpringSecurity.Java_Online_Shop.exception;

public class EmailBusy extends Exception{
    @Override
    public String getMessage() {
        return "EmailBusy";
    }
}
