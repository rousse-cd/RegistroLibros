package spring.edu.pe.modelo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "libros")
@XmlRootElement
// Utilizando Lombock
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor

@NamedQueries({
		@NamedQuery(name = "Libros.findAll", query = "SELECT l FROM Libros l"),
		@NamedQuery(name = "Libros.findByIdlibros", query = "SELECT l FROM Libros l WHERE l.idLibros = :idLibros"),
		@NamedQuery(name = "Libros.findByNombre", query = "SELECT l FROM Libros l WHERE l.nombre = :nombre"),
		@NamedQuery(name = "Libros.findByAutor", query = "SELECT l FROM Libros l WHERE l.autor = :autor"),
		@NamedQuery(name = "Libros.findByCategoria", query = "SELECT l FROM Libros l WHERE l.categoria = :categoria"),
		@NamedQuery(name = "Libros.findByEdicion", query = "SELECT l FROM Libros l WHERE l.edicion = :edicion"),
		@NamedQuery(name = "Libros.findByEditorial", query = "SELECT l FROM Libros l WHERE l.editorial = :editorial"),
		@NamedQuery(name = "Libros.findByImagen", query = "SELECT l FROM Libros l WHERE l.imagen = :imagen"),
		@NamedQuery(name = "Libros.findByFechaPublicacion", query = "SELECT l FROM Libros l WHERE l.fechaPublicacion = :fechaPublicacion"),
		@NamedQuery(name = "Libros.findByIdioma", query = "SELECT l FROM Libros l WHERE l.idioma = :idioma"),
		@NamedQuery(name = "Libros.findByFormato", query = "SELECT l FROM Libros l WHERE l.formato = :formato"),
		@NamedQuery(name = "Libros.findByPrecio", query = "SELECT l FROM Libros l WHERE l.precio = :precio")})
public class Libros implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	// @Column(name = "idFunciones")
	private Integer idLibros;

	@Basic(optional = false)
	@Column(name = "nombre")
	private String nombre;

	// @Basic(optional= false)
	@Column(name = "autor")
	private String autor;
	

	// @Basic(optional= false)
	@Column(name = "categoria")
	private String categoria;
	

	// @Basic(optional= false)
	@Column(name = "edicion")
	private String edicion;
	

	// @Basic(optional= false)
	@Column(name = "editorial")
	private String editorial;
	

	// @Basic(optional= false)
	@Column(name = "imagen")
	private String imagen;
	

	// @Basic(optional= false)
	@Column(name = "fechaPublicacion")
	private String fechaPublicacion;
	

	// @Basic(optional= false)
	@Column(name = "idioma")
	private String idioma;
	

	// @Basic(optional= false)
	@Column(name = "formato")
	private String formato;

	// @Basic(optional= false)
	@Column(name = "precio")
	private String precio;

	

}