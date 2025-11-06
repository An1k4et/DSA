class Solution {
    public int smallestNumber(int n) {
        int lastBit = Integer.highestOneBit(n);
        return lastBit | lastBit-1;
    }
}