/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpmm.bsirh.aarhd.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author dev
 */
@Entity
@Table( name = "colonne", schema = "aarhd"  )
@Getter
@Setter

@EqualsAndHashCode( of = "idColonne" )
public class Colonne implements Serializable
{

           @Id
           @GeneratedValue( strategy = GenerationType.IDENTITY)
           @Column( name = "id_colonne" )
           private int idColonne;

           @Column( name = "type" )
           private String typeColonne;

           @Override
           public String toString ()
           {
                      return typeColonne;
           }

}
