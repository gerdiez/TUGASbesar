/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Gerdi.latihan.latihanmvcjdbc.event;

import edu.Gerdi.latihan.latihanmvcjdbc.entity.Pelanggan;
import edu.Gerdi.latihan.latihanmvcjdbc.model.PelangganModel;

/**
 *
 * @author Esa
 */
public interface PelangganListener {

    public void onChange(PelangganModel model);

    public void onInsert(Pelanggan pelanggan);

    public void onDelete();

    public void onUpdate(Pelanggan pelanggan);
}
