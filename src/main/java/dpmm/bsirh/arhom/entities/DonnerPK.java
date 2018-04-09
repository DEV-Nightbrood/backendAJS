package dpmm.bsirh.arhom.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DonnerPK implements Serializable
{

    @Column( name = "id_droit")
    private int droit;

    @Column( name="id_profil")
    private int profil;
}
