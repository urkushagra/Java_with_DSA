package practice;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class OTPFileHandler {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("One-Time Pad Encryption/Decryption Utility");
        System.out.println("----------------------------------------");

        System.out.print("Enter the path to the plaintext message file: ");
        String plaintextFilePath = scanner.nextLine();

        System.out.print("Enter the path to save/load the key file (e.g., otp_key.bin): ");
        String keyFilePath = scanner.nextLine();

        System.out.print("Enter the path to save the ciphertext file (e.g., ciphertext.bin): ");
        String ciphertextFilePath = scanner.nextLine();

        System.out.print("Enter the path to save the decrypted message file (e.g., decrypted_message.txt): ");
        String decryptedFilePath = scanner.nextLine();

        Path plaintextPath = Paths.get(plaintextFilePath);
        Path keyPath = Paths.get(keyFilePath);
        Path ciphertextPath = Paths.get(ciphertextFilePath);
        Path decryptedPath = Paths.get(decryptedFilePath);

        try {
            // 1. Read plaintext from
            byte[] plaintextBytes = Files.readAllBytes(plaintextPath);
            System.out.println("Plaintext read from file: " + new String(plaintextBytes));

            // 2. Generate or Load Key
            byte[] key;
            if (Files.exists(keyPath)) {
                System.out.println("Key file found. Loading existing key...");
                key = Files.readAllBytes(keyPath);
                if (key.length < plaintextBytes.length) {
                    System.err.println("Warning: Loaded key is shorter than the plaintext. This is not a secure OTP.");
                    System.err.println("Please generate a new key or ensure the existing key is long enough.");
                    return; // Exit if key is too short for proper OTP
                }
            } else {
                System.out.println("Key file not found. Generating a new key...");
                key = OneTimePad.generateKey(plaintextBytes.length);
                Files.write(keyPath, key);
                System.out.println("New key generated and saved to: " + keyPath.toAbsolutePath());
            }

            // 3. Encrypt the message
            byte[] ciphertextBytes = OneTimePad.encrypt(plaintextBytes, key);
            Files.write(ciphertextPath, ciphertextBytes);
            System.out.println("Message encrypted and ciphertext saved to: " + ciphertextPath.toAbsolutePath());
            // Note: Ciphertext will be binary, not directly readable as text

            // 4. Decrypt the message
            byte[] decryptedBytes = OneTimePad.decrypt(ciphertextBytes, key);
            Files.write(decryptedPath, decryptedBytes);
            System.out.println("Message decrypted and saved to: " + decryptedPath.toAbsolutePath());
            System.out.println("Decrypted message: " + new String(decryptedBytes));

        } catch (IOException e) {
            System.err.println("Error during file operations: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Encryption/Decryption error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
