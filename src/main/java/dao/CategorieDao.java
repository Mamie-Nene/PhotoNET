package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Categorie;
import database.DatabaseConnection;

public class CategorieDao 
{
	public static Connection db = DatabaseConnection.getConnection();
	public static Categorie categorie;
		
	public static boolean ajouter(Categorie categorie )
	{ 
		try
		{
			PreparedStatement stmt= db.prepareStatement("INSERT INTO Categorie (libelle ) VALUES (?)");
			stmt.setString(1,categorie.getLibelle());
		    stmt.executeUpdate();
		    stmt.close();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	public static boolean modifier(Categorie categorie ) 
	{
		try
		{
			PreparedStatement stmt= db.prepareStatement("UPDATE Categorie SET libelle=? where id=? ");
			stmt.setString(1,categorie.getLibelle());
			stmt.setInt(3,categorie.getId());
			
			
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
			PreparedStatement stmt= db.prepareStatement("delete from Categorie where id=? ");
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

