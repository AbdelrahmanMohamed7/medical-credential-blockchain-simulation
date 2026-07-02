import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

public class MerkleRootCalculator {

    // Computes the Merkle root from a list of hashed data
    public static String computeMerkleRoot(List<String> dataList) {
        List<String> currentLevel = new ArrayList<>();
        for (String data : dataList) {
            currentLevel.add(applySha256(data));
        }

        while (currentLevel.size() > 1) {
            List<String> nextLevel = new ArrayList<>();
            for (int i = 0; i < currentLevel.size(); i += 2) {
                String left = currentLevel.get(i);
                String right = (i + 1 < currentLevel.size()) ? currentLevel.get(i + 1) : left;
                nextLevel.add(applySha256(left + right));
            }
            currentLevel = nextLevel;
        }

        return currentLevel.isEmpty() ? "" : currentLevel.get(0);
    }

    // Applies SHA-256 hash function
    private static String applySha256(String input) {
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
}
