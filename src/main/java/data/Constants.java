package data;

import com.github.javafaker.Faker;

public enum Constants {
    FIRST_NAME("Florin"),
    LAST_NAME("Bogdan"),
    PASSWORD("Florin94!"),
    INCORRECT_PASSWORD("Florin94"),
    LOGIN_USER("velma1346@gmail.com"),
    INCORRECT_LOGIN_USER("velma@gmail.com"),
    URL("https://magento.softwaretestingboard.com/"),
    QTY("3"),
    COMPANY("Academia Programatorilor"),
    STR("Str Academiei"),
    STR_NUMBER("60"),
    SECTOR("Sector 1"),
    CITY("Bucharest"),
    ZIP_CODE("10001"),
    PHONE_NUMBER("0761677000"),
    RANDOM_EMAIL(generateEmail());
    private String value;

    Constants(String value) {
        this.value = value;
    }

    private static String generateEmail() {
        Faker faker = new Faker();
        String randomName = faker.name().firstName().toLowerCase();
        String randomNumber = faker.bothify("####");
        return randomName + randomNumber + "@gmail.com";
    }

    public String getValue() {
        return value;
    }
}
//la login si create account sa fac assert ptr erori