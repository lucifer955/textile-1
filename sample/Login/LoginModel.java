package sample.Login;

import sample.ConnectDB.ConnectionClass;

import java.sql.*;




public class LoginModel {
    Connection con=null;
    public LoginModel(){                                //  database connection
        try{
         con= ConnectionClass.connect();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        if(con !=null)
    {
        System.out.println("connected");
    }}
        public boolean isDatabaseConnected()
        {
            return con != null;
        }
        public boolean userLogin(String userid,String password,String type) throws SQLException     // user authentication
        {
            try {

                String sql = "SELECT user_id , password , type FROM login where user_id=? AND password=? AND type=?";
                PreparedStatement pr = con.prepareStatement(sql);
                pr.setString(1, userid);
                pr.setString(2, password);
                pr.setString(3, type);

                ResultSet rs = pr.executeQuery();

                if (rs.next()) {
                    return true;
                }
                return false;

            } catch (SQLException ex) {
                return false;
            } finally {


                con.close();}




        }}