package dpmm.bsirh.arhom.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity( name = "DroitAge")
@DiscriminatorValue( "POP_AGE")
public class DroitAge extends Droit
{

}
