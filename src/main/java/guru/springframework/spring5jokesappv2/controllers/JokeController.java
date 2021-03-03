package guru.springframework.spring5jokesappv2.controllers;

import guru.springframework.spring5jokesappv2.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


//SPRING MVC CONTROLLER managed by spring
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
     * NOTE: When using controller interfaces (e.g. for AOP proxying), make sure to
     * consistently put all your mapping annotations - such as @RequestMapping and
     * @SessionAttributes - on the controller interface rather than on the implementation class.
     *
     * value = -- is optional
     */
    @RequestMapping(value = {"/joke", "/", " ", "/another-path"})
    public String showJoke(Model model) {
        model.addAttribute("joke", jokeService.getJoke());
        return "index";
    }
}