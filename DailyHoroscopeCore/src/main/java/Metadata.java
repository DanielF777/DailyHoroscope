import com.fasterxml.jackson.annotation.JsonProperty;

public class Metadata {

    private String mood;
    private String keywords;
    private String intensity;

    public Metadata(@JsonProperty("mood") String mood, @JsonProperty("keywords") String keywords, @JsonProperty("intensity") String intensity) {
        this.mood = mood;
        this.keywords = keywords;
        this.intensity = intensity;
    }

    public String getMood() {
        return mood;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getIntensity() {
        return intensity;
    }
}
