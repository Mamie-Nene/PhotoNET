package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Album;
import database.DatabaseConnection;

public class AlbumDao {
	public static Connection db = DatabaseConnection.getConnection();
	public static Album album;
	public static boolean ajouter(Album album )
	{ 
		try
		{
			PreparedStatement stmt= db.prepareStatement("INSERT INTO Album (nomAlbum, dateCreation, proprioAlbum, detail, portee, categorie, autorisationId) VALUES (?,?,?,?,?,?,?)");
			stmt.setString(1,album.getNomAlbum());
			stmt.setString(2,album.getDateCreation());
			stmt.setString(3,album.getProprioAlbum());
			stmt.setString(4,album.getDetail());
			stmt.setString(5,album.getPortee()); 
			stmt.setInt(6,album.getCategorie()); 
			stmt.setInt(7,album.getAutorisationId()); 
		    stmt.executeUpdate();
		    stmt.close();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	public static boolean modifier(Album album )
	{
		try
		{
			PreparedStatement stmt= db.prepareStatement("UPDATE Album SET nomAlbum=?,dateCreation=?, proprioAlbum=?, detail=?, portee=?, categorie=?, autorisationId=? where id=? ");
			stmt.setString(1,album.getNomAlbum());
			stmt.setString(2,album.getDateCreation());
			stmt.setString(3,album.getProprioAlbum());
			stmt.setString(4,album.getDetail());
			stmt.setString(5,album.getPortee()); 
			stmt.setInt(6,album.getCategorie()); 
			stmt.setInt(7,album.getAutorisationId()); 
			stmt.setInt(8,album.getId());
			
			
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
			PreparedStatement stmt= db.prepareStatement("delete from Album where id=? ");
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
