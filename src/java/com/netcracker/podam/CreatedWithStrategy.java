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

//    @Override
//    public String getStringValue(AttributeMetadata attributeMetadata) {
//        /**
//         * Если поле name, то в зависимости от класса либо генерим улицу, либо
//         * город, либо страну
//         */
//        if ("name".equals(attributeMetadata.getAttributeName())) {
//            if (Street.class.equals(attributeMetadata.getPojoClass())) {
//                return Streets.randomStreet();
//            } else if (City.class.equals(attributeMetadata.getPojoClass())) {
//                return Cities.randomCity();
//            } else if (Country.class.equals(attributeMetadata.getPojoClass())) {
//                return "Podam States of Mockitia";
//            }
//        }
//        return super.getStringValue(attributeMetadata);
//    }

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

//    private enum Cities {
//        MOSCOW, SAINT_PETERSBURG, LONDON, NEW_YORK, SHANGHAI, KARACHI, BEIJING, DELHI, PARIS, NAIROBI;
//
//        private static final List<Cities> values = Collections.unmodifiableList(Arrays.asList(values()));
//        private static final int size = values.size();
//        private static final Random random = new Random();
//
//        public static String randomCity() {
//            return values.get(random.nextInt(size)).toString();
//        }
//    }
//
//    private enum Streets {
//        RUE_ABEL, RUE_AMPERE, AVENUE_PAUL_APPELL, BOULEVARD_ARAGO, JARDINS_ARAGO, SQUARE_ARAGO, RUE_ANTOINE_ARNAULD, SQUARE_ANTOINE_ARNAULD, RUE_BERNOULLI, RUE_BEZOUT, RUE_BIOT, RUE_BORDA, SQUARE_BOREL, RUE_CHARLES_BOSSUT, RUE_DE_BROGLIE, RUE_BUFFON, AVENUE_CARNOT, BOULEVARD_CARNOT, VILLA_SADI_CARNOT, RUE_CASSINI, RUE_CAUCHY, RUE_MICHEL_CHASLES, RUE_NICOLAS_CHUQUET, RUE_CLAIRAUT, RUE_CLAPEYRON, RUE_CONDORCET, RUE_CORIOLIS, RUE_COURNOT, RUE_GASTON_DARBOUX, RUE_DELAMBRE, SQUARE_DELAMBRE, RUE_DEPARCIEUX, RUE_DE_PRONY, RUE_DESARGUES, RUE_DESCARTES, RUE_ESCLANGON, RUE_EULER;
//
//        private static final List<Streets> values = Collections.unmodifiableList(Arrays.asList(values()));
//        private static final int size = values.size();
//        private static final Random random = new Random();
//
//        public static String randomStreet() {
//            return values.get(random.nextInt(size)).toString();
//        }
//    }
}