/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpmm.bsirh.aarhd.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author dev
 */
@Entity
@Table( name = "mapping_colonne", schema = "aarhd"  )
@Getter
@Setter
@ToString( of =
{
         "PK"
} )

@EqualsAndHashCode( of = "order" )
public class MappingColonne implements Serializable
{

        @EmbeddedId
        private MappingColonnePK PK;

           @Column( name = "ordre" )
           private int order;

}
