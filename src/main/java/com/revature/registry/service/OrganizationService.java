package com.revature.registry.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.registry.model.Organization;
import com.revature.registry.repository.OrganizationRepository;

public class OrganizationService {
    private OrganizationRepository oRepo;
    
    public OrganizationService() {
        
    }
    
    @Autowired
    public OrganizationService(OrganizationRepository oRepo) {
        this.oRepo = oRepo;
    }
    
    public List<Organization> getAllOrganizations(){
        
       return oRepo.findAll();
        
    }
    
    public Organization getOrganizationById(int id) {
        Optional<Organization> organization = oRepo.findById(id);
        
        if(organization.isPresent()) {
        return organization.get();
        } else {
           return null;
        }
    }
    
    public Organization registerOrganization(Organization o) {
        Organization savedOrg;
        try {
            savedOrg = oRepo.save(o);
            return savedOrg;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        
    }
    
    public Organization updateOrganizationById(int id, Organization newOrg) {
        Optional<Organization> organization = oRepo.findById(id);
        if(organization.isPresent()) {
            newOrg.setId(id);
            try {
                return oRepo.save(newOrg);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
        
        return null;
    }
    
    //noContent() for ResponseEntity
    public boolean deleteOrganizationById(int id) {
        Optional<Organization> org = oRepo.findById(id);
        if(org.isPresent()) {
            oRepo.deleteById(id);
            
            return true;
        }
        
        return false;
    }
    

}
