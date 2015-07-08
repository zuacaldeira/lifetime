/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.business.persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lifetime
 */
@Entity
@Table(name = "academic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Academic.findAll", query = "SELECT a FROM Academic a"),
    @NamedQuery(name = "Academic.findById", query = "SELECT a FROM Academic a WHERE a.id = :id"),
    @NamedQuery(name = "Academic.findByDegree", query = "SELECT a FROM Academic a WHERE a.degree = :degree"),
    @NamedQuery(name = "Academic.findByCourse", query = "SELECT a FROM Academic a WHERE a.course = :course"),
    @NamedQuery(name = "Academic.findByOrganization", query = "SELECT a FROM Academic a WHERE a.organization = :organization"),
    @NamedQuery(name = "Academic.findByGrade", query = "SELECT a FROM Academic a WHERE a.grade = :grade"),
    @NamedQuery(name = "Academic.findByStart", query = "SELECT a FROM Academic a WHERE a.start = :start"),
    @NamedQuery(name = "Academic.findByEnd", query = "SELECT a FROM Academic a WHERE a.end = :end"),
    @NamedQuery(name = "Academic.findByStatus", query = "SELECT a FROM Academic a WHERE a.status = :status"),
    @NamedQuery(name = "Academic.findByUserId", query = "SELECT a FROM Academic a WHERE a.userId = :userId"),
    @NamedQuery(name = "Academic.findByLanguage", query = "SELECT a FROM Academic a WHERE a.language = :language"),
    @NamedQuery(name = "Academic.findByOriginalId", query = "SELECT a FROM Academic a WHERE a.originalId = :originalId"),
    @NamedQuery(name = "Academic.findByUserIdAndLanguage", query = "SELECT a FROM Academic a WHERE a.userId = :userId AND a.language = :language"),
    @NamedQuery(name = "Academic.findByDescription", query = "SELECT a FROM Academic a WHERE a.description = :description")})
public class Academic extends Achievement implements Serializable {

    private static final long serialVersionUID = 1L;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "degree")
    private Degree degree;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course")
    private Course course;

    @Column(name = "grade")
    private Integer grade;

    @Size(max = 500)
    @Column(name = "description")
    private String description;

    @Size(max = 45)
    @Column(name = "title")
    private String title;

    @Size(max = 45)
    @Column(name = "gradeSystem")
    private String gradeSystem;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "yearsCompleted")
    private Integer yearsCompleted;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "originalId")
    private Academic originalId;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "academic_tool",
            joinColumns = {@JoinColumn(name = "academic", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "tool", referencedColumnName = "id")})
    private List<Tool> tools;
    


    public Academic() {
    }

    public Academic(Integer id) {
        super(id);
    }

    public Academic(Integer id, int userId) {
        super(id, userId);
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Academic)) {
            return false;
        }
        Academic other = (Academic) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return degree + " " + course;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGradeSystem() {
        return gradeSystem;
    }

    public void setGradeSystem(String gradeSystem) {
        this.gradeSystem = gradeSystem;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getYearsCompleted() {
        return yearsCompleted;
    }

    public void setYearsCompleted(Integer yearsCompleted) {
        this.yearsCompleted = yearsCompleted;
    }

    public Academic getOriginalId() {
        return originalId;
    }

    public void setOriginalId(Academic originalId) {
        this.originalId = originalId;
    }

    public List<Tool> getTools() {
        return tools;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }
    
    

    
}
