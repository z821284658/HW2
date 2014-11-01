public class Tuple_info  implements Comparable<Tuple_info>{
		
			private	long User_id;
			private String Text = new String();
			private String User_name = new String();
			
			public Tuple_info(long user_id, String test, String user_name) {
				this.User_id = user_id;
				this.Text = test;
				this.User_name = user_name;
		    }
		    
		    public long getUser_id() {
		        return User_id;
		    }
		  
		    public void setUser_id(long user_id) {
		        this.User_id = user_id;
		    }
			
		    public String getText() {
		        return Text;
		    }
		  
		    public void setText(String test) {
		        this.Text = test;
		    }
		    
		    public String getUser_name() {
		        return User_name;
		    }
		  
		    public void setUser_name(String user_name) {
		        this.User_name = user_name;
		    }
		    
		    @Override
		    public int compareTo(Tuple_info arg0) {
		        // TODO Auto-generated method stub
		    	Long user_id = arg0.getUser_id();
		    	return user_id.compareTo(this.User_id);
		    }
		    
	}
