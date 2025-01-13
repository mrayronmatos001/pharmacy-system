package br.edu.ufrn.services;

import java.util.List;

import br.edu.ufrn.models.Medication;
import br.edu.ufrn.repository.MedicationDao;

public class MedicationService {

    private MedicationDao medicationDao;

    public MedicationService() {
        this.medicationDao = new MedicationDao();
    }

    public Medication getMedicationById(Long id) {
        return medicationDao.findById(id);
    }

    public List<Medication> getAll() {
        return medicationDao.findAll();
    }

    public boolean save(Medication medication) {
        return medicationDao.save(medication);
    }

    public boolean update(Medication medication, String[] params) {
        return medicationDao.update(medication, params);
    }

    public boolean delete(Long id) {
        return medicationDao.delete(id);
    }
}
