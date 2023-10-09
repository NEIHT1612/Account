/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import com.oracle.wls.shaded.org.apache.xalan.res.XSLTErrorResources_sl;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapper.AccountMapper;
import model.Account;

/**
 *
 * @author PC
 */
public class AccountDAO extends DBContext_1 {
    public List<Account> allList(){
        List<Account> list = query(new Account(), new AccountMapper(), null);
        return list;
    }
    
    public List<Account> getListByTuKhoa(int tukhoa){
        HashMap<String, Object> conditions = new HashMap<>();
        conditions.put("id", tukhoa);
        conditions.put("name", "khoadt");
        List<Account> list = query(new Account(), new AccountMapper(), conditions, false);
        return list;
    }
    
    public void insert2(Account account){
        insert(account);
    }
    
    public void update2(){
        HashMap<String, Object> conditions = new HashMap<>();
        conditions.put("id", 13);
        Account account = new Account();
        account.setName("cc");
        account.setPassword("xyz");
        
        update(account, conditions);
    }
    public static void main(String[] args) {
        Account account = new Account(10, "abc", "abc");
        new AccountDAO().insert2(account);
        
        new AccountDAO().update2();
        
        for (Account account1 : new AccountDAO().allList()){
            System.out.println(account1);            
        }
    }
    

//    public List<Account> allList() {
//        List<Account> list = new ArrayList<>();
//        //ket noi voi database
//        connection = getConnection();
//        //lay cau lenh
//        String sql = "select * from Account";
//        try {
//            //chuan bi
//            statement = connection.prepareStatement(sql);
//            //tien hanh
//            resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                Account account = new Account();
//                //id
//                int id = resultSet.getInt("id");
//                //name
//                String name = resultSet.getString("name");
//                //password
//                String password = resultSet.getString("password");
//                account.setId(id);
//                account.setName(name);
//                account.setPassword(password);
//                list.add(account);
//            }
//        } catch (SQLException ex) {
//            System.out.println("Error " + ex.getMessage() + "at DBContext: allList");
//            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
//    }
//
//    public static void main(String[] args) {
//        AccountDAO dao = new AccountDAO();
//        for (Account account : dao.allList()) {
//            System.out.println(account);
//        }
//    }
//
//    public List<Account> getListByTuKhoa(String tukhoa) {
//        List<Account> list = new ArrayList<>();
//        //ket noi voi database
//        connection = getConnection();
//        //lay cau lenh
//        String sql = "select *\n"
//                + "from Account\n"
//                + "where name like ?";
//        try {
//            //chuan bi
//            statement = connection.prepareStatement(sql);
//
//            //set tukhoa vao` sql = "?"
//            statement.setString(1, "%" + tukhoa + "%");
//
//            //tien hanh
//            resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                Account account = new Account();
//                //id
//                int id = resultSet.getInt("id");
//                //name
//                String name = resultSet.getString("name");
//                //password
//                String password = resultSet.getString("password");
//                account.setId(id);
//                account.setName(name);
//                account.setPassword(password);
//                list.add(account);
//            }
//        } catch (SQLException ex) {
//            System.out.println("Error " + ex.getMessage() + "at DBContext: allList");
//            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
//    }
//
//    public int insert(String username, String password) {
//        List<Account> list = new ArrayList<>();
//        //ket noi voi database
//        connection = getConnection();
//        //lay cau lenh
//        String sql = "INSERT INTO [dbo].[Account]\n"
//                + "           ([name]\n"
//                + "           ,[password])\n"
//                + "     VALUES\n"
//                + "           (?, ?)";
//        try {
//            //chuan bi
//            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//
//            //set tukhoa vao` sql = "?"
//            statement.setString(1, username);
//            statement.setString(2, password);
//
//            //tien hanh
//            statement.executeUpdate();
//            resultSet = statement.getGeneratedKeys();
//            if (resultSet.next()) {
//                return resultSet.getInt(1);
//            }
//
//        } catch (SQLException ex) {
//            System.out.println("Error " + ex.getMessage() + "at DBContext: allList");
//            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return -1;
//    }
//
//    public void delete(String id) {
//        List<Account> list = new ArrayList<>();
//        //ket noi voi database
//        connection = getConnection();
//        //lay cau lenh
//        String sql = "DELETE FROM [dbo].[Account]\n"
//                + "      WHERE id = ?";
//        try {
//            //chuan bi
//            statement = connection.prepareStatement(sql);
//
//            //set tukhoa vao` sql = "?"
//            statement.setString(1, id);
//
//            //tien hanh
//            statement.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println("Error " + ex.getMessage() + "at DBContext: allList");
//            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public void update(Account account) {
//        List<Account> list = new ArrayList<>();
//        //ket noi voi database
//        connection = getConnection();
//        //lay cau lenh
//        String sql = "UPDATE [dbo].[Account]\n"
//                + "   SET [name] = ?\n"
//                + "      ,[password] = ?\n"
//                + " WHERE id = ?";
//        try {
//            //chuan bi
//            statement = connection.prepareStatement(sql);
//
//            //set tukhoa vao` sql = "?"
//            statement.setString(1, account.getName());
//            statement.setString(2, account.getPassword());
//            statement.setInt(3, account.getId());
//            
//            //tien hanh
//            statement.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println("Error " + ex.getMessage() + "at DBContext: allList");
//            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
