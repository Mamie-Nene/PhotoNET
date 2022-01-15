package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import beans.Image;
import database.DatabaseConnection;

public class ImgDao {
	public static Connection conn = DatabaseConnection.getConnection();
//	private static HttpServletRequest request;
	
	 private static InputStream inputStream = null;
	 
	
	public static boolean ajouter( HttpServletRequest request,Image image ) throws IOException, ServletException 
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
	        String sql = "INSERT INTO photo (titre,description,motscles,largeur,hauteur, img) values (?, ?, ?,?,?,?)";
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setString(1, image.getTitre());
	        statement.setString(2, image.getDescription());
	        statement.setString(3, image.getMotscles());
	        statement.setInt(4, image.getLargeur());
	        statement.setInt(5, image.getHauteur());
	        
	        inputStream = filePart.getInputStream();
	        if (inputStream != null) 
	        {
	            // fetches input stream of the upload file for the blob column
	            statement.setBlob(6, inputStream);
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
}
