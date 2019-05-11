package controller;

import cart.Cart;
import entity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.BooksService;
import service.ClientsService;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
public class BooksController {

    @Autowired
    BooksService booksService;

    @Autowired
    ClientsService clientsService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView search(@RequestParam String bookName){
        List<Books> bookList = booksService.getBooksByFilter(bookName,0, Double.MAX_VALUE, 0, 0);
        return new ModelAndView("home", "bookList", bookList);
    }

    @RequestMapping(value = "/addToCart", method = RequestMethod.GET)
    public ModelAndView addToCart(@RequestParam int id, Principal principal, HttpServletRequest request) {
        String username = principal.getName();
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            request.getSession().setAttribute("cart", new Cart());
            cart = (Cart) request.getSession().getAttribute("cart");
        }
        Map<Books, Integer> itemMap = cart.getItemMap();
        Books book = booksService.get(id);
        if (itemMap.containsKey(book)) {
            itemMap.replace(book, itemMap.get(book) + 1);
        } else {
            itemMap.put(booksService.get(id), 1);
        }
        return new ModelAndView("forward:/");
    }

//    @RequestMapping(value = "/search", method = RequestMethod.GET)
//    public String searchGet() {
//        return "";
//    }
}
