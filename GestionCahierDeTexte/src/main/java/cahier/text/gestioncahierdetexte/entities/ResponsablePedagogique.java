package cahier.text.gestioncahierdetexte.entities;


import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@PrimaryKeyJoinColumn( name = "id" )
public class ResponsablePedagogique extends Individu {
	

	@JsonIgnore
	@OneToMany(mappedBy="rp")
    private Collection<EstResponsableP> estRPs;
	
	
	public Collection<EstResponsableP> getEstRPs() {
		return estRPs;
	}

	public void setEstRPs(Collection<EstResponsableP> estRPs) {
		this.estRPs = estRPs;
	}

	public ResponsablePedagogique() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponsablePedagogique(long id, String nom, String prenom, int tel) {
		super(id, nom, prenom, tel);
		// TODO Auto-generated constructor stub
	}

	public ResponsablePedagogique(Collection<EstResponsableP> estRPs) {
		super();
		this.estRPs = estRPs;
	}

	
}