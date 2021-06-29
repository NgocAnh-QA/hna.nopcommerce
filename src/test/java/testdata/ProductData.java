package testdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class ProductData {
    public static ProductData getFiles(String fileName) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(fileName), ProductData.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


    /*==========================*/
    @JsonProperty("product_01")
    private Product_01 product_01;

    static class Product_01 {
        @JsonProperty("name")
        private String name;

        @JsonProperty("incorrect_name")
        private String incorrect_name;

        @JsonProperty("relative_name")
        private String relative_name;

        @JsonProperty("search_keyword")
        private String search_keyword;
    }

    public String getProduct_01_name() {
        return product_01.name;
    }

    public String getProduct_01_incorrect_name() {
        return product_01.incorrect_name;
    }

    public String getProduct_01_relative_name() {
        return product_01.relative_name;
    }

    public String getProduct_01_search_keyword() {
        return product_01.search_keyword;
    }

}
