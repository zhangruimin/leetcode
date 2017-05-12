import java.util.ArrayList;
import java.util.Stack;

/**
 */
public class L2017051202_535_Encode_and_Decode_TinyURL {
    class Codec {
        private final ArrayList<String> hash = new ArrayList<String>();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            hash.add(longUrl);
            return (hash.size() - 1) + "";
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return hash.get(Integer.parseInt(shortUrl) - 1);
        }
    }
}





