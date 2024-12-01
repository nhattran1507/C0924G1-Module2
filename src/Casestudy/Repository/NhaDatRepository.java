package Casestudy.Repository;

import Casestudy.Model.NhaDat;

import java.util.ArrayList;
import java.util.List;

public class NhaDatRepository {
    private List<NhaDat> nhaDats = new ArrayList<>();

    public void save(NhaDat nhaDat) {
        nhaDats.add(nhaDat);
    }

    public List<NhaDat> findAll() {
        return nhaDats;
    }
}
