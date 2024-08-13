
import java.util.HashSet;


class CheckPermutation {
    public static void main(String[] args) {
        CheckPermutation checkPermutation = new CheckPermutation();

        System.out.println(checkPermutation.isPermutation("abcd", "abcde"));
    }

    // Solution 1:
    // tc: O(n  log n)- Sp: o(n)
    // public boolean isPermutation(String str1, String str2) {
    //     char[] charStr1 = str1.toCharArray();
    //     Arrays.sort(charStr1);
    //     char[] charStr2 = str2.toCharArray();
    //     Arrays.sort(charStr2);

    //     // check if string and order character match 
    //     if ((str1.length() != str2.length()) && !charStr1.equals(charStr2))
    //         return false;

    //     return true;

    // }
    
    // solution 2:
    // tc: o(n) - sp:o(n)

    public boolean isPermutation(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        
        HashSet<Character> setChar = new HashSet<Character>();

        for(int j = 0;j<str1.length(); j++){
            setChar.add(str1.charAt(j));
        }

        for (int i = 0; i < str2.length(); i++) {
            if (setChar.contains(str2.charAt(i))) {
                setChar.remove(str2.charAt(i));
            }
        }

        if (setChar.size() > 0)
            return false;

        return true;
    }
}
