package App;

import java.util.Date;

/**
 * Created by jameeljiwani on 2018-12-26.
 */
public class Member {
    private String firstName;
    private String lastName;
    // Phone numbers are 10 digits and need a large data type to store them
    // String solves this problem and accounts for leading zeroes as well as dashes
    private String phoneNumber;
    // toString will return format: Wed Dec 26 08:45:25 EST 2018
    private Date date;
    private String comment;

    public Member() {
        setDate(new Date());
    }

    public Member(String fname, String lname, String comment, String number) {
        this();
        setFirstName(fname);
        setLastName(lname);
        setPhoneNumber(number);
        setComment(comment);
    }

    public Member(String fname, String lname, String comment, Date date, String number) {
        this(fname, lname, comment, number);
        setDate(date);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return firstName + ' ' + lastName + ", " + phoneNumber;
    }
}
