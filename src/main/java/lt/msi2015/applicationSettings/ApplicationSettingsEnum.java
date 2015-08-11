package lt.msi2015.applicationSettings;

public enum ApplicationSettingsEnum {
	ONE_TIME_LIMIT("ONE_TIME_LIMIT"), MONTHLY_LIMIT("MONTHLY_LIMIT");

	private final String setting;

	private ApplicationSettingsEnum(final String setting) {
		this.setting = setting;
	}

	@Override
	public String toString() {
		return setting;
	}
}
