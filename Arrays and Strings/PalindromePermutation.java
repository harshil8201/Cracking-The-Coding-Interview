
class PalindromePermutation {
    
    public static void main(String[] args) {
        PalindromePermutation palindromePermutation = new PalindromePermutation();

        System.out.println(palindromePermutation.isPalindromePermutaion("Tact Coa"));
    }
    
    // SOlution 1
    // tc: o(n) - sc: o(m) where m is size of charater
    // we slve this using bit manupulation

    // toggle the ith bit in the integer
    int toggle(int bitVector, int index) {
        if (index < 0)
            return bitVector;

        int mask = 1 << index;
        bitVector ^= mask;
        return bitVector;
    }
    
    // create bit vector for string 
    // for each letter with value 1.
    int createBitVector(String str) {
        int bitVector = 0;
        for (char c : str.toCharArray()) {
            // use Common.getCharNumber(c) insetd of "c".
            int x = /*Common.getCharNumber(c)*/ c;
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }

    // check that at most one bit is set by subtracting one from the 
    // integer and ANDing it with the original integer.
    boolean checkAtMostOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }

    boolean isPalindromePermutaion(String str) {
        int bitVector = createBitVector(str);
        return checkAtMostOneBitSet(bitVector);
    }
}
