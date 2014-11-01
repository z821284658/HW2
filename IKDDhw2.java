/*--------------------------------------------------
*  Hsu Chen Chia
*  
*  Retrieve twitter data containing the query string from iservDB
*  
*  
*  2014.11.1
----------------------------------------------------*/
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JTable;


public class IKDDhw2 {
	
	public static void main(String[] args) throws IOException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
			
			String query_keyword = new String(args[0]);
			ArrayList<Tuple_info> tuples = new ArrayList<Tuple_info>();
			
			// Connect to iservDB
			// TODO Auto-generated method stub
			Class.forName("org.postgresql.Driver");
			String URL = "jdbc:postgresql://iservdb.cloudopenlab.org.tw:5432/julian820568jp_db_8009";
			Connection connect = DriverManager.getConnection( URL, "julian820568jp_user_8009", "Ip8DFLxg" );
			
			
			// Retrieve twitter data containing the query string
			String SQL = "select * from twitter where q = " + "'" + query_keyword + "'" ;
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			while ( rs.next() ) {
				tuples.add(new Tuple_info(Long.parseLong( rs.getString("user_id") ), rs.getString("text"), rs.getString("user_name")));
			}
			rs.close();
			stmt.close();
			
			// sort according to the user ID in the ascendant order
			Collections.sort(tuples, new Comparator<Tuple_info>(){
	        	 @Override
	        	 public int compare(Tuple_info t1, Tuple_info t2) {
	        	  return t2.compareTo(t1);
	        	 }   
	        });
			
			// Show the result in the table form
			JTable table=new JTable(new TableModel(tuples));
			javax.swing.JFrame MyFrame=new javax.swing.JFrame("Query結果" + "'" + query_keyword + "'");
			MyFrame.setSize(500,200);
			MyFrame.setLocation(200,200);
			MyFrame.getContentPane().add(new javax.swing.JScrollPane(table));
			MyFrame.setVisible(true);
		}
         
}
