package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.ProcessedItemDao;
import dao.RawMaterialDao;
import model.ProcessedItem;
import model.RawMaterial;

@Controller
public class HomeController {

	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	RawMaterialDao rawMaterialDao = (RawMaterialDao) context.getBean("rawMaterialDao");
	ProcessedItemDao processedItemDao = (ProcessedItemDao) context.getBean("processedItemDao");

	@RequestMapping("/")
	public String home() {
		return "index";
	}

	@RequestMapping("/index")
	public String logout() {
		return "index";
	}

	@RequestMapping("/login")
	public String about(HttpServletRequest request) {

		String email = "admin@gmail.com";
		String pwd = "admin1234";

		if (email.equals(request.getParameter("email")) && pwd.equals(request.getParameter("pwd")))
			return "dashboard";
		else
			return "index";

	}

	@RequestMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}

	@RequestMapping("/error")
	public String error() {
		return "error";
	}

	@RequestMapping("/insufficientQuan")
	public String insufficientQuan() {
		return "insufficientQuan";
	}

	@RequestMapping(path = "/unavailable")
	public String viewRawPage(Model m, Model mo) {
		List<RawMaterial> rawMaterial = rawMaterialDao.getAllRawMaterials();
		m.addAttribute("rawMaterial", rawMaterial);

		List<ProcessedItem> processedItem = processedItemDao.getAllProcessedItems();
		mo.addAttribute("processedItem", processedItem);

		return "unavailable";

	}
}
