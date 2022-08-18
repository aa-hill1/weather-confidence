package hill.weatherconfidence;

import com.google.cloud.kms.v1.CryptoKeyName;
import com.google.cloud.kms.v1.DecryptResponse;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.protobuf.ByteString;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class KmsDecrypter implements IKmsDecrypter {

    private KeyManagementServiceClient kmsClient;

    private final  CryptoKeyName kmsKey;
    private final Environment environment;

    private String decryptedApiKey = null;

    public KmsDecrypter(KeyManagementServiceClient kmsClient, CryptoKeyName kmsKey, Environment environment) {
        this.kmsClient = kmsClient;
        this.kmsKey = kmsKey;
        this.environment = environment;
        init();
    }

    private void init() {
        try {
            kmsClient = KeyManagementServiceClient.create();
            byte[] buf = Base64.getDecoder().decode(environment.getProperty("gcp.kms.encryptedApiKey"));
            DecryptResponse response = kmsClient.decrypt(kmsKey, ByteString.copyFrom(buf));
            decryptedApiKey = response.getPlaintext().toString(StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getDecryptedApiKey() {
        return decryptedApiKey;
    }
}
