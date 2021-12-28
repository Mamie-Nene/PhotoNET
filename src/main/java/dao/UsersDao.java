package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.DatabaseConnection;

import java.util.ArrayList;

import beans.Utilisateur;


public class UsersDao 
{
	public static Connection db =DatabaseConnection.getConnection();	
	
	public static boolean ajouter(Utilisateur utilisateur )
	{ 
		try
		{
			
			PreparedStatement stmt= db.prepareStatement("INSERT INTO User (nom, prenom, username, pwd, userRole) VALUES (?,?,?,?,?)");
			stmt.setString(1,utilisateur.getNom());
			stmt.setString(2,utilisateur.getPrenom());
			stmt.setString(3,utilisateur.getLogin());
			stmt.setString(4,utilisateur.getPassword());
			stmt.setInt(5,utilisateur.getUserRole()); 
		    stmt.executeUpdate();
		    stmt.close();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		
	}
	public static ArrayList<Utilisateur> lister() 
	{
		ArrayList<Utilisateur> List_users = new ArrayList<Utilisateur>() ;
		try
		{
			
			PreparedStatement stmt= db.prepareStatement("SELECT * FROM User");
			ResultSet result = stmt.executeQuery();
			while (result.next()) 
			{
				Utilisateur utilisateur = new Utilisateur(result.getInt("id"),result.getString("nom"),result.getString("prenom"),result.getString("username"),result.getString("pwd"), result.getInt("userRole"));
				List_users.add(utilisateur);
			}
		
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return List_users;
	}
	
	public static boolean modifier(Utilisateur utilisateur )
	{
		try
		{
			
		
		PreparedStatement stmt= db.prepareStatement("UPDATE Utilisateur SET nom=?, prenom=?, username=?, pwd=?, userRole=? where id=? ");
		stmt.setString(1,utilisateur.getNom());
		stmt.setString(2,utilisateur.getPrenom());
		stmt.setString(3,utilisateur.getLogin());
		stmt.setString(4,utilisateur.getPassword());
		stmt.setInt(5,utilisateur.getUserRole());
		stmt.setInt(6,utilisateur.getId());
		
		stmt.executeUpdate();
		stmt.close();
		} 
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	public static Utilisateur getUser(int id) {
		Utilisateur utilisateur = new Utilisateur();
		
		try
		{
			 
		PreparedStatement stmt= db.prepareStatement("Select * from User where id=? ");
		stmt.setInt(1,id);
		ResultSet result = stmt.executeQuery(); 
		if(result.next()) {
			utilisateur.setId(result.getInt("id"));
			utilisateur.setNom(result.getString("nom"));
			utilisateur.setPrenom(result.getString("prenom"));
			utilisateur.setLogin(result.getString("username"));
			utilisateur.setPassword(result.getString("pwd"));
			utilisateur.setPassword(result.getString("userRole"));

		}
		stmt.close();
		} 
		catch(SQLException e){
			e.printStackTrace();
		}
		return utilisateur;
		
	}
	public static Utilisateur get(String login) {
		Utilisateur utilisateur = new Utilisateur();
		
		try
		{
			 
		PreparedStatement stmt= db.prepareStatement("Select * from User where id=? ");
		stmt.setString(1,login);
		ResultSet result = stmt.executeQuery(); 
		if(result.next()) {
			utilisateur.setId(result.getInt("id"));
			utilisateur.setNom(result.getString("nom"));
			utilisateur.setPrenom(result.getString("prenom"));
			utilisateur.setLogin(result.getString("username"));
			utilisateur.setPassword(result.getString("pwd"));
			utilisateur.setUserRole(result.getInt("userRole"));

		}
		stmt.close();
		} 
		catch(SQLException e){
			e.printStackTrace();
		}
		return utilisateur;
		
	}
	public static boolean supprimer(int id) {
		
		 
		try
		{
			 
		PreparedStatement stmt= db.prepareStatement("delete from User where id=? ");
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
