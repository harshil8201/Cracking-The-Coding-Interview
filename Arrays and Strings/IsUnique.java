class IsUnique {

    public static void main(String[] args) {
        IsUnique solution = new IsUnique();

        System.out.println(solution.isUnique("abcd"));
    }

    // // Solution 1:
    // // TC: O(n) - SC:O(n)

    // public boolean isUnique(String str) {
    //     HashSet<Character> setChar = new HashSet<Character>();

    //     for (int i = 0; i < str.length(); i++) {
    //         if (!setChar.contains(str.charAt(i))) {
    //             setChar.add(str.charAt(i));
    //         } else {
    //             return false;
    //         }
    //     }
    //     return true;
    // }


    // // Solution 2:
    // // TC: o(n) - sp: o(c) where c is the length of string
    
    // public boolean isUnique(String str) {
    //     if (str.length() > 128)
    //         return false;

    //     boolean[] char_set = new boolean[128];

    //     for (int i = 0; i < str.length(); i++) {
    //         int val = str.charAt(i);
    //         if (char_set[val]) { // Already found this char in string
    //             return false;
    //         }
    //         char_set[val] = true;
    //     }

    //     return true;
    // }
    
    // Solution 3:
    // tc: o(n^2) - sc: O(1)

    public boolean isUnique(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }

        return true;
    }
}