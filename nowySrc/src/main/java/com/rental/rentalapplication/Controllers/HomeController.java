package com.rental.rentalapplication.Controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rental.rentalapplication.DTO.UserPersonDto;
import com.rental.rentalapplication.Models.Cart;
import com.rental.rentalapplication.Models.Category;
import com.rental.rentalapplication.Models.Device;
import com.rental.rentalapplication.Models.DeviceCart;
import com.rental.rentalapplication.Models.DeviceFavouriteList;
import com.rental.rentalapplication.Models.FavouriteList;
import com.rental.rentalapplication.Models.User;
import com.rental.rentalapplication.Repository.CartRepository;
import com.rental.rentalapplication.Repository.DeviceCartRepository;
import com.rental.rentalapplication.Repository.DeviceFavouriteListRepository;
import com.rental.rentalapplication.Repository.FavouriteListRepository;
import com.rental.rentalapplication.Services.CategoryManager;
import com.rental.rentalapplication.Services.DeviceManager;
import com.rental.rentalapplication.Services.UserManager;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/homePage")
public class HomeController {
	
	@Autowired
	CategoryManager categoryManager;
	
	@Autowired
	DeviceManager deviceManager;
	
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private FavouriteListRepository favouriteListRepo;
	
	@Autowired
	private DeviceFavouriteListRepository deviceFavouriteListRepo;
	
	@Autowired
	private DeviceCartRepository deviceCartRepo;
	
	@GetMapping("/show")
	public String showHomePage(Model model) {
		List<Category> categories=categoryManager.showCategory();
		List<Device> devices=deviceManager.showDevices();
		model.addAttribute("categories", categories);
		model.addAttribute("devices", devices);
		return "/homePage/home";
	}
	
	@GetMapping("/categories/audio")
	public String showCategoryAudio(Model model) {
		List<Device> devices=deviceManager.showDevices();
		model.addAttribute("devices", devices);
		return "/homePage/categories/audio/audio";
	}
	
	@GetMapping("/categories/camera")
	public String showCategoryCamera(Model model) {
		List<Device> devices=deviceManager.showDevices();
		model.addAttribute("devices", devices);
		return "/homePage/categories/camera/camera";
	}
	
	@GetMapping("/categories/headphone")
	public String showCategoryHeadphone(Model model) {
		List<Device> devices=deviceManager.showDevices();
		model.addAttribute("devices", devices);
		return "/homePage/categories/headphone/headphone";
	}
	
	@GetMapping("/categories/laptop")
	public String showCategoryLaptop(Model model) {
		List<Device> devices=deviceManager.showDevices();
		model.addAttribute("devices", devices);
		return "/homePage/categories/laptop/laptop";
	}
	@GetMapping("/categories/lighting")
	public String showCategoryLighting(Model model) {
		List<Device> devices=deviceManager.showDevices();
		model.addAttribute("devices", devices);
		return "/homePage/categories/lighting/lighting";
	}
	
	@GetMapping("/categories/microphone")
	public String showCategoryMicrophone(Model model) {
		List<Device> devices=deviceManager.showDevices();
		model.addAttribute("devices", devices);
		return "/homePage/categories/microphone/microphone";
	}
	@GetMapping("/categories/monitor")
	public String showCategoryMonitor(Model model) {
		List<Device> devices=deviceManager.showDevices();
		model.addAttribute("devices", devices);
		return "/homePage/categories/monitor/monitor";
	}
	
	@GetMapping("/categories/projector")
	public String showCategoryprojector(Model model) {
		List<Device> devices=deviceManager.showDevices();
		model.addAttribute("devices", devices);
		return "/homePage/categories/projector/projector";
	}
	@GetMapping("/categories/screen")
	public String showCategoryTScreen(Model model) {
		List<Device> devices=deviceManager.showDevices();
		model.addAttribute("devices", devices);
		return "/homePage/categories/screen/screen";
	}
	
	@GetMapping("/categories/tablet")
	public String showCategoryTablet(Model model) {
		List<Device> devices=deviceManager.showDevices();
		model.addAttribute("devices", devices);
		return "/homePage/categories/tablet/tablet";
	}
	@GetMapping("/categories/tv")
	public String showCategoryTv(Model model) {
		List<Device> devices=deviceManager.showDevices();
		model.addAttribute("devices", devices);
		return "/homePage/categories/tv/tv";
	}
	
	@GetMapping("/showDetails/{id}")
	public String showDetailsDevice(@PathVariable ("id") Integer id, Model model) {
		Device device=deviceManager.getDevice(id);
		model.addAttribute("device", device);
		return "homePage/deviceDetails";
	}
	
	@GetMapping("/login")
	public String showLoginForm() {
		return "login/login";
	}
	
	
	
	@GetMapping("/create")
	public String showCreateAccountPage(Model model) {
		model.addAttribute("userPersonDto", new UserPersonDto() );
		return "register/createAccount";
	}
	
	@PostMapping("/create")
	public String createAccount(@Valid @ModelAttribute UserPersonDto userPersonDto, BindingResult result){
		if(result.hasErrors()) {
			return "/register/createAccount";
		}
		userManager.addAccount(userPersonDto);
		return "redirect:/homePage/create";
	}
	
	@PostMapping("/addToCart/{id}")
	public String addToCart(@PathVariable Integer id) {
		User user=userManager.getUser(1);
		Cart cart =new Cart(user);
		Device device=deviceManager.getDevice(id);
		DeviceCart deviceCart= new DeviceCart(cart, device);
		cart.addDeviceCart(deviceCart);
		cartRepo.save(cart);
		return"redirect:/homePage/showDetails/{id}";
	}
	
	@PostMapping("/addToFavouriteList/{id}")
	public String addToFavouriteList(@PathVariable Integer id) {
		User user= userManager.getUser(2);
		FavouriteList favouriteList=new FavouriteList(user);
		Device device=deviceManager.getDevice(id);
		DeviceFavouriteList deviceFavouriteList=new DeviceFavouriteList(device,favouriteList);
		favouriteList.addDeviceFavouriteList(deviceFavouriteList);
		favouriteListRepo.save(favouriteList);
		return "redirect:/homePage/showDetails/{id}";
	}
	
	@GetMapping("/showCart")
	public String showCart(Model model) {
		Cart cart=cartRepo.findById(1).get();
		List<DeviceCart> devicesCarts= cart.getDeviceCart();
		model.addAttribute("devicesCarts", devicesCarts);
		return "cart/cart";
	}
	
	@GetMapping("/showFavouriteList")
	public String showFavouriteList(Model model) {
		FavouriteList favouriteList= favouriteListRepo.findById(1).get();
		List<DeviceFavouriteList> favouritesLists=favouriteList.getDeviceFavouriteLists();
		model.addAttribute("devicesFavouritesLists", favouritesLists);
		return "favouriteList/favouriteList";
	}
	
	@PostMapping("/deleteDevicefromFavouriteList/{id}")
	public String deleteDeviceFromFavouriteList(@PathVariable("id") Integer id) {
		DeviceFavouriteList deviceFavouriteList=deviceFavouriteListRepo.findById(id).get();
		deviceFavouriteListRepo.delete(deviceFavouriteList);
		return"redirect:/homePage/showFavouriteList";
	}
	
	@PostMapping("/deleteDeviceFromCart/{id}")
	public String deleteDeviceFromCart(@PathVariable("id") Integer id) {
		DeviceCart deviceCart=deviceCartRepo.findById(id).get();
		deviceCartRepo.delete(deviceCart);
		return"redirect:/homePage/showCart";
	}
	
}
