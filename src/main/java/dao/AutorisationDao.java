package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Autorisation;
import database.DatabaseConnection;

public class AutorisationDao {
	public static Connection db = DatabaseConnection.getConnection();
	public static Autorisation autorisation;
	
	public static boolean ajouter(Autorisation autorisation )
	{ 
		try
		{
			PreparedStatement stmt= db.prepareStatement("INSERT INTO Autorisation (proprioId, authorizedUser ) VALUES (?,?)");
			stmt.setInt(1,autorisation.getProprioId());
			stmt.setInt(2,autorisation.getAuthorizedUser());
		    stmt.executeUpdate();
		    stmt.close();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	public static boolean modifier(Autorisation autorisation ) 
	{
		try
		{
			PreparedStatement stmt= db.prepareStatement("UPDATE Autorisation SET proprioId=?, autorisationUser=? where id=? ");
			stmt.setInt(1,autorisation.getProprioId());
			stmt.setInt(2,autorisation.getAuthorizedUser()); 
			stmt.setInt(3,autorisation.getId());
			
			
			stmt.executeUpdate();
			stmt.close();
		} 
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public static boolean supprimer(int id) {
		try
		{	 
			PreparedStatement stmt= db.prepareStatement("delete from Autorisation where id=? ");
			stmt.setInt(1,id);
			stmt.executeUpdate(); 
			stmt.close();
			return true;
		} 
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		
	}
}
