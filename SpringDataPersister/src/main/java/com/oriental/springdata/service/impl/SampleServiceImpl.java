package com.oriental.springdata.service.impl;

//import com.oriental.springdata.model.entity.db2.catalog.*;
//import com.oriental.springdata.model.entity.db2.item.vendor.VendorItemCostBreak;
//import com.oriental.springdata.model.repository.db2.*;
import com.oriental.springdata.service.SampleService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

@Service
public class SampleServiceImpl implements SampleService {

  private static final Logger LOGGER = Logger.getLogger(SampleServiceImpl.class);

/*  @Inject
  VendorItemCostBreakRepository vendorItemCostBreakRepository;

  @Inject
  CatalogVersionRepository catalogVersionRepository;

  @Inject
  CatalogMasterRepository catalogMasterRepository;
  
  @Inject
  PlanningQuarterRepository planningQuarterRepository;
  
  @Inject
  MerchantPlannerUserRepository merchantPlannerUserRepository;

  @Inject
  PlannedPageRepository plannedPageRepository;

  @Inject
  AttributesMappingRepository attributesMappingRepository;
  
  @Override
  public List<VendorItemCostBreak> loadAllVendorItemCostBreaks() {
    return vendorItemCostBreakRepository.findByCostBreak(new BigDecimal(0.107));
  }

  @Override
  public long catalogVersionCount(){
    return catalogVersionRepository.count();
  }

  @Override
  public List<CatalogMaster> loadCatalogMaster(){
    return catalogMasterRepository.findAll();
  }
  
  @Override
  public PlanningQuarter save(PlanningQuarter planningQuarter){
      PlanningQuarter planningQuarter1 = planningQuarterRepository.save(planningQuarter);
      return planningQuarter1;
  }
  
  @Override
  public MerchantPlannerUser saveMPU(MerchantPlannerUser merchantPlannerUser){
      MerchantPlannerUser merchantPlannerUser1 = merchantPlannerUserRepository.saveAndFlush(merchantPlannerUser);
      return merchantPlannerUser1;
  }

  @Override
  public AttributesMapping saveAttributesMapping(AttributesMapping attributesMapping){
    return attributesMappingRepository.saveAndFlush(attributesMapping);
  }

  @Override
  public List<AttributesMapping> loadAllAttributesMapping(){
    return attributesMappingRepository.findAll();
  }*/
}
