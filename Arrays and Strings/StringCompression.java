public class StringCompression {
    public static void main(String[] args) {
        StringCompression stringCompression = new StringCompression();

        System.out.println(stringCompression.stringComp("aabcccccaa"));
    }
    
    // solution 1:
    String stringComp(String str) {
        StringBuilder newStr = new StringBuilder();
        int count = 1;

        // intrate hrough string and check occurance
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                newStr.append(str.charAt(i));
                newStr.append(count);
                count = 1;
            }
        }
        // add last element of str and its count
        newStr.append(str.charAt(str.length()-1));
        newStr.append(count);

        // check lenght of newStr
        // if smaller than return newStr otherwise original str 
        return newStr.length() < str.length() ? newStr.toString() : str;
    }
}
