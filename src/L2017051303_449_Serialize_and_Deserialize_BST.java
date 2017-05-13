/**
 */
public class L2017051303_449_Serialize_and_Deserialize_BST {
    class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "[null]";
            }

            return "[" + root.val + "," + serialize(root.left) + "," + serialize(root.right) + "]";
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {

            if ("[null]".equals(data)) {
                return null;
            }

            int firstCommaIndex = getFirstCommaIndex(data);
            TreeNode root = new TreeNode(getRootValue(data, firstCommaIndex));
            String leftPart = getSubTreePart(data, firstCommaIndex + 1);
            root.left = deserialize(leftPart);
            root.right = deserialize(getSubTreePart(data, firstCommaIndex + leftPart.length() + 2));
            return root;
        }

        private String getSubTreePart(String data, int startIndex) {
            int index = findMatchingBracketIndex(data, startIndex);
            return data.substring(startIndex, index + 1);
        }

        private int findMatchingBracketIndex(String data, int first) {
            int index = first;
            int bracketNum = 1;
            while (bracketNum != 0) {
                index++;
                if (data.charAt(index) == '[') {
                    bracketNum++;
                } else if (data.charAt(index) == ']') {
                    bracketNum--;
                }
            }
            return index;
        }

        private int getRootValue(String data, int firstCommaIndex) {
            return Integer.parseInt(data.substring(1, firstCommaIndex));
        }

        private int getFirstCommaIndex(String data) {
            return data.indexOf(',');
        }

    }
}





