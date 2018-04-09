package dpmm.bsirh.arhom.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table( name = "donner", schema = "arhom")
@ToString( of = "PK")
public class Donner implements Serializable {
    @EmbeddedId
    private DonnerPK PK;

     @ManyToOne
     @JoinColumn( name = "id_profil" , updatable = false, insertable = false )
   private Profil profil;

    @ManyToOne
    @JoinColumn( name = "id_droit" , updatable = false, insertable = false )
    private Droit droit;


}
