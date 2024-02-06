package dao;
import dao.impl.SellerDaoJDBC;
import db.DB;
import dao.impl.DepartmentDaoJDBC;

public class Factory {
    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC( DB.getConnection());
            

    }

    public static DepartmentDao createDepartmentDao(){
        return new DepartmentDaoJDBC(DB.getConnection());

    }
}
