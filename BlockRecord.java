import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

public class BlockRecord {
    private int index;
    private long timestamp;
    private String previousHash;
    private String currentHash;
    private String data;

    public BlockRecord(int index, String previousHash, String data) {
        this.index = index;
        this.timestamp = Instant.now().toEpochMilli();
        this.previousHash = previousHash;
        this.data = data;
        this.currentHash = calculateHash();
    }

    // Generates the hash for the block
    public String calculateHash() {
        String input = index + Long.toString(timestamp) + previousHash + data;
        return applySha256(input);
    }

    // Validates the block
    public boolean validateBlock(BlockRecord previousBlock) {
        return previousHash.equals(previousBlock.getCurrentHash()) &&
                currentHash.equals(calculateHash());
    }

    // Applies SHA-256 hash function
    public static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Getters
    public int getIndex() {
        return index;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getCurrentHash() {
        return currentHash;
    }

    public String getData() {
        return data;
    }
}
