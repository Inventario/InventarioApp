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
@Table(name = "codigo", catalog = "inventario", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Codigo.findAll", query = "SELECT c FROM Codigo c"),
    @NamedQuery(name = "Codigo.findById", query = "SELECT c FROM Codigo c WHERE c.id = :id"),
    @NamedQuery(name = "Codigo.findByCodigo", query = "SELECT c FROM Codigo c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Codigo.findBySerie", query = "SELECT c FROM Codigo c WHERE c.serie = :serie")})
public class Codigo implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "serie")
    private String serie;

    public Codigo() {
    }

    public Codigo(Integer id) {
        this.id = id;
    }

    public Codigo(Integer id, String codigo) {
        this.id = id;
        this.codigo = codigo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        String oldCodigo = this.codigo;
        this.codigo = codigo;
        changeSupport.firePropertyChange("codigo", oldCodigo, codigo);
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        String oldSerie = this.serie;
        this.serie = serie;
        changeSupport.firePropertyChange("serie", oldSerie, serie);
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
        if (!(object instanceof Codigo)) {
            return false;
        }
        Codigo other = (Codigo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventarioapp.Codigo[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
