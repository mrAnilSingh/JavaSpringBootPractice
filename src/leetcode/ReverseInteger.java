package leetcode;

public class ReverseInteger {
    public static int reverse(int x) {
        int reversed = 0;

        while (x != 0) {
            int pop = x % 10;

            // Check for overflow before updating the reversed integer
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }

            reversed = reversed * 10 + pop;
            x /= 10;
        }

        return reversed;
    }

    public static void main(String[] args) {
        int x = 120;
        int reversed = reverse(x);
        System.out.println("Reversed Integer: " + reversed);
    }
}

