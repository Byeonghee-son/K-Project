package com.airport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.airport.domain.Notice;
import com.airport.domain.User;
import com.airport.service.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	public NoticeService noticeService;
	
	@GetMapping("/getNoticeList")
	public String getNoticeList(@ModelAttribute("user") User user, Model model, Notice notice) {
		if (user.getId()==null)
			return "redirect:login";
		
		model.addAttribute("noticeList", noticeService.getNoticeList());
		return "getNoticeList";
	}
	
	@GetMapping("/getNotice")
	public String getNotice(@ModelAttribute("user") User user, Model model, Long num) {
		if (user.getId()==null)
			return "redirect:login";
		
		Notice notice = noticeService.getNotice(Notice.builder().num(num).build());
		model.addAttribute("notice", notice);
		return "getNotice";

	}
	
	@PostMapping("/insertNotice")
	public String insertNotice(@ModelAttribute("user") User user, Notice notice) {
		if (user.getId()==null)
			return "redirect:login";
		
		return "insertNotice";
	}
	
	@PutMapping("/updateNotice")
	public String updateNotice(@ModelAttribute("user") User user, Notice notice) {
		if (user.getId()==null)
			return "redirect:login";
		
		noticeService.updateNotice(notice);
		return "redirect:getNoticeList";
		
	}
	
	@DeleteMapping("/deleteNotice")
	public String deleteNotice(@ModelAttribute("user") User user, Notice notice) {
		if (user.getId()==null)
			return "redirect:login";
		
		noticeService.deleteNotice(notice);
		return "redirect:getNoticeList";
		
	}

}
