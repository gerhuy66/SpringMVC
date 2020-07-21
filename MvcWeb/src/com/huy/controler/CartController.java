package com.huy.controler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huy.model.Cart;
import com.huy.model.UserPrincipal;
import com.huy.service.CartService;

@Controller
public class CartController {
	@Autowired
	CartService cartService;
	
	 @RequestMapping(value="/doOrder", method = RequestMethod.GET)
	 public String doOrder(Model model,HttpServletRequest request,Authentication authentication) {
		 	UserPrincipal user = (UserPrincipal) authentication.getPrincipal();
	    	String rawCookie = request.getHeader("Cookie");
	    	String[] cookies = rawCookie.split(";");
	    	for(String coo : cookies) {
	    		String[] aCookie = coo.split("=");
	    		if(aCookie[0].equals("ItemInCart")) {
	    			String[] products = aCookie[0].split(",");
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
}
