
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
public class Student {
    Connection conn;
    ResultSet rs;
    PreparedStatement pst;
   
    private int RollNo;
    private String name;
    private String Address;
    private String EmailId;
    private String ContactNo;
    private int Fee;
    private int due;
    private int paid;
    private String course;
    private byte[] picture;
    
    private String acadmicYr;
    private String  paymentMode;
    private String bankName;
    private String totalAmtWrd;
//    private String Cast;
    private String admissionDate;

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    

    public String getAcadmicYr() {
        return acadmicYr;
    }

    public void setAcadmicYr(String acadmicYr) {
        this.acadmicYr = acadmicYr;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getTotalAmtWrd() {
        return totalAmtWrd;
    }

    public void setTotalAmtWrd(String totalAmtWrd) {
        this.totalAmtWrd = totalAmtWrd;
    }
  

   
    Student(){}
    Student(int _rollno , String _name,String _eid, String _course,int _fee,int _paid,int _due, String _address,String _contact,byte[] _picture, String _admissionDate, String _acadmicYr ,String  _paymentMode,String _bankName,String _totalAmtWrd)
    {
        this.RollNo = _rollno;
        this.name = _name;
        this.EmailId = _eid;
        
        this.course = _course;
        this.Fee =_fee;
        this.paid = _paid;
        
        this.due = _due;
        this.Address = _address;
        this.ContactNo = _contact;
        
        this.picture = _picture;
        
        this.acadmicYr = _acadmicYr;
        this.admissionDate = _admissionDate;
        this.paymentMode =_paymentMode;
        this.bankName =_bankName;
        this.totalAmtWrd =_totalAmtWrd;
//        this.Cast  = _cast;
    }
    public void setRollNo(int RollNo) {
        this.RollNo = RollNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setEmailId(String EmailId) {
        this.EmailId = EmailId;
    }

    public void setContactNo(String ContactNo) {
        this.ContactNo = ContactNo;
    }

    public void setFee(int Fee) {
        this.Fee =  Fee;
    }

    public void setDue(int due) {
        this.due =  due;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public int getRollNo() {
        return RollNo;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return Address;
    }

    public String getEmailId() {
        return EmailId;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public int getFee() {
        return Fee;
    }

    public int getDue() {
        return due;
    }

    public int getPaid() {
        return paid;
    }

    public String getCourse() {
        return course;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void addStudent(int _rollno , String _name, String _eid, String _course,int _fee,int _paid,int _due, String _address,String _contact,byte[] _picture,String _admissionDate,String _acadmicYr,String _paymentMode,String _bankName,String _totalAmtWrd){
     String sql = "INSERT INTO Student VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            //Date _admissionDate,String _paymentMode,String _bankName,String _totalAmtWrd){
            pst = JavaConnect.connectDb().prepareStatement(sql);
          
            pst.setInt(1,_rollno);
            pst.setString(2,_name);
            pst.setString(3, _eid);
            pst.setString(4,_course);
            pst.setInt(5, _fee);
            pst.setInt(6,_paid);
            pst.setInt(7,_due);
            pst.setString(8, _address);
            pst.setString(9,_contact);
            pst.setBytes(10, _picture);
            pst.setString(11, _admissionDate);
            pst.setString(12,_acadmicYr);
            pst.setString(13,_paymentMode);
            pst.setString(14,_bankName);
            pst.setString(15,_totalAmtWrd);
            if(pst.executeUpdate()!=0)
            {
                JOptionPane.showMessageDialog(null,"Account Created Successfuly");
                pst.close();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Not able to process your request");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }

//function to edit student
 public void editStudent(int _rollno , String _name, String _eid, String _course,int _fee,int _paid,int _due, String _address,String _contact,byte[] _picture){
     String sql = "UPDATE Student set RollNO=?, Name = ?, EmailID =?,Course=?,Fee=?,Paid=?,Due=?,Address=?,ContactNo=?, Photo=? where RollNO=? ";        
        try{
           // ('RollNO','Name','EmailID','Course','Fee','Paid','Due','Address','ContactNO','Photo')
             pst = JavaConnect.connectDb().prepareStatement(sql);
          
            pst.setInt(1,_rollno);
            pst.setString(2,_name);
            pst.setString(3, _eid);
            pst.setString(4,_course);
            pst.setInt(5, _fee);
            pst.setInt(6,_paid);
            pst.setInt(7,_due);
            pst.setString(8, _address);
            pst.setString(9,_contact);
            pst.setBytes(10, _picture);
            pst.setInt(11, _rollno);
            
            if(pst.executeUpdate()!=0)
            {
                JOptionPane.showMessageDialog(null,"Record Updated Successfuly");
                pst.close();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Not able to process your request");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }

//function to remove student
public boolean removeStud(int rollNo){
    return true;
}
public ArrayList<Student> student(){
    return new ArrayList<Student>();
}
}
