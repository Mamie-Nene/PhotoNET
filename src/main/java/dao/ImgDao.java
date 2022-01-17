package dao;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import beans.Image;
import beans.Album;
import database.DatabaseConnection;

public class ImgDao {
	public static Connection conn = DatabaseConnection.getConnection();
//	private static ArrayList<Image> images = new ArrayList<Image>() ;
	
	 private static InputStream inputStream = null;
	 
	
	public static boolean ajouter( HttpServletRequest request,Image image, Album album ) throws IOException, ServletException 
	{
	Part filePart = request.getPart("photo");
		
		if (filePart != null) {
            // debug messages
            System.out.println(filePart.getName());
            System.out.println(filePart.getSubmittedFileName());

            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
            
        }
		
		try 
		{
	        // constructs SQL statement
	        String sql = "INSERT INTO photo (titre,description,motscles,largeur,hauteur,album, img) values (?, ?, ?,?,?,?,?)";
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setString(1, image.getTitre());
	        statement.setString(2, image.getDescription());
	        statement.setString(3, image.getMotscles());
	        statement.setInt(4, image.getLargeur());
	        statement.setInt(5, image.getHauteur());
	        statement.setInt(6, album.getId());
	        
	        inputStream = filePart.getInputStream();
	        if (inputStream != null) 
	        {
	            // fetches input stream of the upload file for the blob column
	            statement.setBlob(7, inputStream);
	        }
	        statement.executeUpdate();
	        statement.close();
	        return true;
	        
	    } catch (SQLException ex) 
		{
	        
	        ex.printStackTrace();
	        return false;
	    }
	}
	public static ArrayList<Image> ListeImages(int id) throws IOException 
	{
		ArrayList<Image> List_image = new ArrayList<Image>() ;
		try 
		{
	        // constructs SQL statement
	        String sql = "SELECT * FROM photo WHERE album  = ? ";
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setInt(1, id);
	        ResultSet result = statement.executeQuery();
			while (result.next()) 
			{
				Image image = new Image(result.getInt("id"),result.getInt("hauteur"),result.getInt("largeur"),result.getString("titre"),result.getString("description"),result.getString("motscles"),ImgDao.getImage(result.getBlob("img").getBinaryStream()));
				
				List_image.add(image);
			}

	    } catch (SQLException ex) 
		{
	        
	        ex.printStackTrace();

	    }
//		images = (ArrayList<Image>) List_image.clone();
		
		return List_image;
		
	}
	
	public static String getImage(InputStream inputStream) throws IOException{
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[4096];
		int bytesRead = -1;
		
		while((bytesRead = inputStream.read(buffer)) != -1)
		{
			outputStream.write(buffer, 0, bytesRead);
		}
		byte [] imagesBytes = outputStream.toByteArray();
		String base64Image = Base64.getEncoder().encodeToString(imagesBytes);
		
		inputStream.close();
		outputStream.close();
		
		return base64Image;
	} 
		public static ArrayList<Image> ListAllImg() throws IOException 
		{
			ArrayList<Image> List_image = new ArrayList<Image>() ;
			try 
			{
		        // constructs SQL statement
		        String sql = "SELECT * FROM photo  ";
		        PreparedStatement statement = conn.prepareStatement(sql);
		       
		        ResultSet result = statement.executeQuery();
				while (result.next()) 
				{
					Image image = new Image(result.getInt("id"),result.getInt("hauteur"),result.getInt("largeur"),result.getString("titre"),result.getString("description"),result.getString("motscles"),ImgDao.getImage(result.getBlob("img").getBinaryStream()));
					
					List_image.add(image);
				}

		    } catch (SQLException ex) 
			{
		        
		        ex.printStackTrace();

		    }
//			images = (ArrayList<Image>) List_image.clone();
			
			return List_image;
			
		}
		public static ArrayList<Image> ListeImgByCategorie(int categorie) throws IOException 
		{
			Album album = null;
			ArrayList<Image> List_image = new ArrayList<Image>() ;
			try 
			{
		        // constructs SQL statement
				int cat= album.getCategorie();
				String sql1 = "SELECT * FROM album WHERE categorie  = ? ";
				PreparedStatement statement = conn.prepareStatement(sql1);
		        statement.setInt(1, cat);
		        ArrayList<Album> List_album = new ArrayList<Album>() ;
		        String sql = "SELECT * FROM photo WHERE album  = sql1 ";
		        PreparedStatement statement1 = conn.prepareStatement(sql);
		        statement.setInt(1, cat);
		        ResultSet result = statement.executeQuery();
				while (result.next()) 
				{
					Image image = new Image(result.getInt("id"),result.getInt("hauteur"),result.getInt("largeur"),result.getString("titre"),result.getString("description"),result.getString("motscles"),ImgDao.getImage(result.getBlob("img").getBinaryStream()));
					
					List_image.add(image);
				}

		    } catch (SQLException ex) 
			{
		        
		        ex.printStackTrace();

		    }
//			images = (ArrayList<Image>) List_image.clone();
			
			return List_image;
			
		}
	
}
