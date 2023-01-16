package cahier.text.gestioncahierdetexte.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Inscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	private Date dateInscription;

	@ManyToOne
    @JoinColumn(name="etudiant_id", nullable=false)
	private Etudiant etudiant;
	
	

	
	@ManyToOne
    @JoinColumn(name="cohorte_id", nullable=false)
	private Cohorte cohorte;

	@ManyToOne
    @JoinColumn(name="goupe_id", nullable=false)
	private Groupe groupe;
	
	public Inscription() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	public Inscription(long id, Date dateInscription, Etudiant etudiant,
			Cohorte cohorte, Groupe groupe) {
		super();
		this.id = id;
		this.dateInscription = dateInscription;
		this.etudiant = etudiant;
		this.cohorte = cohorte;
		this.groupe = groupe;
	}




	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}











	public Cohorte getCohorte() {
		return cohorte;
	}



	public void setCohorte(Cohorte cohorte) {
		this.cohorte = cohorte;
	}



	public Groupe getGroupe() {
		return groupe;
	}



	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}



	
}