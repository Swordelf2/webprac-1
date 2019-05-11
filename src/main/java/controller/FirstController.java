package controller;

import entity.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.BooksService;
import service.ClientsService;

import java.util.List;

@Controller
public class FirstController {

    @Autowired
    ClientsService clientsService;

    @Autowired
    BooksService booksService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public ModelAndView bookSearch(ModelAndView modelAndView) {
        modelAndView.setViewName("home");
        modelAndView.getModelMap().addAttribute("bookList", booksService.list());
        modelAndView.getModelMap().addAttribute("bookName");
        return modelAndView;
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listOfClients(){
        List<Clients> list = clientsService.list();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.getModelMap().addAttribute("list", list);
        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView createNewForm(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("updateForm");
        modelAndView.getModelMap().addAttribute("newClient", clientsService.get(id));
        return modelAndView;
    }


    @RequestMapping(value = "/submitUpdate", method = RequestMethod.POST)
    public ModelAndView updateAction(@ModelAttribute Clients newClient){
        clientsService.update(newClient);
        return new ModelAndView("redirect:list");
    }

    @RequestMapping(value = "/delete")
    public ModelAndView delete(@RequestParam int id){
        clientsService.delete(id);
        return new ModelAndView("redirect:list");
    }
}
