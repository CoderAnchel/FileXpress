package org.magiceagle.filexpress.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "localhost:3000")
public class mainController {

    @GetMapping("/app/welcome")
    public String welcome() {
        return "Welcome to FileXpress!";
    }
}
