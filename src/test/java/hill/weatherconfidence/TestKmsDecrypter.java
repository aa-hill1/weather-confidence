package hill.weatherconfidence;

public class TestKmsDecrypter implements IKmsDecrypter{
    @Override
    public String getDecryptedApiKey() {
        return "foo";
    }
}
