/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpmm.bsirh.aarhd.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author dev
 */
@Embeddable
@Data
public class MappingColonnePK implements Serializable
{

    @Column( name = "id_table")
    private Integer idTable;

    @Column( name = "id_colonne")
    private int idColonne;

    @Column( name = "nom_rhapsodie")
    private String nomRhapsodie;

    @Column( name = "nom_infohr")
    private String nomInfohr;

    @Column( name = "cluster")
    private Boolean cluster;
}
