package org.bahmni.module.referencedata.labconcepts.mapper;

import org.bahmni.module.referencedata.labconcepts.contract.Resource;
import org.openmrs.Concept;

import java.util.HashMap;

public class AttributableResourceMapper extends ResourceMapper {

    protected AttributableResourceMapper(String parentConceptName) {
        super(parentConceptName);
    }

    public AttributableResourceMapper() {
        super(null);
    }

    @Override
    public Resource map(Concept concept) {
        Resource resource = new Resource();
        mapResource(resource, concept);
        HashMap<String, Object> properties = new HashMap<>();
        concept.getActiveAttributes().stream().forEach(a -> properties.put(a.getAttributeType().getName(), a.getValueReference()));
        if (!properties.isEmpty()) {
            resource.setProperties(properties);
        }
        return resource;
    }
}
