/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String photo; // Le chemin ou la représentation de la photo peut être stocké ici

    @ManyToOne
    private Employee manager; // Le chef de l'employé

    @ManyToOne
    private Service service; // Le service auquel l'employé appartient

    // Constructeurs, getters et setters

    public Employee() {
    }

    public Employee(String firstName, String lastName, Date dateOfBirth, String photo, Employee manager, Service service) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.photo = photo;
        this.manager = manager;
        this.service = service;
    }

    // Autres méthodes si nécessaires

    public Object getService() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}