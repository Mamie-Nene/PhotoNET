package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Categorie;
import database.DatabaseConnection;

public class CategorieDao 
{
	public static Connection db = DatabaseConnection.getConnection();
	private static ArrayList<Categorie> categories = new ArrayList<Categorie>() ;
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
	public static ArrayList<Categorie> lister() 
	{
		ArrayList<Categorie> List_Categorie = new ArrayList<Categorie>() ;
		try
		{
			
			PreparedStatement stmt= db.prepareStatement("SELECT * FROM Categorie");
			ResultSet result = stmt.executeQuery();
			while (result.next()) 
			{
				categorie = new Categorie(result.getInt("id"),result.getString("libelle"));
				List_Categorie.add(categorie);
			}
		
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		 categories = (ArrayList<Categorie>) List_Categorie.clone();
		
		return List_Categorie;
	}
	
	public static boolean lister(Categorie categorie )
	{ 
		try
		{
			PreparedStatement stmt= db.prepareStatement("SELECT * FROM Categorie ");
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

