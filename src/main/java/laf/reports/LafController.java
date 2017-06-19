package laf.reports;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LafController {
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@RequestMapping(value="/addnewclient",method=RequestMethod.POST)
	public String clientsAdd(@RequestParam String clientId, @RequestParam String clientName, @RequestParam String clientContactPersonName, @RequestParam String clientPhone, @RequestParam String clientEmail, Model model, RedirectAttributes redirectAttrs) {
        Client newClient = new Client();
        Client temp = clientRepository.findOne(clientId);
        
        if(temp == null) {
        	newClient.setClientId(clientId);
        	newClient.setClientName(clientName);        	
        	newClient.setClientContactPersonName(clientContactPersonName);
        	newClient.setClientPhone(clientPhone);
        	newClient.setClientEmail(clientEmail);
        	
        	
        	clientRepository.save(newClient);
        	List<Department> departments = new ArrayList<Department>();
        	redirectAttrs.addFlashAttribute("departments", departments);
        	model.addAttribute("client", clientRepository.findOne(newClient.getClientId()));  	
            redirectAttrs.addAttribute("clientId", newClient.getClientId());
            redirectAttrs.addFlashAttribute("message", "Client Added Successfully!");
            redirectAttrs.addFlashAttribute("client", clientRepository.findOne(newClient.getClientId()));       	
            return "redirect:/client";
        }
        else {        	
        	String message = "The Client already exists. Please verify if the Client Id is new!";
        	redirectAttrs.addFlashAttribute("message", message);
        	return "redirect:/clients";
        }
	}
	
	@RequestMapping(value="/searchbyid",method=RequestMethod.GET)
	public String searchById(@RequestParam String clientId, Model model, RedirectAttributes redirectAttrs) {
		Client temp = clientRepository.findOne(clientId);
		
		if(temp != null) {
			model.addAttribute("client", temp);  	
            redirectAttrs.addAttribute("clientId", clientId);
            redirectAttrs.addFlashAttribute("message", "Client Found!");
            redirectAttrs.addFlashAttribute("client", temp);
            List<Department> departments = new ArrayList<Department>();
        	redirectAttrs.addFlashAttribute("departments", departments);
            return "redirect:/client";
		}
		else {        	
        	String message = "Client Not Found!";
        	redirectAttrs.addFlashAttribute("message", message);
        	return "redirect:/clients";
        }
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/addnewdepartment/{clientId}",method=RequestMethod.POST)
	public String addDepartment(@PathVariable String clientId, @RequestParam String departmentName, @RequestParam String departmentLocation, @RequestParam String labManager, @RequestParam String departmentAddress, Model model, RedirectAttributes redirectAttrs) {
		Department newDept = new Department();
		DepartmentId deptId = new DepartmentId(departmentName, departmentLocation);
		newDept.setDepartmentId(deptId);		
		newDept.setLabManager(labManager);
		newDept.setDepartmentAddress(departmentAddress);
		
		Client theClient = clientRepository.findOne(clientId);
		newDept.setClient(theClient);
		
		if(theClient != null) {
			Department temp = departmentRepository.findOne(deptId);
			if(temp == null) {
				theClient.getDepartments().add(newDept);
				departmentRepository.save(newDept);
				clientRepository.save(theClient);					
				model.addAttribute("client", clientRepository.findOne(theClient.getClientId()));  	
	            redirectAttrs.addAttribute("clientId", theClient.getClientId());
	            redirectAttrs.addFlashAttribute("message", "Department Added Successfully!");
	            redirectAttrs.addFlashAttribute("client", clientRepository.findOne(theClient.getClientId()));
	            List<Department> departments = new ArrayList<Department>();
	            departments = (List<Department>) departmentRepository.findAll();
	            redirectAttrs.addFlashAttribute("departments", departments);
	            return "redirect:/client";
			}
			else {
				redirectAttrs.addAttribute("clientId", theClient.getClientId());
	            redirectAttrs.addFlashAttribute("message", "Couldn't add Department. Department already exists!");
	            redirectAttrs.addFlashAttribute("client", clientRepository.findOne(theClient.getClientId()));
	            List<Department> departments = new ArrayList<Department>();
	            departments = (List<Department>) departmentRepository.findAll();
	            redirectAttrs.addFlashAttribute("departments", departments);
	            return "redirect:/client";
			}
		
		}
		else {        	
        	String message = "Client Not Found!";
        	redirectAttrs.addFlashAttribute("message", message);
        	return "redirect:/clients";
        }
		
	}
	
	@RequestMapping(value="/department/{departmentId}",method=RequestMethod.GET)
	public String department(@PathVariable String departmentId, Model model, RedirectAttributes redirectAttrs) {
		String [] ids = departmentId.split("\\*");
		DepartmentId id = new DepartmentId(ids[0], ids[1]);
		Department thisDept = departmentRepository.findOne(id);
		model.addAttribute(thisDept);
		redirectAttrs.addFlashAttribute("department", thisDept);
		return "redirect:/department";		
	}	
		
	@RequestMapping(value="/client",method=RequestMethod.GET)
	public String client(@ModelAttribute("client") Client theClient, @ModelAttribute("departments") List<Department> departments, @ModelAttribute("message") String message, Model model, RedirectAttributes redirectAttrs) {			
		model.addAttribute("client", clientRepository.findOne(theClient.getClientId()));
		departments = (List<Department>) departmentRepository.findAll();
		model.addAttribute("departments", departments);
		model.addAttribute(message);
		return "client";	
	}
	
	@RequestMapping(value="/updatedepartment/{departmentId}",method=RequestMethod.POST)
	public String updateDepartment(@PathVariable String departmentId, @RequestParam String labManager, @RequestParam String departmentAddress, Model model, RedirectAttributes redirectAttrs) {
		String [] ids = departmentId.split("\\*");
		DepartmentId id = new DepartmentId(ids[0], ids[1]);
		Department theDept = departmentRepository.findOne(id);
		if(theDept != null) {
			theDept.setLabManager(labManager);
			theDept.setDepartmentAddress(departmentAddress);
			departmentRepository.save(theDept);
		
			redirectAttrs.addAttribute("clientId", theDept.getClient().getClientId());
			redirectAttrs.addFlashAttribute("message", "Department Information updated.");
			redirectAttrs.addFlashAttribute("client", clientRepository.findOne(theDept.getClient().getClientId()));
			List<Department> departments = new ArrayList<Department>();
			departments = (List<Department>) departmentRepository.findAll();
			redirectAttrs.addFlashAttribute("departments", departments);
			return "redirect:/client";
		}
		else {        	
			String message = "Department Not Found!";
        	redirectAttrs.addFlashAttribute("message", message);
        	return "redirect:/clients";
        }
	}
	
	@RequestMapping(value="/department",method=RequestMethod.GET)
	public String client(@ModelAttribute("department") Department theDept, Model model, RedirectAttributes redirectAttrs) {			
		model.addAttribute("department", departmentRepository.findOne(theDept.getDepartmentId()));			
		return "department";	
	}
	
}
