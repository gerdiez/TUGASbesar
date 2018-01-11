/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Gerdi.latihan.latihanmvcjdbc.controller;

import edu.Gerdi.latihan.latihanmvcjdbc.model.PelangganModel;
import edu.Gerdi.latihan.latihanmvcjdbc.view.PelangganView;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Esa
 */
public class PelangganController {

    private PelangganModel model;

    public void setModel(PelangganModel model) {
        this.model = model;
    }

    public void resetPelanggan(PelangganView view) {
        model.resetPelanggan();
    }

    public void insertPelanggan(PelangganView view) {
        String nama = view.getTxtNama().getText();
        String alamat = view.getTxtAlamat().getText();
        String telepon = view.getTxtTelepon().getText();
        String email = view.getTxtEmail().getText();

        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh kosong");
        } else if (nama.length() > 255) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh lebih dari 255 huruf");
        } else if (telepon.length() > 12) {
            JOptionPane.showMessageDialog(view, "Nomor telepon tidak boleh lebih dari 12 digit");
        } else if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(view, "Email tidak valid");
        } else {

            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);

            try {
                model.insertPelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan berhasil ditambahkan!");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi eror di database dengan pesan", throwable.getMessage()});
            }
        }
    }

    public void updatePelanggan(PelangganView view) {

        if (view.getTablePelanggan().getSelectedColumn() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan pilih baris data yang akan diubah");
            return;
        }

        Integer Id = Integer.parseInt(view.getTxtId().getText());

        String nama = view.getTxtNama().getText();
        String alamat = view.getTxtAlamat().getText();
        String telepon = view.getTxtTelepon().getText();
        String email = view.getTxtEmail().getText();

        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh kosong");
        } else if (nama.length() > 255) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh lebih dari 255 huruf");
        } else if (telepon.length() > 12) {
            JOptionPane.showMessageDialog(view, "Nomor telepon tidak boleh lebih dari 12 digit");
        } else if (email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(view, "Email tidak valid");
        } else {
            model.setId(Id);
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);

            try {
                model.updatePelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan berhasil di ubah!");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi eror di database dengan pesan", throwable.getMessage()});
            }
        }
    }

    public void deletePelanggan(PelangganView view) {
        if (view.getTablePelanggan().getSelectedColumn() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan pilih baris data yang akan di hapus");
            return;
        }
        if (JOptionPane.showConfirmDialog(view, "anda yakin ingin menghapusnya?") == JOptionPane.OK_OPTION) {
            Integer id = Integer.parseInt(view.getTxtId().getText());
            model.setId(id);

            try {
                model.deletePelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan berhasil di hapus!");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi eror di database dengan pesan", throwable.getMessage()});
            }
        }
    }
}
