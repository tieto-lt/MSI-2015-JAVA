package lt.msi2015.applicationSettings;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationSettingsRest {
	
	@Autowired
	private ApplicationSettingsService applicationSettingsService;
	
<<<<<<< HEAD
	@RequestMapping(value = "admin/applicationSettings/save", method = RequestMethod.POST)
=======
	@Autowired
	ApplicationSettingsRepository repository;
	
	@RequestMapping(value = "applicationSettings/save", method = RequestMethod.POST)
>>>>>>> df3ef46ad52e3597099ed4faee45a06a265324c5
	ResponseEntity<String> saveApplicationSettings(@RequestBody List<ApplicationSetting> settings) {
		if (!applicationSettingsService.save(settings))
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
<<<<<<< HEAD
=======
	
	@RequestMapping(value = "/applicationSettings", method = RequestMethod.GET)
	List<ApplicationSetting> getApplicationSettings() {
		return repository.findAll();
	}
>>>>>>> df3ef46ad52e3597099ed4faee45a06a265324c5
}
