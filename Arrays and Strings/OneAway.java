import java.util.HashSet;

public class OneAway {
    public static void main(String[] args) {
        OneAway oneAway = new OneAway();
        System.out.println(oneAway.isOneEditAway("pale", "bale"));

    }
    
    // Solution 1:
    boolean isOneEditAway(String orignal, String edited) {
        HashSet<Character> charSet = new HashSet<Character>();

        // insert all char from Original String to HashSet
        for (char c : orignal.toCharArray()) {
            charSet.add(c);
        }

        // Check if char from edited string present in Original or not.
        for (char i : edited.toCharArray()) {
            if (charSet.contains(i)) {
                charSet.remove(i);
            }
        }

        // check the size of charSet
        if (charSet.size() > 1) return false;

        return true;
    }
}
