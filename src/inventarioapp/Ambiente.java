/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventarioapp;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Documentos
 */
@Entity
@Table(name = "ambiente", catalog = "inventario", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Ambiente.findAll", query = "SELECT a FROM Ambiente a"),
    @NamedQuery(name = "Ambiente.findById", query = "SELECT a FROM Ambiente a WHERE a.id = :id"),
    @NamedQuery(name = "Ambiente.findByNombre", query = "SELECT a FROM Ambiente a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Ambiente.findByResponsable", query = "SELECT a FROM Ambiente a WHERE a.responsable = :responsable")})
public class Ambiente implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "responsable")
    private String responsable;

    public Ambiente() {
    }

    public Ambiente(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        String oldResponsable = this.responsable;
        this.responsable = responsable;
        changeSupport.firePropertyChange("responsable", oldResponsable, responsable);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ambiente)) {
            return false;
        }
        Ambiente other = (Ambiente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventarioapp.Ambiente[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
