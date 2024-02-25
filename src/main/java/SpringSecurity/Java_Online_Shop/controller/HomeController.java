package SpringSecurity.Java_Online_Shop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/steam")
public class HomeController {
    @GetMapping(value = "/")
    public String homePage() {
        return "home";
    }

    @GetMapping(value = "/sign_in")
    public String signInPage() {
        return "sign_in";
    }

    @GetMapping(value = "/detailsProduct/{id}")
    public String detailsProductPage(@PathVariable(name = "id") Long id,
                                     Model model) {
        model.addAttribute("product_id", id);
        return "detailsProduct";
    }

    @GetMapping(value = "/register")
    public String registerPage() {
        return "register";
    }


}
