package Entity;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jordan Ramirez
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByClaveSku", query = "SELECT p FROM Producto p WHERE p.claveSku = :claveSku"),
    @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Producto.findByPrecio", query = "SELECT p FROM Producto p WHERE p.precio = :precio"),
    @NamedQuery(name = "Producto.findByCantidadExistente", query = "SELECT p FROM Producto p WHERE p.cantidadExistente = :cantidadExistente"),
    @NamedQuery(name = "Producto.findByProveedor", query = "SELECT p FROM Producto p WHERE p.proveedor = :proveedor")})
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    //Se agrega libreria para no generar conflicto con clave-sku que es autoincremental
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "clave_sku")
    private Integer claveSku;
    @Size(max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 30)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 30)
    @Column(name = "precio")
    private String precio;
    @Size(max = 30)
    @Column(name = "cantidad_existente")
    private String cantidadExistente;
    @Size(max = 30)
    @Column(name = "proveedor")
    private String proveedor;

    public Producto() {
    }

    public Producto(Integer claveSku) {
        this.claveSku = claveSku;
    }

    public Integer getClaveSku() {
        return claveSku;
    }

    public void setClaveSku(Integer claveSku) {
        this.claveSku = claveSku;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCantidadExistente() {
        return cantidadExistente;
    }

    public void setCantidadExistente(String cantidadExistente) {
        this.cantidadExistente = cantidadExistente;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (claveSku != null ? claveSku.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.claveSku == null && other.claveSku != null) || (this.claveSku != null && !this.claveSku.equals(other.claveSku))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Producto[ claveSku=" + claveSku + " ]";
    }
    
}
