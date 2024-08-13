class URLify {
    public static void main(String[] args) {
        URLify uRLify = new URLify();
        char[] str = "Mr John Smith      ".toCharArray();
        uRLify.urlUnified(str, 13);
        System.out.println(new String(str));
    }


    // tc:  o(n) - sc: 0(1)
    public void urlUnified(char[] str, int trueLength) {
        int numberOfSpace = countOfChar(str, 0, trueLength, ' ');
        int newIndex = trueLength -1+ numberOfSpace*2;

        // if there are excess space, add a null charater.
        // This indicates that the space after that point have not been replaced with %20.
        if (newIndex + 1 < str.length) str[newIndex + 1] = '\0';

        for (int oldIndex = trueLength - 1; oldIndex >= 0; oldIndex--) {
            if (str[oldIndex] == ' ') { // Insert %20
                str[newIndex] = '0';
                str[newIndex - 1] = '2';
                str[newIndex - 2] = '%';
                newIndex -= 3;
            } else{
                str[newIndex] = str[oldIndex];
                newIndex -= 1;
            }
        }

    }
    
    private int countOfChar(char[] str, int start, int end, int target) {
        int count = 0;
        for (int i = start; i < end; i++) {
            if (str[i] == target) {
                count++;
            }
        }
        return count;
    }
}
