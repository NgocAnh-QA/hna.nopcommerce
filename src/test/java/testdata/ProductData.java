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
     /*=============================================*/

    @JsonProperty("product_02")
    private Product_02 product_02;

    static class Product_02 {
        @JsonProperty("name")
        private String name;

        @JsonProperty("price")
        private String price;

        @JsonProperty("quantity")
        private String quantity;

        @JsonProperty("processor")
        private String processor;

        @JsonProperty("ram")
        private String ram;

        @JsonProperty("hdd")
        private String hdd;

        @JsonProperty("os")
        private String os;

        @JsonProperty("software")
        private String software;
    }

    public String getProduct_02_name() {
        return product_02.name;
    }

    public String getProduct_02_price() {
        return product_02.price;
    }

    public String getProduct_02_quantity() {
        return product_02.quantity;
    }

    public String getProduct_02_processor() {
        return product_02.processor;
    }

    public String getProduct_02_ram() {
        return product_02.ram;
    }

    public String getProduct_02_hdd() {
        return product_02.hdd;
    }

    public String getProduct_02_os() {
        return product_02.os;
    }

    public String getProduct_02_software() {
        return product_02.software;
    }

    /*=============================================*/

    @JsonProperty("product_03")
    private Product_03 product_03;

    static class Product_03 {
        @JsonProperty("name")
        private String name;

        @JsonProperty("price")
        private String price;

        @JsonProperty("quantity")
        private String quantity;

        @JsonProperty("processor")
        private String processor;

        @JsonProperty("ram")
        private String ram;

        @JsonProperty("hdd")
        private String hdd;

        @JsonProperty("os")
        private String os;

        @JsonProperty("software")
        private String software;
    }

    public String getProduct_03_name() {
        return product_03.name;
    }

    public String getProduct_03_price() {
        return product_03.price;
    }

    public String getProduct_03_quantity() {
        return product_03.quantity;
    }

    public String getProduct_03_processor() {
        return product_03.processor;
    }

    public String getProduct_03_ram() {
        return product_03.ram;
    }

    public String getProduct_03_hdd() {
        return product_03.hdd;
    }

    public String getProduct_03_os() {
        return product_03.os;
    }

    public String getProduct_03_software() {
        return product_03.software;
    }

}
