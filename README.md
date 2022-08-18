# weather-confidence

Getting up and running:

The app uses a GCP service account token to authenticate in order to call KMS decrypt operations and for database access.
In order to run the app locally, you need a decrypted service account token.  The encrypted token is stored in 
`/encrypted/weather-confidence-sa.json.secret`, and you can either decrypt using the `/bin/kmedecrypt` script (linux, mac)
with:

```sh 
cat ./encrypted/gcp-service-account-token.enc | base64 | ./bin/kmsdecrypt dev  > ~/sa-token.json.secret
```

...or using the underlying `gcloud` command with:

```sh 
gcloud kms decrypt --plaintext-file=~/weather-confidence-sa.json.secret --ciphertext-file=encrypted/gcp-service-account-token.enc --project=weather-confidence --location=global --keyring=main --key=main
```

To run either command, you will need gcloud command line authenticated against the GCP project. The decrypted file in the examples above will 
be saved into the user's home directory.  Adjust as required.  If decrypting into the project folder, the extension `.secret`
is important since it will be ignored by git (see `.gitignore` file).  Never commit unencrypted creds into git.

In order for the app to use these credentials, the simplest thing to do is to set a GOOGLE_APPLICATION_CREDENTIALS 
environment variable with the path to the decrypted service account token as the value.  You can do this two ways - either on the shell 
before launching the app, or within your IDE in the run profile.

## Using encrypted values in the app
Encrypted values (currently) need to be configured in the `KmsDecrypter` class, and then that class is configured at startup
time as a property source.  This means that the rest of the app does not need to care about decryption or whether a
property is encrypted or not - it's transparent to the rest of the app, so just use the properties as if they're 
normal, unencrypted properties. Currently, the decryption is non-lazy and is handled in the `KmsDecrypter.init()` method.
This could be made lazy and optimised but it's not worth doing so when we only have a couple of encrypted values.

