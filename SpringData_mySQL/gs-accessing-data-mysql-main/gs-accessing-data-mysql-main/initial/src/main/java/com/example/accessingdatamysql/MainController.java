package com.example.accessingdatamysql;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(path="/friend")
public class MainController {
	
	@Autowired
	private FriendRepository friendRepository;
	
	@PostMapping("/add")
	public @ResponseBody String addNewFriend (@RequestParam String name
			, @RequestParam String bfname) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Friend n = new Friend();
		n.setName(name);
		n.setBestFriend(bfname);
		friendRepository.save(n);
		return "Saved";
	}
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Friend> getAllFriends() {
		// This returns a JSON or XML with the users
		return friendRepository.findAll();
	}

}


