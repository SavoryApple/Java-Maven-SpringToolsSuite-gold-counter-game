package com.seannavery.ninjagold;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class HomeController {
	
	static ArrayList<String> activityMessages = new ArrayList<String>();
	
    @RequestMapping("/")
    public String index(HttpSession session, Model model) {
    	if (session.getAttribute("totalGold") == null) {
    		session.setAttribute("totalGold", 0);
    	}
    	model.addAttribute("displayMessages", activityMessages);
        return "index.jsp";
    }
    
    @RequestMapping("/reset")
    public String reset(HttpSession session) {
    	System.out.println("Button being acessed");
    	session.setAttribute("totalGold", 0);
    	activityMessages.clear();
    	return "redirect:/";
    }
    
    @RequestMapping(value="/submitFarmCaveHouse", method=RequestMethod.POST)
    public String submitFarmCaveHouse(
    		HttpSession session, 
    		Model model,
    		@RequestParam(required=false, value="farm") Integer farm,
    		@RequestParam(required=false, value="cave") Integer cave,
    		@RequestParam(required=false, value="house") Integer house
    		){	
    	Random r = new Random();
    	int low = 10; //inclusive
    	int high = 21; //exclusive
    	int result = r.nextInt(high-low) + low;
    	Integer farmCaveHouseRandomGold =(Integer) result;
    	Integer farmCaveHouseGold = (Integer) session.getAttribute("totalGold") + farmCaveHouseRandomGold;
		session.setAttribute("totalGold", farmCaveHouseGold);
		model.addAttribute("totalGold", farmCaveHouseGold);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM d HH:mma");  
		LocalDateTime now = LocalDateTime.now(); 
		if(farm != null) {
			System.out.println("You entered a farm and found "+farmCaveHouseRandomGold+" gold ("+dtf.format(now)+")");
			activityMessages.add("You entered a farm and found "+farmCaveHouseRandomGold+" gold ("+dtf.format(now)+")");
		}
		if(cave != null) {
			activityMessages.add("You entered a cave and found "+farmCaveHouseRandomGold+" gold ("+dtf.format(now)+")"); 
		}
		if(house != null) {
			activityMessages.add("You entered a house and found "+farmCaveHouseRandomGold+" gold ("+dtf.format(now)+")"); 
		}
        return "redirect:/";
    }
    
    @RequestMapping(value="/submitQuest", method=RequestMethod.POST)
    public String submitQuest(
    		HttpSession session, 
    		Model model
    		){	
    	Random r = new Random();
    	int low = 1; //inclusive
    	int high = 3; //exclusive
    	int coinToss = r.nextInt(high-low) + low;
    	if(coinToss == 1) {
    		Random r2 = new Random();
        	int low2 = 0; //inclusive
        	int high2 = 51; //exclusive
        	int randomNum = r2.nextInt(high2-low2) + low2;
    		Integer questRandomGold = (Integer) randomNum;
    		Integer questGold = (Integer) session.getAttribute("totalGold") - questRandomGold;
    		session.setAttribute("totalGold", questGold);
    		model.addAttribute("totalGold", questGold);
    		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM d HH:mma");  
    		LocalDateTime now = LocalDateTime.now();  
    		activityMessages.add("You attempted a quest and LOST "+questRandomGold+" gold ("+dtf.format(now)+")"); 
    	}
    	else if(coinToss == 2) {
    		Random r3 = new Random();
        	int low3 = 0; //inclusive
        	int high3 = 51; //exclusive
        	int randomNum2 = r3.nextInt(high3-low3) + low3;
    		Integer questRandomGold = (Integer) randomNum2;
    		Integer questGold = (Integer) session.getAttribute("totalGold") + questRandomGold;
    		session.setAttribute("totalGold", questGold);
    		model.addAttribute("totalGold", questGold);
    		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM d HH:mma");  
    		LocalDateTime now = LocalDateTime.now();  
    		activityMessages.add("You attempted a quest and GAINED "+questRandomGold+" gold ("+dtf.format(now)+")"); 
    	}
        return "redirect:/";
    }
 
}