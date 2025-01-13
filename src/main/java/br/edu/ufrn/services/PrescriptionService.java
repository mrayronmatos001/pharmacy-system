package br.edu.ufrn.services;

import java.util.List;

import br.edu.ufrn.models.Prescription;
import br.edu.ufrn.repository.PrescriptionDao;

public class PrescriptionService {

    private PrescriptionDao prescriptionDao;

    public PrescriptionService() {
        this.prescriptionDao = new PrescriptionDao();
    }

    public Prescription getPrescriptionById(Long id) {
        return prescriptionDao.findById(id);
    }

    public List<Prescription> getAll() {
        return prescriptionDao.findAll();
    }

    public boolean save(Prescription prescription) {
        return prescriptionDao.save(prescription);
    }

    public boolean update(Prescription prescription, String[] params) {
        return prescriptionDao.update(prescription, params);
    }

    public boolean delete(Long id) {
        return prescriptionDao.delete(id);
    }
}