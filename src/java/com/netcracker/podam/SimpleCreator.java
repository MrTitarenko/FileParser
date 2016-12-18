package com.netcracker.podam;

import com.netcracker.entity.Data;
import com.netcracker.entity.DataImpl;
import uk.co.jemos.podam.api.DataProviderStrategy;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class SimpleCreator {
    public Data setValues() {
        DataProviderStrategy strategy = new CreatedWithStrategy();
        PodamFactory factory = new PodamFactoryImpl(strategy);
        return factory.manufacturePojo(DataImpl.class);
    }
}