package grumsen.dal;

import grumsen.be.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Daniel
 */
public class AdminDAO{
    DBConnector dbConnect = new DBConnector();
    
    public Admin createAdmin(int id, Admin a) throws SQLException{
        try(Connection conn = dbConnect.getConnection()){
            String sql = "INSERT INTO Admin(name, projectId) VALUES(?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, a.getName());
            pstmt.setInt(2, a.getProjectId());
            
            int createdRows = pstmt.executeUpdate();
            
            if(createdRows == 0){
                throw new SQLException("Creating an admin failed, no rows created.");
            }
            
            try(ResultSet generatedKeys = pstmt.getGeneratedKeys()){
                if(generatedKeys.next()){
                    a.setId((int)generatedKeys.getLong(1));
                }else {
                    throw new SQLException("Creating an admin failed, no ID obtained");
                }
            }
        }
        return a;
    }
}