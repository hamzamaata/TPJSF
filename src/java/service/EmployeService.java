/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Employee;
import entities.Service;
import java.util.List;

public class EmployeService extends AbstractFacade<Employee> {

    @Override
    protected Class<Employee> getEntityClass() {
        return Employee.class;
    }

    // Ajoutez des méthodes spécifiques à EmployeeService si nécessaire

    public List<Employee> getEmployeesByService(Service selectedService) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Employee getServiceChief(Service selectedService) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
