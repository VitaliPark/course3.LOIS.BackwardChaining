package GUI;

public enum GUIConstants {
	ABOUT_MESSAGE("Authors:\nVitali Park\nAndrew Nepogoda"), BUTTONS_COLOR(
			"Button.highlight"), SEARCH_INMG_PATH(".\\image\\search.png"), OPEN_IMG_PATH(
			".\\image\\HP-Folder.png"), ABOUT_IMG_PATH(".\\image\\about.png"), SEARCH_BUTTON_NAME(
			"Search"), DB_LABEL_NAME("DB"), RESULT_LABEL_NAME("Result"), QUERY_LABEL_NAME(
			"Query"), INCORRECT_INPUT("incorrect input"), INCORRECT_FILE(
			"incorrect file");
	GUIConstants(String value) {
		this.value = value;
	}

	private String value;

	public String getValue() {
		return value;
	}
}
