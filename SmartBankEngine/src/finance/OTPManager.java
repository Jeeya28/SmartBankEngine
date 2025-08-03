package finance;

import java.util.*;

public class OTPManager {
	private int generatedOTP;

    public void generateOTP() {
        generatedOTP = 1000 + new Random().nextInt(9000);
        System.out.println("[SECURE OTP] Your one-time password is: " + generatedOTP);
    }

    public boolean verifyOTP() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the OTP: ");
        int input = sc.nextInt();
        return input == generatedOTP;
    }
}
