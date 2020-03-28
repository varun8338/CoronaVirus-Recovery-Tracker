package io.varun.coronavirustracker.controllers;

import java.awt.Taskbar.State;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.varun.coronavirustracker.models.LocationStats;
import io.varun.coronavirustracker.services.CoronaVirusDataService;

@Controller
public class HomeController {
	
	
	@Autowired
	CoronaVirusDataService coronaVirusDataService;
	
	@GetMapping("/")
	public String home(Model model)
	{
		
		List<LocationStats> allStats = coronaVirusDataService.getAllStats();
		int totalRecoveredCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
		int totalPreviousDay = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
		model.addAttribute("locationStats", allStats);
		model.addAttribute("totalReportedCases", totalRecoveredCases);
		model.addAttribute("totalPreviousDay", totalPreviousDay);
		return "home";
	}

}
