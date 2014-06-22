/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.FinanceAccount;

import Business.Payment.PaymentDirectory;
import java.util.Date;

/**
 *
 * @author hyf
 */
public abstract class FinanceAccount {

    private String name;
    private String nameOnCard;
    private String cardType;
    private String cardNumber;
    private String ExpiresYear;
    private String ExpiresMonth;
    private String securityCode;
    private double remaining = 0;

    public enum FinanceAccountType {

        In("In"), Out("Out"), TrasactionAccount("TrasactionAccount"), Personal("Personal");
        private String value;

        private FinanceAccountType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiresYear() {
        return ExpiresYear;
    }

    public void setExpiresYear(String ExpiresYear) {
        this.ExpiresYear = ExpiresYear;
    }

    public String getExpiresMonth() {
        return ExpiresMonth;
    }

    public void setExpiresMonth(String ExpiresMonth) {
        this.ExpiresMonth = ExpiresMonth;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public double getRemaining() {
        return remaining;
    }

    public void setRemaining(double remaining) {
        this.remaining = remaining;
    }

    public void increaseRemaining(double r) {
        remaining = remaining + r;
    }

    public void reduceRemaining(double r) {
        remaining = remaining - r;
    }

   
    @Override
    public String toString() {
        return name;
    }
}
