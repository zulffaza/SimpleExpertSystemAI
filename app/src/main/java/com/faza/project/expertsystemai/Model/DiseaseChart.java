package com.faza.project.expertsystemai.Model;

import java.util.ArrayList;

/**
 * Dibuat oleh Faza Zulfika Permana Putra
 * Tanggal 9 Mei 2017
 */

public class DiseaseChart extends SymptomsChart {
    private ArrayList<Integer> subBagan;

    public DiseaseChart() {
        this(null);
    }

    public DiseaseChart(String name) {
        this(name, null);
    }

    public DiseaseChart(String name, String question) {
        super(name, question);

        subBagan = new ArrayList<>();
    }

    public ArrayList<Integer> getSubBagan() {
        return subBagan;
    }

    public void setSubBagan(ArrayList<Integer> subBagan) {
        this.subBagan = subBagan;
    }
}