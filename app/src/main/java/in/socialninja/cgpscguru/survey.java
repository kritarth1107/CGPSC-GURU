package in.socialninja.cgpscguru;

public class survey {
    private String name;

    public survey() {

    }


    public survey(String name, String link) {
        this.name = name;
        this.link = link;
    }

    private String link ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
