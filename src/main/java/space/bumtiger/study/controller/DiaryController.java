package space.bumtiger.study.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import space.bumtiger.study.domain.Diary;
import space.bumtiger.study.service.DiaryService;

@Controller
@RequestMapping("diary")
public class DiaryController {
	@Autowired
	private DiaryService diaryService;

	@PostMapping("save")
	public String saveDiary(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String title = request.getParameter("title");
		String studyDate = request.getParameter("studyDate");
		String content = request.getParameter("content");
		Diary diary = new Diary(title, content, studyDate);
		diaryService.save(diary);
		return "redirect:listing";
	}

	@GetMapping("listing")
	public String diaryListing(Model model) {
		List<Diary> diaries = diaryService.listing();
		model.addAttribute("diaries", diaries);
		return "listing";
	}
	
	@GetMapping("read")
	public String readDiary(HttpServletRequest request, Model model) {
		String sno = request.getParameter("sno");
		model.addAttribute("diary", diaryService.readDiary(sno));
		return "diary";
	}

	@GetMapping("write")
	public String writeDiary() {
		return "diary";
	}

}
