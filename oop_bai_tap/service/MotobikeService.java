package oop_bai_tap.service;

import oop_bai_tap.entity.Motobike;
import oop_bai_tap.repository.MotobikeRepository;

import java.util.List;

public class MotobikeService implements IMotobikeService {

    MotobikeRepository motobikeRepository = new MotobikeRepository();
    @Override
    public void addMotobike(Motobike motobike) {
        motobikeRepository.addMotobike(motobike);
    }

    @Override
    public List<Motobike> getListMotobike() {
        return motobikeRepository.getListMotobike();
    }
}
