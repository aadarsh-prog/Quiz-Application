
package quiz.pojo;



public class UserPojo 
{
    private String uname;
    private String upass;
    private String email;

     public UserPojo()
     {
         
     }
    public UserPojo(String uname, String upass, String email) {
        this.uname = uname;
        this.upass = upass;
        this.email = email;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
