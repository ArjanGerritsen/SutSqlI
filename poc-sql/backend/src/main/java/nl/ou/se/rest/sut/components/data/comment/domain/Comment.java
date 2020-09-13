package nl.ou.se.rest.sut.components.data.comment.domain;

public class Comment {

    // variable(s)
    private Long id;
    private String description;

    // getter(s) and setter(s)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}