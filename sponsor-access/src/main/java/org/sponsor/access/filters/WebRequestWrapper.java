package org.sponsor.access.filters;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
 
final class WebRequestWrapper extends HttpServletRequestWrapper {
    // holds custom header and value mapping
    private final Map<String, String> customHeaders;
 
    public WebRequestWrapper(HttpServletRequest request){
        super(request);
        this.customHeaders = new HashMap<String, String>();
    }
    
    public void putHeader(String name, String value){
        this.customHeaders.put(name, value);
    }
 
    public String getHeader(String name) {
        // check the custom headers first
        String headerValue = customHeaders.get(name);
        
        if (headerValue != null){
            return headerValue;
        }
        // else return from into the original wrapped object
        return ((HttpServletRequest) getRequest()).getHeader(name);
    }
 
    public Enumeration<String> getHeaderNames() {
        // create a set of the custom header names
        Set<String> set = new HashSet<String>(this.customHeaders.keySet());
        // now add the headers from the wrapped request object
        Enumeration<String> e = ((HttpServletRequest) getRequest()).getHeaderNames();
        while (e.hasMoreElements()) {
            // add the names of the request headers into the list
            String n = e.nextElement();
            set.add(n);
        }
 
        // create an enumeration from the set and return
        return Collections.enumeration(set);
    }
    
    public Map<String, String> getCustomHeaders() {
		return customHeaders;
	}
    
    @Override
    public Enumeration<String> getHeaders(String name) {
        // check the custom headers first
        String headerValue = customHeaders.get(name);
        
        if (headerValue != null){
            return Collections.enumeration(Arrays.asList(headerValue));
        }
    	return super.getHeaders(name);
    }
}