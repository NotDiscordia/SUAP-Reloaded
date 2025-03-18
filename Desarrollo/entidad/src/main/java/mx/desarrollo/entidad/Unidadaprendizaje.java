/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.entidad;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "unidadaprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidadaprendizaje.findAll", query = "SELECT u FROM Unidadaprendizaje u")
    , @NamedQuery(name = "Unidadaprendizaje.findByClaveUA", query = "SELECT u FROM Unidadaprendizaje u WHERE u.claveUA = :claveUA")
    , @NamedQuery(name = "Unidadaprendizaje.findByNombreUA", query = "SELECT u FROM Unidadaprendizaje u WHERE u.nombreUA = :nombreUA")
    , @NamedQuery(name = "Unidadaprendizaje.findByHorasClase", query = "SELECT u FROM Unidadaprendizaje u WHERE u.horasClase = :horasClase")
    , @NamedQuery(name = "Unidadaprendizaje.findByHorasTaller", query = "SELECT u FROM Unidadaprendizaje u WHERE u.horasTaller = :horasTaller")
    , @NamedQuery(name = "Unidadaprendizaje.findByHorasLaboratorio", query = "SELECT u FROM Unidadaprendizaje u WHERE u.horasLaboratorio = :horasLaboratorio")})
public class Unidadaprendizaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "claveUA")
    private Integer claveUA;
    @Basic(optional = false)
    @Column(name = "nombreUA")
    private String nombreUA;
    @Basic(optional = false)
    @Column(name = "horasClase")
    private int horasClase;
    @Basic(optional = false)
    @Column(name = "horasTaller")
    private int horasTaller;
    @Basic(optional = false)
    @Column(name = "horasLaboratorio")
    private int horasLaboratorio;
    @ManyToMany(mappedBy = "unidadaprendizajeCollection")
    private Collection<Profesor> profesorCollection;

    public Unidadaprendizaje() {
    }

    public Unidadaprendizaje(Integer claveUA) {
        this.claveUA = claveUA;
    }

    public Unidadaprendizaje(Integer claveUA, String nombreUA, int horasClase, int horasTaller, int horasLaboratorio) {
        this.claveUA = claveUA;
        this.nombreUA = nombreUA;
        this.horasClase = horasClase;
        this.horasTaller = horasTaller;
        this.horasLaboratorio = horasLaboratorio;
    }

    public Integer getClaveUA() {
        return claveUA;
    }

    public void setClaveUA(Integer claveUA) {
        this.claveUA = claveUA;
    }

    public String getNombreUA() {
        return nombreUA;
    }

    public void setNombreUA(String nombreUA) {
        this.nombreUA = nombreUA;
    }

    public int getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(int horasClase) {
        this.horasClase = horasClase;
    }

    public int getHorasTaller() {
        return horasTaller;
    }

    public void setHorasTaller(int horasTaller) {
        this.horasTaller = horasTaller;
    }

    public int getHorasLaboratorio() {
        return horasLaboratorio;
    }

    public void setHorasLaboratorio(int horasLaboratorio) {
        this.horasLaboratorio = horasLaboratorio;
    }

    @XmlTransient
    public Collection<Profesor> getProfesorCollection() {
        return profesorCollection;
    }

    public void setProfesorCollection(Collection<Profesor> profesorCollection) {
        this.profesorCollection = profesorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (claveUA != null ? claveUA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidadaprendizaje)) {
            return false;
        }
        Unidadaprendizaje other = (Unidadaprendizaje) object;
        if ((this.claveUA == null && other.claveUA != null) || (this.claveUA != null && !this.claveUA.equals(other.claveUA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.desarrollo.entidad.Unidadaprendizaje[ claveUA=" + claveUA + " ]";
    }
    
}
