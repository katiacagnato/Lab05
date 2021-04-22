package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.anagrammi.FXMLController;
import it.polito.tdp.anagrammi.model.Model;


public class ParolaDAO {
	
	FXMLController controllore;
	Model model;
	
public boolean isCorrect(String anagramma){
		
	boolean esiste;
		
		try {
					Connection conn = DBConnect.getConnection();		
				
					String sql= "SELECT nome FROM parola WHERE nome=? ";
							
					PreparedStatement st= conn.prepareStatement(sql);
				
					
					st.setString(1, anagramma);
					ResultSet res= st.executeQuery();
				 			
					// if(res.next()) ritorna true se c'e una riga, false se non c'è
					if(res.next()==true)
					{
						esiste=true;
					}
					else
						esiste=false;
					
					conn.close();
				return esiste;
					
			} catch (SQLException e) {
			e.printStackTrace(); 
			return false;
			}
		}	
	
}
