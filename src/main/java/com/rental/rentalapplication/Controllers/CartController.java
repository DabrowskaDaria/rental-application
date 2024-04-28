package com.rental.rentalapplication.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rental.rentalapplication.DTO.CartCostsDto;
import com.rental.rentalapplication.DTO.CartDataDto;
import com.rental.rentalapplication.DTO.CartMetodsDto;
import com.rental.rentalapplication.DTO.CartPersonCompanyDto;
import com.rental.rentalapplication.DTO.DeviceDto;
import com.rental.rentalapplication.Models.Cart;
import com.rental.rentalapplication.Models.Company;
import com.rental.rentalapplication.Models.Device;
import com.rental.rentalapplication.Models.DeviceCart;
import com.rental.rentalapplication.Models.MethodOfPayment;
import com.rental.rentalapplication.Models.MethodOfPaymentRepository;
import com.rental.rentalapplication.Models.MethodOfReception;
import com.rental.rentalapplication.Models.Person;
import com.rental.rentalapplication.Models.Rental;
import com.rental.rentalapplication.Models.RentalStatus;
import com.rental.rentalapplication.Models.User;
import com.rental.rentalapplication.Repository.CartRepository;
import com.rental.rentalapplication.Repository.CompanyRepository;
import com.rental.rentalapplication.Repository.DeviceCartRepository;
import com.rental.rentalapplication.Repository.MethodOfReceptionRepository;
import com.rental.rentalapplication.Repository.PersonRepository;
import com.rental.rentalapplication.Repository.RentalRepository;
import com.rental.rentalapplication.Services.DeviceManager;
import com.rental.rentalapplication.Services.UserManager;

@Controller
public class CartController {
	
	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private DeviceManager deviceManager;
	
	@Autowired
	private DeviceCartRepository deviceCartRepo;
	
	@Autowired
	private MethodOfReceptionRepository methodOfReceptionRepo;
	
	@Autowired
	private MethodOfPaymentRepository methodOfPaymentRepo;
	
	@Autowired
	private RentalRepository rentalRepo;
	
	@Autowired
	private PersonRepository personRepo;
	
	@Autowired
	private CompanyRepository companyRepo;
	
	@GetMapping("/showCart")
	public String showCart(Model model) {
		Cart cart=cartRepo.findById(1).get();
		List<DeviceCart> devicesCarts= cart.getDeviceCart();
		model.addAttribute("devicesCarts", devicesCarts);
		return "cart/cart";
	}
	
	@PostMapping("/addToCart/{id}")
	public String addToCart(@PathVariable Integer id) {
		User user=userManager.getUser(4);
		Cart cart =new Cart(user);
		Device device=deviceManager.getDevice(id);
		DeviceCart deviceCart= new DeviceCart(cart, device);
		cart.addDeviceCart(deviceCart);
		cartRepo.save(cart);
		return"redirect:/homePage/showDetails/{id}";
	}
	
	@PostMapping("/deleteDeviceFromCart/{id}")
	public String deleteDeviceFromCart(@PathVariable("id") Integer id) {
		DeviceCart deviceCart=deviceCartRepo.findById(id).get();
		deviceCartRepo.delete(deviceCart);
		return"redirect:/showCart";
	}
	
	@GetMapping("/showCartRentalForm")
	public String showCartRentalForm(Model model) {
		model.addAttribute("cartDataDto", new CartDataDto());
		return "cart/cartFirstStep";
	}
	
	@PostMapping("/addToDBFirstStep")
	public String addToDBFirstStep(@ModelAttribute CartDataDto cartDataDto) {
		RentalStatus rentalStatus= new RentalStatus();
		rentalStatus.setId(4);
		User user= new User();
		user.setId(2);
		Rental rental= new Rental(cartDataDto.getRentalStartDate(),cartDataDto.getRentalEndDate(),rentalStatus,user);
		rentalRepo.save(rental);
		return"redirect:/showCartSecondStepForm";
	}
	
	@GetMapping("/showCartSecondStepForm")
	public String showCartSecondStepForm(Model model) {
		List<MethodOfReception> methodsOfReception= methodOfReceptionRepo.findAll();
		List<MethodOfPayment> methodsOfPayment= methodOfPaymentRepo.findAll();
		model.addAttribute("methodsOfReception", methodsOfReception);
		model.addAttribute("methodsOfPayment", methodsOfPayment);
		model.addAttribute("cartMetodsDto", new CartMetodsDto());
		return "cart/cartSecondStep";
	}
	
	@PostMapping("/addToDBSecondStep")
	public String addToDbSecondStep(@ModelAttribute CartMetodsDto cartMetodsDto) {
		Rental rental= rentalRepo.findById(2).get();
		rental.setMethodOfReception(cartMetodsDto.getMethodsOfReception());
		rental.setMethodOfPayment(cartMetodsDto.getMethodsOfPayment());
		rentalRepo.save(rental);
		return "redirect:/showCartThirdStepForm";
	}
	
	@GetMapping("/showCartThirdStepForm")
	public String showCartThirdStepForm(Model model) {
		model.addAttribute("cartCostsDto", new CartCostsDto());
		model.addAttribute("device", new DeviceDto());
		return "cart/cartThirdStep";
	}
	
	@GetMapping("/showCartFourthStepForm")
	public String showCartFourthStepForm(Model model) {
		model.addAttribute("cartPersonCompanyDto", new CartPersonCompanyDto());
		return "cart/cartFourthStep";
	}
	@PostMapping("/addToDBFourthStep")
	public String addToDbFourthStep(@ModelAttribute CartPersonCompanyDto cartPersonCompanyDto) {
		if(cartPersonCompanyDto.getPeselNumber()!=null) {
		Person person=personRepo.findById(1).get();
		person.setFirstName(cartPersonCompanyDto.getFirstName());
		person.setSurname(cartPersonCompanyDto.getSurname());
		person.setPesel(cartPersonCompanyDto.getPeselNumber());
		person.setPhoneNumber(cartPersonCompanyDto.getPhoneNumber());
		person.setPlace(cartPersonCompanyDto.getPlace());
		person.setHouseNumber(cartPersonCompanyDto.getHouseNumber());
		person.setStreet(cartPersonCompanyDto.getStreet());
		person.setZipCode(cartPersonCompanyDto.getZipCode());
		personRepo.save(person);
		}else {
		Company company=new Company(cartPersonCompanyDto.getName(),cartPersonCompanyDto.getCompanyNumber(),cartPersonCompanyDto.getPlace(),cartPersonCompanyDto.getStreet(),cartPersonCompanyDto.getBuldingNumber(),cartPersonCompanyDto.getZipCode());
		companyRepo.save(company);}
		return "redirect:/showCartSummary";
	}
	
	@GetMapping("/showCartSummary")
	public String showCartSummary(Model model) {
		return "cart/summary";
	}
	
}
