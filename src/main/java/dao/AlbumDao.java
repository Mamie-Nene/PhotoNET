package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Album;
import beans.Utilisateur;
import database.DatabaseConnection;

public class AlbumDao {
	private static ArrayList<Album> albums = new ArrayList<Album>() ;
	public static Connection conn = DatabaseConnection.getConnection();
	
	public static boolean AjouterAlbum(Album album,Utilisateur utilisateur) 
	{
		
		try
		{
			
			PreparedStatement stmt= conn.prepareStatement("INSERT INTO album (nomAlbum, detail, portee,proprioAlbum,categorie) VALUES (?,?,?,?,?)");
			stmt.setString(1,album.getNomAlbum());
			stmt.setString(2,album.getDetail());
			stmt.setString(3, album.getPortee());	
			stmt.setInt(4, utilisateur.getId());
			stmt.setInt(5, album.getCategorie());
			
		    stmt.executeUpdate();
		    stmt.close();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	public static ArrayList<Album> listerAlbum() 
	{
		ArrayList<Album> List_album = new ArrayList<Album>() ;
		try
		{
			
			PreparedStatement stmt= conn.prepareStatement("SELECT * FROM album");
			ResultSet result = stmt.executeQuery();
			while (result.next()) 
			{
				Album album = new Album(result.getInt("id"),result.getString("nomAlbum"),result.getString("detail"),result.getString("portee"),result.getInt("categorie"));
				List_album.add(album);
			}
		
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		 albums = (ArrayList<Album>) List_album.clone();
		
		return List_album;
	}
	public static Album getAlbumbyName(String nom) {
		for(Album album : albums) 
		{
			if(album.getNomAlbum().equals(nom))
			{
				return album;
			}
		}
		return null;
	}
	public static Album getAlbumById(int id) {
		for(Album album : albums) 
		{
			if(album.getId() == id)
			{
				return album;
			}
		}
		return null;
	}
	public static boolean supprimer(int id) 
	{
		try
		{
			 
		PreparedStatement stmt= conn.prepareStatement("delete from album where id=? ");
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
