package com.huy.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.huy.service.CatalogService;
import com.huy.service.PageProductService;
import com.huy.service.ProductService;
import com.huy.model.Catalog;
import com.huy.model.Product;

import com.huy.model.CatagoryOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class ProductControler {
	@Autowired
	CatalogService catalogService;
	@Autowired
	ProductService productService;

	@Autowired
	PageProductService pageProductService;
	
	@RequestMapping(value ={"/home","/"}, method = RequestMethod.GET)
	public String home(Model model,Authentication authentication) {
		model.addAttribute("catagoryOption",new CatagoryOptions());
		List<Catalog> listCa = new ArrayList<Catalog>();
		listCa = catalogService.getCatalog();
		model.addAttribute("catalogs",listCa);
		
		model.addAttribute("logedUsername",authentication.getName());
		
		List<Product> topProducts= productService.getTopProduct();
		List<Product> onSaleProducts= productService.getOnSaleProduct();
		
		model.addAttribute("topProducts", topProducts);
		model.addAttribute("onSaleProducts", onSaleProducts);
		return "home";
	}
	
	@RequestMapping(value="/catagory/{id}", method = RequestMethod.GET)
    public String getCatagory (@PathVariable String id,Model model,
    		 @RequestParam("page") Optional<Integer> page, 
    	      @RequestParam("size") Optional<Integer> size,
    	      @RequestParam("search") Optional<String> searchValue,
    	      @RequestParam("option") Optional<String> cataOption,
    	      Authentication authentication) {
		
    	List<Catalog> listCa = new ArrayList<Catalog>();
    	listCa = catalogService.getCatalog();
    	model.addAttribute("catalogs",listCa);
//    	model.addAttribute("logedUsername",authentication.getName());
    	
    	List<Product> listPro = new ArrayList<Product>();
    	if(!searchValue.isPresent()) {
			listPro = productService.getProductByCatalogId(id);
			model.addAttribute("pageTitle",catalogService.getCatalogById(id).getCata_name());
			
			model.addAttribute("catagory",catalogService.getCatalogById(id));
			pageProductService.setProductList(id);
			model.addAttribute("isSearchPage",false);
    	}else {
    		Product searchProduct = new Product();
    		searchProduct.setP_name(searchValue.get());
    		searchProduct.setCatalog_id(cataOption.get());
    		
    		System.out.println(searchProduct);
    		listPro = productService.searchProByName(searchProduct);
    		model.addAttribute("pageTitle","Found "+listPro.size()
    		+" products"+" with catagory: "
    		+catalogService.getCatalogById(cataOption.get()).getCata_name()+", with key: \""+searchValue.get()+"\" !");
    		pageProductService.setProductSearchList(listPro);
    		model.addAttribute("isSearchPage",true);
    		model.addAttribute("search",searchValue.get());
    		model.addAttribute("option",cataOption.get());
    	}
    	model.addAttribute("products",listPro);
    	
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(3);
		
			
	
		Page<Product> productPage = pageProductService.findPaginated(PageRequest.of(currentPage - 1
				, pageSize));
		model.addAttribute("productPage", productPage);
        
        
        int totalPages = productPage.getTotalPages();
  
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);

        }
        
        return "catagory";
    }
    @RequestMapping(value="/detail/{id}", method = RequestMethod.GET)
    public String getDetail (@PathVariable String id,Model model,Authentication authentication) {
    	model.addAttribute("catagory",catalogService.getCatalogById(id));
    	List<Catalog> listCa = new ArrayList<Catalog>();
    	listCa = catalogService.getCatalog();
    	model.addAttribute("catalogs",listCa);
    	model.addAttribute("logedUsername",authentication.getName());
    	Product detailProduct = productService.getDetailProduct(id);
    	model.addAttribute("detailProduct",detailProduct);
        return "detail";
    }
    @RequestMapping(value="/cart", method = RequestMethod.GET)
    public String getCart(Model model) {
    	List<Catalog> listCa = new ArrayList<Catalog>();
    	listCa = catalogService.getCatalog();
    	model.addAttribute("catalogs",listCa);
    	model.addAttribute("pageTitle","All item in your Cart");
    	return "cart";
    }

}
