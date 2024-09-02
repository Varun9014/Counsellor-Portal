package in.ashokit.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.dto.ViewEnqsFilterRequest;
import in.ashokit.entity.Enquiry;
import in.ashokit.service.EnquiryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EnquiryController {

	private EnquiryService enqService;

	// Correct constructor injection
	public EnquiryController(EnquiryService enqService) {
		this.enqService = enqService;
	}

	
	
	@PostMapping("/filter-enqs")
	public String filterEnquries(ViewEnqsFilterRequest viewEnqsFilterRequest,HttpServletRequest req,Model model)
	{
				// get existing session obj
				HttpSession session = req.getSession(false);
				Integer counsellorId = (Integer) session.getAttribute("counsellorId");
					
				List<Enquiry> enqsList = enqService.getEnquiresWithFilter(viewEnqsFilterRequest, counsellorId);
			
				model.addAttribute("enquiries",enqsList);
				
				return "viewEnqsPage";
				
	}

	@GetMapping("/view-enquiries")
	public String getEnquries(HttpServletRequest request, Model model) {
		
		// get existing session obj
		HttpSession session = request.getSession(false);
		Integer counsellorId = (Integer) session.getAttribute("counsellorId");
		
		List<Enquiry> enqList=enqService.getAllEnquiries(counsellorId);
		
		model.addAttribute("enquiries",enqList);
		
		// search form binding object
		ViewEnqsFilterRequest filterReq=new ViewEnqsFilterRequest();
		model.addAttribute("viewEnqsFilterRequest",filterReq);
	
		
		return "viewEnqsPage";
	}


	@GetMapping("/enquiry") // TO DISPLAY THE EMPTY ENQUIRY FORM
	public String addEnquiryPage(Model model) {
		Enquiry enquiry = new Enquiry();
		model.addAttribute("enquiry", enquiry);
		return "enquiryForm";
	}
	
	@PostMapping("/addEnq") // TO SAVE THE ENQUIRY
	public String handleAddEnquiry(Enquiry enquiry, HttpServletRequest req, Model model) throws Exception {
		// Get existing session obj
		HttpSession session = req.getSession(false);
		Integer counsellorId = (Integer) session.getAttribute("counsellorId");

		boolean isSaved = enqService.addEnquiry(enquiry, counsellorId);

		if (isSaved) {
			model.addAttribute("smsg", "Enquiry Added");
		} else {
			model.addAttribute("emsg", "Failed To Add Enquiry");
		}

		// THIS WILL WORK AS THE SAME AS LIKE <td> <a href="enquiry" class="btn
		// btn-info">Reset</a> </td>
		// IN ENQUIRYCONTROLLER
		enquiry = new Enquiry();
		model.addAttribute("enquiry", enquiry);

		return "enquiryForm";
	}
}
