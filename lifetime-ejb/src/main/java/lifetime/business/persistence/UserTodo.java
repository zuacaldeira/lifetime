/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.business.persistence;

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
@Table(name = "user_todo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserTodo.findAll", query = "SELECT u FROM UserTodo u"),
    @NamedQuery(name = "UserTodo.findById", query = "SELECT u FROM UserTodo u WHERE u.id = :id"),
    @NamedQuery(name = "UserTodo.findByUserId", query = "SELECT u FROM UserTodo u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserTodo.findByUserIdAndTodoId", query = "SELECT u FROM UserTodo u WHERE u.userId = :userId AND u.todoId = :todoId"),
    @NamedQuery(name = "UserTodo.findByTodoId", query = "SELECT u FROM UserTodo u WHERE u.todoId = :todoId")})
public class UserTodo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "userId")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "todoId")
    private int todoId;

    public UserTodo() {
    }

    public UserTodo(Integer id) {
        this.id = id;
    }

    public UserTodo(Integer id, int userId, int todoId) {
        this.id = id;
        this.userId = userId;
        this.todoId = todoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
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
        if (!(object instanceof UserTodo)) {
            return false;
        }
        UserTodo other = (UserTodo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UserTodo: userId=" + userId + " todoId=" + todoId;
    }

}
