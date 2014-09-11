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
@Table(name = "bien", catalog = "inventario", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Bien.findAll", query = "SELECT b FROM Bien b"),
    @NamedQuery(name = "Bien.findById", query = "SELECT b FROM Bien b WHERE b.id = :id"),
    @NamedQuery(name = "Bien.findByNombre", query = "SELECT b FROM Bien b WHERE b.nombre = :nombre"),
    @NamedQuery(name = "Bien.findByDetalle", query = "SELECT b FROM Bien b WHERE b.detalle = :detalle"),
    @NamedQuery(name = "Bien.findByFotos", query = "SELECT b FROM Bien b WHERE b.fotos = :fotos"),
    @NamedQuery(name = "Bien.findByEstado", query = "SELECT b FROM Bien b WHERE b.estado = :estado"),
    @NamedQuery(name = "Bien.findByPrecio", query = "SELECT b FROM Bien b WHERE b.precio = :precio"),
    @NamedQuery(name = "Bien.findByClaseId", query = "SELECT b FROM Bien b WHERE b.claseId = :claseId"),
    @NamedQuery(name = "Bien.findByAmbienteId", query = "SELECT b FROM Bien b WHERE b.ambienteId = :ambienteId"),
    @NamedQuery(name = "Bien.findByCodigoId", query = "SELECT b FROM Bien b WHERE b.codigoId = :codigoId"),
    @NamedQuery(name = "Bien.findByPeriodoId", query = "SELECT b FROM Bien b WHERE b.periodoId = :periodoId")})
public class Bien implements Serializable {
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
    @Column(name = "detalle")
    private String detalle;
    @Column(name = "fotos")
    private String fotos;
    @Column(name = "estado")
    private String estado;
    @Column(name = "precio")
    private Integer precio;
    @Basic(optional = false)
    @Column(name = "clase_id")
    private int claseId;
    @Basic(optional = false)
    @Column(name = "ambiente_id")
    private int ambienteId;
    @Basic(optional = false)
    @Column(name = "codigo_id")
    private int codigoId;
    @Basic(optional = false)
    @Column(name = "periodo_id")
    private int periodoId;

    public Bien() {
    }

    public Bien(Integer id) {
        this.id = id;
    }

    public Bien(Integer id, int claseId, int ambienteId, int codigoId, int periodoId) {
        this.id = id;
        this.claseId = claseId;
        this.ambienteId = ambienteId;
        this.codigoId = codigoId;
        this.periodoId = periodoId;
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

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        String oldDetalle = this.detalle;
        this.detalle = detalle;
        changeSupport.firePropertyChange("detalle", oldDetalle, detalle);
    }

    public String getFotos() {
        return fotos;
    }

    public void setFotos(String fotos) {
        String oldFotos = this.fotos;
        this.fotos = fotos;
        changeSupport.firePropertyChange("fotos", oldFotos, fotos);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        String oldEstado = this.estado;
        this.estado = estado;
        changeSupport.firePropertyChange("estado", oldEstado, estado);
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        Integer oldPrecio = this.precio;
        this.precio = precio;
        changeSupport.firePropertyChange("precio", oldPrecio, precio);
    }

    public int getClaseId() {
        return claseId;
    }

    public void setClaseId(int claseId) {
        int oldClaseId = this.claseId;
        this.claseId = claseId;
        changeSupport.firePropertyChange("claseId", oldClaseId, claseId);
    }

    public int getAmbienteId() {
        return ambienteId;
    }

    public void setAmbienteId(int ambienteId) {
        int oldAmbienteId = this.ambienteId;
        this.ambienteId = ambienteId;
        changeSupport.firePropertyChange("ambienteId", oldAmbienteId, ambienteId);
    }

    public int getCodigoId() {
        return codigoId;
    }

    public void setCodigoId(int codigoId) {
        int oldCodigoId = this.codigoId;
        this.codigoId = codigoId;
        changeSupport.firePropertyChange("codigoId", oldCodigoId, codigoId);
    }

    public int getPeriodoId() {
        return periodoId;
    }

    public void setPeriodoId(int periodoId) {
        int oldPeriodoId = this.periodoId;
        this.periodoId = periodoId;
        changeSupport.firePropertyChange("periodoId", oldPeriodoId, periodoId);
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
        if (!(object instanceof Bien)) {
            return false;
        }
        Bien other = (Bien) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventarioapp.Bien[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
