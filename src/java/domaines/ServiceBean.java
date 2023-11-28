/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domaines;

import entities.Employee;
import entities.Service;
import service.ServiceService;
import service.EmployeService;  // Changement ici

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class ServiceBean {

    private Service selectedService;
    private List<Employee> employeesForSelectedService;
    private Employee serviceChief;
    private ServiceService serviceService;
    private EmployeService employeService;  // Changement ici

    public ServiceBean() {
        serviceService = new ServiceService();
        employeService = new EmployeService();  // Changement ici
    }

    public Service getSelectedService() {
        return selectedService;
    }

    public void setSelectedService(Service selectedService) {
        this.selectedService = selectedService;
    }

    public List<Employee> getEmployeesForSelectedService() {
        return employeesForSelectedService;
    }

    public void setEmployeesForSelectedService(List<Employee> employeesForSelectedService) {
        this.employeesForSelectedService = employeesForSelectedService;
    }

    public Employee getServiceChief() {
        return serviceChief;
    }

    public void setServiceChief(Employee serviceChief) {
        this.serviceChief = serviceChief;
    }

    public void onServiceChange() {
        if (selectedService != null) {
            employeesForSelectedService = employeService.getEmployeesByService(selectedService);  // Changement ici
            serviceChief = employeService.getServiceChief(selectedService);  // Changement ici
        } else {
            employeesForSelectedService = null;
            serviceChief = null;
        }
    }

    public void onCreateAction() {
        serviceService.create(selectedService);
        selectedService = new Service();
    }

    public List<Service> getServices() {
        return serviceService.getAll();
    }

    // Reste de votre classe...
}