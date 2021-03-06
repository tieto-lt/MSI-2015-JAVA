package lt.msi2015.applicationSettings;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface ApplicationSettingsRepository extends Repository<ApplicationSetting, String> {
	ApplicationSetting save(ApplicationSetting setting);
	List<ApplicationSetting> findAll();
	ApplicationSetting findByProperty(String property);
}
