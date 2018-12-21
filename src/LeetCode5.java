public class LeetCode5 {
    public static void main(String[] args) {
        LeetCode5 leetCode5 = new LeetCode5();
        System.out.println(leetCode5.longestPalindrome("acsdbababxxx"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxLength = 0;
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = s.charAt(j) == s.charAt(i) && (i - j <= 2 || dp[i - 1][j + 1]);
                if (dp[i][j]) {
                    if (i - j + 1 > maxLength) {
                        maxLength = i - j + 1;
                        answer = s.substring(j, i + 1);
                    }
                }
            }
        }
        return answer;
    }
}
