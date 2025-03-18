package com.example.demo.service;

import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    public List<Patient> searchPatients(String name, Integer age, String gender, String phone) {
        if (name != null && !name.isEmpty()) {
            return patientRepository.searchByName(name);
        } else if (age != null) {
            return patientRepository.findByAge(age);
        } else if (gender != null && !gender.isEmpty()) {
            return patientRepository.findByGenderIgnoreCase(gender);
        } else if (phone != null && !phone.isEmpty()) {
            return patientRepository.findByPhone(phone);
        }
        else {
            return patientRepository.findAll();
        }
    }
}
