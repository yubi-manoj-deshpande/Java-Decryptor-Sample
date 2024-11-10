package org.example;

import java.security.PrivateKey;

public class Main {
    public static void main(String[] args) {
        try {
            // Load private key
            PrivateKey privateKey = RSAUtil.getPrivateKey("/Users/manoj.deshpande/private_key.pem");

            // Encrypted message from JavaScript (Base64 encoded)
            String encryptedMessage = "TqsTVNWa4gJE+hkZLTzFo/fkpBOpBjcSFnTGh/V2ZHZ3ehsEA1cee1JHMyYC7MamUTNqOfrY3xWxgP/C1nPRExBGu2a8KgQYPeGPZM4wAZpfam1PMQzmKxsOxAsdAgazWdwV/edgtsS0ppMg4vur23XoMOCIGXaQBFcI91QhRGwy9vYFPab1nfSijv0XLjAwUSsRYEqQ3+cDEeKCoViQYZ/GFppdFy8Ok3tgdinlYTPKZ1B6Ort/zM8jpxSjSpnChcU724gjvQV9sjBPJ2Qpe4s7NEObWzGFZkgDU0EoshVaWRNIynt0HfbQa4KbaL5GKeLK4xsq/jMwhFDsqnMPOQ==";

            // Decrypt the message
            String decryptedMessage = Decryptor.decrypt(encryptedMessage, privateKey);
            System.out.println("Decrypted Message: " + decryptedMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
