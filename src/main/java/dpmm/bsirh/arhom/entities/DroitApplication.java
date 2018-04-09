package dpmm.bsirh.arhom.entities;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity( name = "DroitApplication")
@DiscriminatorValue( "APPLICATION")
public class DroitApplication extends Droit
{

}
