package com.huy.controler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.huy.model.Cart;
import com.huy.model.Product;
import com.huy.model.UserPrincipal;
import com.huy.service.CartService;
import com.huy.service.ProductService;

@Controller
public class CartController {
	@Autowired
	CartService cartService;
	@Autowired
	ProductService productService;
	 @RequestMapping(value="/doOrder", method = RequestMethod.GET)
	 public String doOrder(Model model,HttpServletRequest request,Authentication authentication) {
		 	UserPrincipal user = (UserPrincipal) authentication.getPrincipal();
	    	String rawCookie = request.getHeader("Cookie");
	    	System.out.println(rawCookie);
	    	String[] cookies = rawCookie.split(";");
	    	for(String coo : cookies) {
	    		String[] aCookie = coo.split("=");
	    		if(aCookie[0].trim().equals("OrderItem")) {
	    			String[] products = aCookie[1].split(",");
	    			for(String pro:products) {
	    				String[] pro_details = pro.split("-");
	    				Cart cart = new Cart();
	    				cart.setCardId(user.getUsername()+"_cart");
	    				cart.setpId(pro_details[0]);
	    				cart.setUserOwn(user.getUsername());
	    				cartService.insertCart(cart);
	    			}
	    			
	    		}
	    	}
	    	return "redirect:cart";
	    }
	 @RequestMapping(value="/viewOrderHistory", method = RequestMethod.GET)
	 public String viewOrderHistory(Model model,Authentication authentication, RedirectAttributes ra) throws NullPointerException  {
		 UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
		 List<Cart> orderedCart = cartService.getOrderHistoryByUserName(userPrincipal.getUsername());
		 List<Product> productList = new ArrayList<Product>();
		 for(Cart cart: orderedCart) {
			 Product product = productService.getProductById(cart.getpId());
			 productList.add(product);
		 }
//		 for(Product pro: productList) {
//			 System.out.println(pro.toString());
//		 }
		 ra.addFlashAttribute("proList", productList);
		 return "redirect:information";
	 }


	 
}
