package com.fpt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Posted from Sep 11, 2018, 10:18 AM
 *
 * @author Vi Quynh (vi.quynh.31598@gmail.com)
 */
@Entity
@Table(name = "lop_hoc")
public class LopHoc {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ma_lop")
    private String maLop;

    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "trang_thai")
    private String trangThai;

    @ManyToOne
    @JoinColumn(name = "phong_hoc")
    private PhongHoc phongHoc;

    @Column(name = "ngay_hoc")
    private String ngayHoc;

    @Column(name = "ca_hoc")
    private String caHoc;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ngay_tao")
    private Date ngayTao;

    @Column(name = "ngay_bat_dau")
    private Date ngayBatDau;

    @Column(name = "ngay_ket_thuc")
    private Date ngayKetThuc;

    @ManyToOne
    @JoinColumn(name = "ma_giao_vien")
    private GiaoVien giaoVien;

    @ManyToOne
    @JoinColumn(name = "ma_mon_hoc")
    private MonHoc monHoc;

    @OneToMany(mappedBy = "lopHoc", fetch = FetchType.EAGER)
    private Set<ThongBao> lstThongBao;

    @OneToMany(mappedBy = "lopHoc", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<BaiTap> lstBaiTap;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "lop_sinhvien",
            joinColumns = { @JoinColumn(name = "ma_lop") },
            inverseJoinColumns = { @JoinColumn(name = "ma_sinh_vien") }
    )
    Set<SinhVien> sinhViens;

    @OneToMany(mappedBy = "lopHoc", fetch = FetchType.EAGER)
    private Set<BaiDang> lstBaiDang;

    @OneToMany(mappedBy = "lopHoc", fetch = FetchType.EAGER)
    private Set<Diem> lstDiem;

    @OneToMany(mappedBy = "lopHoc", fetch = FetchType.EAGER)
    private Set<TaiLieu> lstTaiLieu;

    public Set<Diem> getLstDiem() {
        return lstDiem;
    }

    public void setLstDiem(Set<Diem> lstDiem) {
        this.lstDiem = lstDiem;
    }

    public LopHoc() {
    }

    public Set<BaiTap> getLstBaiTap() {
        return lstBaiTap;
    }

    public void setLstBaiTap(Set<BaiTap> lstBaiTap) {
        this.lstBaiTap = lstBaiTap;
    }

    public String getNgayHoc() {
        return ngayHoc;
    }

    public void setNgayHoc(String ngayHoc) {
        this.ngayHoc = ngayHoc;
    }

    public String getCaHoc() {
        return caHoc;
    }

    public void setCaHoc(String caHoc) {
        this.caHoc = caHoc;
    }

    public GiaoVien getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(GiaoVien giaoVien) {
        this.giaoVien = giaoVien;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public Set<ThongBao> getLstThongBao() {
        return lstThongBao;
    }

    public void setLstThongBao(Set<ThongBao> lstThongBao) {
        this.lstThongBao = lstThongBao;
    }

    public Set<SinhVien> getSinhViens() {
        return sinhViens;
    }

    public void setSinhViens(Set<SinhVien> sinhViens) {
        this.sinhViens = sinhViens;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public PhongHoc getPhongHoc() {
        return phongHoc;
    }

    public void setPhongHoc(PhongHoc phongHoc) {
        this.phongHoc = phongHoc;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public Set<BaiDang> getLstBaiDang() {
        return lstBaiDang;
    }

    public void setLstBaiDang(Set<BaiDang> lstBaiDang) {
        this.lstBaiDang = lstBaiDang;
    }

    public Set<TaiLieu> getLstTaiLieu() {
        return lstTaiLieu;
    }

    public void setLstTaiLieu(Set<TaiLieu> lstTaiLieu) {
        this.lstTaiLieu = lstTaiLieu;
    }
}
