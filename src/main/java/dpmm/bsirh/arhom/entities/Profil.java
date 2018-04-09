package dpmm.bsirh.arhom.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author florent
 */
@Entity
@Table( name = "profil", schema = "ARHOM")
@NoArgsConstructor
@EqualsAndHashCode( of = "idProfil")
@ToString( of = {"idProfil","nom","type"})
@Data
public class Profil implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id_profil")
    private Integer idProfil;
    @Column( name = "nom")
    private String nom;
    @Column( name = "type")
    private String type;

    @OneToMany( mappedBy = "idProfil", fetch = FetchType.LAZY)
    private List<Utilisateur> utilisateurList;

    @OneToMany( mappedBy = "profil", fetch = FetchType.LAZY)
    private List<Donner> listDonner;



}
