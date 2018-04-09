package dpmm.bsirh.arhom.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author florent
 */
@Entity
@Table( name = "utilisateur", schema = "ARHOM")
@Data
@NoArgsConstructor
@EqualsAndHashCode( of = "identifiant")
public class Utilisateur implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)

    @Column( name = "id_utilisateur")
    //TODO Ajouter les Jsonproperty !
    private Integer idUtilisateur;

    @Column( name = "identifiant")
    private String identifiant;

    @Column( name = "password")
    private String password;


    @Column( name = "date_debut")
    @Temporal( TemporalType.DATE)
    @JsonbDateFormat("yyyy-mm-dd")
    private Date dateDebut;

    @Column( name = "date_fin")
    @Temporal( TemporalType.DATE)
    @Future(message = "La date de fin doit etre supérieur à celle d'aujourd'hui")
    @JsonbDateFormat("yyyy-mm-dd")
    private Date dateFin;
    @Min(50000)    
    @Column( name = "id_individu")
    private Integer idIndividu;
    @Column( name = "id_poste")
    @Min(50000)
    private Integer idPoste;
    @Column( name = "mail")
    private String mail;
    @JoinColumn( name = "id_profil", referencedColumnName = "id_profil")
    @ManyToOne( optional = false)
    private Profil idProfil;

}