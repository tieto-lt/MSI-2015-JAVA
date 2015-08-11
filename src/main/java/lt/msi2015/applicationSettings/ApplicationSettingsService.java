package lt.msi2015.applicationSettings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationSettingsService {
	
	@Autowired
	ApplicationSettingsRepository repository;
	
	@Transactional
	boolean save(List<ApplicationSetting> settings) {
		Map<ApplicationSettingsEnum, Integer> settingsMap = convertSettingsToMap(settings);
		
		if (settingsMap.get(ApplicationSettingsEnum.ONE_TIME_LIMIT) > 
			settingsMap.get(ApplicationSettingsEnum.MONTHLY_LIMIT))
			return false;
		
		return saveSettings(settings);
	}
	
	public Map<ApplicationSettingsEnum, Integer> convertSettingsToMap(List<ApplicationSetting> settings) {
		Map<ApplicationSettingsEnum, Integer> settingsMap = new HashMap<>();
		for (ApplicationSetting setting : settings)
			settingsMap.put(ApplicationSettingsEnum.valueOf(setting.getProperty().toUpperCase()), setting.getValue());
		return settingsMap;
	}
	
	private boolean saveSettings(List<ApplicationSetting> settings) {
		boolean result = true;
		
		for (ApplicationSetting setting : settings) {
			if (repository.save(setting) == null)
				result = false;
		}
		
		return result;
	}
}
