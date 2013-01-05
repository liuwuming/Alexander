package cn.work.Serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class User  {
	//private static final long serialVersionUID = 1L;
	 private Integer  id;
	    private String     name;
	    public User(){
	    }
	    public User (Integer id, String name){
	        this.id   = id;
	        this.name = name;
	    }
	    public Integer getId() {
	        return id;
	    }
	    public String getName() {
	        return name;
	    }
	    public void setId(Integer id) {
	        this.id = id;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		serializable();
//		inverseSerializable();
		
	}
	public static void serializable() throws Exception{
        
        User user = new User(9080, "fancy");
        ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("user.ser"));
        outStream.writeObject(user);
        System.out.println("<---- Finished ---->");
    }
	 public static void inverseSerializable() throws Exception{
	        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("user.ser"));
	        User user = (User)inputStream.readObject();
	        System.out.println("ID   : " + user.getId());
	        System.out.println("name : " + user.getName());
	 }

}
