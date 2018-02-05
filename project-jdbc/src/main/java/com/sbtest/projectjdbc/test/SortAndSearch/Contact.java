package com.sbtest.projectjdbc.test.SortAndSearch;

/**
 * 联系人
 */
public class Contact implements Comparable<Contact>{
    private String firstName;
    private String lastName;
    private String phone;

    public Contact(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return lastName + ", " + firstName + "\t" + phone;
    }

    /**
     * 联系人是按姓排序的，如果有两个联系人同姓，则使用其名来排序。
     * @param other
     * @return
     */
    @Override
    public int compareTo(Contact other) {
        int result;
        if(lastName.equals(other.lastName)){
            result = firstName.compareTo(other.firstName);
        }else{
            result = lastName.compareTo(other.lastName);
        }
        return result;
    }
}
