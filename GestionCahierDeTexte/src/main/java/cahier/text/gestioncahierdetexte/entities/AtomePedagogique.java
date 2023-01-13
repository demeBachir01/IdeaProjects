package cahier.text.gestioncahierdetexte.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class AtomePedagogique {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String libelle;
	private int volumeHoraire;

	private Integer nbreHeureEffectue;
	private Integer nbreHeureRestant;
	
	@ManyToOne
    @JoinColumn(name="ec_id", nullable=false)
	private EC ec;
	@ManyToOne
	private SeanceCours seanceCours;



	

}