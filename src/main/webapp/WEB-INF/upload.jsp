<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajout d'une image</title>
</head>
<body>
		 <form method="post"
        enctype="multipart/form-data">
        <table>
              
              <tr>
                <td>Titre:</td>
                <td><input type="text" name="titre"/></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><input type="text" name="desc" /></td>
            </tr>
             <tr>
                <td>Mots Clés:</td>
                <td><input type="text" name="mc" /></td>
            </tr>
            <tr>
                <td>hauteur:</td>
                <td><input type="number" name="hauteur"  /></td>
            </tr>
            <tr>
                <td>largeur:</td>
                <td><input type="number" name="largeur" /></td>
            </tr>  
            <tr>
                <td>Choose Image:</td>
                <td><input type="file" name="photo"
                    required="required" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"></td>
            </tr>
        </table>
    </form>
</body>
</html>