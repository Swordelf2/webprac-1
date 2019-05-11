package controller;

import entity.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.ClientsService;
import service.WorkersService;

@Controller
public class EnterController {

    @Autowired
    ClientsService clientsService;

    @Autowired
    WorkersService workersService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/error403", method = RequestMethod.GET)
    public String error403() {
        return "error403";
    }



    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView("registration");
        modelAndView.getModelMap().addAttribute("newUser", new Clients());
        return modelAndView;
    }

    @RequestMapping(value = "/submitNew", method = RequestMethod.POST)
    public ModelAndView registerClient(@ModelAttribute Clients newUser){
        ModelAndView modelAndView = new ModelAndView();
        if (clientsService.clientByLogin(newUser.getEmail()) != null
                || workersService.workerByLogin(newUser.getEmail()) != null) {
            modelAndView.setViewName("registration");
            modelAndView.getModelMap().addAttribute("invalid", true);
            modelAndView.getModelMap().addAttribute("newUser", new Clients());
        } else {
            modelAndView.setViewName("redirect:list");
            clientsService.add(newUser);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/submitNew", method = RequestMethod.GET)
    public String authGet() {
        return "redirect:";
    }

}
