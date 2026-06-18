class Solution {
    public double angleClock(int hour, int minutes) {
        // Angle of minute hand
        double minuteAngle = minutes * 6.0;

        // Angle of hour hand
        double hourAngle = (hour % 12) * 30.0 + minutes * 0.5;

        // Absolute difference
        double diff = Math.abs(hourAngle - minuteAngle);

        // Return smaller angle
        return Math.min(diff, 360.0 - diff);
    }
}
