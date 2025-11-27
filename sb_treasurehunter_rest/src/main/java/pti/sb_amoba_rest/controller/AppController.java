package pti.sb_amoba_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pti.sb_amoba_rest.dto.RankDto;
import pti.sb_amoba_rest.dto.UserDto;
import pti.sb_amoba_rest.dto.UserDtoFromFE;
import pti.sb_amoba_rest.service.AppService;

@CrossOrigin(origins = "*")
@RestController
public class AppController {

	
		private AppService service;

		@Autowired
		public AppController(AppService service) {
			super();
			this.service = service;
		}
		
		
		
		//http://localhost:8080/login
		
		@PostMapping("/login")
		public UserDto getUser(
				@RequestBody UserDtoFromFE userDtoFromFE)
		{ 
		
			UserDto userDto = service.examUserLogin(
					userDtoFromFE.getName(),
					userDtoFromFE.getPassword());
	
			return userDto;		
		}
		
		//http://localhost:8080/save
		@PostMapping("/save")
		public void saveNewRank(
				@RequestBody RankDto rankDto) {
			
			service.saveNewRank(rankDto);
			
		}
			
		
		
		
		
		
		
}
