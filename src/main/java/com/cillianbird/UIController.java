package com.cillianbird;

import java.util.Properties;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UIController {
	private static final Logger log = Logger.getLogger(UIController.class);

	private static final String HOME = "home";
	private static final String PAGE = "page";
	private static final String TITLE = "title";
	
	// Property source
	@Resource(name = "messageSource")
	MessageSource messageSource;
	
	@Autowired
	Properties props;
	
	private static final String[] MESSAGES = {"addicted", "likes", "loves", "obsessed", "toomuch"};
	
	@RequestMapping(value = "/")
	public ModelAndView root() {
        Random r = new Random();
        int randomNumber=r.nextInt(MESSAGES.length);
        String msg = MESSAGES[randomNumber];
        
		ModelAndView mav = setView(HOME, messageSource.getMessage("index.title", null, null));
		mav.addObject("msg", msg);
		return mav;
	}
	
	@RequestMapping(value = "/index.html")
	public ModelAndView home() {
		return setView(HOME, messageSource.getMessage("index.title", null, null));
	}
	
	private ModelAndView setView(String pageName, String title) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName(pageName);
		mav.addObject(PAGE, pageName);
		mav.addObject(TITLE, title);

		log.debug("Setting view: " + pageName);
		
		return mav;
	}
}
