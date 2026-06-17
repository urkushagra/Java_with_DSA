class Solution {

    public int numberOfRounds(String loginTime, String logoutTime) {

        int start = toMinutes(loginTime);
        int end = toMinutes(logoutTime);

        // Crossed midnight
        if (end < start) {
            end += 24 * 60;
        }

        // Round login up
        start = ((start + 14) / 15) * 15;

        // Round logout down
        end = (end / 15) * 15;

        return Math.max(0, (end - start) / 15);
    }

    private int toMinutes(String time) {

        int hours = Integer.parseInt(time.substring(0, 2));
        int minutes = Integer.parseInt(time.substring(3));

        return hours * 60 + minutes;
    }
}
