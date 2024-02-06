package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.SellerDao;
import db.DB;
import entities.Department;
import entities.Seller;

public class SellerDaoJDBC implements SellerDao {

    private Connection conn;
    public SellerDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Seller obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public void update(Seller obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement st=null;
        ResultSet rs=null;
        try{
            st=conn.prepareStatement(
                "SELECT seller.*,department.Name as DepName"
                + "FROM seller INNER JOIN department"
                + "ON seller.DepartmentId = department.Id"
                +"WHERE seller.Id = ?");
                st.setInt(1, id);
                rs=st.executeQuery();
                if( rs.next()){
                    Department dep = instantiateDepartment(rs);
                    Seller obj = instantiateSeller(rs, dep);

                    
                    return obj;
                }
                return null;
        } catch (SQLException e){
            e.getSQLState();

        }
        finally {
           DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
        return null;
    }

    private Seller instantiateSeller(ResultSet st, Department dep) throws SQLException {
        new Seller();
            Seller obj = new Seller();
                    obj.setId(st.getInt("Id"));
                    obj.setName(st.getString("Name"));
                    obj.setEmail (st.getString("Email"));
                    obj.setBaseSalary(st.getDouble("BaseSalary"));
                    obj.setBirthDate (st.getDate("BirthDate"));
                    obj.setDepartment(dep);
                    return (obj);
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep= new Department();
        dep.setId(rs.getInt("DepartmentId"));
        dep.setName(rs.getString("DepName"));

        return dep;
    }

    @Override
    public List<Seller> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public List<Seller> findByDepartment(Department department) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByDepartment'");
    }
    
}
