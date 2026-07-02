import java.security.KeyPair;
import java.util.Arrays;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting Blockchain...");

        // Generate Ed25519 key pair for digital signatures
        KeyPair keyPair = DigitalSignatureUtility.generateKeyPair();
        System.out.println("KeyPair generated successfully.");

        // Create the genesis block
        BlockRecord genesis = new BlockRecord(0, "0", "Genesis Block Data");
        System.out.println("Genesis Block created:");
        System.out.println("Index: " + genesis.getIndex());
        System.out.println("Hash: " + genesis.getCurrentHash());
        System.out.println("-------------------------------------------");

        // Create the second block
        BlockRecord secondBlock = new BlockRecord(1, genesis.getCurrentHash(), "Second Block Data");
        System.out.println("Second Block created:");
        System.out.println("Index: " + secondBlock.getIndex());
        System.out.println("Hash: " + secondBlock.getCurrentHash());
        System.out.println("-------------------------------------------");

        // Validate the second block
        boolean isValid = secondBlock.validateBlock(genesis);
        System.out.println("Is the second block valid? " + isValid);
        System.out.println("-------------------------------------------");

        // Example data to hash
        String data = "Medical Credential Data";
        String hashedData = BlockRecord.applySha256(data);
        System.out.println("Hashed Data: " + hashedData);
        System.out.println("-------------------------------------------");

        // Example of Merkle root creation
        List<String> dataList = Arrays.asList(
                BlockRecord.applySha256("Data1"),
                BlockRecord.applySha256("Data2"),
                BlockRecord.applySha256("Data3"),
                BlockRecord.applySha256("Data4"));
        String merkleRoot = MerkleRootCalculator.computeMerkleRoot(dataList);
        System.out.println("Merkle Root calculated: " + merkleRoot);
        System.out.println("-------------------------------------------");

        // Example of AES encryption/decryption
        String secretKey = AESUtility.generateSecretKey();
        String encryptedData = AESUtility.encrypt(data, secretKey);
        System.out.println("Encrypted Data: " + encryptedData);

        String decryptedData = AESUtility.decrypt(encryptedData, secretKey);
        System.out.println("Decrypted Data: " + decryptedData);
        System.out.println("-------------------------------------------");

        // Signing and verifying data
        byte[] signature = DigitalSignatureUtility.signData(data, keyPair.getPrivate());
        System.out.println("Data signed successfully.");
        System.out.println("Signature: " + DigitalSignatureUtility.bytesToHex(signature));

        boolean isSignatureValid = DigitalSignatureUtility.verifySignature(data, signature, keyPair.getPublic());
        System.out.println("Is the signature valid? " + isSignatureValid);
        System.out.println("-------------------------------------------");

        System.out.println("Blockchain completed successfully.");
    }
}
