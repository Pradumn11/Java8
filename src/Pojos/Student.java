package Pojos;

public class Student {
    public Student(int passportNo, String firstName, String lastName, String gender, int percentage, int schoolId) {
        this.passportNo = passportNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.percentage = percentage;
        this.schoolId = schoolId;
    }

    int passportNo;
    String firstName;
    String lastName;
    String gender;
    int percentage;
    int schoolId;

    @Override
    public String toString() {
        return "Student{" +
                "passportNo=" + passportNo +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", percentage=" + percentage +
                ", schoolId=" + schoolId +
                '}';
    }

    public Student() {
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }



    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public int getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(int passportNo) {
        this.passportNo = passportNo;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}


