package in.socialninja.cgpscguru;

public class video {
    private String name;
    private String thumbnail;
    public video(){

    }
    public video(String name, String thumbnail, String url) {
        this.name = name;
        this.thumbnail = thumbnail;
        this.url = url;
    }

    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
