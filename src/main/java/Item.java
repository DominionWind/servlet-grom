import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "ITEM")

public class Item {
    private long id;
    private String name;
    private Date dateCreated;
    private Date lastDateUpdate;
    private String description;

    @Id
    @SequenceGenerator(name = "ITEM_SEQ", sequenceName = "ITEM_PK_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEM_SEQ")
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @JsonFormat(pattern = "dd.mm.yyyy")
    @Column(name = "DATE_CREATED")
    public Date getDateCreated() {
        return dateCreated;
    }

    @JsonFormat(pattern = "dd.mm.yyyy")
    @Column(name = "LAST_DATE_UPDATE")
    public Date getLastDateUpdate() {
        return lastDateUpdate;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setLastDateUpdate(Date lastDateUpdate) {
        this.lastDateUpdate = lastDateUpdate;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateCreated=" + dateCreated +
                ", lastDateUpdate=" + lastDateUpdate +
                ", description='" + description + '\'' +
                '}';
    }
}