package org.xstefank.maven.map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PropertiesAdapterTest {
    
    private PropertiesAdapter adapter;
    
    @Before
    public void beforeTest() {
        adapter = new PropertiesAdapter();
    }
    
    @Test
    public void testMarshal() {
        Map<String, String> testProps = new HashMap<>();
        testProps.put("test.prop1", "value1");
        testProps.put("test.prop2", "value2");
        
        List<JAXBElement<String>> properties = new ArrayList<>(adapter.marshal(testProps).getProperties());
        
        Assert.assertEquals(2, properties.size());
        
        int count = 1;
        properties.sort(new ByNameComparator());
                
        for (JAXBElement<String> element : properties) {
            Assert.assertEquals("version.test.prop" + count, element.getName().toString());
            Assert.assertEquals("value" + count, element.getValue());
            
            count++;
        }
    }

    @Test
    public void testUnmarshal() throws Exception {
        PropertiesWrapper propertiesWrapper = new PropertiesWrapper();
        propertiesWrapper.addProperty(new JAXBElement<>(new QName("version.test.prop1"), String.class, "value1"));
        propertiesWrapper.addProperty(new JAXBElement<>(new QName("version.test.prop2"), String.class, "value2"));

        Map<String, String> result = adapter.unmarshal(propertiesWrapper);
        
        Assert.assertEquals(2, result.size());
        Assert.assertNotNull(result.get("test.prop1"));
        Assert.assertEquals("value1", result.get("test.prop1"));
        Assert.assertNotNull(result.get("test.prop2"));
        Assert.assertEquals("value2", result.get("test.prop2"));
    }
    
    private class ByNameComparator implements java.util.Comparator<JAXBElement<String>> {
       
        @Override
        public int compare(JAXBElement<String> o1, JAXBElement<String> o2) {
            return o1.getName().toString().compareTo(o2.getName().toString());
        }
    }
}
