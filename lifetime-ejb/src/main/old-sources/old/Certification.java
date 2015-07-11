/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old;

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
@Table(name = "certification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Certification.findAll", query = "SELECT c FROM Certification c"),
    @NamedQuery(name = "Certification.findById", query = "SELECT c FROM Certification c WHERE c.id = :id"),
    @NamedQuery(name = "Certification.findByDegree", query = "SELECT c FROM Certification c WHERE c.degree = :degree"),
    @NamedQuery(name = "Certification.findByCourse", query = "SELECT c FROM Certification c WHERE c.course = :course"),
    @NamedQuery(name = "Certification.findByExamId", query = "SELECT c FROM Certification c WHERE c.examId = :examId"),
    @NamedQuery(name = "Certification.findByOrganization", query = "SELECT c FROM Certification c WHERE c.organization = :organization"),
    @NamedQuery(name = "Certification.findByExamCenter", query = "SELECT c FROM Certification c WHERE c.examCenter = :examCenter"),
    @NamedQuery(name = "Certification.findByStart", query = "SELECT c FROM Certification c WHERE c.start = :start"),
    @NamedQuery(name = "Certification.findByEnd", query = "SELECT c FROM Certification c WHERE c.end = :end"),
    @NamedQuery(name = "Certification.findByUserId", query = "SELECT c FROM Certification c WHERE c.userId = :userId"),
    @NamedQuery(name = "Certification.findByLanguage", query = "SELECT c FROM Certification c WHERE c.language = :language"),
    @NamedQuery(name = "Certification.findByOriginalId", query = "SELECT c FROM Certification c WHERE c.originalId = :originalId"),
    @NamedQuery(name = "Certification.findByUserIdAndLanguage", query = "SELECT a FROM Certification a WHERE a.userId = :userId AND a.language = :language"),
    @NamedQuery(name = "Certification.findByDescription", query = "SELECT c FROM Certification c WHERE c.description = :description")})
public class Certification extends Achievement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "grade")
    private Integer grade;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "degree")
    private Degree degree;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course")
    private Course course;

    @Size(max = 45)
    @Column(name = "examId")
    private String examId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "examCenter")
    private Organization examCenter;

    @Size(max = 500)
    @Column(name = "description")
    private String description;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "originalId")
    private Certification originalId;
    
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "certification_tool",
            joinColumns = {@JoinColumn(name = "certification", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "tool", referencedColumnName = "id")})
    private List<Tool> tools;
    
    
    public Certification() {
    }

    public Certification(Integer id) {
        super(id);
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public Organization getExamCenter() {
        return examCenter;
    }

    public void setExamCenter(Organization examCenter) {
        this.examCenter = examCenter;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return degree + " " + course;
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

    public Certification getOriginalId() {
        return originalId;
    }

    public void setOriginalId(Certification originalId) {
        this.originalId = originalId;
    }

    public List<Tool> getTools() {
        return tools;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }
    
    
    
}
