package hill.weatherconfidence;

public class DummyKmsDecrypter implements IKmsDecrypter{
    @Override
    public String getDecryptedApiKey() {
        return "foo";
    }
}
