package com.niit.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale.Category;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.model.Product;
import com.niit.service.CategoryService;
import com.niit.service.ProductService;


@Controller
public class ProductController 
{
	@Autowired
	private ProductService productService;;
	
	@Autowired CategoryService categoryService;
	
	@RequestMapping("/admin/product/productform")
	public String showPage(@ModelAttribute(value="product") Product product,BindingResult bindingResult,Model model)
	{
		model.addAttribute("productList", productService.getAllProducts());
		return "productform";
	}	
	
	
	
	
	/*@RequestMapping("admin/product/productform")
	public String getProductForm(Model model)
	{
		model.addAttribute("product",new Product());
		model.addAttribute("categoryList", categoryService.getAllCategorys());
		return "productform";
	}	*/
	
/*	=======================saving product Object=====================================*/
	@RequestMapping("admin/product/saveproduct")
	public String saveOrUpdateProduct(@Valid @ModelAttribute(value="product") Product product,BindingResult result,RedirectAttributes attributes)
	{
		if(result.hasErrors())
		{
			System.out.println("HAS ERRORS");
			return "productform";
		}
		System.out.println("After validation");
		productService.saveOrUpdateProduct(product);
		MultipartFile image=product.getImage();
		if(image!=null && !image.isEmpty())
		{
			Path path=Paths.get("F:/workspace/DTProject1/src/main/webapp/WEB-INF/resources/images/"+product.getId()+".png");
			try 
			{
				image.transferTo(new File(path.toString()));
			} 
			catch (IllegalStateException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		return "redirect:/all/product/productlist";
	}
	
	
	/*	=======================Listing product Object=====================================*/
	
	@RequestMapping("/all/product/productlist")
	public String getAllProducts(Model model)
	{
		List<Product> products=productService.getAllProducts();
		for(Product p:products)
		{
			System.out.println(p.getName());
			System.out.println(p.getPrice());
		}
		model.addAttribute("products",products);
		model.addAttribute("categoryList", categoryService.getAllCategorys());
	
		return "productlist";
	}
	
	/*	=======================Listing Individual product Object=====================================*/
	@RequestMapping("/all/product/viewproduct/{id}")
	public String viewProduct(@PathVariable int id,Model model)
	{
		Product product=productService.getProductById(id);
		model.addAttribute("product",product);
		return "viewproduct";
	}
	
/* ================================Edit Individual product object======================================= */
	
	@RequestMapping("/admin/product/editproduct/{id}")
	public String editProduct(@PathVariable int id, Model model)
	{
		Product product=productService.getProductById(id);
		model.addAttribute("product", product);
		List<com.niit.model.Category> categoryList=categoryService.getAllCategorys();
		model.addAttribute("categoryList", categoryList);
		return "productform";
	}
	
	/*	=======================Deleting Individual product Object=====================================*/
	@RequestMapping("/admin/product/deleteproduct/{id}")
	public String deleteProduct(@PathVariable int id)
	{
		productService.deleteProduct(id);
		return "redirect:/all/product/productlist";
	}
	@RequestMapping("/all/product/productsByCategory")
	public String getProductsByCategory(@RequestParam(name="searchCondition") String searchCondition,
			Model model,HttpSession session){
	        session.setAttribute("categories",categoryService.getAllCategorys());
		List<Product> products=productService.getAllProducts();
		//Assigning list of products to model attribute products
		model.addAttribute("products",products);
		model.addAttribute("searchCondition",searchCondition);
		return "productlist";
	}
	
}