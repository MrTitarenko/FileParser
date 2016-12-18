package com.netcracker.podam;

import com.netcracker.entity.Book;
import com.netcracker.entity.Customer;
import com.netcracker.entity.Film;
import uk.co.jemos.podam.api.AbstractRandomDataProviderStrategy;
import uk.co.jemos.podam.api.AttributeMetadata;

import java.util.Random;

public class CreatedWithStrategy extends AbstractRandomDataProviderStrategy {
    private static final Random random = new Random(System.currentTimeMillis());

    public CreatedWithStrategy() {
        super();
    }

    @Override
    public Integer getInteger(AttributeMetadata attributeMetadata) {
        if (Customer.class.equals(attributeMetadata.getPojoClass()) ||
                Book.class.equals(attributeMetadata.getPojoClass()) ||
                Film.class.equals(attributeMetadata.getPojoClass())) {
            if ("id".equals(attributeMetadata.getAttributeName())) {
                return 1 + random.nextInt(9_000);
            } else if ("age".equals(attributeMetadata.getAttributeName())) {
                return 1 + random.nextInt(89);
            } else if ("year".equals(attributeMetadata.getAttributeName())) {
                return 1967 + random.nextInt(49);
            } else if ("budget".equals(attributeMetadata.getAttributeName())) {
                return 100_000 + random.nextInt(9_000_000);
            }
        }
        return super.getInteger(attributeMetadata);
    }
}