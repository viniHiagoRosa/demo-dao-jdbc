package application;

import db.dbException;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;

public class Program2 {
    public static void main(String[] args) {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("TEST 1 : findAll: ");
        List<Department> list;
        list = departmentDao.findAll();
        for(Department obj : list){
            System.out.println(obj);
        }
        System.out.println();

        System.out.println("TEST 2 : findById");
        Department department = departmentDao.findById(1);
        System.out.println(department);
        System.out.println();

        System.out.println("TEST 3 : insert department");
        Department newDepartment = new Department(null, "Fruits");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted department : " + newDepartment.getId());
        System.out.println();

        System.out.println("TEST 4 : update department");
        department = departmentDao.findById(1);
        if(department == null){
            throw new dbException("Não foi possível atualizar, departamento inexistente");
        }
        department.setName("Food");
        departmentDao.update(department);
        System.out.println("Update completed!");
        System.out.println();

        System.out.println("TEST 5 : delete department");
        departmentDao.deleteById(10);
        System.out.println("Delete completed!");
    }
}