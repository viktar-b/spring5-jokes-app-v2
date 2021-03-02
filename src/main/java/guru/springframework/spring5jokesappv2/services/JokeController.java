package guru.springframework.spring5jokesappv2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


//SPRING MVC CONTROLLER
@Controller
public class JokeController {

    private final JokeService jokeService;

    /*
     * The following @Autowired annotation in not necessary since we have
     * a single constructor,however provided for clarity
     *
     * IoC will automatically inject the concrete class that implements jokeService interface
     * Priority can be defined by use of @Primary annotations
     */
    @Autowired
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    /* showJoke - the controller method.
     * This method is going to get invoked when we come into the
     * context that we have to request mapping
     *
     * RequestMapping is provided by the spring-boot-starter-web
     *
     * Model is part of the ui library,
     *
     *
     */
    @RequestMapping({"/", " "})
    public String showJoke(Model model) {
        model.addAttribute("joke", jokeService.getJoke());
        return "index";
    }
}
