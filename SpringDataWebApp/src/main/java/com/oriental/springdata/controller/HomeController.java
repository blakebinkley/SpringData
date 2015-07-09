package com.oriental.springdata.controller;

//import com.oriental.pim.epv.model.entity.db2.catalog.AttributesMapping;
//import com.oriental.pim.epv.model.entity.db2.catalog.CatalogMaster;
//import com.oriental.pim.epv.model.entity.db2.catalog.PlannedPage;
import com.oriental.springdata.service.SampleService;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

/**
 *  * Handles requests for the application home page.
 *  
 */
@Controller
@RequestMapping(value = "/home")
public class HomeController {

  private static final Logger LOGGER = Logger.getLogger(HomeController.class);

  @Inject
  private SampleService sampleService;

  @InitBinder
  public void initBinder(WebDataBinder binder) {
    LOGGER.info("Entering");
  }

/*  @RequestMapping(value = "/catalogVersionCount", method = RequestMethod.GET,
          produces = {MediaType.APPLICATION_JSON_VALUE})
  @ResponseBody
  public long catalogVersionCount() {
    ModelAndView modelAndView = new ModelAndView();
    long count = sampleService.catalogVersionCount();
    LOGGER.info("catalogVersionCount: " + count);

    LOGGER.info("Catalog Master: "+ sampleService.loadCatalogMaster());

    modelAndView.setViewName("SUCCESS");

    return count;
  }

  @RequestMapping(value = "/catalogMaster", method = RequestMethod.GET,
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @ResponseBody
  public List<CatalogMaster> catalogMaster() {
    ModelAndView modelAndView = new ModelAndView();

    List<CatalogMaster> catalogMasterList = sampleService.loadCatalogMaster();
    LOGGER.info("Catalog Master count: " + catalogMasterList.size());
    modelAndView.setViewName("SUCCESS");
    modelAndView.addObject("catalogMasterList", catalogMasterList);

    return catalogMasterList;
  }

  @RequestMapping(value = "/attributesMapping", method = RequestMethod.GET)
  public ModelAndView attributesMapping(){

    ModelAndView modelAndView = new ModelAndView();

    List<AttributesMapping> attributesMappingList = sampleService.loadAllAttributesMapping();

    modelAndView.addObject("attributesMapping", new AttributesMapping());
    modelAndView.setViewName("attributesMapping");
    modelAndView.addObject("attributesMappingList", attributesMappingList);

    return modelAndView;
  }
  @RequestMapping(value = "/saveAttributesMapping", method = RequestMethod.POST)
  public ModelAndView saveAttributesMapping(@ModelAttribute("attributesMapping") AttributesMapping attributesMapping){

    ModelAndView modelAndView = new ModelAndView();

    if(attributesMapping != null
            || attributesMapping.getOtcAttributeName() != null || attributesMapping.getOtcAttributeName() != ""
            || attributesMapping.getStepAttributeName() != null || attributesMapping.getStepAttributeName() != ""
            || attributesMapping.getOtcGroup() != null || attributesMapping.getOtcGroup() != ""
            || attributesMapping.getStepGroup() != null || attributesMapping.getStepGroup() != ""){
      AttributesMapping attributesMappingAfterSave = sampleService.saveAttributesMapping(attributesMapping);
    }

    List<AttributesMapping> attributesMappingList = sampleService.loadAllAttributesMapping();
    modelAndView.addObject("attributesMappingList", attributesMappingList);
    modelAndView.addObject("attributesMapping", new AttributesMapping());
    modelAndView.setViewName("attributesMapping");

    return modelAndView;
  }
*/
}
