package com.example.cashcard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class CashCardJsonTest {

      @Autowired
      private JacksonTester<CashCard> json;

      @Test
      void cashCardSerializationTest() throws IOException {
            CashCard cashCard = new CashCard(99L, 123.45);
            assertThat(json.write(cashCard)).isStrictlyEqualToJson("expected.json");
            assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.id");
            assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.id")
                        .isEqualTo(99);
            assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.amount");
            assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.amount")
                        .isEqualTo(123.45);

      }

      @Test
      void cashCardDeserializationTest() throws IOException {
            String expected = """
                        {
                            "id":99,
                            "amount":123.45
                        }
                        """;

            ObjectMapper objectMapper = new ObjectMapper();
            CashCard cashCard = objectMapper.readValue(expected, CashCard.class);

            // Now check if the fields match the expected values
            assertThat(cashCard.getId()).isEqualTo(99L);
            assertThat(cashCard.getAmount()).isEqualTo(123.45);
      }
}