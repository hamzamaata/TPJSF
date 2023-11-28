package domaines;

import entities.Employee;
import entities.Service;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import service.EmployeService;
import service.ServiceService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class EmployeeBean {

    private EmployeService employeService; // Renommer ici
    private ServiceService serviceService;
    private List<Employee> allEmployees;
    private List<Service> allServices;
    private BarChartModel employeeByServiceModel;

    public EmployeeBean() {
        employeService = new EmployeService(); // Renommer ici
        serviceService = new ServiceService();
    }

    @PostConstruct
    public void init() {
        allEmployees = employeService.getAll(); // Renommer ici
        allServices = serviceService.getAll();
        createEmployeeByServiceModel();
    }

    public BarChartModel getEmployeeByServiceModel() {
        return employeeByServiceModel;
    }

    private void createEmployeeByServiceModel() {
        employeeByServiceModel = new BarChartModel();

        for (Service service : allServices) {
            ChartSeries series = new ChartSeries();
            series.setLabel(service.getLibelle());

            long employeeCount = allEmployees.stream()
                    .filter(employee -> employee.getService() != null && employee.getService().equals(service))
                    .count();

            series.set(service.getLibelle(), employeeCount);
            employeeByServiceModel.addSeries(series);
        }

        employeeByServiceModel.setTitle("Nombre d'employés par Service");
        employeeByServiceModel.setLegendPosition("ne");
    }

    // Ajoutez d'autres méthodes et propriétés si nécessaire
}