package com.adl.hellospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adl.hellospring.model.Profile;
import com.adl.hellospring.model.Resume;
import com.adl.hellospring.model.Skill;
import com.adl.hellospring.repository.ProfileRepository;
import com.adl.hellospring.repository.ResumeRepository;
import com.adl.hellospring.repository.SkillRepository;

@Controller
public class MainController {
	@Autowired
	private ProfileRepository profileRepo;
	@Autowired
	private SkillRepository skillRepo;
	@Autowired
	private ResumeRepository resumeRepo;
	
	@GetMapping("/")
	public String helloWorld(Model model) {
		Profile profile = profileRepo.findById(1).get();
		List<Skill> listSkill = skillRepo.findAll();
		List<Resume> listResumeEducation = resumeRepo.findByTipe("education");
		List<Resume> listResumeEmployment = resumeRepo.findByTipe("employment");
		model.addAttribute("profile", profile);
		model.addAttribute("skills", listSkill);
		model.addAttribute("resumeEducation", listResumeEducation);
		model.addAttribute("resumeEmployment", listResumeEmployment);
		return "dora";
	}
	
	@GetMapping("/insert")
	@ResponseBody
	public String setData() {
		Resume resume = new Resume();
		resume.setJudul("SD Keren Punya");
		resume.setTahun("2000-2020");
		resume.setKeterangan("Ga tau gelap");
		resume.setTipe("education");
		
		resumeRepo.save(resume);
		return "Masuk Pak Eko~";
	}
}
