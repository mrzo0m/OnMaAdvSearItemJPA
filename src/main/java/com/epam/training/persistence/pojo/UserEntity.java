/**
 *
 */
package com.epam.training.persistence.pojo;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

//import org.apache.bval.constraints.Email;

/**
 * @author Oleg_Burshinov
 */
@Component
//Named queries also enforce the best practice of using query parameters.
//Named queries also enforce the best practice of using query parameters.
@NamedQueries({
        @NamedQuery(
                name = "isUserAuthorized",
                query = "select u from UserEntity u where u.login like :login and u.password like :password"
        ),
        @NamedQuery(
                name = "findUsersByLogin",
                query = "select u from UserEntity u where u.login =:login"
        )
})
@Entity
@Access(AccessType.FIELD)
@Table(name = "USERS", schema = "OMPTEST", catalog = "")
public class UserEntity implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -1360172948486494551L;

    /**
     * JPA
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<ItemsEntity> itemsEntities;

    /**
     * UserID
     */
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "USR_ID_G")
    @SequenceGenerator(name = "USR_ID_G", sequenceName = "USR_ID_GEN")
    private Integer userId;
    /**
     * UserEntity name
     */
    @Basic
    @Column(name = "FULL_NAME")
    private String fullName;
    /**
     * Where user live
     */
    @Basic
    @Column(name = "BILLING_ADDRESS")
    private String billingAddress;
    /**
     * LOGIN
     */
    @Basic
    @Column(name = "LOGIN")
    private String login;
    /**
     * PASSWORD
     */
    @Basic
    @Column(name = "PASSWORD")
    private String password;
    /**
     * E-MAIL
     */
    @Basic
    @Column(name = "EMAIL")
    private String email;
    /**
     * phone
     */
    private String phone;

    @Transient
    private String confirmPassword;

    /**
     *
     */
    public UserEntity() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @param fullName
     * @param billingAddress
     * @param login
     * @param password
     * @param email
     */
    public UserEntity(String fullName, String billingAddress,
                      String login, String password, String email) {
        super();
        this.fullName = fullName;
        this.billingAddress = billingAddress;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    /**
     * @param login
     * @param password
     */
    public UserEntity(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((billingAddress == null) ? 0 : billingAddress.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result
                + ((fullName == null) ? 0 : fullName.hashCode());
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        result = prime * result
                + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof UserEntity)) {
            return false;
        }
        UserEntity other = (UserEntity) obj;
        if (billingAddress == null) {
            if (other.billingAddress != null) {
                return false;
            }
        } else if (!billingAddress.equals(other.billingAddress)) {
            return false;
        }
        if (email == null) {
            if (other.email != null) {
                return false;
            }
        } else if (!email.equals(other.email)) {
            return false;
        }
        if (fullName == null) {
            if (other.fullName != null) {
                return false;
            }
        } else if (!fullName.equals(other.fullName)) {
            return false;
        }
        if (login == null) {
            if (other.login != null) {
                return false;
            }
        } else if (!login.equals(other.login)) {
            return false;
        }
        if (password == null) {
            if (other.password != null) {
                return false;
            }
        } else if (!password.equals(other.password)) {
            return false;
        }
        if (userId == null) {
            if (other.userId != null) {
                return false;
            }
        } else if (!userId.equals(other.userId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UserEntity ["
                + (billingAddress != null ? "billingAddress=" + billingAddress
                + ", " : "")
                + (email != null ? "email=" + email + ", " : "")
                + (fullName != null ? "fullName=" + fullName + ", " : "")
                + (login != null ? "login=" + login + ", " : "")
                + (password != null ? "password=" + password + ", " : "")
                + (userId != null ? "userId=" + userId : "") + "]";
    }

    public Collection<ItemsEntity> getItemsEntities() {
        return itemsEntities;
    }

    public void setItemsEntities(Collection<ItemsEntity> itemsEntities) {
        this.itemsEntities = itemsEntities;
    }


    /**
     * @return the userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the billingAddress
     */
    public String getBillingAddress() {
        return billingAddress;
    }

    /**
     * @param billingAddress the billingAddress to set
     */
    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param emali the email to set
     */
    public void setEmail(String emali) {
        this.email = emali;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone phones
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @param confirmPassword the confirmPassword to set
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }


}
