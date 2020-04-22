package com.github.getthrough.serialization;

import com.github.getthrough.serialization.domain.Person;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class JavaSerializationTest {

    private Person person;

    @Before
    private void init() {
        person = new Person();
        person.setName("zz");
        person.setAge(19);
        person.setGender("女");
        person.setEmail("xxas@gmail.com");
    }

    @Test
    public void serialize() throws IOException {
        JavaSerialization js = new JavaSerialization();
        js.serialize(
                person,
                "/Users/getthrough/IdeaProjects/demos_collection/target/serializedObjects");


    }

    @Test
    public void deserialize() {

    }


}
