package lt.msi2015.applicationSettings;

public enum ApplicationSettingsEnum {
	DAYLY_LIMIT("daily_limit"), MONTHLY_LIMIT("monthly_limit");

	private final String setting;

	/**
	 * @param text
	 */
	private ApplicationSettingsEnum(final String setting) {
		this.setting = setting;
	}

	@Override
	public String toString() {
		return setting;
	}
}
