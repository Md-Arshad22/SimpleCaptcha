package com.Captcha.Captcha.RegistrationController;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Captcha.Captcha.CaptchaGenerator;

import jakarta.servlet.http.HttpSession;

/*import javax.servlet.http.HttpSession;*/

@Controller
public class RegistrationController {

    @GetMapping("/verify")
    public String showRegistrationForm(Model model, HttpSession session) {
        // Generate CAPTCHA
        String captcha = CaptchaGenerator.generateCaptcha(6);
        
        // Store CAPTCHA in session
        session.setAttribute("captcha", captcha);
        
        // Add CAPTCHA to model
        model.addAttribute("captcha", captcha);

        return "verifyCaptcha"; // Thymeleaf template name (register.html)
    }

    @PostMapping("/verifyCaptcha")
    public String register(@RequestParam("captcha") String enteredCaptcha, HttpSession session, Model model) {
        // Retrieve the CAPTCHA from session
        String sessionCaptcha = (String) session.getAttribute("captcha");

        
        // Verify CAPTCHA
        if (sessionCaptcha != null && sessionCaptcha.equals(enteredCaptcha)) {
            // CAPTCHA is correct, proceed with registration
            model.addAttribute("message", "Registration successful!");
            return "success"; // Thymeleaf template name for success page
        } else {
            // CAPTCHA is incorrect
            model.addAttribute("message", "CAPTCHA verification failed. Please try again.");
            return "verifyCaptcha"; // Redirect back to registration form
        }
    }
}