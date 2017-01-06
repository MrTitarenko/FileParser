package com.netcracker.podam;

import com.netcracker.entity.Book;
import com.netcracker.entity.Customer;
import com.netcracker.entity.Film;
import uk.co.jemos.podam.api.AbstractRandomDataProviderStrategy;
import uk.co.jemos.podam.api.AttributeMetadata;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CreatedWithStrategy extends AbstractRandomDataProviderStrategy {
    private static final Random random = new Random(System.currentTimeMillis());

    public CreatedWithStrategy() {
        super();
    }

    @Override
    public int getNumberOfCollectionElements(Class<?> type) {
        if (Customer.class.getName().equals(type.getName())) {
            return 1 + random.nextInt(2);
        } else if (Book.class.getName().equals(type.getName())) {
            return 1 + random.nextInt(10);
        }
        return super.getNumberOfCollectionElements(type);

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

    @Override
    public String getStringValue(AttributeMetadata attributeMetadata) {
        if ("author".equals(attributeMetadata.getAttributeName())) {
            return "Stephen King";
        }
        if ("name".equals(attributeMetadata.getAttributeName())) {
            if (Customer.class.equals(attributeMetadata.getPojoClass())) {
                return Customers.randomCustomer();
            } else if (Book.class.equals(attributeMetadata.getPojoClass())) {
                return Books.randomBook();
            }
        }
        return super.getStringValue(attributeMetadata);
    }

    private enum Customers {
        BILL, JOE, PAUL, ERICA, JENNA, FRED, ANTONI, MARIA, MARK, SUZANA, MIKE;

        private static final List<Customers> values =
                Collections.unmodifiableList(Arrays.asList(values()));
        private static final int size = values.size();
        private static final Random random = new Random();

        public static String randomCustomer() {
            return values.get(random.nextInt(size)).toString();
        }
    }

    private enum Books {
        Carrie, The_Shining, The_Long_Walk, Pet_Sematary, It, Misery,
        The_Dark_Tower, The_Green_Mile, Mr_Mercedes;

        private static final List<Books> values =
                Collections.unmodifiableList(Arrays.asList(values()));
        private static final int size = values.size();
        private static final Random random = new Random();

        public static String randomBook() {
            return values.get(random.nextInt(size)).toString();
        }
    }
}