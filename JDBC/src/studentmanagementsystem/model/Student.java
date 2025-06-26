package studentmanagementsystem.model;

public class Student {
    private int rollNo;
    private String name;
    private String branch;
    private String mobileNo;

    public Student(){}
    public Student(int rollNo, String name, String branch, String mobileNo){
        setRollNo(rollNo);
        setName(name);
        setBranch(branch);
        setMobileNo(mobileNo);
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", branch='" + branch + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
}
