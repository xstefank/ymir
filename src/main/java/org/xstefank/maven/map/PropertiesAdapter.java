package org.xstefank.maven.map;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.namespace.QName;
import java.util.HashMap;
import java.util.Map;

public class PropertiesAdapter extends XmlAdapter<PropertiesWrapper, Map<String, String>> {

    private static final String VERSION_PREFIX = "version.";
    
    @Override
    public Map<String, String> unmarshal(PropertiesWrapper propertiesWrapper) throws Exception {
        Map<String, String> map = new HashMap<>();
        
        for (JAXBElement<String> element : propertiesWrapper.getProperties()) {
            map.put(element.getName().toString().substring(VERSION_PREFIX.length()), element.getValue());
        }
        
        return map;
    }

    @Override
    public PropertiesWrapper marshal(Map<String, String> m) {
        PropertiesWrapper wrapper = new PropertiesWrapper();
        for(Map.Entry<String, String> entry : m.entrySet()){
            wrapper.addProperty(new JAXBElement<>(new QName(VERSION_PREFIX + entry.getKey()), String.class, entry.getValue()));
        }
        return wrapper;
    }
}
