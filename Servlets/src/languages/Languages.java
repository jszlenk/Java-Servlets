package languages;

public enum Languages {
    PL("pl"),
    EN("en"),
    DE("de");

    protected final String language;

    Languages(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }
}