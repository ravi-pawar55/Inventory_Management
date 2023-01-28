package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import dao.IssueRawMaterialDao;
import dao.RawMaterialDao;
import model.IssueRawMaterial;
import model.RawMaterial;

@Controller
public class RawMaterialController {

	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	RawMaterialDao rawMaterialDao = (RawMaterialDao) context.getBean("rawMaterialDao");
	IssueRawMaterialDao issueRawMaterialDao = (IssueRawMaterialDao) context.getBean("issueRawMaterialDao");

	@RequestMapping(path = "/addRawMaterial")
	public String viewRawPage() {
		return "addRawMaterialDash";
	}

	@RequestMapping(path = "/AddRawMaterial")
	public RedirectView addMaterial(@ModelAttribute RawMaterial rawMaterial, HttpServletRequest request) {

		try {
			rawMaterialDao.insert(rawMaterial);
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl(request.getContextPath() + "/viewRaw");
			return redirectView;
		} catch (Exception e) {

			RedirectView redirectView = new RedirectView();
			redirectView.setUrl(request.getContextPath() + "/error");
			return redirectView;
		}
	}

	@RequestMapping(path = "/viewRaw")
	public String viewRawPage(Model m) {
		List<RawMaterial> rawMaterial = rawMaterialDao.getAllRawMaterials();
		m.addAttribute("rawMaterial", rawMaterial);
		return "viewRaw";
	}

	@RequestMapping(path = "/deleteraw/{id}", method = RequestMethod.GET)
	public RedirectView deleteRaw(@PathVariable("id") int id, HttpServletRequest request) {

		rawMaterialDao.deleteRawMaterial(id);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/viewRaw");
		return redirectView;
	}

	@RequestMapping(path = "issueRaw")
	public String issueRaw() {
		return "issueRawForm";
	}

	@RequestMapping(path = "/issueRawMaterial")
	public RedirectView issueRawForm(@ModelAttribute IssueRawMaterial issuerawMaterial, HttpServletRequest request) {
		try {
			int quan = issuerawMaterial.getQuantity();
			int id = issuerawMaterial.getItemId();
			RawMaterial rm = rawMaterialDao.getRawMaterial(id);
			if (rm.getQuantity() - quan >= 0) {
				// ProcessedItem ps2 = processedItemDao.getProcessedItem(id);
				rm.setQuantity(rm.getQuantity() - quan);
				rawMaterialDao.updateRawMaterial(rm);
				issueRawMaterialDao.insert(issuerawMaterial);
				RedirectView redirectView = new RedirectView();
				redirectView.setUrl(request.getContextPath() + "/viewRawLog");
				return redirectView;
			} else {
				RedirectView redirectView = new RedirectView();
				redirectView.setUrl(request.getContextPath() + "/insufficientQuan");
				return redirectView;
			}
		} catch (Exception e) {

			RedirectView redirectView = new RedirectView();
			redirectView.setUrl(request.getContextPath() + "/error");
			return redirectView;
		}
	}

	@RequestMapping(path = "/viewRawLog")
	public String rawLogPage(Model md) {
		List<IssueRawMaterial> issueRawMaterial = issueRawMaterialDao.getAllIssueRawMaterials();
		md.addAttribute("issueRawMaterial", issueRawMaterial);
		return "viewRawLogs";
	}

	@RequestMapping(value = "/updaterawquan", method = RequestMethod.GET)
	public String update(@RequestParam int id, Model m) {

		m.addAttribute("id", id);
		return "updateQuan";
	}

	@RequestMapping("/updateRawQuan")
	public RedirectView updateQuan(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		int newQuan = Integer.parseInt(request.getParameter("quan"));
		if (newQuan > 0) {
			RawMaterial oldrawmaterial = rawMaterialDao.getRawMaterial(id);
			oldrawmaterial.setQuantity(oldrawmaterial.getQuantity() + (newQuan));
			rawMaterialDao.updateRawMaterial(oldrawmaterial);
		}

		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/viewRaw");
		return redirectView;
	}

}
