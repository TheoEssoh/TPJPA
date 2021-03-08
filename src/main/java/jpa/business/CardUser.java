package jpa.business;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity (name = "cardUser")
public class CardUser implements Serializable {
    private Long id;
    private Date attributionDate ;
    private Date withdrawalDate;
    private Date beginDate;
    private Date endDate;
    private User user;
   private Card card;

    public CardUser( Date attributionDate, Date withdrawalDate, Date beginDate, Date endDate) {
        this.id = getId();
        this.attributionDate = attributionDate;
        this.withdrawalDate = withdrawalDate;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public CardUser(Date beginDate, Date endDate) {
        this.id = getId();
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public CardUser() {

    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAttributionDate() {
        if (attributionDate == null){

            return new Date(new java.util.Date().getTime());
        }
        return attributionDate;
    }

    public void setAttributionDate(Date attributionDate) {
        this.attributionDate = attributionDate;
    }

    public Date getWithdrawalDate() {
        if (withdrawalDate == null){

            return new Date(new java.util.Date().getTime());
        }
        return withdrawalDate;
    }

    public void setWithdrawalDate(Date withdrawalDate) {
        this.withdrawalDate = withdrawalDate;
    }

    public Date getBeginDate() {
        if (beginDate == null){

            return new Date(new java.util.Date().getTime());
        }
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        if (endDate == null){

            return new Date(new java.util.Date().getTime());
        }
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @ManyToOne
    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardUser)) return false;
        CardUser cardUser = (CardUser) o;
        return getId().equals(cardUser.getId()) && getAttributionDate().equals(cardUser.getAttributionDate()) && getWithdrawalDate().equals(cardUser.getWithdrawalDate()) && getBeginDate().equals(cardUser.getBeginDate()) && getEndDate().equals(cardUser.getEndDate()) && getUser().equals(cardUser.getUser()) && getCard().equals(cardUser.getCard());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAttributionDate(), getWithdrawalDate(), getBeginDate(), getEndDate(), getUser(), getCard());
    }

    @Override
    public String toString() {
        return "CardUser{" +
                "id=" + id +
                ", attributionDate=" + attributionDate +
                ", withdrawalDate=" + withdrawalDate +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                '}';
    }
}
