package dpmm.bsirh.arhom.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author florent
 */
@Entity
@Table( name = "droit" , schema = "ARHOM" )
@Inheritance( strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn( name = "type", discriminatorType = DiscriminatorType.STRING, length = 30 )
@Data
@NoArgsConstructor
@EqualsAndHashCode( of = "idDroit")
public abstract class Droit implements Serializable
{

    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id_droit")
    @Id
    private Integer idDroit;


    @Column( name = "description")
    private String description;

    @Column( name = "type",updatable = false,insertable = false)
    protected String type ;



}