package com.psl.api.dao;

import com.psl.api.bean.InventoryDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("inventoryDetailsDao")
public class InventoryDetailsDaoImpl extends JdbcDaoSupport implements InventoryDetailsDao {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void initialiaze() {
        this.setDataSource(dataSource);
    }

    String sql;

    @Override
    public List<InventoryDetails> getAllInventoryDetails() {
        sql = "SELECT * FROM inventory_details";
        try {
            return this.getJdbcTemplate().query(sql, new RowMapper<InventoryDetails>() {

                @Override
                public InventoryDetails mapRow(ResultSet resultSet, int row) throws SQLException {
                    InventoryDetails inventoryDetails = new InventoryDetails();
                    inventoryDetails.setInventoryId(resultSet.getInt("inventory_id"));
                    inventoryDetails.setCategoryId(resultSet.getInt("category_id"));
                    inventoryDetails.setExpiryDate(resultSet.getDate("expiry_date"));
                    inventoryDetails.setManufacturingDate(resultSet.getDate("mgf_date"));
                    inventoryDetails.setProductId(resultSet.getInt("product_id"));
                    inventoryDetails.setQuantity(resultSet.getInt("quantity"));
                    inventoryDetails.setUnitPrice(resultSet.getDouble("unit_price"));
                    return inventoryDetails;
                }
            });
        }catch(EmptyResultDataAccessException e)
        {
            return null;
        }
    }

    @Override
    public InventoryDetails addInventoryDetails(InventoryDetails inventoryDetails) {
        sql = "INSERT INTO inventory_details(category_id, expiry_date, mfg_date, product_id, quantity, unit_price) VALUES ( " + inventoryDetails.getCategoryId() + "," + inventoryDetails.getExpiryDate() + "," + inventoryDetails.getManufacturingDate() + ","+ inventoryDetails.getProductId() + "," + inventoryDetails.getQuantity() + "," + inventoryDetails.getUnitPrice() + " )";
        this.getJdbcTemplate().update(sql);
        return inventoryDetails;
    }

    @Override
    public InventoryDetails updateInventoryDetails(InventoryDetails inventoryDetails) {
        sql = "UPDATE inventory_details SET mfg_date = " + inventoryDetails.getManufacturingDate() + ", expiry_date = " + inventoryDetails.getExpiryDate() + ", category_id = " + inventoryDetails.getCategoryId() + ", product_id = " + inventoryDetails.getProductId() + ", quantity = " + inventoryDetails.getQuantity() + ", unit_price = " + inventoryDetails.getUnitPrice() +" WHERE inventory_id = " + inventoryDetails.getInventoryId();
        boolean isUpdated = this.getJdbcTemplate().update(sql) == 1 ? true : false;
        if(isUpdated)
            return inventoryDetails;
        else
            return null;
    }

    @Override
    public InventoryDetails getInventoryDetailsById(int inventoryId) {

        sql = "SELECT * FROM inventory_details WHERE inventory_id = " + inventoryId;
        try {

            return this.getJdbcTemplate().queryForObject(sql, new RowMapper<InventoryDetails>() {

                @Override
                public InventoryDetails mapRow(ResultSet resultSet, int row) throws SQLException {
                    InventoryDetails inventoryDetails = new InventoryDetails();
                    inventoryDetails.setInventoryId(resultSet.getInt("inventory_id"));
                    inventoryDetails.setCategoryId(resultSet.getInt("category_id"));
                    inventoryDetails.setExpiryDate(resultSet.getDate("expiry_date"));
                    inventoryDetails.setManufacturingDate(resultSet.getDate("mgf_date"));
                    inventoryDetails.setProductId(resultSet.getInt("product_id"));
                    inventoryDetails.setQuantity(resultSet.getInt("quantity"));
                    inventoryDetails.setUnitPrice(resultSet.getDouble("unit_price"));
                    return inventoryDetails;
                }
            });
        }catch(EmptyResultDataAccessException e)
        {
            return null;
        }
    }


    @Override
    public boolean deleteInventoryDetailsById(int inventoryId) {
        sql = "DELETE FROM inventory_details WHERE inventory_id = " + inventoryId;
        boolean isDeleted = this.getJdbcTemplate().update(sql) == 1 ? true : false;
        return isDeleted;
    }
}
