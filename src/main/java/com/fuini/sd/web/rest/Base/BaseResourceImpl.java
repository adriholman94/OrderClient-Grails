package com.fuini.sd.web.rest.Base;

import com.fiuni.sd.DTO.Base.BaseDTO;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public abstract class BaseResourceImpl<DTO extends BaseDTO> implements IBaseResource<DTO>{

    private final String resourcePath;
    private final Class<DTO> dtoClass;
    private final WebResource webResource;
    private static final String BASE_URL = "http://localhost:8080/";

    public BaseResourceImpl(Class<DTO> dtoClass, String resourcePath){
        this.dtoClass = dtoClass;
        this.resourcePath = BASE_URL + resourcePath;
        final Client jerseyClient = Client.create();
        webResource = jerseyClient.resource(this.resourcePath);
    }

    protected WebResource getWebResource(){
        return webResource;
    }

    protected Class<DTO> getDTOClass(){
        return  dtoClass;
    }

    @Override
    public DTO getById(Integer id) {
        System.out.println("get -> " + getWebResource().path("/" + id).toString());
        return getWebResource().path("/" + id).get(getDTOClass());
    }

    @Override
    public DTO save(DTO dto) {
        return getWebResource().entity(dto).post(getDTOClass());
    }
}
