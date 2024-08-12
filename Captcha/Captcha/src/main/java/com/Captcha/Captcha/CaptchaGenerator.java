package com.Captcha.Captcha;

/*public class CaptchaGenerator {

}*/
public class CaptchaGenerator {  
    public static String generateCaptcha(int length) {  
        char[] characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();  
        StringBuilder captcha = new StringBuilder();  
        for (int i = 0; i < length; i++) {  
            int index = (int) (Math.random() * characters.length);  
            captcha.append(characters[index]);  
        }  
        return captcha.toString();  
    }  
    public static void main(String[] args) {  
        int captchaLength = 6; // Enter the required length of CAPTCHA  
        String capt = generateCaptcha(captchaLength);  
        System.out.println("CAPTCHA: " + capt);  
    }  
} 





