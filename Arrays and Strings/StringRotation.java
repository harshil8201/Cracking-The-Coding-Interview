class StringRotation {
    public static void main(String[] args) {
        StringRotation stringRotation = new StringRotation();
        System.out.println(stringRotation.isRotation("waterbottle", "erbottlewat"));
    }

    // solution 1:
    boolean isRotation(String s1, String s2) {

        StringBuilder foundChar = new StringBuilder();
        StringBuilder notFoundChar = new StringBuilder();
        StringBuilder res = new StringBuilder();
        int cursor = 0;

        if(s1.length() != s2.length()) return false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(cursor)) {
                foundChar.append(s1.charAt(i));
                cursor++;
            } else {
                notFoundChar.append(s1.charAt(i));
            }
        }

        res.append(notFoundChar);
        res.append(foundChar);

        return s1.equals(res.toString()) ? true : false;
    }


    // // Solution 2:
    // boolean isRotation(String s1, String s2) {
    //     int len = s1.length();

    //     // check that s1 and s2 are equal length not empty
    //     if (len == s2.length() && len > 0) {
    //         // Cpncatentae s1 and s1 within new buffer
    //         String s1s1 = s1 + s1;
    //         return isRotation(s1s1, s2);
    //     }
    //     return false;
    // }
}
