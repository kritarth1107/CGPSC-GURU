package in.socialninja.cgpscguru;

public class syllabus_cgpsc {
    private String header;

    public syllabus_cgpsc()
    {

    }
    public syllabus_cgpsc(String header, String link) {
        this.header = header;
        this.link = link;
    }

    private String link;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
