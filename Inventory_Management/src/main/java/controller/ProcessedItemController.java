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

import dao.IssueProcessedItemDao;
import dao.ProcessedItemDao;
import model.IssueProcessedItem;
import model.ProcessedItem;

@Controller
public class ProcessedItemController {

	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	ProcessedItemDao processedItemDao = (ProcessedItemDao) context.getBean("processedItemDao");
	IssueProcessedItemDao issueProcessedItemDao = (IssueProcessedItemDao) context.getBean("issueProcessedItemDao");

	@RequestMapping(path = "/addProcessed")
	public String addProcessed() {
		return "addProcessedItemForm";
	}

	@RequestMapping(path = "/AddProcessedItem")
	public RedirectView addItem(@ModelAttribute ProcessedItem processedItem, HttpServletRequest request) {
		try {
			processedItemDao.insert(processedItem);
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl(request.getContextPath() + "/viewProcessed");
			return redirectView;
		} catch (Exception e) {

			RedirectView redirectView = new RedirectView();
			redirectView.setUrl(request.getContextPath() + "/error");
			return redirectView;
		}
	}

	@RequestMapping(path = "/viewProcessed")
	public String viewRawPage(Model mo) {
		List<ProcessedItem> processedItem = processedItemDao.getAllProcessedItems();
		mo.addAttribute("processedItem", processedItem);
		return "viewProcessed";
	}

	@RequestMapping(path = "/deleteprocessed/{id}", method = RequestMethod.GET)
	public RedirectView deleteRaw(@PathVariable("id") int id, HttpServletRequest request) {

		processedItemDao.deleteProcessedItem(id);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/viewProcessed");
		return redirectView;
	}

	@RequestMapping(path = "/issueProcessed")
	public String IssueProcessed() {
		return "issueProcessedForm";
	}

	@RequestMapping(path = "/issueProcessedItem")
	public RedirectView issueProcessed(@ModelAttribute IssueProcessedItem issueprocessedItem,
			HttpServletRequest request) {
		try {
			int quan = issueprocessedItem.getQuantity();
			int id = issueprocessedItem.getItemId();
			ProcessedItem ps1 = processedItemDao.getProcessedItem(id);
			if (ps1.getQuantity() - quan >= 0) {

				ps1.setQuantity(ps1.getQuantity() - quan);
				processedItemDao.updateProcessedItem(ps1);
				issueProcessedItemDao.insert(issueprocessedItem);
				RedirectView redirectView = new RedirectView();
				redirectView.setUrl(request.getContextPath() + "/viewLogProcessed");
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

	@RequestMapping(path = "/viewLogProcessed")
	public String viewProcessedLog(Model mo) {
		List<IssueProcessedItem> issueProcessedItem = issueProcessedItemDao.getAllIssueProcessedItems();
		mo.addAttribute("IssueProcessedItem", issueProcessedItem);
		return "viewProcessedLog";
	}

	@RequestMapping(value = "/updateprocessedquan", method = RequestMethod.GET)
	public String update(@RequestParam int id, Model m) {

		m.addAttribute("id", id);
		return "updateQuanProcessed";
	}

	@RequestMapping("/updateProcessedQuan")
	public RedirectView updateQuanProcessed(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		int newQuan = Integer.parseInt(request.getParameter("quan"));
		if (newQuan > 0) {
			ProcessedItem pi = processedItemDao.getProcessedItem(id);
			pi.setQuantity(pi.getQuantity() + (newQuan));
			processedItemDao.updateProcessedItem(pi);
		}
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/viewProcessed");
		return redirectView;
	}

}
