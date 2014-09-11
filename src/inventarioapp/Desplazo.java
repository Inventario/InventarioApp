/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventarioapp;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Documentos
 */
@Entity
@Table(name = "desplazo", catalog = "inventario", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Desplazo.findAll", query = "SELECT d FROM Desplazo d"),
    @NamedQuery(name = "Desplazo.findById", query = "SELECT d FROM Desplazo d WHERE d.id = :id"),
    @NamedQuery(name = "Desplazo.findByFecha", query = "SELECT d FROM Desplazo d WHERE d.fecha = :fecha"),
    @NamedQuery(name = "Desplazo.findByDetalle", query = "SELECT d FROM Desplazo d WHERE d.detalle = :detalle"),
    @NamedQuery(name = "Desplazo.findByBienId", query = "SELECT d FROM Desplazo d WHERE d.bienId = :bienId"),
    @NamedQuery(name = "Desplazo.findByAmbienteorigenId", query = "SELECT d FROM Desplazo d WHERE d.ambienteorigenId = :ambienteorigenId"),
    @NamedQuery(name = "Desplazo.findByAmbientedestinoId", query = "SELECT d FROM Desplazo d WHERE d.ambientedestinoId = :ambientedestinoId")})
public class Desplazo implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "detalle")
    private String detalle;
    @Basic(optional = false)
    @Column(name = "bien_id")
    private int bienId;
    @Basic(optional = false)
    @Column(name = "ambienteorigen_id")
    private int ambienteorigenId;
    @Basic(optional = false)
    @Column(name = "ambientedestino_id")
    private int ambientedestinoId;

    public Desplazo() {
    }

    public Desplazo(Integer id) {
        this.id = id;
    }

    public Desplazo(Integer id, Date fecha, int bienId, int ambienteorigenId, int ambientedestinoId) {
        this.id = id;
        this.fecha = fecha;
        this.bienId = bienId;
        this.ambienteorigenId = ambienteorigenId;
        this.ambientedestinoId = ambientedestinoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        Date oldFecha = this.fecha;
        this.fecha = fecha;
        changeSupport.firePropertyChange("fecha", oldFecha, fecha);
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        String oldDetalle = this.detalle;
        this.detalle = detalle;
        changeSupport.firePropertyChange("detalle", oldDetalle, detalle);
    }

    public int getBienId() {
        return bienId;
    }

    public void setBienId(int bienId) {
        int oldBienId = this.bienId;
        this.bienId = bienId;
        changeSupport.firePropertyChange("bienId", oldBienId, bienId);
    }

    public int getAmbienteorigenId() {
        return ambienteorigenId;
    }

    public void setAmbienteorigenId(int ambienteorigenId) {
        int oldAmbienteorigenId = this.ambienteorigenId;
        this.ambienteorigenId = ambienteorigenId;
        changeSupport.firePropertyChange("ambienteorigenId", oldAmbienteorigenId, ambienteorigenId);
    }

    public int getAmbientedestinoId() {
        return ambientedestinoId;
    }

    public void setAmbientedestinoId(int ambientedestinoId) {
        int oldAmbientedestinoId = this.ambientedestinoId;
        this.ambientedestinoId = ambientedestinoId;
        changeSupport.firePropertyChange("ambientedestinoId", oldAmbientedestinoId, ambientedestinoId);
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
        if (!(object instanceof Desplazo)) {
            return false;
        }
        Desplazo other = (Desplazo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventarioapp.Desplazo[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
