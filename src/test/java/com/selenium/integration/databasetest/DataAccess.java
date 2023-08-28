package com.selenium.integration.databasetest;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class DataAccess {
    // write method to get a product information
    public boolean getProduct(String productName, Connection connection){
        boolean isProductExist=false;
        Statement statement=null; //define a statement object for execute sql script
        ResultSet resultSet=null; // mandatory
        CachedRowSet cachedRowSet=null; // optional
        //Initialize the cached row set
        try {
            cachedRowSet= RowSetProvider.newFactory().createCachedRowSet();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            statement= connection.createStatement(); // new query set
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String selectProduct=String.format("select product_id,name,price from cc_CubeCart_inventory" +
                " where name='%s'", productName);
        try {
            resultSet=statement.executeQuery(selectProduct);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // verify the result set
        if (resultSet==null){
            System.out.println("No records found!!!");
            return isProductExist;
        }
        else {
            try {
                cachedRowSet.populate(resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            int count=0;
            while (true){
                try {
                    if (!cachedRowSet.next()){
                        break;
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                int product_id=0;
                try {
                    product_id=cachedRowSet.getInt("product_id");
                    String name=cachedRowSet.getString("name");
                    double price=cachedRowSet.getDouble("price");
                    System.out.println("product_id="+product_id+", name="+name+", price="+price);
                    count=cachedRowSet.getMaxRows();
                }catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (count>=1){
                System.out.println("Product count= "+count);
                isProductExist=true;
            }
            return isProductExist;
        }
    }

    public boolean getCustomer(String email, Connection connection){
        boolean isCustomerExist=false;
        Statement statement=null; //define a statement object for execute sql script
        ResultSet resultSet=null; // mandatory
        CachedRowSet cachedRowSet=null; // optional
        //Initialize the cached row set
        try {
            cachedRowSet= RowSetProvider.newFactory().createCachedRowSet();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            statement= connection.createStatement(); // new query set
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String selectCustomer=String.format("select customer_id,email,first_name from cc_CubeCart_customer" +
                " where email='%s'", email);
        try {
            resultSet=statement.executeQuery(selectCustomer);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // verify the result set
        if (resultSet==null){
            System.out.println("No records found!!!");
            return isCustomerExist;
        }
        else {
            try {
                cachedRowSet.populate(resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        int count=0;
        int customer_id=0;
        while (true){
            try {
                if (!cachedRowSet.next()){
                    break;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                customer_id=cachedRowSet.getInt("customer_id");
                String customer_email=cachedRowSet.getString("email");
                String first_name=cachedRowSet.getString("first_name");
                System.out.println("customer_id="+customer_id+", email="+customer_email+", first_name="+first_name);
                count=cachedRowSet.getRow();
            }catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (count>=1){
            System.out.println("Customer count= "+count);
            isCustomerExist=true;
        }
        return isCustomerExist;
    }

    public boolean insertNewCategory(CategoryObject categoryObject, Connection connection){
        String categoryInsertQuery="insert into cc_CubeCart_category (cat_name,cat_desc,cat_parent_id," +
                "cat_image,per_ship,item_ship,item_int_ship,per_int_ship,hide,seo_meta_title,seo_meta_description," +
                "seo_meta_keywords,priority,status) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        //Create mysql insert with prepared statement
        PreparedStatement insertStatement= null;
        try {
            insertStatement = connection.prepareStatement(categoryInsertQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            insertStatement.setString(1,categoryObject.getCatName());
            insertStatement.setString(2,categoryObject.getCatDesc());
            insertStatement.setInt(3,categoryObject.getCatParentId());
            insertStatement.setInt(4,categoryObject.getCatImage());
            insertStatement.setDouble(5,categoryObject.getPerShip());
            insertStatement.setDouble(6,categoryObject.getItemShip());
            insertStatement.setDouble(7,categoryObject.getItemIntShip());
            insertStatement.setDouble(8,categoryObject.getPerIntShip());
            insertStatement.setInt(9,categoryObject.getHide());
            insertStatement.setString(10,categoryObject.getSeoMetaTitle());
            insertStatement.setString(11,categoryObject.getSeoMetaDescription());
            insertStatement.setString(12,categoryObject.getSeoMetaKeywords());
            insertStatement.setInt(13,categoryObject.getPriority());
            insertStatement.setInt(14,categoryObject.getStatus());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //execute the prepared statement
        int affectedRow= 0;
        try {
            affectedRow = insertStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(affectedRow+" rows affected.");
        if (affectedRow>=1)
            return true;
        else
            return false;
    }

    public boolean deleteNewCategory(String categoryName, Connection connection){
        String categoryDeleteQuery="delete from cc_CubeCart_category where cat_name=?)";
        //Create mysql insert with prepared statement
        PreparedStatement deleteStatement= null;
        try {
            deleteStatement = connection.prepareStatement(categoryDeleteQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            deleteStatement.setString(1,categoryName);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //execute the prepared statement
        int affectedRow= 0;
        try {
            affectedRow = deleteStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(affectedRow+" rows affected.");
        if (affectedRow>=1)
            return true;
        else
            return false;
    }
}
