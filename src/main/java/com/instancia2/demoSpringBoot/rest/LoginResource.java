package com.instancia2.demoSpringBoot.rest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.sql.*;

@RestController
public class LoginResource {

    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public String login(@RequestParam(name = "user") String user, @RequestParam(name = "pass") String pass){
        String respuesta = null;

        pass = DigestUtils.sha256Hex(pass);

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/login","root","root");
            Statement st = connection.createStatement();

            String query = "select * from usuarios where user='"+ user +"' and pass= '"+ pass +"'";

            ResultSet resultSet;

            resultSet = st.executeQuery(query);

            if(resultSet.first()){
                respuesta = "usuario encontrado";
            }else{
                respuesta = "usuario no encontrao";
            }

            resultSet.close();
            st.close();
            connection.close();
            

        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }catch (SQLException s){
            System.out.println(s.getMessage());
        }

        return respuesta;

    }
}
