package lt.msi2015.applicationSettings;

public enum ApplicationSettingsEnum {
	ONE_TIME_LIMIT("one_time_limit"), MONTHLY_LIMIT("monthly_limit");

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
//[{"property":"one_time_limit","value":"100"},{"property":"monthly_limit","value":"200"}]
