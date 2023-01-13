package cahier.text.gestioncahierdetexte.entities;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class ParcoursSuivi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int enCours;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dateDebut;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dateFin;
	
	@ManyToOne
    @JoinColumn(name="inscription_id", nullable=false)
		private Inscription inscription;
	
	
	@ManyToOne
    @JoinColumn(name="parcours_id", nullable=false)
	private Parcours parcours;

	public ParcoursSuivi() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ParcoursSuivi(Long id, int enCours, Date dateDebut, Date dateFin, Inscription inscription,
			Parcours parcours) {
		super();
		this.id = id;
		this.enCours = enCours;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.inscription = inscription;
		this.parcours = parcours;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getEnCours() {
		return enCours;
	}


	public void setEnCours(int enCours) {
		this.enCours = enCours;
	}


	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public Date getDateFin() {
		return dateFin;
	}


	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}


	public Inscription getInscription() {
		return inscription;
	}


	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}


	public Parcours getParcours() {
		return parcours;
	}


	public void setParcours(Parcours parcours) {
		this.parcours = parcours;
	}


	
}