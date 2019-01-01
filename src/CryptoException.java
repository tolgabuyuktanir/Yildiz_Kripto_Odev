public class CryptoException extends Throwable {
    public CryptoException() {
    }
    public CryptoException(String s, Exception ex) {
        super(s,ex);
    }
}
