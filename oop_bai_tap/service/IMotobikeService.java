package oop_bai_tap.service;

import oop_bai_tap.entity.Motobike;

import java.util.List;

public interface IMotobikeService {
    void  addMotobike(Motobike motobike);
    List<Motobike> getListMotobike();
}
