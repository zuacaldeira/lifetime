/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lifetime
 */
@Entity
@Table(name = "job_offer_task")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobOfferTask.findAll", query = "SELECT j FROM JobOfferTask j"),
    @NamedQuery(name = "JobOfferTask.findById", query = "SELECT j FROM JobOfferTask j WHERE j.id = :id"),
    @NamedQuery(name = "JobOfferTask.findByJobOfferId", query = "SELECT j FROM JobOfferTask j WHERE j.jobOfferId = :jobOfferId"),
    @NamedQuery(name = "JobOfferTask.findByTaskId", query = "SELECT j FROM JobOfferTask j WHERE j.taskId = :taskId")})
public class JobOfferTask implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "jobOfferId")
    private int jobOfferId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "taskId")
    private int taskId;

    public JobOfferTask() {
    }

    public JobOfferTask(Integer id) {
        this.id = id;
    }

    public JobOfferTask(Integer id, int jobOfferId, int taskId) {
        this.id = id;
        this.jobOfferId = jobOfferId;
        this.taskId = taskId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getJobOfferId() {
        return jobOfferId;
    }

    public void setJobOfferId(int jobOfferId) {
        this.jobOfferId = jobOfferId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobOfferTask)) {
            return false;
        }
        JobOfferTask other = (JobOfferTask) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lifetime.business.persistence.JobOfferTask[ id=" + id + " ]";
    }
    
}
