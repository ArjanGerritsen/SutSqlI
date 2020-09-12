package nl.ou.se.rest.sut.components.service.comment.domain;

public class CommentDto {

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