package pe.edu.usmp.java.servicio.usuario.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="Usuario")
@Table(name="USUARIO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUsuario")
    @SequenceGenerator(sequenceName = "SEQ_USUARIO", allocationSize = 1, name = "seqUsuario")
	@Column(name="ID_USUARIO", length = 6, nullable=false)
	private Integer id;	
	
	@Column(name="NOMBRES", length = 60, nullable=false)
	@NotEmpty
	private String nombres;
	
	@Column(name="APELLIDOS", length = 60, nullable=false)
	@NotEmpty
	private String apellidos;
	
	@Column(name="USUARIO", length = 60, nullable=false)
	@NotEmpty
	private String usuario;
	
	@Column(name="CONTRASENA", length = 60, nullable=false)
	@NotEmpty
	private String contrasena;
	
	@Column(name="CELULAR", length = 9, unique=true, nullable=false)	
	private Integer celular;
	
	@Column(name="ESTADO", length = 1, nullable=false)
	@NotEmpty
	private String estado;
	
}
