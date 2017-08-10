package leetcode;

/**
 */
public class L2017042801_468_Validate_IP_Address {
    public static void main(String[] args) {
        new L2017042801_468_Validate_IP_Address().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:");
    }

    public String validIPAddress(String IP) {
        if (IP == null || IP.trim().length() == 0) {
            return "Neither";
        }

        if (isSeparator(IP.charAt(0)) || isSeparator(IP.charAt(IP.length() - 1))) {
            return "Neither";
        }
        String[] v4Parts = IP.split("\\.");

        if (v4Parts.length == 4) {
            if (isValidV4(v4Parts)) {
                return "IPv4";
            }
            return "Neither";
        }

        String[] v6Parts = IP.split(":");
        if (isValidV6(v6Parts)) {
            return "IPv6";
        }

        return "Neither";
    }

    private boolean isSeparator(char c) {
        return c == '.' || c == ':';
    }

    private boolean isValidV6(String[] v6Parts) {
        if (v6Parts.length != 8) {
            return false;
        }

        for (String v6Part : v6Parts) {
            if (v6Part.length() > 4 || v6Part.length() == 0) {
                return false;
            }

            for (int i = 0; i < v6Part.length(); i++) {
                char c = v6Part.charAt(i);
                if (!isValidV6Char(c)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidV6Char(char c) {
        return c >= '0' && c <= '9' || c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F';
    }

    private boolean isValidV4(String[] v4Parts) {
        try {
            for (String v4Part : v4Parts) {
                if (v4Part.length() > 1 && (v4Part.charAt(0) == '0' || v4Part.charAt(0) == '-')) {
                    return false;
                }


                int n = Integer.parseInt(v4Part);
                if (n < 0 || n > 255) {
                    return false;
                }
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}





