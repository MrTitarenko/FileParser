package com.netcracker.dao;

interface Query {
    String INSERT_CUSTOMER =
            "MERGE INTO customers tab\n" +
                    "  USING (SELECT ? AS id, ? AS name, ? AS age FROM dual) new\n" +
                    "    ON (new.id = tab.customer_id)\n" +
                    "  WHEN MATCHED THEN\n" +
                    "    UPDATE SET\n" +
                    "      tab.customer_name = new.name,\n" +
                    "      tab.age = new.age\n" +
                    "  WHEN NOT MATCHED THEN\n" +
                    "    INSERT VALUES (customer_id.NEXTVAL, new.name, new.age)";


    String INSERT_BOOK =
            "MERGE INTO books tab\n" +
                    "  USING (SELECT ? AS id, ? AS author, ? AS name, ? AS year FROM dual) new\n" +
                    "    ON (new.id = tab.book_id)\n" +
                    "  WHEN MATCHED THEN\n" +
                    "    UPDATE SET\n" +
                    "      tab.author = new.author,\n" +
                    "      tab.book_name = new.name,\n" +
                    "      tab.book_year = new.year\n" +
                    "  WHEN NOT MATCHED THEN\n" +
                    "    INSERT VALUES (book_id.NEXTVAL, new.author, new.name, new.year)";

    String INSERT_FILM =
            "MERGE INTO films tab\n" +
                    "  USING (SELECT ? AS id, ? AS name, ? AS genre, ? AS budget FROM dual) new\n" +
                    "    ON (new.id = tab.film_id)\n" +
                    "  WHEN MATCHED THEN\n" +
                    "    UPDATE SET\n" +
                    "      tab.film_name = new.name,\n" +
                    "      tab.genre = new.genre,\n" +
                    "      tab.budget = new.budget\n" +
                    "  WHEN NOT MATCHED THEN\n" +
                    "    INSERT VALUES (film_id.NEXTVAL, new.name, new.genre, new.budget)";
}