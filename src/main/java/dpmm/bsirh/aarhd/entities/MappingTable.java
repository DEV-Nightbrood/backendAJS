/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpmm.bsirh.aarhd.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author dev
 */
@Entity
@Table( name = "mapping_table", schema = "aarhd" )
@Data
@ToString( of=
          {
                     "nomInfohr"
          })

@EqualsAndHashCode( of = "idTable")
public class MappingTable implements Serializable
{
           @Id
               @GeneratedValue( strategy = GenerationType.IDENTITY)
           @Column( name="id_table")
                     private int idTable;
           
           
           @Column( name="nom_rhapsodie")
           private String nomRhapsodie;
           
           @Column( name="nom_infohr")
           private String nomInfohr;
           
           
                     }
