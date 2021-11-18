public class DecodeCaesar {
    public DecodeCaesar() {
    }

    public String decrypt(String secret, int shift) {
        if (shift > 0 && shift < 26) {
            secret = secret.toUpperCase();
            for (int i = 0; i < secret.length(); i++) {
                char c = secret.charAt(i);
                if (c >= 65 && c <= 90) {
                    c = (char) (c - shift);
                    if (c > 90) {
                        c = (char) (c - 26);
                    }
                }
                secret = secret.substring(0, i) + c + secret.substring(i + 1);
            }
        }
        return secret;
    }
}
