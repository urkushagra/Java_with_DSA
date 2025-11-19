class AuthService {

    private String passwordHash;  // hidden
    private String otp;           // hidden

    public void register(String password) {
        this.passwordHash = hash(password);  // encryption inside
    }

    public boolean login(String password) {
        return passwordHash.equals(hash(password)); // controlled check
    }

    public void sendOtp(String phoneNumber) {
        this.otp = generateOtp();     // hidden logic
        // send otp (API call hidden)
    }

    public boolean verifyOtp(String code) {
        return otp.equals(code);      // controlled validation
    }
}
